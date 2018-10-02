package rummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;  
import java.util.Comparator;

public class Player {
	
	private List<Tile> myHandTile = new ArrayList<Tile>();
	private ArrayList<ArrayList<Tile>> myMeld = new ArrayList<ArrayList<Tile>>();
	private boolean hasSet = false;
	private boolean hasRun = false;
	
	public Player() {
		
	}
	
	public ArrayList<ArrayList<Tile>> getMyMeld(){
		return this.myMeld;
	}
	
	public List<Tile> getMyHandTile(){
		return this.myHandTile;
	}
	
//	public void printMyMeld() {
//	      for(int i = 0; i< this.getMyMeld().size();i++) {
//	    	  for(int j = 0; j<this.getMyMeld().get(i).size(); j++){
//	    	      this.getMyMeld().get(i).get(j).printTile();
//	    	  }
//	    	  System.out.println("");
//	      }
//	}
	
	/*Shuffle user's hand tile
	 * sort according to tile's color
	 */
	public void sort() {
		Collections.sort(myHandTile, new CompareTile());	
	}
	
	/** sort according to tile's rank
	 */
	public void sortRankFirst() {
		Collections.sort(myHandTile, new CompareTileRankFirst());
	}
	
	public int getNumberOfHandTile() {
		return this.myHandTile.size();
	}
	
	//initially add 14 tiles to user's handTile.
	public void initialHandTile(Deck d){
		for(int i = 0; i < 14; i++) {
			myHandTile.add(d.drawTile());
		}
	}

		
	
	/* three or four of a kind of the same rank;
	 * 
	 */
	public void hasSet() {
		this.sortRankFirst();
		int index = 0;
		List<Tile> ht = this.myHandTile;
		int count = 1;
		
		while(index<ht.size()-1) {
				if(!ht.get(index).getColor().equals(ht.get(index+1).getColor()) && 
				(ht.get(index).getNumber()==ht.get(index+1).getNumber())) {
						count++;
						if(count >= 3) {
							ArrayList<Tile> temp = new ArrayList<Tile>();
							if(count == 4) {
								
								myMeld.remove(myMeld.size()-1);
								temp.clear();
								temp.add(ht.get(index-2));
								temp.add(ht.get(index-1));
								temp.add(ht.get(index));
								temp.add(ht.get(index+1));	
							} else {
								temp.clear();
								temp.add(ht.get(index-1));
								temp.add(ht.get(index));
								temp.add(ht.get(index+1));	
								}
							hasSet = true;
							myMeld.add(temp);
						}
						index++;
				} else {
					count = 1;
					index++;
				}
		}
		this.sort();
	}
	
	
	
	/* three or more cards in sequence, of the same suit
	 * here we assume the hand card has sorted.!!!!
	 */
	public void hasRun() {
		int index = 0;
		List<Tile> ht = this.myHandTile;
		int count = 1;
	
		while(index<ht.size()-1) {
				if(ht.get(index).getColor().equals(ht.get(index+1).getColor()) && 
				isContinous(ht.get(index).getNumber(),ht.get(index+1).getNumber())) {
						count++;
						if(count >= 3) {
							ArrayList<Tile> temp = new ArrayList<Tile>();
							if(count == 3) {
								temp.clear();
								temp.add(ht.get(index-1));
								temp.add(ht.get(index));
								temp.add(ht.get(index+1));	
							} else {
								myMeld.remove(myMeld.size()-1);
								temp.clear();
								int t = index+1;
								for(int i = 0; i < count; i++) {
									temp.add(ht.get(t));
									t--;
								}
							}
							hasRun = true;
							myMeld.add(temp);
						}
						index++;
				} else {
					count = 1;
					index++;
				}
		}
	}
	
	
	public boolean hasMeld() {
		return this.hasRun||this.hasSet;
	}
	
	/* Helper method for hasRun()
	 * Here i assume i2 always larger than i1
	 */
	public boolean isContinous(int i1, int i2) {
		if((i2-i1) == 1) 
			return true;
		return false;
	}
	

	
//	public boolean initialCheck(ArrayList<Tile> meld) {
//		
//	}
//	
	
	
	public ArrayList<Tile> dealTile(ArrayList<Tile> al){
		myHandTile.remove(al);
		return al;
	}
	
	
	public Tile drawATile(Tile t) {
		myHandTile.add(t);
		return t;
	}
	
	public String toString() {
		String result = "Hand Tile: ";
		for(int i = 0; i < this.myHandTile.size(); i++) {
			result+= this.myHandTile.get(i).getColor()+
					this.myHandTile.get(i).getNumber()+" ";
		}
		return result;
	}
}



/* compare each tile in user's hand 
 * in order to sort them in order Color First
 * R1 R7 R9 B2 G1 D3
 * */
class CompareTile implements Comparator<Tile>{

	public int compare(Tile t1, Tile t2) {
		int i = convertColorToInteger(t1).compareTo(convertColorToInteger(t2));
		if (i != 0){
       return i;
    }

		Integer r1 = new Integer(t1.getNumber());
		Integer r2 = new Integer(t2.getNumber());
		i = r1.compareTo(r2);
		return i;
	}
	
	


	/* Convert tile's color to Integer
	 * So that it can be compared through .compareTo()
	 * R < B < G < D
	 * */
	public Integer convertColorToInteger(Tile t) {
		if(t.getColor().equals("R")) {
			Integer i = new Integer(1);
			return i;
		} else if(t.getColor().equals("B")) {
			Integer i = new Integer(2);
			return i;
		} else if(t.getColor().equals("G")) {
			Integer i = new Integer(3);
			return i;
		} else {
			Integer i = new Integer(4);
			return i;
		}
	}
}


/* compare each tile in user's hand 
 * in order to sort them in order Rank First
 * int the order: R1 G2 R3 B3 G4 D4 R7
 * */
class CompareTileRankFirst implements Comparator<Tile>{

	public int compare(Tile t1, Tile t2) {
		Integer r1 = new Integer(t1.getNumber());
		Integer r2 = new Integer(t2.getNumber());
		
		int i = r1.compareTo(r2);
		if (i != 0)
		return i;
 
		i = convertColorToInteger(t1).compareTo(convertColorToInteger(t2));		
		return i;
	}
	
	


	/* Convert tile's color to Integer
	 * So that it can be compared through .compareTo()
	 * R < B < G < D
	 * */
	public Integer convertColorToInteger(Tile t) {
		if(t.getColor().equals("R")) {
			Integer i = new Integer(1);
			return i;
		} else if(t.getColor().equals("B")) {
			Integer i = new Integer(2);
			return i;
		} else if(t.getColor().equals("G")) {
			Integer i = new Integer(3);
			return i;
		} else {
			Integer i = new Integer(4);
			return i;
		}
	}
}


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;  
import java.util.Comparator;

public class Player {
	
	private List<Tile> myHandTile = new ArrayList<Tile>();
	
	public Player() {
		
	}
	
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
	public boolean hasSet() {
		this.sortRankFirst();
		int index = 0;
		List<Tile> ht = this.myHandTile;
		int count = 1;
		
		while(index<ht.size()-1) {
				if(!ht.get(index).getColor().equals(ht.get(index+1).getColor()) && 
				(ht.get(index).getRank()==ht.get(index+1).getRank())) {
						count++;
						if(count == 3) return true;
						index++;
				} else {
					count = 1;
					index++;
				}
		}
		this.sort();
		return false;
	}
	
	
	
	/* three or more cards in sequence, of the same suit
	 * here we assume the hand card has sorted.!!!!
	 */
	public boolean hasRun() {
		int index = 0;
		List<Tile> ht = this.myHandTile;
		int count = 1;
		
		while(index<ht.size()-1) {
				if(ht.get(index).getColor().equals(ht.get(index+1).getColor()) && 
				isContinous(ht.get(index).getRank(),ht.get(index+1).getRank())) {
						count++;
						if(count == 3) return true;
						index++;
				} else {
					count = 1;
					index++;
				}
		}
		return false;
	}
	
	
	public boolean hasMeld() {
		return this.hasRun()||this.hasSet();
	}
	
	/* Helper method for hasRun()
	 * Here i assume i2 always larger than i1
	 */
	public boolean isContinous(int i1, int i2) {
		if((i2-i1) == 1) 
			return true;
		return false;
	}
	

	
	public boolean initialCheck(ArrayList<Tile> meld) {
		
	}
	
	
	
	public ArrayList<Tile> dealTile(ArrayList<Tile> al){
		myHandTile.remove(al);
	}
	
	
	public Tile drawATile(Tile t) {
		myHandTile.add(t);
		return t;
	}
	
	public String toString() {
		String result = "Hand Tile: ";
		for(int i = 0; i < this.myHandTile.size(); i++) {
			result+= this.myHandTile.get(i).getColor()+
					this.myHandTile.get(i).getRank()+" ";
		}
		return result;
	}
}



/* compare each tile in user's hand 
 * in order to sort them in order Color First
 * R1 R7 R9 B2 G1 D3
 * */
class CompareTile implements Comparator<Tile>{

	@Override
	public int compare(Tile t1, Tile t2) {
		int i = convertColorToInteger(t1).compareTo(convertColorToInteger(t2));
		if (i != 0){
       return i;
    }

		Integer r1 = new Integer(t1.getRank());
		Integer r2 = new Integer(t2.getRank());
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

	@Override
	public int compare(Tile t1, Tile t2) {
		Integer r1 = new Integer(t1.getRank());
		Integer r2 = new Integer(t2.getRank());
		
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


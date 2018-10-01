import java.util.ArrayList;
import java.util.List;
import java.util.Collections;  
import java.util.Comparator;

public class Player {
	
	private List<Tile> myHandTile = new ArrayList<Tile>();
	
	public Player() {
		
	}
	
	//Shuffle user's hand tile
	public void sort() {
		Comparator<Tile> comp = new CompareTile();
		Collections.sort(myHandTile, comp);	
	}
	
	public int getNumberOfHandTile() {
		return this.myHandTile.size();
	}
	
	public void initialHandTile(Deck d){
		for(int i = 0; i < 14; i++) {
			myHandTile.add(d.drawTile());
		}
	}
	
	public boolean hasMeld() {
		
	}
	
	public ArrayList<Tile> findMeld() {
		
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
 * in order to sort them in order
 * R B G D
 * */
class CompareTile implements Comparator<Tile>{
	
	@Override
	public int compare(Tile t1, Tile t2) {
		int i = covertColorToInteger(t1).compareTo(covertColorToInteger(t2));
		if (i != 0) return i;
		
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
		if(t.getColor().equals('R')) {
			Integer i = new Integer(1);
			return i;
		} else if(t.getColor().equals('B')) {
			Integer i = new Integer(2);
			return i;
		} else if(t.getColor().equals('G')) {
			Integer i = new Integer(3);
			return i;
		} else {
			Integer i = new Integer(4);
			return i;
		}
	}
}


import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Tile> myHandTile = new ArrayList<Tile>();
	
	public Player() {
		
	}
	
	public void sort() {
		
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

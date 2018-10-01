import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Tile> myHandCard = new ArrayList<Tile>();
	
	public Player() {
		
	}
	
	public int getNumberOfHandCard() {
		return this.myHandCard.size();
	}
	
	public void initialHandCard(Deck d){
		for(int i = 0; i < 14; i++) {
			myHandCard.add(d.drawTile());
		}
	}
	
	public Tile drawATile(Tile t) {
		myHandCard.add(t);
	}
	
}

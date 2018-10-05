package tilerummy;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	public static final String[] colors = {"R", "B", "G", "O"};
	public static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	private ArrayList<Tile> tileDeck;
	
	public Deck() {
		tileDeck = new ArrayList<Tile>();
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < colors.length; j++) {
				for(int k = 0; k < numbers.length; k++) {
					Tile t= new Tile(colors[j], numbers[k]);
					tileDeck.add(t);
				}
			}
		}
		
		Collections.shuffle(tileDeck);
	}
	
	public int getDeckSize(){
		return tileDeck.size();
	}
	
	public Tile drawTile() {
		return tileDeck.remove(0);
	}
	
}
	
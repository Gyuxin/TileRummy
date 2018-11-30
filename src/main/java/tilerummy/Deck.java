package tilerummy;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	public static final String[] colors = {"R", "B", "G", "O"};
	public static final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	private ArrayList<Tile> tileDeck;
	
	public Deck() {
		tileDeck = new ArrayList<Tile>();
	}

	public void buildDeck(){

		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < colors.length; j++) {
				for(int k = 0; k < numbers.length; k++) {
					Tile t= new Tile(colors[j], numbers[k]);
					tileDeck.add(t);
				}
			}
		}
		
		// add 2 jokers to deck
		Tile joker=new Tile("J",0);
		tileDeck.add(joker);
		tileDeck.add(joker);
		Collections.shuffle(tileDeck);

	}
	
	// 随机生成一张牌，不拿走。用来决定哪个玩家先出牌
	public Tile getARandomTile() {
		Collections.shuffle(tileDeck);
		return this.tileDeck.get(0);
	}
	
	public int getDeckSize(){
		return tileDeck.size();
	}
	
	public Tile drawTile() {
		if(tileDeck.size()==0) {
			System.out.println("没牌啦");
			System.exit(0);
		}
		return tileDeck.remove(0);
	}

	public void addTile(Tile t){
		tileDeck.add(t);
	}
	
}
	
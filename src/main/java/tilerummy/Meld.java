package tilerummy;

import java.util.ArrayList;

public class Meld {
	
	public final static String[] types = {"S", "R"};
	
	private ArrayList<Tile> meld;
	private String type;
	
	public Meld() {
		
		meld = new ArrayList<Tile>();
		
	}
	
	public boolean checkSet() {
		
		for(int i = 0; i < meld.size(); i++) {
			if (meld.get(i).getRank())
		}
		
		return false;
		
	}
	
	public void addTile(Tile t) {	
		meld.add(t);		
	}
	
	public Tile removeTile(int position) {
		return meld.remove(position);
	}
	
	public void printMeld() {
		for(int i = 0; i < meld.size(); i++) {
			meld.get(i).printTile();
		}
	}
	
	public boolean checkMeld() {
		
		for(int i = 0; )
		
		return false;
	}

}

package tilerummy;

import java.util.ArrayList;

public class Meld {
	
	private ArrayList<Tile> meld;
	private boolean isSet;
	private boolean isRun;
	
	public Meld() {
		
		meld = new ArrayList<Tile>();
		
	}
	
	public void checkSet() {
		
		String r = 
		for(int i = 0; i < meld.size(); i++) {
			
		}
		
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

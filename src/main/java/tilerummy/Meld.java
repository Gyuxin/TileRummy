package tilerummy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Meld {
	
	private ArrayList<Tile> meld;
	private String type;
	
	public Meld() {
		
		meld = new ArrayList<Tile>();
		type = setType();
		
	}

	public int getMeldSize(){
		return meld.size();
	}
	
	//check if the meld is a set
	//set: three or four tiles with the same number in different colors
	public boolean isSet() {
		
		boolean isSet = false;

		//get the number of the first tile in the meld
		int n = meld.get(0).getNumber();

		//check if remaining tiles' ranks are same as the first one
		for(int i = 1; i < meld.size(); i++) {
			if (meld.get(i).getNumber() == n){
				isSet = true;
			} else {
				return false;
			}
		}

		//A set that stores all colors of tiles in the meld
		Set<String> c = new HashSet<String>();

		//check if every tile has different color
		for(int i = 0; i < meld.size(); i++){
			c.add(meld.get(i).getColor());
		}
		
		//if the size of colors is less than the size of meld, some tiles have same color
		if(c.size() < meld.size()) {
			return false;
		}

		return isSet;
		
	}

	public boolean isRun(){

		boolean isRun = false;

		//get the color of the first tile
		String c = meld.get(0).getColor();

		//check if remaining tiles have same color as the first tile
		for(int i = 1; i < meld.size(); i++){
			if(meld.get(i).getColor().indexOf(c.charAt(0)) == 0){
				isRun = true;
			} else {
				return false;
			}
		}

		//check if numbers in sequence
		for(int i = 0; i < meld.size()-2; i++){
			if((meld.get(i+1).getNumber() - meld.get(i).getNumber()) == 0){
				isRun = true;
			} else {
				return false;
			}
		}

		return isRun;

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
	
	public String setType() {

		if(isSet()){
			return "S";
		} else {
			return "R";
		} 

	}

	public String getType(){
		return this.type;
	}

	public Tile removeFirstTile(){
		return meld.remove(0);
	}

	public Tile removeLastTile(){
		return meld.remove(meld.size()-1);
	}

}

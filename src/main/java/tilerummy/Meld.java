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
	
	public void addTileAtLast(Tile t) {	
		meld.add(t);		
	}

	public void addTileAtFirst(Tile t){
		meld.add(0, t);
	}
	
	public Tile removeTile(int position) {
		return meld.remove(position);
	}

	public Tile getFirstTile(){
		return meld.get(0);
	}

	public Tile getLastTile(){
		return meld.get(meld.size()-1);
	}
	
	public void printMeld() {
		System.out.print("{ ");
		for(int i = 0; i < meld.size(); i++) {
			meld.get(i).printTile();
		}
		System.out.print("}");
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

	//Check if a meld contains a tile
	public boolean containsTile(Tile t){

		for(int i = 0; i < meld.size(); i++){
			Tile curTile = meld.get(i);
			if(t.getColor().equals(curTile.getColor()) && t.getNumber() == curTile.getNumber()){
				return true;
			}
		}

		return false;
	}

}

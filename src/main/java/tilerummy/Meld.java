package tilerummy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Meld {
	
	private ArrayList<Tile> meld;
	private boolean justPlayed;
	
	public Meld() {
		
		meld = new ArrayList<Tile>();
		justPlayed = false;

	}

	public Meld(ArrayList<Tile> m){

		meld = m;
		justPlayed = false;

	}
	
	public ArrayList<Tile> getMeld(){
		return this.meld;
	}

	public int getMeldSize(){
		return meld.size();
	}

	public void setJustPlayed(){
		this.justPlayed = true;
	}

	public void setJustPlayedFalse(){
		this.justPlayed = false;
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
		if(this.justPlayed){
			System.out.print("*");
		}
		System.out.print("{ ");
		for(int i = 0; i < meld.size(); i++) {
			if(meld.get(i).getColor().equals("J")) {			// 还原joker的值
				meld.get(i).setNumber(0);
			}
			meld.get(i).printTile();
		}
		System.out.print("}");
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
	
	public boolean sameNumber(Tile t) {
		for(int i = 0; i < meld.size(); i++){
			Tile curTile = meld.get(i);
			if(t.getNumber() == curTile.getNumber()){
				return true;
			}
		}
		return false;
	}
	
	public boolean sameColor(Tile t) {
		for(int i = 0; i < meld.size(); i++){
			Tile curTile = meld.get(i);
			if(t.getColor().equals(curTile.getColor())){
				return true;
			}
		}
		return false;
	}

	public Tile get(int j) {
		return meld.get(j);
	}
	

	public void slice(int s, int e) {	
		Meld temp = new Meld();
		temp.meld.addAll(this.meld.subList(s, e));
		this.meld = temp.meld;
	}

}

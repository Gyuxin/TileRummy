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

 
 public int getMeldScore() {
	 int score = 0;
	 for(int i = 0; i < meld.size(); i++) {
		 score += meld.get(i).getNumber();
	 }
	 return score;
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
 
	public boolean getJustPlayed() {
		return this.justPlayed;
	}
	
	public boolean isMeld() {
		
		boolean isMeld = false;
		
		if(this.isRun()&&meld.size()>2) {
			isMeld = true;
		} 
		else if(this.isSet() && this.getMeldSize() < 5 && meld.size()>2 ) {
			isMeld = true;
		}
		return isMeld;
		
	}
 
	 public boolean isSetNoJoker() {
		  
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
	
	 public boolean isSet() {
		 
		 boolean isSet = false;
		 int jokerIndex = -1;
		 
		 for(int i = 0; i < meld.size(); i++) {
			 if(meld.get(i).getColor().equals("J")) {
				 jokerIndex = i;
			 }
		 }
		 
		 if(jokerIndex != -1) {
			 
			 ArrayList<Tile> temp = meld;
			 temp.remove(jokerIndex);
			 Meld tempMeld = new Meld(temp);
			 isSet = tempMeld.isSetNoJoker();
			 
		 } else {
			 
			 isSet = isSetNoJoker();
			 
		 }
		 
		 return isSet;
	 }

	 public boolean isRunNoJoker(){

		  boolean isRun = false;

		  //get the color of the first tile
		  String c = meld.get(0).getColor();

		  //check if remaining tiles have same color as the first tile
		  for(int i = 1; i < meld.size(); i++){
		   if(meld.get(i).getColor().equals(c)){
		    isRun = true;
		   } else {
		    return false;
		   }
		  }

		  //check if numbers in sequence
		  for(int i = 0; i < meld.size()-2; i++){
		   if((meld.get(i+1).getNumber() - meld.get(i).getNumber()) == 1){
		    isRun = true;
		   } else {
		    return false;
		   }
		  }

		  return isRun;

		 }
	 public boolean isRun() {
		 
		 boolean isRun = false;
		 int jokerIndex = -1;
		 
		 for(int i = 0; i < meld.size(); i++) {
			 if(meld.get(i).getColor().equals("J")) {
				 jokerIndex = i;
			 }
		 }
		 
		 if(jokerIndex != -1) {
			 for(int i = 0; i < meld.size(); i++) {
				 
			 }		 
		 }
		 
		 if(jokerIndex != -1) {
			 for(int i = 1; i < 14; i++) {
				 ArrayList<Tile> temp = meld;
				 temp.remove(jokerIndex);
				 Meld tempMeld = new Meld(temp);
				 tempMeld.addTileAtLast(new Tile(temp.get(0).getColor(), i));
				 if(tempMeld.isRunNoJoker()) {
					 isRun = true;
					 break;
				 } 
			 }
		 } 
		 else {
			 isRun = isRunNoJoker();
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
 
 public String printMeld() {
  String result = "";
  if(this.justPlayed){
   result+="*";
  }
  result+="{ ";
  for(int i = 0; i < meld.size(); i++) {
   result+=meld.get(i).printTile();
  }
  result+="}";
  return result;
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
 
 public ArrayList<Tile> getMeld(){
	  return this.meld;
	 }

}
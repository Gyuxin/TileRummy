package tilerummy;

import java.util.ArrayList;

public class Table {
 
 private ArrayList<Meld> table;
 
 public Table() {
  
  table = new ArrayList<Meld>();
  
 }
 
 public ArrayList<Meld> getTable(){
	 return table;
 }
 
 public void setNewTable(ArrayList<Meld> t) {
	 this.table = t;
 }

 public int getSize(){
  return table.size();
 }

 public Meld getMeld(int position){
  return table.get(position);
 }

 public void setMeldsPlayedFalse(){

  for(int i = 0; i < table.size(); i++){
   table.get(i).setJustPlayedFalse();
  }

 }

 public String printTable(){
  String result="";
  for(int i = 0; i < table.size(); i++){
   result += table.get(i).printMeld();
  }
  setMeldsPlayedFalse();
  return result;
 }

 public boolean isEmpty(){
  if(table.size() == 0){
   return true;
  }
  return false;
 }
 
 public void addMeld(Meld meld) {
  table.add(meld);
  meld.setJustPlayed();
 }

 //remove empty meld
 public void removeEmptyMeld(){
  
  for(int i = 0; i < table.size(); i++){
   if(table.get(i).getMeldSize() == 0){
    table.remove(i);
    i--;
   }
  }
 }
 
 public boolean checkInValid() {
 	 
	 for(int i = 0; i < table.size(); i++) {
		 
		 if(!table.get(i).isMeld()) {
			 return false;
		 }
		 
	 }
	 	 
	 return true;
	 
 }

}
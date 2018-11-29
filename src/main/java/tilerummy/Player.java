package tilerummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;  
import java.util.Comparator;

public class Player {
 
 private List<Tile> myHandTile = new ArrayList<Tile>();
 private ArrayList<ArrayList<Tile>> myMeld = new ArrayList<ArrayList<Tile>>();
 private ArrayList<ArrayList<Tile>> myRunMeld = new ArrayList<ArrayList<Tile>>();
 private ArrayList<ArrayList<Tile>> mySetMeld = new ArrayList<ArrayList<Tile>>();
 private boolean hasSet = false;
 private boolean hasRun = false;
 
 
 public boolean initialedFirstMeld = false;
 
 public Player() {
  
 }
 
 public ArrayList<ArrayList<Tile>> getMyMeld(){
	 return this.myMeld;
 }
 
 public List<Tile> getMyHandTile(){
	 return this.myHandTile;
 }
 
 public void printMyMeld() {
       for(int i = 0; i< this.myMeld.size();i++) {
        for(int j = 0; j<this.myMeld.get(i).size(); j++){
            this.myMeld.get(i).get(j).printTile();
        }
        System.out.println("");
       }
 }
 
 /*Shuffle user's hand tile
  * sort according to tile's color
  */
 public void sort() {
	 	Collections.sort(myHandTile, new CompareTile()); 
 }
 
 /** sort according to tile's rank
  */
 public void sortRankFirst() {
	 	Collections.sort(myHandTile, new CompareTileRankFirst());
 }
 
 public int getNumberOfHandTile() {
	 return this.myHandTile.size();
 }
 
 //initially add 14 tiles to user's handTile.
 public void initialHandTile(Scanner sc, Deck d){
	  for(int i = 0; i < 14; i++) {
		 // Tile temp = new Tile(sc.next());
		  Tile temp = d.drawTile();
		  myHandTile.add(temp);
	  }
 }

 
 public int numberOfJokerInHand() {
	 int jokerNum = 0;
	 for(int i = 0; i<this.getNumberOfHandTile();i++) {
		 if(this.getMyHandTile().get(i).getColor().equals("J") && this.getMyHandTile().get(i).getNumber()==0) {
			 jokerNum++;
		 }
	 }
	 return jokerNum;
 }
  
 
 public boolean isSet(ArrayList<Tile> s) {
	 Meld m = new Meld(s);
	 return m.isSet();
 }
 
 public boolean isRun(ArrayList<Tile> r) {
	 Meld m = new Meld(r);
	 return m.isRun();
 }
 
 
 /* three or four of a kind of the same rank;
  * 
  */
 public void hasSet() {
	  this.sortRankFirst();
	  int index = 0;
	  List<Tile> ht = this.myHandTile;
	  int count = 1;
	  
	  while(index<ht.size()-1) {
		    if(!ht.get(index).getColor().equals(ht.get(index+1).getColor()) && 
		    (ht.get(index).getNumber()==ht.get(index+1).getNumber())) {
			      count++;
			      if(count >= 3) {
				       ArrayList<Tile> temp = new ArrayList<Tile>();
				       if(count == 4) {
				        
					        mySetMeld.remove(mySetMeld.size()-1);
					        temp.clear();
					        temp.add(ht.get(index-2));
					        temp.add(ht.get(index-1));
					        temp.add(ht.get(index));
					        temp.add(ht.get(index+1)); 
				       } else {
					        temp.clear();
					        temp.add(ht.get(index-1));
					        temp.add(ht.get(index));
					        temp.add(ht.get(index+1)); 
				        }
				       hasSet = true;
				       mySetMeld.add(temp);
			      }
			      index++;
		    } else {
			     count = 1;
			     index++;
		    }
	  }
	  this.sort();
 }
 
 
 
 /* three or more cards in sequence, of the same suit
  * here we assume the hand card has sorted.!!!!
  */
 public void hasRun() {
	  int index = 0;
	  List<Tile> ht = this.myHandTile;
	  int count = 1;
	 
	  while(index<ht.size()-1) {
		    if(ht.get(index).getColor().equals(ht.get(index+1).getColor()) && 
		    isContinous(ht.get(index).getNumber(),ht.get(index+1).getNumber())) {
			      count++;
			      if(count >= 3) {
				       ArrayList<Tile> temp = new ArrayList<Tile>();
				       if(count == 3) {
					        temp.clear();
					        temp.add(ht.get(index-1));
					        temp.add(ht.get(index));
					        temp.add(ht.get(index+1)); 
				       } else {
					        myRunMeld.remove(myRunMeld.size()-1);
					        temp.clear();
					        int t = index+1;
					        for(int i = 0; i < count; i++) {
					         temp.add(ht.get(t));
					         t--;
					        }
				       }
				       hasRun = true;
				       myRunMeld.add(temp);
			      }
			      index++;
		    } else {
			     count = 1;
			     index++;
		    }
	  }
 }
 
 
 //没法组成meld的剩余的牌
 public List<Tile> tilesNotInMeld(){
	 List<Tile> list = new ArrayList<Tile>();
	 list.addAll(this.myHandTile);				// make a deep copy
	 for(int i=0; i<this.myMeld.size();i++) {
		 for(int j=0;j<this.myMeld.get(i).size();j++) {
			 list.remove(this.myMeld.get(i).get(j));		// 把meld 从 handtile 里移除
		 }
	 }
	 return list;
 }
 
 /* player class 每次出牌前要先call 这个function
  * 判断有没有meld， 有：形成meld arraylist return true
  * 没有： return false
  * */
 public boolean hasMeld() {				
	 myMeld.clear();
	 myRunMeld.clear();			
	 mySetMeld.clear();	// 每一次call 这个function，清空上一轮的结果，重新判断。
	 hasRun = false;
	 hasSet = false;
	 
	  this.hasRun();	
	  this.hasSet();

	  checkDuplicate();	
	  
	  int joker = this.numberOfJokerInHand();
	  List<Tile> list = this.tilesNotInMeld();
	  // 有joker：
	  if(joker>0) {
		  if(joker==1) {	//有1张joker
			  if(this.twoConsecutiveTiles(list)!=null) {
				  ArrayList<Tile> temp = this.getLargestConsuctiveList(twoConsecutiveTiles(list));
				  temp.add(new Tile("J",0));
				  this.myMeld.add(temp);
				  return true;
			  }
		  } else {			//有2张joker
			  if(this.twoConsecutiveTiles(list)!=null) {		// 把两张joker 拆成2组
				  ArrayList<Tile> temp = this.getLargestConsuctiveList(twoConsecutiveTiles(list));
				  temp.add(new Tile("J",0));					// 放其中一张joker来形成meld
				  this.myMeld.add(temp);
				  return true;
			  } else {					
				  ArrayList<Tile> temp = new ArrayList<Tile>();			
				  temp.add(list.get(this.getMaxNumberInHand(list))); // 把两张joker和手牌里数字最大的一张牌组成meld
				  temp.add(new Tile("J",0));
				  temp.add(new Tile("J",0));
				  this.myMeld.add(temp);
				  return true;
			  }
			  }
		  }
	  return this.hasRun||this.hasSet;
 }
 
 
 // 避免一张牌出现在handmeld里两次。
 public void checkDuplicate() {

	 ArrayList<Tile> duplicateTile = new ArrayList<Tile>();
     ArrayList<ArrayList<Tile>> tempRun = new ArrayList<ArrayList<Tile>>(myRunMeld);
	 ArrayList<ArrayList<Tile>> tempSet = new ArrayList<ArrayList<Tile>>(mySetMeld);
	 for(int i = 0; i<this.myHandTile.size()-1; i++) {
		 if(myHandTile.get(i).compareTile(myHandTile.get(i+1))) {
			 duplicateTile.add(myHandTile.get(i));
		 }
	 }
		 for(int a=0;a<tempRun.size();a++) {
			 for(int b=0;b<tempRun.get(a).size();b++){

				 for(int c=0;c<tempSet.size();c++) {
					 for(int d=0;d<tempSet.get(c).size();d++){
						 
						 if(tempRun.get(a).get(b).compareTile(tempSet.get(c).get(d))) {
							 if(!duplicateTile.contains(tempRun.get(a).get(b))) {
								 if(tempRun.get(a).size()>3 && (b==tempRun.get(a).size()-1 || b==0)) {	// {R2 R3 R4 R5} VS {R5 B5 G5} 可以 remove R5
									 myRunMeld.get(a).remove(myRunMeld.get(a).get(b));
								 } else if(tempSet.get(c).size()>3) {									// {R2 O2 B2 G2] VS {R2 R3 R4} 可以 remove R2
									 mySetMeld.get(c).remove(mySetMeld.get(c).get(d));
								 } else {
									 getLargerMeld(tempRun.get(a),tempSet.get(c));		// 舍弃数字小的meld
								 }
							 }
						 }
					 }
			 
		 }
		 }
	 }
	 myMeld.addAll(mySetMeld);
	 myMeld.addAll(myRunMeld);
 }
 
 
 public void getLargerMeld(ArrayList<Tile> r, ArrayList<Tile> s) {
	 int countRunVlu = 0;
	 int countSetVlu = 0;
	 for(int i=0; i<r.size(); i++) {
		 countRunVlu+=r.get(i).getNumber();
	 }
	 for(int i=0; i<s.size(); i++) {
		 countSetVlu+=s.get(i).getNumber();
	 }
	 if(countRunVlu>countSetVlu) {
		 mySetMeld.remove(s);
	 } else {
		 myRunMeld.remove(r);
	 }
 }
 
 public ArrayList<Tile> getLargestConsuctiveList(ArrayList<ArrayList<Tile>> ll) {
	 int maxNum = 0;
	 int maxIndex = 0;
	 for(int i=0;i<ll.size();i++) {
		 if((ll.get(i).get(0).getNumber()+ll.get(i).get(1).getNumber())>maxNum){
			 maxNum = ll.get(i).get(0).getNumber()+ll.get(i).get(1).getNumber();
			 maxIndex = i;
		 }
	 }
	 return ll.get(maxIndex);
 }
 
 
 /* Helper method for hasRun()
  * Here i assume i2 always larger than i1
  */
 public boolean isContinous(int i1, int i2) {
	  if((i2-i1) == 1) 
	   return true;
	  return false;
 }
 
 
 // return INDEX of max number tile in hand
 public int getMaxNumberInHand(List<Tile> list) {
	 int maxNumber = 0;
	 int maxIndex = 0;
	 for(int i=0; i<list.size();i++) {
		 if(list.get(i).getNumber()>maxNumber) {
			 maxNumber = list.get(i).getNumber();
			 maxIndex = i;
		 }
	 }
	 return maxIndex;
 }
 

 
// public boolean initialCheck(ArrayList<Tile> meld) {
//  
// }
// 
 
 public void computerTurn(Table t, Deck d, Scanner sc) {
 }
 
 public Tile dealTile(Tile t){
	  if(t.getColor().equals("J")) {			// 还原joker 的值
		  for(int i=0;i<this.getNumberOfHandTile();i++) {
			  if(this.getMyHandTile().get(i).getColor().equals("J")) {
				  myHandTile.remove(i);
				  t.setNumber(0);
				  break;
			  }
		  }
	  } else {
		  myHandTile.remove(t);
	  }
	  return t;
 }
 
 public void  hightlightrecenttile(Tile t) {
	
	 t.setColor(t.getColor()+"*");
 }
 public void resettile(Tile t) {
	 
	if (t.getColor().contains("*") ) {
		t.getColor().substring(0, t.getColor().length()-1);
	}
	 
 }
 
 public Tile drawATile(Tile t) {
	  myHandTile.add(t);
	  return t;
 }
 
 public String toString() {
	  String result = "Hand Tile: ";
	
	  for(int i = 0; i < this.myHandTile.size(); i++) {
	   result+= this.myHandTile.get(i).getColor()+
	     this.myHandTile.get(i).getNumber()+" ";
	  }
	  return result;
}

 /* 先找 「o1 o2」, 再找「r1 o1」
  * 只return 一组
 */
public ArrayList<ArrayList<Tile>> twoConsecutiveTiles(List<Tile> list){
	ArrayList<ArrayList<Tile>> tempList = new ArrayList<ArrayList<Tile>>();
	List<Tile> newList = new ArrayList<Tile>();
	newList.addAll(list);
	// find RUN
	Collections.sort(list, new CompareTile()); 
	int count=0;
	while(count<list.size()-1) {
		if(list.get(count).getColor().equals(list.get(count+1).getColor()) && 
			isContinous(list.get(count).getNumber(),list.get(count+1).getNumber())) {
			ArrayList<Tile> temp = new ArrayList<Tile>();
			temp.add(list.get(count));
			temp.add(list.get(count+1));
			newList.remove(list.get(count));
			newList.remove(list.get(count+1));
			tempList.add(temp);
		}
		count++;	
	}
	
	// find SET
	Collections.sort(newList, new CompareTileRankFirst()); 
	count = 0;
	while(count<newList.size()-1) {
		if(newList.get(count).getColor()!=newList.get(count+1).getColor() && 
			newList.get(count).getNumber()==newList.get(count+1).getNumber()) {
			ArrayList<Tile> temp = new ArrayList<Tile>();
			temp.add(newList.get(count));
			temp.add(newList.get(count+1));
			tempList.add(temp);
		}
		count++;
	}
	if(tempList.size()==0) return null;
	else return tempList;
}

/* compare each tile in user's hand 
 * in order to sort them in order Color First
 * R1 R7 R9 B2 G1 D3
 * */
class CompareTile implements Comparator<Tile>{

	 public int compare(Tile t1, Tile t2) {
	  int i = convertColorToInteger(t1).compareTo(convertColorToInteger(t2));
	  if (i != 0){
	       return i;
	    }
	
	  Integer r1 = new Integer(t1.getNumber());
	  Integer r2 = new Integer(t2.getNumber());
	  i = r1.compareTo(r2);
	  return i;
	 }
	 
	 
	
	
	 /* Convert tile's color to Integer
	  * So that it can be compared through .compareTo()
	  * R < B < G < O < JOKER
	  * */
	 public Integer convertColorToInteger(Tile t) {
	  if(t.getColor().equals("R")) {
		   Integer i = new Integer(1);
		   return i;
	  } else if(t.getColor().equals("B")) {
		   Integer i = new Integer(2);
		   return i;
	  } else if(t.getColor().equals("G")) {
		   Integer i = new Integer(3);
		   return i;
	  } else if(t.getColor().equals("O")){
		   Integer i = new Integer(4);
		   return i;
	  } else {
		   Integer i = new Integer(5);
		   return i;
	  }
	 }
}


/* compare each tile in user's hand 
 * in order to sort them in order Rank First
 * int the order: R1 G2 R3 B3 G4 D4 R7
 * */
class CompareTileRankFirst implements Comparator<Tile>{

	 public int compare(Tile t1, Tile t2) {
		  Integer r1 = new Integer(t1.getNumber());
		  Integer r2 = new Integer(t2.getNumber());
		  
		  int i = r1.compareTo(r2);
		  if (i != 0)
		  return i;
		 
		  i = convertColorToInteger(t1).compareTo(convertColorToInteger(t2));  
		  return i;
	 }
 
 


	 /* Convert tile's color to Integer
	  * So that it can be compared through .compareTo()
	  * R < B < G < D < Joker
	  * */
	 public Integer convertColorToInteger(Tile t) {
		  if(t.getColor().equals("R")) {
			   Integer i = new Integer(1);
			   return i;
		  } else if(t.getColor().equals("B")) {
			   Integer i = new Integer(2);
			   return i;
		  } else if(t.getColor().equals("G")) {
			   Integer i = new Integer(3);
			   return i;
		  } else if(t.getColor().equals("O")) {
			   Integer i = new Integer(4);
			   return i;			  
		  } else {
			   Integer i = new Integer(5);
			   return i;
		  }
	 }
}
}
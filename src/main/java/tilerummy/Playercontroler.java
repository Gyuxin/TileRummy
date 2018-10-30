package tilerummy;

import java.util.ArrayList;
import java.util.Scanner;

public class Playercontroler extends Player{
	
	private ArrayList<String> myHandTile = new ArrayList <String>();
	
	private String[] dealcard;
	
	private ArrayList<String> dealcard1 = new ArrayList <String>();

	private Scanner scanner;

	private Scanner temp;
	
	private Table t;
	
	
	  public boolean firstMeldInitialCheck()
	  {
		  return initialedFirstMeld;
	  }
	  
	  public void sort(){
		  super.sort();
	  }
	  public void sortRankFirst(){
		  
		  super.sortRankFirst();
	  }

	  public int getNumberOfHandTile(){
		  
	    return super.getNumberOfHandTile();
	  }

	  public void initialHandTitle(Deck d)
	  {
	    super.initialHandTile(d);
	  }
	  
	  public Tile drawATile(Tile t){
	    return super.drawATile(t);
	  }


	  public String toString(){
	    return super.toString();
	  }


	  public void hasSet(){
		  super.hasSet();
	  }
	  
	  public void hasRun(){
		  super.hasRun();
	  }
	  
	  public boolean hasMeld(){
		  return super.hasMeld();
	  }
	  
	  public void dealornotdeal() {
		  System.out.println("do you want to deal the cards?(Y/N)");
		  scanner = new Scanner(System.in);
		  String temp = scanner.next();
		  if (temp.equalsIgnoreCase("Y")) {
			  dealcard();
		  }else {
			  return;
		  }
	  }
	
	  public void dealcard() {
		
		
		System.out.println("do you want to deal new Meld or add a tile ?(M/T)");
		  scanner = new Scanner(System.in);
		  String temp = scanner.next();
		  if (temp.equalsIgnoreCase("M")) {
				
				
		  }

	}
	  
	
	public void dealmeld() {
		System.out.println("please enter thr meld:");
		temp = new Scanner(System.in);
		dealcard = temp.nextLine().split("\\s+");
		
		for(int i=0; i< myHandTile.size() ; i++) {
			
			for(int j=0; j<dealcard.length;j++) {
				
				if (dealcard[j] == myHandTile.get(i)) {
					
					dealcard1.add(dealcard[j]);
					myHandTile.remove(i);
				}
			}
		}
		t.addMeld(dealcard1);
	}
	
	public void dealtile() {
		
	}
	
}



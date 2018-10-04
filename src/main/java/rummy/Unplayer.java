package rummy;

import java.util.ArrayList;
import java.util.Scanner;

public class Unplayer extends Player{
	
	
	private ArrayList<String> handcard = new ArrayList <String>();
	
	private String[] dealcard;
	
	
	 /*	public void sort(){
										
										  super.sort();
									  }
									  
									  
									  public void sortRankFirst(){
										  
										  super.sortRankFirst();
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
									  public int getNumberOfHandTile(){
										  
									    return super.getNumberOfHandTile();
									  }
								
									  public void initialHandTitle(Deck d){
										  
									    super.initialHandTile(d);
									  }
									  
									  public Tile drawATile(Tile t){
										  
									    return super.drawATile(t);
									  }
									  
									  public String toString(){
										  
									    return super.toString();
									  }
									
	  * 
	  * 
	  */
	
	
	
	
	public void dealcard() {
		
		System.out.println("please deal the cards");
		
		Scanner temp = new Scanner(System.in);
		dealcard = temp.nextLine().split("\\s+");
		
		for(int i=0; i< handcard.size() ; i++) {
			
			for(int j=0; j<dealcard.length;j++) {
				
				if (dealcard[j] == handcard.get(i)) {
					
					dealcard1.add(dealcard[j]);
					handcard.remove(i);
				}
			}
		}
		
	}

}

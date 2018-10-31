package tilerummy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Playercontroler extends Player{
	
	private ArrayList<Tile> myHandTile = new ArrayList <Tile>();
	
	private ArrayList<Tile> dealcard = new ArrayList <Tile>();
	
	private ArrayList<Tile> dealcard1 = new ArrayList <Tile>();
	
	private Meld dealcard2 = new Meld();
	
	private Scanner scanner;

	private Scanner temp;
	
	private Table t;
	
	public int X;
	
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
		  }
	  }
	
		public void dealcard() {
			
			
			System.out.println("do you want to deal new Meld or add a tile ?(M/T)");
			  scanner = new Scanner(System.in);
			  String temp = scanner.next();
			  if (temp.equalsIgnoreCase("M")) {
					dealmeld();
			  }
			  if (temp.equalsIgnoreCase("T")) {
					dealtile();
			  }else {
				  return;
			  }
			  
	
		}
	  
	
		public void dealmeld() {
			System.out.println("please enter thr meld:");
			temp = new Scanner(System.in);
			String s = temp.nextLine();
			int i = temp.nextInt();			
			dealcard.add(Tile(s,i));
			
			for(int i1=0; i1< myHandTile.size() ; i1++) {
				
				for(int j=0; j<dealcard.size();j++) {
					
					if (dealcard.get(j) == myHandTile.get(i1)) {
						
						dealcard1.add(dealcard.get(i));
						myHandTile.remove(i1);
					}
				}
			}
			t = new Table();
			Meld M = new Meld(dealcard1);
			t.addMeld(M);
		}
	
		private Tile Tile(String s, int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public void dealtile() {
			System.out.println("please choose the meld you want to deal:");
			 scanner = new Scanner(System.in);
			 String temp = scanner.next();
			 int X = Integer.parseInt(temp);
			 dealcard2 = t.getMeld(X);
			 
			System.out.println("do you want to deal in front or end (F/E)");
			scanner = new Scanner(System.in);
			String temp1 = scanner.next();
			
			if (temp1.equalsIgnoreCase("F")) {
				System.out.println("input the card you want yo deal");
				scanner = new Scanner(System.in);
				temp1 = scanner.next();
				String x = scanner.next();
				int y = scanner.nextInt();
				Tile p = new Tile(x,y);
				dealcard2.addTileAtFirst(p);
				super.dealTile(p);
			}
			
			if (temp1.equalsIgnoreCase("E")) {
				System.out.println("input the card you want yo deal");
				scanner = new Scanner(System.in);
				temp1 = scanner.next();
				String x = scanner.next();
				int y = scanner.nextInt();
				Tile p = new Tile(x,y);
				dealcard2.addTileAtLast(p);
				super.dealTile(p);
		  	}
		}
	

		

	
}

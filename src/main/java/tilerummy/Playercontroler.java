package tilerummy;

import java.util.ArrayList;
import java.util.Scanner;

public class Playercontroler extends Player{
	
	private ObservableValue ov = null;
	public Playercontroler(ObservableValue ov)
	{
		super();
		this.ov = ov;
	}
	
	private ArrayList<Tile> myHandTile = new ArrayList <Tile>();
	
	private ArrayList<Tile> dealcard = new ArrayList <Tile>();
	
	private ArrayList<Tile> dealcard1 = new ArrayList <Tile>();
	
	private Meld dealcard2 = new Meld();
	
	private Meld dealcard3 = new Meld();
	
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
	    this.ov.setValue(this.getNumberOfHandTile());
	  }
	  
	  public Tile drawATile(Tile t)
	  {
		Tile temp = super.drawATile(t);
		this.ov.setValue(this.getNumberOfHandTile());
	    return temp;
	  }
	  

	  public String toString(){
	    return super.toString();
	  }
	  
	  public void printHandTile()
	  {
		  System.out.println("\nyour hand tile: ");
		  for(int i = 0; i < this.getNumberOfHandTile(); i++)
		  {
			  this.getMyHandTile().get(i).printTile();
		  }
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
	  
	  public void dealornotdeal(Deck d) {
		  
		  System.out.println("do you want to deal the cards?(Y/N)");
		  scanner = new Scanner(System.in);
		  String temp = scanner.next();
		  if (temp.equalsIgnoreCase("Y")) {
			  dealcard();
		  }
		  if (temp.equalsIgnoreCase("N")) {
			  Tile newTile = d.drawTile();
			  this.drawATile(newTile);
		  }
	  }
	
		public void dealcard() {
			
			
			System.out.println("do you want to deal new Meld or add a tile or edit existing table?(M/T/E)");
			  scanner = new Scanner(System.in);
			  String temp = scanner.next();
			  if (temp.equalsIgnoreCase("M")) {
					dealmeld();
			  }
			  if (temp.equalsIgnoreCase("T")) {
					dealtile();
			  }if (temp.equalsIgnoreCase("E")) {
					edittable();
			  }else {
				  tilerummy.Tile next = null;
				  super.drawATile(next);
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
			this.ov.setValue(this.getNumberOfHandTile());
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
				for(int i1=0; i1< myHandTile.size() ; i1++) {
					if (p == myHandTile.get(i1)) {
						myHandTile.remove(i1);
					}
				}
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
				for(int i1=0; i1< myHandTile.size() ; i1++) {
					if (p == myHandTile.get(i1)) {
						myHandTile.remove(i1);
					}
				}
		  	}
			this.ov.setValue(this.getNumberOfHandTile());
		}
		
			public void edittable() {
				System.out.println("please choose the meld you want to edite:");
				 scanner = new Scanner(System.in);
				 String temp = scanner.next();
				 int X = Integer.parseInt(temp);
				 dealcard2 = t.getMeld(X);
				 dealcard3 = t.getMeld(X);
				 
				 System.out.println("please choose card N to card M to slice:");
				 scanner = new Scanner(System.in);
				 String temp1 = scanner.next();
				 String temp2 = scanner.next();
				 int s = Integer.parseInt(temp1);
				 int e = Integer.parseInt(temp2);
				 int count = dealcard2.getMeldSize();
				 dealcard2.slice(s,e);
				 dealcard3.slice(e,count);
				 
				 System.out.println("do you want to deal first meld in front or end or not deal(F/E/N)");
					scanner = new Scanner(System.in);
					String temp3 = scanner.next();
					if (temp3.equalsIgnoreCase("N")) {
						dealsecondmeld();
					}
					if (temp3.equalsIgnoreCase("F")) {
						System.out.println("input the card you want yo deal");
						scanner = new Scanner(System.in);
						temp3 = scanner.next();
						String x = scanner.next();
						int y = scanner.nextInt();
						Tile p = new Tile(x,y);
						dealcard2.addTileAtFirst(p);
						super.dealTile(p);
						for(int i1=0; i1< myHandTile.size() ; i1++) {
							if (p == myHandTile.get(i1)) {
								myHandTile.remove(i1);
							}
						}
					}
					
					if (temp3.equalsIgnoreCase("E")) {
						System.out.println("input the card you want yo deal");
						scanner = new Scanner(System.in);
						temp3 = scanner.next();
						String x = scanner.next();
						int y = scanner.nextInt();
						Tile p = new Tile(x,y);
						dealcard2.addTileAtLast(p);
						super.dealTile(p);
						for(int i1=0; i1< myHandTile.size() ; i1++) {
							if (p == myHandTile.get(i1)) {
								myHandTile.remove(i1);
							}
						}
				  	}
				 
				 
					this.ov.setValue(this.getNumberOfHandTile());
			}
			public void dealsecondmeld() {
				System.out.println("do you want to deal second meld in front or end or not deal(F/E/N)");
				scanner = new Scanner(System.in);
				String temp3 = scanner.next();
				if (temp3.equalsIgnoreCase("N")) {
					return;
				}
				if (temp3.equalsIgnoreCase("F")) {
					System.out.println("input the card you want yo deal");
					scanner = new Scanner(System.in);
					temp3 = scanner.next();
					String x = scanner.next();
					int y = scanner.nextInt();
					Tile p = new Tile(x,y);
					dealcard3.addTileAtFirst(p);
					super.dealTile(p);
					for(int i1=0; i1< myHandTile.size() ; i1++) {
						if (p == myHandTile.get(i1)) {
							myHandTile.remove(i1);
						}
					}
				}
				
				if (temp3.equalsIgnoreCase("E")) {
					System.out.println("input the card you want yo deal");
					scanner = new Scanner(System.in);
					temp3 = scanner.next();
					String x = scanner.next();
					int y = scanner.nextInt();
					Tile p = new Tile(x,y);
					dealcard3.addTileAtLast(p);
					super.dealTile(p);
					for(int i1=0; i1< myHandTile.size() ; i1++) {
						if (p == myHandTile.get(i1)) {
							myHandTile.remove(i1);
						}
					}
			  	}
				this.ov.setValue(this.getNumberOfHandTile());
			}
	

		

	
}
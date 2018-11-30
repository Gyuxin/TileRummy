package tilerummy;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.Iterator;

public class Playercontroler extends Player{
	
	private ObservableValue ov = null;
	private Scanner sc;
	public Playercontroler(ObservableValue ov, Scanner sc)
	{
		this.ov = ov;
		this.sc = sc;
	}
	
	
	private Meld dealcard3 = new Meld();
	
	private Scanner scanner = new Scanner(System.in);
	
	private Table t;
	
	public int X;
	  
	  public void sort(){
		  super.sort();
	  }
	  public void sortRankFirst(){
		  
		  super.sortRankFirst();
	  }

	  public int getNumberOfHandTile(){
		  
	    return super.getNumberOfHandTile();
	  }

	  public void initialHandTitle(Scanner sc, Deck d)
	  {
	    super.initialHandTile(sc, d);
	    this.ov.setValue(this.getNumberOfHandTile());
	  }
	  
	  public Tile drawATile()
	  {
			Tile temp = new Tile(sc.next());
			super.drawATile(temp);
			this.ov.setValue(this.getNumberOfHandTile());
		    return temp;
	  }
	  
	  public Tile dealTile(Tile t){
		  Tile temp = super.dealTile(t);
		  this.ov.setValue(this.getNumberOfHandTile());
		  return temp;
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
	  
	  public void computerTurn(Table t, Deck d, Scanner sc) {
		  
		  System.out.println("do you want to deal the cards?(Y/N)");
		  String temp = sc.next();
		  if (temp.equalsIgnoreCase("Y")) {
			  dealcard(t, sc);
		  }
		  else if (temp.equalsIgnoreCase("N")) {
			  System.out.print("You draw a new tile ... ");
			  this.drawATile().printTile();
		  }
	  }
	
		public void dealcard(Table t, Scanner sc) {
			
			
			System.out.println("do you want to deal new Meld or add a tile or edit existing table?(M/T/E)");
			  String temp = sc.next();
			  System.out.println(temp);
			  if (temp.equalsIgnoreCase("M")) {
					dealmeld(t, sc);
			  }
			  else if (temp.equalsIgnoreCase("T")) {
					dealtile(t);
			  }
//			  }if (temp.equalsIgnoreCase("E")) {
//					edittable();
//			  }
			  else {
				  this.drawATile();
			  }
			  
	
		}
	  
	// User deals a meld from hand 
		public void dealmeld(Table t, Scanner sc) {
			System.out.println("NO OF TILES IN YOUR MELD: ");
			int i = sc.nextInt();
			System.out.println("please enter meld IN ORDER (seperate each tile by space) :");
			String[] N = new String[i];
			for(int j = 0; j<i; j++) {
				N[j] = sc.next();
			}

//			String[] N = sc.nextLine().split("\\s+");  // Put each tile in a String array
			
			ArrayList<Tile> dm = new ArrayList <Tile>(); // dm is the ArrayList<Tile> user about to deal
			for(int a=0; a< N.length; a++) {
				Tile M = new Tile(N[a]);
				dm.add(M);
			}
			Meld usersHandMeld = new Meld(dm); // usersHandMeld is the Meld user about to deal.
			
			
			Iterator<Tile> it = this.getMyHandTile().iterator(); // Iterator is to remove the tile from users' hand tile.
			
			for(int j=0; j<usersHandMeld.getMeldSize();j++) {
				while(it.hasNext()) {
				Tile tempT = it.next();
					if (usersHandMeld.get(j).compareTile(tempT)) {
						usersHandMeld.get(j).printTile();
						it.remove();
						break;
					}
				}
			}
	
			t.addMeld(usersHandMeld); // add the Meld to users's 
			this.ov.setValue(this.getNumberOfHandTile());
			  //print the situation on the table
			  System.out.println("\nSituation of table");
			  t.printTable();
		}
	
		// User deal a single tile
		public void dealtile(Table t)
		  {
		   System.out.println("please choose the INDEX of meld from table that you want to add a tile to:");
		   int indexOfMeld = sc.nextInt();
		   Meld meldToBeAdd = t.getMeld(indexOfMeld);   
		   
		   System.out.println("do you want to deal tile in front or end (F/E) of the Meld");
		   String s = sc.next();
		    System.out.println("input the tile you want yo deal");
		    String tileName = sc.next();
		    Tile tileToBeDeal = new Tile(tileName);
		    tileToBeDeal.printTile();
			
		    if (s.equalsIgnoreCase("F")) {
		    	meldToBeAdd.addTileAtFirst(tileToBeDeal);  			// add tile to the meld 
		    } else {
		    	meldToBeAdd.addTileAtLast(tileToBeDeal);
		    }
		    
		    Iterator<Tile> it = this.getMyHandTile().iterator();	// remove tile from hand tile
		    while(it.hasNext()) {
				Tile tempT = it.next();
			     if (tileToBeDeal.compareTile(tempT)){
				      it.remove();
				      break;
			     }
		    }
		   this.ov.setValue(this.getNumberOfHandTile());
			  //print the situation on the table
			  System.out.println("\nSituation of table");
			  t.printTable();
		  }
}
		
//			public void edittable() {
//				System.out.println("please choose the meld you want to edite:");
//				 scanner = new Scanner(System.in);
//				 String temp = scanner.next();
//				 int X = Integer.parseInt(temp);
//				 dealcard2 = t.getMeld(X);
//				 dealcard3 = t.getMeld(X);
//				 
//				 System.out.println("please choose card N to card M to slice:");
//				 scanner = new Scanner(System.in);
//				 String temp1 = scanner.next();
//				 String temp2 = scanner.next();
//				 int s = Integer.parseInt(temp1);
//				 int e = Integer.parseInt(temp2);
//				 int count = dealcard2.getMeldSize();
//				 dealcard2.slice(s,e);
//				 dealcard3.slice(e,count);
//				 
//				 System.out.println("do you want to deal first meld in front or end or not deal(F/E/N)");
//					scanner = new Scanner(System.in);
//					String temp3 = scanner.next();
//					if (temp3.equalsIgnoreCase("N")) {
//						dealsecondmeld();
//					}
//					if (temp3.equalsIgnoreCase("F")) {
//						System.out.println("input the card you want yo deal");
//						scanner = new Scanner(System.in);
//						temp3 = scanner.next();
//						String x = scanner.next();
//						int y = scanner.nextInt();
//						Tile p = new Tile(x,y);
//						dealcard2.addTileAtFirst(p);
//						super.dealTile(p);
//						for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
//							if (p == this.getMyHandTile().get(i1)) {
//								this.getMyHandTile().remove(i1);
//							}
//						}
//					}
//					
//					if (temp3.equalsIgnoreCase("E")) {
//						System.out.println("input the card you want yo deal");
//						scanner = new Scanner(System.in);
//						temp3 = scanner.next();
//						String x = scanner.next();
//						int y = scanner.nextInt();
//						Tile p = new Tile(x,y);
//						dealcard2.addTileAtLast(p);
//						super.dealTile(p);
//						for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
//							if (p == this.getMyHandTile().get(i1)) {
//								this.getMyHandTile().remove(i1);
//							}
//						}
//				  	}
//				 
//				 
//					this.ov.setValue(this.getNumberOfHandTile());
//			}
//			public void dealsecondmeld() {
//				System.out.println("do you want to deal second meld in front or end or not deal(F/E/N)");
//				scanner = new Scanner(System.in);
//				String temp3 = scanner.next();
//				if (temp3.equalsIgnoreCase("N")) {
//					return;
//				}
//				if (temp3.equalsIgnoreCase("F")) {
//					System.out.println("input the card you want yo deal");
//					scanner = new Scanner(System.in);
//					temp3 = scanner.next();
//					String x = scanner.next();
//					int y = scanner.nextInt();
//					Tile p = new Tile(x,y);
//					dealcard3.addTileAtFirst(p);
//					super.dealTile(p);
//					for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
//						if (p == this.getMyHandTile().get(i1)) {
//							this.getMyHandTile().remove(i1);
//						}
//					}
//				}
//				
//				if (temp3.equalsIgnoreCase("E")) {
//					System.out.println("input the card you want yo deal");
//					scanner = new Scanner(System.in);
//					temp3 = scanner.next();
//					String x = scanner.next();
//					int y = scanner.nextInt();
//					Tile p = new Tile(x,y);
//					dealcard3.addTileAtLast(p);
//					super.dealTile(p);
//					for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
//						if (p == this.getMyHandTile().get(i1)) {
//							this.getMyHandTile().remove(i1);
//						}
//					}
//			  	}
//				this.ov.setValue(this.getNumberOfHandTile());
//			}
//	

		

	

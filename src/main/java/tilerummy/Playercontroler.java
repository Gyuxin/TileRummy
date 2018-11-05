package tilerummy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Playercontroler extends Player{

	private ObservableValue ov = null;
	public Playercontroler(ObservableValue ov)
	{
		this.ov = ov;
	}

	private ArrayList<Tile> dealmeld = new ArrayList <Tile>();

	private Meld dealcard2 = new Meld();

	private Meld dealcard3 = new Meld();

	private Scanner scanner;

	private Scanner temp;


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

	  public void dealornotdeal(Table t, Deck d) {

		  System.out.println("do you want to deal the cards?(Y/N)");
		  scanner = new Scanner(System.in);
		  String temp = scanner.next();
		  if (temp.equalsIgnoreCase("Y")) {
			  dealcard(t);
		  }
		  else if (temp.equalsIgnoreCase("N")) {
			  Tile newTile = d.drawTile();
			  this.drawATile(newTile);
		  }
	  }

		public void dealcard(Table t)
		{
			System.out.println("do you want to deal new Meld or add a tile or edit existing table?(M/T/E)");
			scanner = new Scanner(System.in);
			String temp = scanner.next();
			if(temp.equalsIgnoreCase("M"))
			{
				dealmeld(t);
			}
			if(temp.equalsIgnoreCase("T"))
			{
				dealtile(t);
			}
			if(temp.equalsIgnoreCase("E"))
			{
				edittable(t);
			}
			else
			{
				tilerummy.Tile next = null;
				super.drawATile(next);
			}
		}

	    //FIXED
		public void dealmeld(Table t)
		{
			System.out.println("please enter thr meld:");
			temp = new Scanner(System.in);
		    String[] N = temp.nextLine().split("\\s+");
			ArrayList<Tile> dm = new ArrayList <Tile>();
			for(int a=0; a< N.length; a++)
			{
				Tile M = new Tile(N[a]);
			    dm.add(M);
			}
			Meld usersHandMeld = new Meld(dm);
			System.out.println(usersHandMeld.getMeldSize());
			Iterator<Tile> it = this.getMyHandTile().iterator();
			for(int j=0; j<usersHandMeld.getMeldSize();j++)
			{
				while(it.hasNext())
				{
					Tile tempT = it.next();
			        if (usersHandMeld.get(j).compareTile(tempT))
			        {
			           usersHandMeld.get(j).printTile();
			           it.remove();
			           break;
			        }
			     }
		    }
			Meld MM = new Meld(dm);
			t.addMeld(MM);
			System.out.println("HANDTILE:"+this.toString());
			System.out.println("no of handtile"+this.getNumberOfHandTile());
			this.ov.setValue(this.getNumberOfHandTile());
	    }

        //FIXED
		// User deal a single tile
		  public void dealtile(Table t)
		    {
		     System.out.println("please choose the INDEX of meld from table that you want to add a tile to:");
		     String meldName = scanner.next();
		     int indexOfMeld = Integer.parseInt(meldName);

		     Meld meldToBeAdd = t.getMeld(indexOfMeld);

		     System.out.println("do you want to deal tile in front or end (F/E) of the Meld");
		     String s = scanner.next();

		      System.out.println("input the tile you want yo deal");
		      String tileName = scanner.next();
		      Tile tileToBeDeal = new Tile(tileName);
		      tileToBeDeal.printTile();

		      if (s.equalsIgnoreCase("F")) {
		       meldToBeAdd.addTileAtFirst(tileToBeDeal);     // add tile to the meld
		      } else {
		       meldToBeAdd.addTileAtLast(tileToBeDeal);
		      }

		      Iterator<Tile> it = this.getMyHandTile().iterator(); // remove tile from hand tile
		      while(it.hasNext()) {
		    Tile tempT = it.next();
		        if (tileToBeDeal.compareTile(tempT)){
		          it.remove();
		          break;
		        }
		      }
		     this.ov.setValue(this.getNumberOfHandTile());
		    }







			public void edittable(Table t) {
				System.out.println("please choose the meld you want to edite:");
				 scanner = new Scanner(System.in);
				 int temp = scanner.nextInt();
				 Meld target = t.getMeld(temp);
				 Meld tempMeld = new Meld();
				 for(int i = 0; i<target.getMeldSize();i++)
				 {
					 tempMeld.addTileAtFirst(target.get(i));
				 }
				 System.out.println("please choose card N to card M to slice:");
				 scanner = new Scanner(System.in);
				 int cutLine1 = scanner.nextInt();
			     int cutLine2 = scanner.nextInt();
			     System.out.println("the first split list is: ");
			     dealcard2 = target;

				 int count = dealcard2.getMeldSize();
				 dealcard2.slice(cutLine1,cutLine2);
				 dealcard2.printMeld();
				 for(int j=0; j<dealcard2.getMeldSize();j++)
				 {
					 tempMeld.getMeld().remove(dealcard2.get(j));
				 }
				 tempMeld.printMeld();



				 System.out.println("do you want to deal to first meld in front or end or not deal(F/E/N)");
					scanner = new Scanner(System.in);
					String temp3 = scanner.next();
					if (temp3.equalsIgnoreCase("N")) {
						dealsecondmeld();
					}
					if (temp3.equalsIgnoreCase("F")) {
						System.out.println("input the card you want to deal");
						scanner = new Scanner(System.in);
						String tileName = scanner.next();
						Tile p = new Tile(tileName);
						dealcard2.addTileAtFirst(p);
						super.dealTile(p);
						for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
							if (p == this.getMyHandTile().get(i1)) {
								this.getMyHandTile().remove(i1);
							}
						}
					}

					if (temp3.equalsIgnoreCase("E")) {
						System.out.println("input the card you want to deal");
						scanner = new Scanner(System.in);
						String tileName = scanner.next();
						Tile p = new Tile(tileName);
						dealcard2.addTileAtLast(p);
						super.dealTile(p);
						for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
							if (p == this.getMyHandTile().get(i1)) {
								this.getMyHandTile().remove(i1);
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
					String tileName = scanner.next();
					Tile p = new Tile(tileName);
					dealcard3.addTileAtFirst(p);
					super.dealTile(p);
					for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
						if (p == this.getMyHandTile().get(i1)) {
							this.getMyHandTile().remove(i1);
						}
					}
				}

				if (temp3.equalsIgnoreCase("E")) {
					System.out.println("input the card you want yo deal");
					scanner = new Scanner(System.in);
					String tileName = scanner.next();
					Tile p = new Tile(tileName);
					dealcard3.addTileAtLast(p);
					super.dealTile(p);
					for(int i1=0; i1< this.getMyHandTile().size() ; i1++) {
						if (p == this.getMyHandTile().get(i1)) {
							this.getMyHandTile().remove(i1);
						}
					}
			  	}
				this.ov.setValue(this.getNumberOfHandTile());
			}





}

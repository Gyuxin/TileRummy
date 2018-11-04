package tilerummy;

import java.util.ArrayList;

public class Computer1 extends Player{

	private ObservableValue ov = null;
	public Computer1(ObservableValue ov)
	{
		super();
		this.ov = ov;
	}
	public boolean firstMeldInitialCheck()
	  {
		  return initialedFirstMeld;
	  }
	  public void sort()
	  {
		  super.sort();
	  }
	  public void sortRankFirst()
	  {
		  super.sortRankFirst();
	  }
	  
	  public int getNumberOfHandTile()
	  {
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

	  public String toString()
	  {
	    return super.toString();
	  }

	  
	  public void hasSet()
	  {
		  super.hasSet();
	  }
	  public void hasRun()
	  {
		  super.hasRun();
	  }
	  public boolean hasMeld()
	  {
		  return super.hasMeld();
	  }
	  public void printHandTile()
	  {
		  System.out.println("\ncomputer 1 's hand tile: ");
		  for(int i = 0; i < this.getNumberOfHandTile(); i++)
		  {
			  this.getMyHandTile().get(i).printTile();
		  }
	  }
	  public void initialFirstMeld(Table t, Deck d)
	  {
		  System.out.println("Computer1 start initial his first meld");
		  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
		  if(this.hasMeld())
		  {
			  int[] meldSums = new int[this.getMyMeld().size()];
			  int initialSum = 0;
	     	  int index = 0;
     		  for(int i = 0; i<this.getMyMeld().size();i++)
     		  {
     			  int total = 0;
				  for(int j=0;j<this.getMyMeld().get(i).size();j++)
				  {
					  total += this.getMyMeld().get(i).get(j).getNumber();
				  }
				  if(total>=30)
				  {
					  handOutTiles = this.getMyMeld();
					  System.out.println("Computer1 detect a initial meld, which is: ");
					  for(int a =0; a<this.getMyMeld().get(i).size();a++)
					  {
						  this.getMyMeld().get(i).get(a).printTile();
					  }
				  }
				  else if(total<30)
				  {
					  meldSums[index] = total;
					  index++;	  
				  }
			   }
			   if(handOutTiles.size() == 0)
			   {
				  for(int i = 0 ;i < this.getMyMeld().size(); i++)
				  {
					  initialSum += meldSums[i];
					  if(initialSum >=30)
					  {
						  handOutTiles = this.getMyMeld();
					  }
				  }  
			   }
		   }
		  if(handOutTiles.size()==0)
		  {
			  System.out.println("Computer1 can not initial his first meld");
			  //player draw a new tile
			  System.out.println("Computer1 draw a new tile");
			  Tile newTile = d.drawTile();
			  this.drawATile(newTile);
			  
			  System.out.println("computer1 get:" );
			  newTile.printTile();
			  
		  }
		  else if(!handOutTiles.isEmpty())
		  {
			  System.out.println("Computer1 initial his first meld successfully");
			  //delete those tiles from player hand tile
			  System.out.println("computer 1 hand tiles are: ");
			  for(int x = 0; x<handOutTiles.size();x++)
			  {
				  for(int y =0 ; y<handOutTiles.get(x).size(); y++)
				  {
					  handOutTiles.get(x).get(y).printTile();
					  this.dealTile(handOutTiles.get(x).get(y));
				  		
				  }  
			  }
			  //initial player has already initial his or her first meld
			  this.initialedFirstMeld = true;
			  //add those melds on the table
			  for(int i = 0; i <handOutTiles.size();i++)
			  {
				  Meld initialMeld = new Meld(handOutTiles.get(i));
				  t.addMeld(initialMeld);
			  }
			  //print the situation on the table
			  System.out.println("\nSituation of table");
			  t.printTable();
		  }
	  }
	  public void playing(Table t, Deck d)
	  {
		  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
		  boolean computer1MeldChanged = false;
		  boolean computer1NoChanged = true;
		  if(this.hasMeld())
		  {
			  for(int i = 0; i <this.getMyMeld().size(); i++)
			  {
				  handOutTiles.add(this.getMyMeld().get(i));
			  }
			  //add those melds on the table and display on the console
			  System.out.println("\ncomputer 1 deal some new melds: ");
			  for(int i = 0; i <handOutTiles.size();i++)
			  {
				  Meld newMeld = new Meld(handOutTiles.get(i));
				  newMeld.printMeld();
				  t.addMeld(newMeld);
			  }
			 
			  System.out.println("computer 1 deal tiles are: ");
			  //remove from the hand
			  for(int x = 0; x<handOutTiles.size();x++)
			  {
				  for(int y =0 ; y<handOutTiles.get(x).size(); y++)
				  {
					  handOutTiles.get(x).get(y).printTile();
					  this.dealTile(handOutTiles.get(x).get(y));  		
				  }  
			  }
			  System.out.println("\nThe situation on the table is: ");
			  t.printTable();
			  
			  //check if computer still have tile can be deal on the table according to the situation on the table
			  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
			  for(int j = 0; j<temp.size();j++)
			  {
				  computer1MeldChanged = Logic.addOneTile(temp.get(j),t);
				  if(computer1MeldChanged)
				  {
					  System.out.println("\ncomputer 1 deal another tile on the table ");
					  temp.get(j).printTile();
					  //remove from hand
					  this.getMyHandTile().remove(temp.get(j));
					  this.ov.setValue(this.getNumberOfHandTile());
				  }
			   }
			  
			   //print out the table
			   System.out.println("\nsituation on the table");
			   t.printTable();
		  }
		  else
		  {
			ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
			 for(int j = 0; j<temp.size();j++)
			 {
				 computer1MeldChanged = Logic.addOneTile(temp.get(j),t);
				 if(computer1MeldChanged)
				 {
					 System.out.println("\ncomputer 1 deal tile: ");
					 temp.get(j).printTile();
					 //remove from hand
					 this.getMyHandTile().remove(temp.get(j));
					 this.ov.setValue(this.getNumberOfHandTile());
					 computer1NoChanged = false;
				 }
			 }
			 if(computer1NoChanged)
			 {
				 System.out.println("\ncomputer 1 can do nothing, he draw a need card");
				 Tile newTile = d.drawTile();
				 this.drawATile(newTile);
				 System.out.println("\ncomputer 1 get :");
				 newTile.printTile();
				 System.out.println("\nNothing changed on the table");
				 
			 }
			 else if(!computer1NoChanged)
			 {
				 System.out.println("\nsituation on the table");
				 t.printTable();
			 }
		  }  
	  }
	  
	  public static void computerTurn(Computer1 thisComputer, Table gameTable, Deck gameDeck)
		{
			if(!thisComputer.initialedFirstMeld)
			{
				System.out.println("\nComputer1 has not initialed his first meld");
				thisComputer.initialFirstMeld(gameTable, gameDeck);
				if(!thisComputer.initialedFirstMeld)
				{
					System.out.println(" \nNothing has been changed on the table");
				}
			}
			else
			{
				thisComputer.playing(gameTable, gameDeck);
			}
		}
}
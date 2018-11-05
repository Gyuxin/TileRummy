package tilerummy;

import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class Computer3 extends Player implements Observer{

	private ObservableValue ov = null;
	private boolean canPlay = false;
	public Computer3(ObservableValue ov)
	{
		super();
		this.ov = ov;
	}

	public void update(Observable obs, Object obj)
	{
		if(this.getNumberOfHandTile() - ov.getValue() >=3) {
			canPlay = true;
		} else {
			canPlay = false;
		}
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
	  }
	  public Tile drawATile(Tile t)
	  {
	    return super.drawATile(t);
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
		  System.out.println("\ncomputer 3 's hand tile: ");
		  for(int i = 0; i < this.getNumberOfHandTile(); i++)
		  {
			  this.getMyHandTile().get(i).printTile();
		  }
	  }
	  public void initialFirstMeld(Table t, Deck d)
	  {
		  System.out.println("Computer3 start initial his first meld");
		  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
		  if(this.hasMeld())
		  {
			  int indexOfMield = 0;
			  int sumOfInitial = 0;
		      int[] mieldSums = new int[this.getMyMeld().size()];
		      for(int i = 0; i<this.getMyMeld().size();i++)
		      {
		    	  int total = 0;

		    	  for(int j=0;j<this.getMyMeld().get(i).size();j++)
			      {
			    	  total += this.getMyMeld().get(i).get(j).getNumber();
			      }
			      if(total>=30)
			      {
			    	  handOutTiles.add(this.getMyMeld().get(i));
			    	  System.out.println("computer 3 detect a initial meld, which is: ");
			    	  for(int a =0; a<this.getMyMeld().get(i).size(); a++)
			    	  {
			    		  this.getMyMeld().get(i).get(a).printTile();
			    	  }
			    	  break;
			      }
			      else
			      {
			    	  mieldSums[indexOfMield] = total;
				      indexOfMield++;
				  }
			  }
		      if(handOutTiles.size() == 0)
		      {
		    	  int i = 0;
				  while(sumOfInitial<30 && i<this.getMyMeld().size())
				  {
					  sumOfInitial += mieldSums[i];
					  if(sumOfInitial >=30)
					  {
						  for(int a =0; a<=i; a++)
						  {
							  handOutTiles.add(this.getMyMeld().get(a));
						  }
						  System.out.println("\ncomputer 3 use more than one meld to initial his first 30+, those are: ");
						  for(int b = 0; b <handOutTiles.size(); b++)
						  {
							  System.out.println("{");
							  for(int c = 0; c <handOutTiles.get(b).size(); c++)
							  {
								  handOutTiles.get(b).get(c).printTile();
							  }
							  System.out.println("}");
						  }
					  }
					  i++;
				  }
			  }
		  }
		  if(handOutTiles.size()==0)
		  {
			  System.out.println("Computer3 can not initial his first meld");
			  //player draw a new tile
			  System.out.println("Computer3 draw a new tile");
			  Tile newTile = d.drawTile();
			  this.drawATile(newTile);
			  System.out.println("computer 3 get: ");
			  newTile.printTile();
		  }
		  else if(!handOutTiles.isEmpty())
		  {
			  System.out.println("\nComputer3 initial his first meld successfully");
			  System.out.println("computer 3 deal tiles are: ");
			  //delete those tiles from player hand tile
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
		  boolean computer3MeldChanged = false;
		  boolean computer3NoChanged = true;
		  if(canPlay)
		  {
			  if(this.hasMeld())
			  {
				  for(int i = 0; i <this.getMyMeld().size(); i++)
				  {
					  handOutTiles.add(this.getMyMeld().get(i));
				  }
				  System.out.println("\ncomputer 3 deal some new melds: ");
				  //add on the table and display on the console
				  for(int i = 0; i <handOutTiles.size();i++)
				  {
					  Meld newMeld = new Meld(handOutTiles.get(i));
					  newMeld.printMeld();
					  t.addMeld(newMeld);
				  }
				  System.out.println("\ncomputer 3 deal tiles are: ");
				  //remove from hand tile
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
				  //check if computer still have tile in hand can be deal on the table according to the situation on the table
				  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
				  for(int j = 0; j<temp.size();j++)
				  {
					  computer3MeldChanged = Logic.addOneTile(temp.get(j),t);
					  if(computer3MeldChanged)
					  {
						  System.out.println("\ncomputer 3 would reuse table ");
						  temp.get(j).printTile();
						  this.getMyHandTile().remove(temp.get(j));
					  }
				  }

					//check if computer still have two tiles can be deal at the same time
				  ArrayList<ArrayList<Tile>> tiles = Logic.twoConsecutiveTiles(temp);
				  boolean computer3ChangedAgain = false;
				  for(int k = 0; k < tiles.size(); k++)
				  {
					  computer3ChangedAgain = Logic.addTwoTiles(tiles.get(k), t);
					  if(computer3ChangedAgain)
					  {
						  System.out.println("\ncomputer2 reuse the table again");
						  for(int l = 0; l<tiles.get(k).size(); l++)
						  {
							  //print tiles name
							  tiles.get(k).get(l).printTile();
						  }
						  //remove those two tiles in the arraylist
						  Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());

					  }
				  }
				  System.out.println("\nThe situation on the table is: ");
				  t.printTable();
			  }
			  else
			  {
				  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
					 for(int j = 0; j<temp.size();j++)
					 {
						 computer3MeldChanged = Logic.addOneTile(temp.get(j),t);
						 if(computer3MeldChanged)
						 {
							 System.out.println("\ncomputer 3 deal tiles: ");
							 temp.get(j).printTile();
							 this.getMyHandTile().remove(temp.get(j));
							 computer3NoChanged = false;
						 }
					 }

					 //check if computer still have two tiles can be deal at the same time
					  ArrayList<ArrayList<Tile>> tiles = Logic.twoConsecutiveTiles(this.getMyHandTile());
					  boolean computer3ChangedAgain = false;
					  for(int k = 0; k < tiles.size(); k++)
					  {
						  computer3ChangedAgain = Logic.addTwoTiles(tiles.get(k), t);
						  if(computer3ChangedAgain)
						  {
							  System.out.println("\ncomputer2 reuse the table again");
							  for(int l = 0; l<tiles.get(k).size(); l++)
							  {
								  //print tiles name
								  tiles.get(k).get(l).printTile();
							  }
							  //remove those two tiles in the arraylist
							  Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());

						  }
					  }
					 if(computer3NoChanged && !computer3ChangedAgain)
					 {
						 System.out.println("\ncomputer 3 can do nothing, he draw a new card");
						 Tile newTile = d.drawTile();
						 this.drawATile(newTile);
						 System.out.println("computer 3 get: ");
						 newTile.printTile();
					 }
					 else if(!computer3NoChanged || computer3ChangedAgain)
					 {
						 System.out.println("\nthe situation on the table is: ");
					 }
			  }

		  }
		  else
		  {
			  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
				 for(int j = 0; j<temp.size();j++)
				 {
					 computer3MeldChanged = Logic.addOneTile(temp.get(j),t);
					 if(computer3MeldChanged)
					 {
						 System.out.println("\ncomputer 3 deal tiles: ");
						 temp.get(j).printTile();
						 this.getMyHandTile().remove(temp.get(j));
						 computer3NoChanged = false;
					 }
				 }

				 //check if computer still have two tiles can be deal at the same time
				  ArrayList<ArrayList<Tile>> tiles = Logic.twoConsecutiveTiles(this.getMyHandTile());
				  boolean computer3ChangedAgain = false;
				  for(int k = 0; k < tiles.size(); k++)
				  {
					  computer3ChangedAgain = Logic.addTwoTiles(tiles.get(k), t);
					  if(computer3ChangedAgain)
					  {
						  System.out.println("\ncomputer2 reuse the table again");
						  for(int l = 0; l<tiles.get(k).size(); l++)
						  {
							  //print tiles name
							  tiles.get(k).get(l).printTile();
						  }
						  //remove those two tiles in the arraylist
						  Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());

					  }
				  }
				 if(computer3NoChanged && !computer3ChangedAgain)
				 {
					 System.out.println("\ncomputer 3 can do nothing, he draw a new card");
					 Tile newTile = d.drawTile();
					 System.out.println("\ncomputer 3 get: ");
					 newTile.printTile();
				 }
				 else if(!computer3NoChanged || computer3ChangedAgain)
				 {
					 System.out.println("\nthe situation on the table is: ");
				 }
		  }
	  }
	  public static void computerTurn(Computer3 thisComputer, Table gameTable, Deck gameDeck)
		{
			if(!thisComputer.initialedFirstMeld)
			{
				System.out.println("\nComputer3 has not initialed his first meld");
				thisComputer.initialFirstMeld(gameTable, gameDeck);
				if(!thisComputer.initialedFirstMeld)
				{
					System.out.println("\nNothing has been changed on the table");
				}
			}
			else
			{
				thisComputer.playing(gameTable, gameDeck);
			}
		}
}

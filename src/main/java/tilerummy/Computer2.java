package tilerummy;

import java.util.ArrayList;
public class Computer2 extends Player{
	
	private ObservableValue ov = null;
	public Computer2(ObservableValue ov)
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
		this.ov.setValue(this.getNumberOfHandTile());
	    super.initialHandTile(d);
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
		  System.out.println("\ncomputer 2 's hand tile: ");
		  for(int i = 0; i < this.getNumberOfHandTile(); i++)
		  {
			  this.getMyHandTile().get(i).printTile();
		  }
	  }
	  public void initialFirstMeld(Table t, Deck d)
	  {
		  System.out.println("Computer2 start initial his first meld");
		  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
		  int sumOfInitial = 0;
		  if(this.hasMeld())
		  {
			  if(!t.isEmpty())
			  {
				  int indexOfMield = 0;
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
				    	  System.out.println("computer 2 detect a initial meld, which is: ");
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
							  System.out.println("\ncomputer 2 use more than one meld to initial his first 30+, those are: ");
							  for(int b = 0; b <handOutTiles.size(); b++)
							  {
								  
								  for(int c = 0; c <handOutTiles.get(b).size(); c++)
								  {
									  handOutTiles.get(b).get(c).printTile();
								  }
								  System.out.println("\n");
							  }
						  }
						  i++;
					  }  
				  }
			  }
		  }
		  if(handOutTiles.size()==0)
		  {
			  System.out.println("computer2 can not initial his first meld");
			  //player draw a new tile
			  System.out.println("computer2 draw a new tile");
			  Tile newTile = d.drawTile();
			  this.drawATile(newTile);  
			  System.out.println("computer 2 get : ");
			  newTile.printTile();
		  }
		  else if(!handOutTiles.isEmpty())
		  {
			  System.out.println("\ncomputer2 initial his first meld successfully");
			  System.out.println("computer 2 deal tiles are: ");
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
		  boolean computer2MeldChanged = false;
		  boolean computer2NoChanged = true;
		  
		  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
			 for(int j = 0; j<temp.size();j++)
			 {
				 computer2MeldChanged = Logic.addOneTile(temp.get(j),t);
				 if(computer2MeldChanged)
				 {
					 System.out.println("\ncomputer 2 deal tile: ");
					 temp.get(j).printTile();
					 this.getMyHandTile().remove(temp.get(j));
					 this.ov.setValue(this.getNumberOfHandTile());
					 computer2NoChanged = false;
				 }
			 }
			 if(computer2NoChanged)
			 {
				 System.out.println("\ncomputer 2 can do thing, he draw a card");
				 Tile newTile = d.drawTile();
				 this.drawATile(newTile);
				 System.out.println("\ncomputer2 get : ");
				 newTile.printTile();
			 }
			 else if(!computer2NoChanged)
			 {
				 System.out.println("\nthe situation on the table is: ");
				 t.printTable();
			 }
	  }
	  public static void computerTurn(Computer2 thisComputer, Table gameTable, Deck gameDeck)
		{
			if(!thisComputer.initialedFirstMeld)
			{
				System.out.println("\nComputer2 has not initialed his first meld");
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
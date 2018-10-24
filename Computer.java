import java.util.ArrayList;

class Computer extends Player
{
  // Stratergy;
	private String stratergyType = null;
  public Computer(String s)
  {
    super();
    stratergyType = s;

  }
  public boolean firstMeldInitialCheck()
  {
	  return initialedFirstMeld;
  }
  public String getStratergyType()
  {
	  return stratergyType;
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
  public void initialFirstMeld(Table t, Deck d)
  {
	  System.out.println("player start initial his first meld");
	  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();

	  if(this.stratergyType == "stratergy1")
	  {
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
					  System.out.println("\n");
					  System.out.println("Computer1 detect a initial meld, which is: ");
					  for(int a =0; a<this.getMyMeld().get(i).size();a++)
					  {
						  this.getMyMeld().get(i).get(a).printTile();
					  }
					  System.out.println("\n");

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
	  }
	  else if(this.stratergyType == "stratergy2")
	  {
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
				    	  System.out.println("\n");
				    	  System.out.println("computer 2 detect a initial meld, which is: ");
				    	  for(int a =0; a<this.getMyMeld().get(i).size(); a++)
				    	  {
				    		  this.getMyMeld().get(i).get(a).printTile();
				    	  }
				    	  System.out.println("\n");
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
							  System.out.println("\n");
							  System.out.println("computer 2 use more than one meld to initial his first 30+, those are: ");
							  for(int b = 0; b <handOutTiles.size(); b++)
							  {
								  System.out.println("{");
								  for(int c = 0; c <handOutTiles.get(b).size(); c++)
								  {
									  handOutTiles.get(b).get(c).printTile();
								  }
								  System.out.println("}");
								  System.out.println("\n");
							  }
						  }
						  i++;
					  }
				  }
			  }
		  }
	  }
	  else if(this.stratergyType == "stratergy3")
	  {
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
			    	  System.out.println("\n");
			    	  System.out.println("computer 3 detect a initial meld, which is: ");
			    	  for(int a =0; a<this.getMyMeld().get(i).size(); a++)
			    	  {
			    		  this.getMyMeld().get(i).get(a).printTile();
			    	  }
			    	  System.out.println("\n");
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
						  System.out.println("\n");
						  System.out.println("computer 3 use more than one meld to initial his first 30+, those are: ");
						  for(int b = 0; b <handOutTiles.size(); b++)
						  {
							  System.out.println("{");
							  for(int c = 0; c <handOutTiles.get(b).size(); c++)
							  {
								  handOutTiles.get(b).get(c).printTile();
							  }
							  System.out.println("}");
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
		  System.out.println("player can not initial his first meld");
		  //player draw a new tile
		  System.out.println("player draw a new tile");
		  this.drawATile(d.drawTile());
	  }
	  else if(!handOutTiles.isEmpty())
	  {
		  System.out.println("player initial his first meld successfully");
		  //delete those tiles from player hand tile
		  for(int x = 0; x<handOutTiles.size();x++)
		  {
			  for(int y =0 ; y<handOutTiles.get(x).size(); y++)
			  {
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
		  System.out.println("Situation of table");
		  t.printTable();
	  }
  }





  public void playing(Table t, Deck d, int player1HandCardNumber, int player2HandCardNumber, int player3HandCardNumber)
  {
	  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
	  if(this.stratergyType == "stratergy1")
	  {
		  boolean computer1MeldChanged = false;
		  boolean computer1NoChanged = true;

		  if(this.hasMeld())
		  {
			  for(int i = 0; i <this.getMyMeld().size(); i++)
			  {
				  handOutTiles.add(this.getMyMeld().get(i));
			  }
			  //add those melds on the table and display on the console
			  System.out.println("computer 1 deal some new melds: ");
			  for(int i = 0; i <handOutTiles.size();i++)
			  {
				  Meld newMeld = new Meld(handOutTiles.get(i));
				  newMeld.printMeld();
				  t.addMeld(newMeld);
			  }
			  System.out.println("The situation on the table");
			  t.printTable();
			  //remove from the hand
			  for(int x = 0; x<handOutTiles.size();x++)
			  {
				  for(int y =0 ; y<handOutTiles.get(x).size(); y++)
				  {
					  this.dealTile(handOutTiles.get(x).get(y));

				  }
			  }

		  }
		  else
		  {
			ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
			 for(int j = 0; j<temp.size();j++)
			 {
				 computer1MeldChanged = Logic.addOneTile(temp.get(j),t);
				 if(computer1MeldChanged)
				 {
					 System.out.println("computer 1 deal tile: ");
					 temp.get(j).printTile();
					 //remove from hand
					 this.getMyHandTile().remove(temp.get(j));
					 computer1NoChanged = false;
				 }
			 }
			 if(computer1NoChanged)
			 {
				 System.out.println("computer 1 can do nothing, he draw a need card");
				 System.out.println("Nothing changed on the table");
				 this.drawATile(d.drawTile());
			 }
			 else if(!computer1NoChanged)
			 {
				 System.out.println("situation on the table");
				 t.printTable();
			 }
		  }
	  }
	  else if(this.stratergyType == "stratergy2")
	  {
		  boolean computer2MeldChanged = false;
		  boolean computer2NoChanged = true;

		  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
			 for(int j = 0; j<temp.size();j++)
			 {
				 computer2MeldChanged = Logic.addOneTile(temp.get(j),t);
				 if(computer2MeldChanged)
				 {
					 System.out.println("computer 2 deal tile: ");
					 temp.get(j).printTile();
					 this.getMyHandTile().remove(temp.get(j));
					 computer2NoChanged = false;
				 }
			 }
			 if(computer2NoChanged)
			 {
				 System.out.println("computer 2 can do thing, he draw a card");
				 this.drawATile(d.drawTile());
			 }
			 else if(!computer2NoChanged)
			 {
				 System.out.println("the situation on the table is: ");
				 t.printTable();
			 }
	  }
	  else if(this.stratergyType == "stratergy3")
	  {
		  boolean computer3MeldChanged = false;
		  boolean computer3NoChanged = true;
		  if(this.getMyHandTile().size() - player1HandCardNumber >= 3 || this.getMyHandTile().size() - player2HandCardNumber >= 3 || this.getMyHandTile().size() - player3HandCardNumber >= 3)
		  {
			  if(this.hasMeld())
			  {
				  for(int i = 0; i <this.getMyMeld().size(); i++)
				  {
					  handOutTiles.add(this.getMyMeld().get(i));
				  }
				  System.out.println("computer 3 deal some new melds: ");
				  //add on the table and display on the console
				  for(int i = 0; i <handOutTiles.size();i++)
				  {
					  Meld newMeld = new Meld(handOutTiles.get(i));
					  newMeld.printMeld();
					  t.addMeld(newMeld);
				  }
				  System.out.println("The situation on the table is: ");
				  t.printTable();
				  //remove from hand tile
				  for(int x = 0; x<handOutTiles.size();x++)
				  {
					  for(int y =0 ; y<handOutTiles.get(x).size(); y++)
					  {
						  this.dealTile(handOutTiles.get(x).get(y));

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
							 System.out.println("computer 3 deal tiles: ");
							 temp.get(j).printTile();
							 this.getMyHandTile().remove(temp.get(j));
							 computer3NoChanged = false;
						 }
					 }
					 if(computer3NoChanged)
					 {
						 System.out.println("computer 3 can do nothing, he draw a new card");
						 this.drawATile(d.drawTile());
					 }
					 else if(!computer3NoChanged)
					 {
						 System.out.println("the situation on the table is: ");
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
						 System.out.println("computer 3 deal tiles: ");
						 temp.get(j).printTile();
						 this.getMyHandTile().remove(temp.get(j));
						 computer3NoChanged = false;
					 }
				 }
				 if(computer3NoChanged)
				 {
					 System.out.println("computer 3 can do nothing, he draw a new card");
					 this.drawATile(d.drawTile());
				 }
				 else if(!computer3NoChanged)
				 {
					 System.out.println("the situation on the table is: ");
				 }
		  }

	  }
  }
}

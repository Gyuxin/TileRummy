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
  public boolean firstWiledInitialCheck()
  {
	  return initialedFirstMield;
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
							  System.out.println("computer 2 use more than one meld to initial his first 30+, those are: ");
							  for(int b = 0; b <handOutTiles.size(); b++)
							  {
								  System.out.println("{}");
								  for(int c = 0; c <handOutTiles.get(b).size(); c++)
								  {
									  handOutTiles.get(b).get(c).printTile();
								  }
								  System.out.println("{}");
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
						  System.out.println("computer 3 use more than one meld to initial his first 30+, those are: ");
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
				  for(int a = 0; a <this.getMyHandTile().size();a++)
				  {
					  if(this.getMyMeld().get(x).get(y) == this.getMyHandTile().get(a))
					  {
						  this.getMyHandTile().remove(this.getMyMeld().get(x).get(y));
					  }
				  }

			  }

		  }
		  //initial player has already initial his or her first meld
		  this.initialedFirstMield = true;
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





  public void dealCard(Table t, int player1HandCardNumber, int player2HandCardNumber, int player3HandCardNumber)
  {
	  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
	  if(this.stratergyType == "stratergy1")
	  {
		  if(this.hasMeld())
		  {
			  for(int i = 0; i <this.getMyMeld().size(); i++)
			  {
				  handOutTiles.add(this.getMyMeld().get(i));
			  }
		  }
		  else
		  {
			  //according and the situation on the table to deal card
		  }

	  }
	  else if(this.stratergyType == "stratergy2")
	  {
		//only deal card according to the situation on the table
	  }
	  else if(this.stratergyType == "stratergy3")
	  {
		  if(this.getMyHandTile().size() - player1HandCardNumber >= 3 || this.getMyHandTile().size() - player2HandCardNumber >= 3 || this.getMyHandTile().size() - player3HandCardNumber >= 3)
		  {
			  if(this.hasMeld())
			  {
				  for(int i = 0; i <this.getMyMeld().size(); i++)
				  {
					  handOutTiles.add(this.getMyMeld().get(i));
				  }
			  }
			  else
			  {
				//according the situation on the table to deal card
			  }

		  }
		  else
		  {
			//only deal card according to the situation on the table
		  }

	  }
  }



  //by using stratergy

  // public void dealCardAccordingStratergy()
  // {
  //
  // }
}

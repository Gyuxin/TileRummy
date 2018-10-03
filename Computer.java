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
  public ArrayList<ArrayList<Tile>> initialFirstMield(Table t, int player1HandCardNumber, int player2HandCardNumber, int player3HandCardNumber)
  {
	  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
	  if(this.stratergyType == "stratergy1")
	  {
		  if(this.hasMeld())
		  {
			  int[] mieldSums = new int[this.getNumberOfHandTile()];
			  int index = 0;
			  int total = 0;
			  int initialSum = 0;
			  for(int i = 0; i<this.getNumberOfHandTile();i++)
			  {
				  for(int j=0;j<this.getMyMeld().get(i).size();j++)
				  {
					  total += this.getMyMeld().get(i).get(j).getNumber();
				  }
				  if(total>=30)
				  {
					  handOutTiles = this.getMyMeld();
					  break;
				  }
				  else
				  {
					  mieldSums[index] = total;
					  index++;
				  }
			  }
			  if(handOutTiles.size() == 0)
			  {
				  int i = 0;
				  while(initialSum<=30 || i<this.getNumberOfHandTile())
				  {
					  initialSum += mieldSums[i];
					  i++;
				  }
				  if(initialSum >=30)
				  {
					  handOutTiles = this.getMyMeld();
				  }
			  }
		  }
	  }
	  else if(this.stratergyType == "stratergy2")//make sure what stratergy that computer use
	  {
		  int sumOfInitial = 0;
		  if(this.hasMeld())
		  {
			  if(!t.isEmpty())
			  {
				  int indexOfMield = 0;
			      int[] mieldSums = new int[this.getNumberOfHandTile()];
			      for(int i = 0; i<this.getNumberOfHandTile();i++)
			      {
			    	  int total = 0;
				      for(int j=0;j<this.getMyMeld().get(i).size();j++)
				      {
				    	  total += this.getMyMeld().get(i).get(j).getNumber();
				      }
				      if(total>=30)
				      {
				    	  handOutTiles.add(this.getMyMeld().get(i));
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
					  while(sumOfInitial<=30 || i<this.getNumberOfHandTile())
					  {
						  sumOfInitial += mieldSums[i];
						  i++;
					  }
					  if(sumOfInitial >=30)
					  {
						  for(int a =0; a<=i; a++)
						  {
							  handOutTiles.add(this.getMyMeld().get(a));
						  }
					  }
				  }
			  }
		  }
	  }
	  else if(this.stratergyType == "stratergy3")
	  {
		  if(this.hasMeld())
		  {
			  if(this.getNumberOfHandTile()- player1HandCardNumber <= 3 || this.getNumberOfHandTile()- player2HandCardNumber <= 3 ||this.getNumberOfHandTile()- player3HandCardNumber <= 3)
			  {
				  if(this.hasMeld())
				  {
					  int[] mieldSums = new int[this.getNumberOfHandTile()];
					  int index = 0;
					  int total = 0;
					  int initialSum = 0;
					  for(int i = 0; i<this.getNumberOfHandTile();i++)
					  {
						  for(int j=0;j<this.getMyMeld().get(i).size();j++)
						  {
							  total += this.getMyMeld().get(i).get(j).getNumber();
						  }
						  if(total>=30)
						  {
							  handOutTiles = this.getMyMeld();
							  break;
						  }
						  else
						  {
							  mieldSums[index] = total;
							  index++;
						  }
					  }
					  if(handOutTiles.size() == 0)
					  {
						  int i = 0;
						  while(initialSum<=30 || i<this.getNumberOfHandTile())
						  {
							  initialSum += mieldSums[i];
							  i++;
						  }
						  if(initialSum >=30)
						  {
							  handOutTiles = this.getMyMeld();
						  }
					  }
				  }

			  }
			  else
			  {
				  int[] mieldSums = new int[this.getNumberOfHandTile()];
				  int index = 0;
				  int total = 0;
				  int initialSum = 0;
				  for(int i = 0; i<this.getNumberOfHandTile();i++)
				  {
					  for(int j=0;j<this.getMyMeld().get(i).size();j++)
					  {
						  total += this.getMyMeld().get(i).get(j).getNumber();
					  }
					  if(total>=30)
					  {
						  handOutTiles.add(this.getMyMeld().get(i));
				    	  break;
					  }
					  else
					  {
						  mieldSums[index] = total;
						  index++;
					  }
				  }
				  if(handOutTiles.size() == 0)
				  {
					  int i = 0;
					  while(initialSum<=30 || i<this.getNumberOfHandTile())
					  {
						  initialSum += mieldSums[i];
						  i++;
					  }
					  if(initialSum >=30)
					  {
						  for(int a =0; a<=i; a++)
						  {
							  handOutTiles.add(this.getMyMeld().get(a));
						  }
					  }
				  }
			  }
		  }
	  }
	  for(int x = 0; x<handOutTiles.size();x++)
	  {
		  int index = 0;
		  for(int y = 0; y<this.getNumberOfHandTile(); y++)
		  {
			  for(int a = 0; a < handOutTiles.size(); a++)
			  {
				  for(int b = 0; b <handOutTiles.get(a).size();b++)
				  {
					  if(handOutTiles.get(a).get(b) == this.getMyHandTile().get(y))
					  {
						  index = y;
						  this.getMyHandTile().remove(y);
					  }
				  }
			  }
		  }
	  }
	  return handOutTiles;
	 }
  public void dealCard(int player1HandCardNumber, int player2HandCardNumber, int player3HandCardNumber)
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

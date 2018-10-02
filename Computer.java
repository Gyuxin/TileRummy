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

  public void dealCard()
  {

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
  public ArrayList<ArrayList<Tile>> initialFirstMield(Table t)
  {
	  ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
	  if(this.stratergyType == "stratergy1")
	  {
		  if(this.hasMeld())
		  {
			  int[] mieldSums = new int[this.myMeld.size()];
			  int index = 0;
			  int total = 0;
			  int initialSum = 0;
			  for(int i = 0; i<this.myMeld.size();i++)
			  {
				  for(int j=0;j<this.myMeld.get(i).size();j++)
				  {
					  total += this.myMeld.get(i).get(j).getNumber();
				  }
				  if(total>=30)
				  {
					  handOutTiles = this.myMeld;
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
				  while(initialSum<=30 || i<this.myMeld.size())
				  {
					  initialSum += mieldSums[i];
					  i++;
				  }
				  if(initialSum >=30)
				  {
					  handOutTiles = this.myMeld;
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
			      int[] mieldSums = new int[this.myMeld.size()];
			      for(int i = 0; i<this.myMeld.size();i++)
			      {
			    	  int total = 0;
				      for(int j=0;j<this.myMeld.get(i).size();j++)
				      {
				    	  total += this.myMeld.get(i).get(j).getNumber();
				      }
				      if(total>=30)
				      {
				    	  if(this.myMeld.get(i).size() <= 3)
				    	  {
				    		  handOutTiles.add(this.myMeld.get(i));
						      break;
				          }
				    	  else
				    	  {
				    		  int sum = 0;
						      int index = this.myMeld.get(i).size()-1;
						      ArrayList<Tile> temp = new ArrayList<Tile>();
						      while(sum<=30 || index >=0 )
						      {
						    	  sum += this.myMeld.get(i).get(index).getNumber();
						    	  temp.add(this.myMeld.get(i).get(index));
							      index--;
							  }
						      handOutTiles.add(temp);
				          }
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
					  while(sumOfInitial<=30 || i<this.myMeld.size())
					  {
						  sumOfInitial += mieldSums[i];
						  i++;
					  }
					  if(sumOfInitial >=30)
					  {
						  for(int a =0; a<=i; a++)
						  {
							  handOutTiles.add(this.myMeld.get(a));
						  }
					  }
				  }
			      else if(handOutTiles.size()>1)
			      {
				  }
			  }
		  }
	  }




	return handOutTiles;

  }


  //by using stratergy

  // public void dealCardAccordingStratergy()
  // {
  //
  // }
}

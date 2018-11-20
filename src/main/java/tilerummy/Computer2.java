package tilerummy;

import java.util.ArrayList;
import java.util.Scanner;
public class Computer2 extends Player{
	
	private ObservableValue ov = null;
	private Scanner sc;
	public Computer2(ObservableValue ov, Scanner sc)
	{
		super();
		this.ov = ov;
		this.sc = sc;
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
	  
	  public void initialHandTitle(Scanner sc)
	  {
		this.ov.setValue(this.getNumberOfHandTile());
	    super.initialHandTile(sc);
	  }
	  public Tile drawATile(Tile t)
	  {
		 
		Tile temp = new Tile(sc.next());
		
		super.drawATile(temp);
		this.ov.setValue(this.getNumberOfHandTile());
		this.sort();
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
	  
	  public int jokerIndex() {
		  for(int i = 0; i<this.getMyMeld().size(); i++) {
			  if(this.getMyMeld().get(i).get(2).getColor().equals("J")) {	// JOKER is always in the 2nd index of a meld.
				  return i;
			  }
		  }
		  return 99;
	  }
	  
	  public void jokerReplaceVlu(int index) {
		  if(this.getMyMeld().get(index).get(0).getNumber()==this.getMyMeld().get(index).get(1).getNumber()) {	// meld is a set
			  this.getMyMeld().get(index).get(2).setNumber(this.getMyMeld().get(index).get(0).getNumber());  // 把joker number换成它replace的值
		  } else {		// meld is a run
			  int temp = this.getMyMeld().get(index).get(1).getNumber()+1;
			  if(temp!=14) {		// case{o12 o13 j0}
				  this.getMyMeld().get(index).get(2).setNumber(this.getMyMeld().get(index).get(1).getNumber()+1);  // 把joker number换成它replace的值
			  } else {
				  this.getMyMeld().get(index).get(2).setNumber(11);
			  }
		  }
	  }
	  
	  public void bothJokerReplaceVlu(int index) {
			  this.getMyMeld().get(index).get(2).setNumber(this.getMyMeld().get(index).get(0).getNumber());  // 把joker number换成它replace的值
			  this.getMyMeld().get(index).get(1).setNumber(this.getMyMeld().get(index).get(0).getNumber());  // 把joker number换成它replace的值
	  }
	  
	  public int numberOfJokerInMeld() {
		  int count=0;
		  for(int i=0;i<this.getMyMeld().size();i++) {
			  if(this.getMyMeld().get(i).get(2).getColor().equals("J")){
				  count++;
			  }
		  }
		  return count;
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
				  if(this.numberOfJokerInMeld()>0) {			// 手里有joker
					  int index = jokerIndex();
					  if(this.numberOfJokerInMeld()==1) {		// 一张joker
						  this.jokerReplaceVlu(index);
					  } else {									// 两张joker
						  this.bothJokerReplaceVlu(index);
					  }
				  }
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
			  System.out.println("computer 2 get : ");
			  Tile newTile = d.drawTile();
			  this.drawATile(newTile).printTile();
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
		  boolean lastMeldInHand = false;
		  
		  if(this.hasMeld())
		  {
			  ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
			  for(int a=0; a<this.getMyMeld().size();a++)
			  {
				  for(int b=0; b<this.getMyMeld().get(a).size();b++)
				  {
					  temp.remove(this.getMyMeld().get(a).get(b));
				  }
			  }
			  if(temp.size()==0)
			  {
				  lastMeldInHand = true;
			  }
		  }

		  if(lastMeldInHand)
		  {
			  System.out.println("computer2 deal all the tiles(which is a meld) in his hand and finish the game: ");
			  for(int a=0; a<this.getMyMeld().size();a++)
			  {
				  for(int b=0; b<this.getMyMeld().get(a).size();b++)
				  {
					  this.getMyMeld().get(a).get(b).printTile();
					  this.getMyHandTile().remove(this.getMyMeld().get(a).get(b));
				  }
			  }
			  this.ov.setValue(this.getNumberOfHandTile());
		  }
		  else if(!lastMeldInHand)
		  {
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


				//check if computer still have two tiles can be deal at the same time
				  ArrayList<ArrayList<Tile>> tiles = Logic.twoConsecutiveTiles(this.getMyHandTile());
				  boolean computer2ChangedAgain = false;
				  for(int k = 0; k < tiles.size(); k++)
				  {
					  computer2ChangedAgain = Logic.addTwoTiles(tiles.get(k), t);
					  if(computer2ChangedAgain)
					  {
						  System.out.println("\ncomputer2 reuse the table again");
						  for(int l = 0; l<tiles.get(k).size(); l++)
						  {
							  //print tiles name
							  tiles.get(k).get(l).printTile();
						  }
						  //remove those two tiles in the arraylist
						  Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());
							this.ov.setValue(this.getNumberOfHandTile());

					  }
				  }

				 if(computer2NoChanged && !computer2ChangedAgain)
				 {
					 System.out.println("\ncomputer 2 can do thing, he draw a card");
					 Tile newTile = d.drawTile();
					 this.drawATile(newTile);
					 System.out.println("\ncomputer2 get : ");
					 newTile.printTile();
				 }
				 else if(!computer2NoChanged || computer2ChangedAgain)
				 {
					 System.out.println("\nthe situation on the table is: ");
					 t.printTable();
				 }
		  }
	  }
	  public void computerTurn(Table gameTable, Deck gameDeck, Scanner sc)
		{
			if(!this.initialedFirstMeld)
			{
				System.out.println("\nComputer2 has not initialed his first meld");
				this.initialFirstMeld(gameTable, gameDeck);
				if(!this.initialedFirstMeld)
				{
					System.out.println("\nNothing has been changed on the table");
				}
			}
			else
			{
				this.playing(gameTable, gameDeck);
			}
		}
	  
	  

}
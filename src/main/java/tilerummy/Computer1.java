package tilerummy;

import java.util.ArrayList;
import java.util.Scanner;

public class Computer1 extends Player{

 private ObservableValue ov = null;
 private Scanner sc;
 private InfoView info;
 public Computer1() {
  
 }
 public Computer1(ObservableValue ov, Scanner sc)
 {
  super();
  this.ov = ov;
  this.sc = sc;
 }
 
 @Override
  public String getPlayerType() {
   return "Coumputer:Strategy 1";
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
   
   public void initialHandTitle(Scanner sc, Deck d)
   {
     super.initialHandTile(sc, d);
     this.ov.setValue(this.getNumberOfHandTile());
   }
   public Tile drawATile(Tile t)
   {
  //Tile temp = new Tile(sc.next());
  super.drawATile(t);
  this.ov.setValue(this.getNumberOfHandTile());
  this.sort();
     return t;
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
    info.addToConsole("\n\ncomputer 1 's hand tile: ");
    for(int i = 0; i < this.getNumberOfHandTile(); i++)
    {
     info.addToConsole(this.getMyHandTile().get(i).printTile());
    }
   }
   
   public int jokerIndex() {
    for(int i = 0; i<this.getMyMeld().size(); i++) {
     if(this.getMyMeld().get(i).get(2).getColor().equals("J")) { // JOKER is always in the 2nd index of a meld.
      return i;
     }
    }
    return 99;
   }
   
   public void jokerReplaceVlu(int index) {
    if(this.getMyMeld().get(index).get(0).getNumber()==this.getMyMeld().get(index).get(1).getNumber()) { // meld is a set
     this.getMyMeld().get(index).get(2).setNumber(this.getMyMeld().get(index).get(0).getNumber());  // 把joker number换成它replace的值
    } else {  // meld is a run
     int temp = this.getMyMeld().get(index).get(1).getNumber()+1;
     if(temp!=14) {  // case{o12 o13 j0}
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
    info.addToConsole("\nComputer1 start initial his first meld");
    ArrayList<ArrayList<Tile>> handOutTiles = new ArrayList<ArrayList<Tile>>();
    if(this.hasMeld())
    {
     if(this.numberOfJokerInMeld()>0) {   // 手里有joker
      
      int index = jokerIndex();
      if(this.numberOfJokerInMeld()==1) {  // 一张joker
       this.jokerReplaceVlu(index);
      } else {         // 两张joker
       this.bothJokerReplaceVlu(index);
      }
     }
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
       info.addToConsole("\nComputer1 detect a initial meld, which is: ");
       for(int a =0; a<this.getMyMeld().get(i).size();a++)
       {
        info.addToConsole(this.getMyMeld().get(i).get(a).printTile());
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
     info.addToConsole("\nComputer1 can not initial his first meld");
     //player draw a new tile
     info.addToConsole("\nComputer1 draw a new tile");
     info.addToConsole("\ncomputer1 get:" );
     Tile newTile = d.drawTile();
     info.addToConsole(this.drawATile(newTile).printTile());
     
    }
    else if(!handOutTiles.isEmpty())
    {
     info.addToConsole("\nComputer1 initial his first meld successfully");
     //delete those tiles from player hand tile
     info.addToConsole("\ncomputer 1 hand tiles are: ");
     
     for(int x = 0; x<handOutTiles.size();x++)
     {
      for(int y =0 ; y<handOutTiles.get(x).size(); y++)
      {
       info.addToConsole(handOutTiles.get(x).get(y).printTile());
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
     info.addToConsole("\n\nSituation of table");
     info.addToConsole(t.printTable());
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
     info.addToConsole("\n\ncomputer 1 deal some new melds: ");
     for(int i = 0; i <handOutTiles.size();i++)
     {
      Meld newMeld = new Meld(handOutTiles.get(i));
      info.addToConsole(newMeld.printMeld());
      t.addMeld(newMeld);
     }
    
     info.addToConsole("\ncomputer 1 deal tiles are: ");
     //remove from the hand
     for(int x = 0; x<handOutTiles.size();x++)
     {
      for(int y =0 ; y<handOutTiles.get(x).size(); y++)
      {
       info.addToConsole(handOutTiles.get(x).get(y).printTile());
       this.dealTile(handOutTiles.get(x).get(y));    
      }  
     }
     info.addToConsole("\n\nThe situation on the table is: ");
     info.addToConsole(t.printTable());
     
     //check if computer still have tile can be deal on the table according to the situation on the table
     ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
     for(int j = 0; j<temp.size();j++)
     {
      computer1MeldChanged = Logic.addOneTile(temp.get(j),t);
      if(computer1MeldChanged)
      {
       info.addToConsole("\n\ncomputer 1 deal another tile on the table ");
       info.addToConsole(temp.get(j).printTile());
       //remove from hand
       this.getMyHandTile().remove(temp.get(j));
       this.ov.setValue(this.getNumberOfHandTile());
      }
      }
     //check if computer still have two tiles can be deal at the same time
     ArrayList<ArrayList<Tile>> tiles = Logic.twoConsecutiveTiles(this.getMyHandTile());
     boolean computer1ChangedAgain = false;
     for(int k = 0; k < tiles.size(); k++)
     {
      computer1ChangedAgain = Logic.addTwoTiles(tiles.get(k), t);
      if(computer1ChangedAgain)
      {
       info.addToConsole("\n\ncomputer1 reuse the table again");
       for(int l = 0; l<tiles.get(k).size(); l++)
       {
        //print tiles name
        info.addToConsole(tiles.get(k).get(l).printTile());
       }
       //remove those two tiles in the arraylist
       Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());
      this.ov.setValue(this.getNumberOfHandTile());

      }
     }
      //print out the table
      info.addToConsole("\n\nsituation on the table");
      info.addToConsole(t.printTable());
    }
    else
    {
    ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
     for(int j = 0; j<temp.size();j++)
     {
      computer1MeldChanged = Logic.addOneTile(temp.get(j),t);
      if(computer1MeldChanged)
      {
       info.addToConsole("\n\ncomputer 1 deal tile: ");
       info.addToConsole(temp.get(j).printTile());
       //remove from hand
       this.getMyHandTile().remove(temp.get(j));
       this.ov.setValue(this.getNumberOfHandTile());
       computer1NoChanged = false;
      }
     }
     //check if computer still have two tiles can be deal at the same time
      ArrayList<ArrayList<Tile>> tiles = Logic.twoConsecutiveTiles(this.getMyHandTile());
      boolean computer1ChangedAgain = false;
      for(int k = 0; k < tiles.size(); k++)
      {
       computer1ChangedAgain = Logic.addTwoTiles(tiles.get(k), t);
       if(computer1ChangedAgain)
       {
        info.addToConsole("\n\ncomputer1 reuse the table again");
        for(int l = 0; l<tiles.get(k).size(); l++)
        {
         //print tiles name
         info.addToConsole(tiles.get(k).get(l).printTile());
        }
        //remove those two tiles in the arraylist
        Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());
       this.ov.setValue(this.getNumberOfHandTile());

       }
      }
     if(computer1NoChanged && !computer1ChangedAgain)
     {
      info.addToConsole("\n\ncomputer 1 can do nothing, he draw a need card");
      Tile newTile = d.drawTile();
      this.drawATile(newTile);
      info.addToConsole("\n\ncomputer 1 get :");
      info.addToConsole(newTile.printTile());
      info.addToConsole("\n\nNothing changed on the table");

     }
     else if(!computer1NoChanged || computer1ChangedAgain)
     {
      info.addToConsole("\n\nsituation on the table");
      info.addToConsole(t.printTable());
     }
    }  
   }
   
   public void playerTurn(Table gameTable, Deck gameDeck, Scanner sc, InfoView info)
  {
	   info.addToConsole(this.toString());
     this.info = info;
   if(!this.initialedFirstMeld)
   {
    info.addToConsole("\n\nComputer1 has not initialed his first meld");
    this.initialFirstMeld(gameTable, gameDeck);
    if(!this.initialedFirstMeld)
    {
     info.addToConsole("\n \nNothing has been changed on the table");
    }
   }
   else
   {
    this.playing(gameTable, gameDeck);
   }
  }
}
package tilerummy;

import java.util.ArrayList;

import java.util.Observer;
import java.util.Scanner;
import java.util.Observable;

public class Computer3 extends Player implements Observer{

 private ObservableValue ov = null;
 private boolean canPlay = false;
 private Scanner sc;
 private InfoView info;
 public Computer3(ObservableValue ov, Scanner sc)
 {
  super();
  this.ov = ov;
  this.sc = sc;
 }

 @Override
  public String getPlayerType() {
   return "Coumputer:Strategy 3";
  }
 
 public void update(Observable obs, Object obj)
 {
  if(this.getNumberOfHandTile() - ov.getValue() >=3) {
   canPlay = true;
  }
 }

 public void setCanplay(boolean flag)
 {
  this.canPlay = flag;
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
     super.initialHandTile(sc,d);
   }
   public Tile drawATile(Tile t)
   {
   Tile temp = new Tile(sc.next());
   
   super.drawATile(temp);
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
    info.addToConsole("\n\ncomputer 3 's hand tile: ");
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
    info.addToConsole("\nComputer3 start initial his first meld");
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
          info.addToConsole("\ncomputer 3 detect a initial meld, which is: ");
          for(int a =0; a<this.getMyMeld().get(i).size(); a++)
          {
           info.addToConsole(this.getMyMeld().get(i).get(a).printTile());
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
        info.addToConsole("\n\ncomputer 3 use more than one meld to initial his first 30+, those are: ");
        for(int b = 0; b <handOutTiles.size(); b++)
        {
         info.addToConsole("\n{");
         for(int c = 0; c <handOutTiles.get(b).size(); c++)
         {
          handOutTiles.get(b).get(c).printTile();
         }
         info.addToConsole("\n}");
        }
       }
       i++;
      }
     }
    }
    if(handOutTiles.size()==0)
    {
     info.addToConsole("\nComputer3 can not initial his first meld");
     //player draw a new tile
     info.addToConsole("\nComputer3 draw a new tile");
     info.addToConsole("\ncomputer 3 get: ");
     Tile newTile = d.drawTile();
     info.addToConsole(this.drawATile(newTile).printTile());
    }
    else if(!handOutTiles.isEmpty())
    {
     info.addToConsole("\n\nComputer3 initial his first meld successfully");
     info.addToConsole("\ncomputer 3 deal tiles are: ");
     //delete those tiles from player hand tile
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
      info.addToConsole("\n\ncomputer 3 deal some new melds: ");
      //add on the table and display on the console
      for(int i = 0; i <handOutTiles.size();i++)
      {
       Meld newMeld = new Meld(handOutTiles.get(i));
       newMeld.printMeld();
       t.addMeld(newMeld);
      }
      info.addToConsole("\n\ncomputer 3 deal tiles are: ");
      //remove from hand tile
      for(int x = 0; x<handOutTiles.size();x++)
      {
       for(int y =0 ; y<handOutTiles.get(x).size(); y++)
       {
        info.addToConsole(handOutTiles.get(x).get(y).printTile());
        this.dealTile(handOutTiles.get(x).get(y));

       }
      }
      info.addToConsole("\n\nThe situation on the table is: ");
      t.printTable();
      //check if computer still have tile in hand can be deal on the table according to the situation on the table
      ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
      for(int j = 0; j<temp.size();j++)
      {
       computer3MeldChanged = Logic.addOneTile(temp.get(j),t);
       if(computer3MeldChanged)
       {
        info.addToConsole("\n\ncomputer 3 would reuse table ");
        info.addToConsole(temp.get(j).printTile());
        this.getMyHandTile().remove(temp.get(j));
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
           info.addToConsole("\n\ncomputer3 reuse the table again");
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
      info.addToConsole("\n\nThe situation on the table is: ");
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
        info.addToConsole("\n\ncomputer 3 deal tiles: ");
        info.addToConsole(temp.get(j).printTile());
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
            info.addToConsole("\n\ncomputer3 reuse the table again");
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
      if(computer3NoChanged && !computer3ChangedAgain)
      {
       info.addToConsole("\n\ncomputer 3 can do nothing, he draw a new card");
       info.addToConsole("\ncomputer 3 get: ");
        Tile newTile = d.drawTile();
        info.addToConsole(this.drawATile(newTile).printTile());
      }
      else if(!computer3NoChanged || computer3ChangedAgain)
      {
       info.addToConsole("\n\nthe situation on the table is: ");
       t.printTable();
      }
     }

    }
    else
    {
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
      info.addToConsole("\ncomputer3 deal all the tiles(which is a meld) in his hand and finish the game: ");
      for(int a=0; a<this.getMyMeld().size();a++)
      {
       for(int b=0; b<this.getMyMeld().get(a).size();b++)
       {
        info.addToConsole(this.getMyMeld().get(a).get(b).printTile());
        this.getMyHandTile().remove(this.getMyMeld().get(a).get(b));
       }
      }
     }
     else if(!lastMeldInHand)
     {
      ArrayList<Tile> temp = new ArrayList<Tile>(this.getMyHandTile());
      for(int j = 0; j<temp.size();j++)
      {
       computer3MeldChanged = Logic.addOneTile(temp.get(j),t);
       if(computer3MeldChanged)
       {
        info.addToConsole("\n\ncomputer 3 deal tiles: ");
        info.addToConsole(temp.get(j).printTile());
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
         info.addToConsole("\n\ncomputer3 reuse the table again");
         for(int l = 0; l<tiles.get(k).size(); l++)
         {
          //print tiles name
          info.addToConsole(tiles.get(k).get(l).printTile());
         }
         //remove those two tiles in the arraylist
         Logic.removeTwoTiles(tiles.get(k), this.getMyHandTile());

        }
       }
      if(computer3NoChanged && !computer3ChangedAgain)
      {
       info.addToConsole("\n\ncomputer 3 can do nothing, he draw a new card");
       Tile newTile = d.drawTile();
       info.addToConsole("\n\ncomputer 3 get: ");
       info.addToConsole(newTile.printTile());
      }
      else if(!computer3NoChanged || computer3ChangedAgain)
      {
       info.addToConsole("\n\nthe situation on the table is: ");
       t.printTable();
      }
      
     }
    }
   }
   public void playerTurn(Table gameTable, Deck gameDeck, Scanner sc, InfoView info)
  {
    this.info = info;
   if(!this.initialedFirstMeld)
   {
    info.addToConsole("\n\nComputer3 has not initialed his first meld");
    this.initialFirstMeld(gameTable, gameDeck);
    if(!this.initialedFirstMeld)
    {
     info.addToConsole("\n\nNothing has been changed on the table");
    }
   }
   else
   {
    this.playing(gameTable, gameDeck);
   }
   this.setCanplay(false);
  }
}
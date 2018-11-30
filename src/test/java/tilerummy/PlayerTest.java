package tilerummy;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;


public class PlayerTest extends TestCase {

	public void testHasSet() {
		Player p = new Player();
		  Tile t1 = new Tile("R",8);
	      Tile t2 = new Tile("R",10);
	      Tile t3 = new Tile("R",11);
	      Tile t4 = new Tile("R",12);
	      Tile t5 = new Tile("B",1);
	      Tile t6 = new Tile("B",10);
	      Tile t7 = new Tile("B",11);
	      Tile t8 = new Tile("G",1);
	      Tile t9 = new Tile("G",4);
	      Tile t10 = new Tile("G",8);
	      Tile t11 = new Tile("G",10);
	      Tile t12 = new Tile("O",3);
	      Tile t13 = new Tile("O",8);
	      Tile t14 = new Tile("O",11);
	      Tile t15 = new Tile("O",13);
	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);
	      p.drawATile(t11);
	      p.drawATile(t12);
	      p.drawATile(t13);
	      p.drawATile(t14);
	      p.drawATile(t15);
//	      
	      //p.hasSet();
	      
//	      System.out.println(p.toString());
//	      p.hasMeld();
//	      System.out.println("begin");
////	      assertEquals(9, p.getNumberOfHandTile());
//	      for(int i = 0; i< p.getMyMeld().size();i++) {
//	    	  for(int j = 0; j<p.getMyMeld().get(i).size(); j++){
//	    	      p.getMyMeld().get(i).get(j).printTile();
//	    	  }
//	    	  System.out.println("");
//	      }
//	      System.out.println("end");
	}
	
	public void testCase2() {
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("R",4);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("B",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("R",8);
	      Tile t9 = new Tile("B",8);
	      Tile t10 = new Tile("O",8);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);

//	      
	      //p.hasSet();
	      
	      System.out.println(p.toString());
	      p.hasMeld();
	      System.out.println("begin");
//	      assertEquals(9, p.getNumberOfHandTile());
	      for(int i = 0; i< p.getMyMeld().size();i++) {
	    	  for(int j = 0; j<p.getMyMeld().get(i).size(); j++){
	    	      p.getMyMeld().get(i).get(j).printTile();
	    	  }
	    	  System.out.println("");
	      }
	      System.out.println("end");
	}
	
	public void testHandTileSortWithJoker() {
		System.out.println("\n\nTEST FOR HAND TILE SORT WITH JOKER:\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("B",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("G",8);
	      Tile t9 = new Tile("O",8);
	      Tile t10 = new Tile("J",0);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);
	      
	      p.sort();
	      
	      System.out.println(p.toString());

	      p.sortRankFirst();

	      System.out.println(p.toString());
	}

	public void testNumberOfJokerInHand() {
		System.out.println("\n\nTEST FOR NUMBER OF JOKER IN HAND:\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("B",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("G",8);
	      Tile t9 = new Tile("O",8);
	      Tile t10 = new Tile("J",0);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);
	      
	      System.out.println(p.numberOfJokerInHand());
	      
	      p.dealTile(t2);
	      System.out.println(p.numberOfJokerInHand());
	}
	
	public void testTwoConsecutiveFunction() {
		System.out.println("\n\nTEST FOR twoConsecutiveTiles RETURN:\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("R",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("R",5);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("G",8);
	      Tile t9 = new Tile("O",8);
	      Tile t10 = new Tile("J",0);

	      
	      //p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);

	      p.sort();
	      p.hasMeld();
	      System.out.println(p.toString());
	      List<Tile> exclude = p.tilesNotInMeld();
	      p.printMyMeld();
	      for(int i=0;i<exclude.size();i++) {
		      exclude.get(i).printTile();
		      System.out.println("\n");
	      }

	      
	      if(p.twoConsecutiveTiles(exclude)!=null) {
		      for(int i = 0; i<p.twoConsecutiveTiles(exclude).size();i++) {
		    	  for(int j = 0; j<p.twoConsecutiveTiles(exclude).get(i).size(); j++) {
		    		  p.twoConsecutiveTiles(exclude).get(i).get(j).printTile();
		    	  }
		      }
	      }
	}
	
	public void testMaxNumberInHand() {
		System.out.println("\n\nTEST FOR RETURN MAX NUMBER IN HAND\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("B",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("G",8);
	      Tile t9 = new Tile("O",8);
	      Tile t10 = new Tile("J",0);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);

	      System.out.println(p.getMaxNumberInHand());
	}

	public void testCheckDuplicate() {
		System.out.println("\n\nTEST CHECK DUPLICATE\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("B",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("R",2);
	      Tile t9 = new Tile("R",4);
	      Tile t10 = new Tile("O",5);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      //p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);
	      p.sort();
	      p.hasMeld();
	      System.out.println(p.toString());
	      p.printMyMeld();
	      System.out.println(p.getMyMeld().size());
	}
	
	public void testMeldWithJoker() {
		System.out.println("\n\nTEST HAND MELD WITH JOKER\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("O",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("R",2);
	      Tile t9 = new Tile("R",4);
	      Tile t10 = new Tile("J",0);

	      
	      //p.drawATile(t1);
	      p.drawATile(t2);
	     // p.drawATile(t3);
	    //  p.drawATile(t4);
	    //  p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	     // p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);

	      p.sort();
	      p.hasMeld();
	      System.out.println(p.toString());
	      p.printMyMeld();
	      
	}
	
	public void testTilesNotInMeld() {
		System.out.println("\n\nTEST HAND TILES EXCLUDE FROM MELD\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("O",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("R",2);
	      Tile t9 = new Tile("R",4);
	      Tile t10 = new Tile("J",0);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);

	      p.sort();
	      p.hasMeld();
	      p.printMyMeld();
	      System.out.println(p.toString());
	      for(int i=0;i<p.tilesNotInMeld().size();i++) {
	    	  p.tilesNotInMeld().get(i).printTile();
	      }
	
	      
	      System.out.println(p.toString());
	      
	      
	}
	
	public void testPlayFirst() {
		System.out.println("\n\nTEST PLAY FIRST\n\n");
		Player p = new Player();
		  Tile t1 = new Tile("R",3);
	      Tile t2 = new Tile("J",0);
	      Tile t3 = new Tile("R",5);
	      Tile t4 = new Tile("B",4);
	      Tile t5 = new Tile("B",5);
	      Tile t6 = new Tile("O",6);
	      Tile t7 = new Tile("G",5);
	      Tile t8 = new Tile("R",2);
	      Tile t9 = new Tile("R",4);
	      Tile t10 = new Tile("J",0);

	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      p.drawATile(t10);

	      p.sort();
	      p.hasMeld();
	      p.printMyMeld();
	      System.out.println(p.toString());
	      for(int i=0;i<p.tilesNotInMeld().size();i++) {
	    	  p.tilesNotInMeld().get(i).printTile();
	      }
	
	      
	      System.out.println(p.toString());
	      
	      
	}
	
}

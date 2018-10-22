package rummy;

import junit.framework.TestCase;


public class ComputerTest extends TestCase {

	public void testInitialHandCard() {
		
		Computer c1 = new Computer("stratergy1");
		Computer c2 = new Computer("stratergy2");
		Computer c3 = new Computer("stratergy3");
		
		Table t = null;

		  Tile t1 = new Tile("R",2);
	      Tile t2 = new Tile("O",2);
	      Tile t3 = new Tile("O",3);
	      Tile t4 = new Tile("O",1);
	      Tile t5 = new Tile("R",5);
	      Tile t6 = new Tile("R",1);
	      Tile t7 = new Tile("R",4);
	      Tile t8 = new Tile("R",3);
	      Tile t9 = new Tile("G",1);
	      
	      c1.drawATile(t1);
	      c1.drawATile(t2);
	      c1.drawATile(t3);
	      c1.drawATile(t4);
	      c1.drawATile(t5);
	      c1.drawATile(t6);
	      c1.drawATile(t7);
	      c1.drawATile(t8);
	      c1.drawATile(t9);
	      
	      //p.hasSet();
	      c1.sort();
	      for(int i = 0; i<c1.getMyHandTile().size(); i++) {
	    	  c1.getMyHandTile().get(i).printTile();
	      }
	      c1.hasRun();  
	     // System.out.print(c1.initialFirstMield(t,10,10,10));
	      System.out.println("begin");
//	      assertEquals(9, p.getNumberOfHandTile());
	      for(int i = 0; i< c1.getMyMeld().size();i++) {
	    	  for(int j = 0; j<c1.getMyMeld().get(i).size(); j++){
	    	      c1.getMyMeld().get(i).get(j).printTile();
	    	  }
	    	  System.out.println("");
	      }
	      System.out.println("end");
	}

}

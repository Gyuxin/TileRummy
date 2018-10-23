package tilerummy;

import junit.framework.TestCase;


public class PlayerTest extends TestCase {

	public void testHasSet() {
		Player p = new Player();
		  Tile t1 = new Tile("R",8);
	      Tile t2 = new Tile("R",9);
	      Tile t3 = new Tile("R",10);
	      Tile t4 = new Tile("B",10);
	      Tile t5 = new Tile("O",10);
//	      Tile t6 = new Tile("R",1);
//	      Tile t7 = new Tile("R",4);
//	      Tile t8 = new Tile("R",3);
//	      Tile t9 = new Tile("G",1);
	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
//	      p.drawATile(t6);
//	      p.drawATile(t7);
//	      p.drawATile(t8);
//	      p.drawATile(t9);
//	      
	      //p.hasSet();
	      p.sort();
	      for(int i = 0; i<p.getMyHandTile().size(); i++) {
	    	  p.getMyHandTile().get(i).printTile();
	      }
	      System.out.println(p.toString());
	      p.hasMeld();
	      System.out.println(p.toString());
	      p.hasRun();  
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

}

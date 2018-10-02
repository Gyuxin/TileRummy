package rummy;

import junit.framework.TestCase;


public class PlayerTest extends TestCase {

	public void testHasSet() {
		Player p = new Player();
		  Tile t1 = new Tile("R",6);
	      Tile t2 = new Tile("O",2);
	      Tile t3 = new Tile("G",7);
	      Tile t4 = new Tile("O",1);
	      Tile t5 = new Tile("B",1);
	      Tile t6 = new Tile("R",1);
	      Tile t7 = new Tile("O",4);
	      Tile t8 = new Tile("O",3);
	      Tile t9 = new Tile("G",1);
	      
	      p.drawATile(t1);
	      p.drawATile(t2);
	      p.drawATile(t3);
	      p.drawATile(t4);
	      p.drawATile(t5);
	      p.drawATile(t6);
	      p.drawATile(t7);
	      p.drawATile(t8);
	      p.drawATile(t9);
	      
	     // p.hasSet();
	      assertEquals(9, p.getNumberOfHandTile());
	}

}

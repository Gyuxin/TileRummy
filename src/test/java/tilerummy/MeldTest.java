package tilerummy;

import junit.framework.TestCase;


public class MeldTest extends TestCase {

	public void testMeldSlice() {
		  Tile t1 = new Tile("R",2);
	      Tile t2 = new Tile("O",2);
	      Tile t3 = new Tile("O",3);
	      Tile t4 = new Tile("O",1);
	      Tile t5 = new Tile("R",5);
	      Tile t6 = new Tile("R",1);
	      Tile t7 = new Tile("R",4);
	      Tile t8 = new Tile("R",3);
	      Tile t9 = new Tile("G",1);
	      Tile t10 = new Tile("R",6);
	      
	      Meld m = new Meld();
	      m.addTileAtLast(t6);
	      m.addTileAtLast(t1);
	      m.addTileAtLast(t8);
	      m.addTileAtLast(t7);
	      m.addTileAtLast(t5);
	      m.addTileAtLast(t10);
	      m.printMeld();
	      m.slice(0, 6);
	      m.printMeld();

	}

}

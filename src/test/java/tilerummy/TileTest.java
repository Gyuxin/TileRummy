package tilerummy;

import junit.framework.TestCase;

public class TileTest extends TestCase {
	
	public void testTile() {
		
		Tile t = new Tile("G2");
		
		assertEquals("G", t.getColor());
		assertEquals(2, t.getNumber());
		
	}

}

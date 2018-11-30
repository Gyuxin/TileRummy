package tilerummy;

import junit.framework.TestCase;


public class ComputerTest extends TestCase {

	public void testComputer1InitialJoker() {
		
		System.out.println("\n\ntest Computer1 initial with poker\n\n");
		
		Computer1 c1 = new Computer1();
		
		Table t = new Table();
		Deck d = new Deck();

		  Tile t1 = new Tile("O",4);
	      Tile t2 = new Tile("O",5);
	      Tile t3 = new Tile("O",6);
	      Tile t4 = new Tile("O",11);
	      Tile t5 = new Tile("O",12);
	      Tile t6 = new Tile("J",0);
	      Tile t7 = new Tile("R",4);
	      Tile t8 = new Tile("R",3);
	      Tile t9 = new Tile("G",1);
	      
	      c1.drawATile(t1);
	      c1.drawATile(t2);
	      c1.drawATile(t3);
	      c1.drawATile(t4);
	      c1.drawATile(t5);
	      c1.drawATile(t6);
//	      c1.drawATile(t7);
//	      c1.drawATile(t8);
//	      c1.drawATile(t9);
	      
	      //p.hasSet();
	      
	      
	      c1.sort();
	      c1.printHandTile();
	     // System.out.print(c1.initialFirstMield(t,10,10,10));
	      c1.initialFirstMeld(t,d);
	}

}

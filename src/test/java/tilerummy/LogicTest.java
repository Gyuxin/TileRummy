package tilerummy;

import junit.framework.TestCase;


public class LogicTest extends TestCase {

	public void testHasSet() {
		Player p = new Player();
		  Tile t1 = new Tile("R",1);
	      Tile t2 = new Tile("R",2);
	      Tile t3 = new Tile("R",7);
	      Tile t4 = new Tile("R",10);
	      Tile t5 = new Tile("R",11);
	      Tile t6 = new Tile("B",3);
	      Tile t7 = new Tile("G",2);
	      Tile t8 = new Tile("G",3);
	      Tile t9 = new Tile("G",5);
	      Tile t10 = new Tile("O",11);
	      Tile t11 = new Tile("O",11);
	      Tile t12 = new Tile("B",12);
	      Tile t13 = new Tile("G",12);
	      Tile t14 = new Tile("O",12);

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
	
	      Table t = new Table();
	      Meld m = new Meld();
	      m.addTileAtLast(t12);
	      m.addTileAtLast(t13);
	      m.addTileAtLast(t14);
	      t.addMeld(m);
	      
	      for(int i=0;i<p.getNumberOfHandTile();i++) {
	    	  Logic.addOneTile(p.getMyHandTile().get(i), t);
	      }
	      
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

}

package tilerummy;

import junit.framework.TestCase;


public class ObserverTest extends TestCase {

	public void testC3CanPlayMeld() {
		
		ObservableValue ov = new ObservableValue(0);
		Computer1 c1 = new Computer1(ov);
		Computer2 c2 = new Computer2(ov);
		Computer3 c3 = new Computer3(ov);
		ov.addObserver(c3);
		
		//initial deck on the table
				Deck gameDeck = new Deck();
				gameDeck.buildDeck();
				
				//initial table 
				Table gameTable = new Table();
				
				
		  Tile t1 = new Tile("R",2);
	      Tile t2 = new Tile("B",3);
	      Tile t3 = new Tile("O",3);
	      Tile t4 = new Tile("R",3);
	      Tile t5 = new Tile("R",5);
	      Tile t6 = new Tile("R",1);
	      Tile t7 = new Tile("R",4);
	      Tile t8 = new Tile("R",3);
	      Tile t9 = new Tile("G",1);
	      
	      c3.drawATile(t1);
	      c3.drawATile(t2);
	      c3.drawATile(t3);
	      c3.drawATile(t4);
	      c3.drawATile(t5);
	      c3.drawATile(t6);
	      c3.drawATile(t7);
	      
	      c1.drawATile(t8);
	      c1.drawATile(t9);
	      c2.drawATile(t9);
	      
	      //p.hasSet();
	      c1.sort();
	      
	      	System.out.println("Computer 1 round");
			c1.initialedFirstMeld = true;
			c1.printHandTile();
			c1.computerTurn(c1, gameTable, gameDeck);
	
			   c2.sort();
			//player2 round
			System.out.println("\n");
			System.out.println("Computer 2 round");
			c2.initialedFirstMeld = true;
			c2.printHandTile();
			c2.computerTurn(c2, gameTable, gameDeck);
			//player3 round
			
			   c3.sort();
			System.out.println("\n");
			System.out.println("Computer 3 round");
			c3.initialedFirstMeld = true;
			c3.printHandTile();
			c3.computerTurn(c3, gameTable, gameDeck);

	      
	}
	
	public void testC3CannotPlayMeld() {
		
		ObservableValue ov = new ObservableValue(0);
		Computer1 c1 = new Computer1(ov);
		Computer2 c2 = new Computer2(ov);
		Computer3 c3 = new Computer3(ov);
		ov.addObserver(c3);
		
		//initial deck on the table
				Deck gameDeck = new Deck();
				gameDeck.buildDeck();
				
				//initial table 
				Table gameTable = new Table();
				
				
		  Tile t1 = new Tile("R",2);
	      Tile t2 = new Tile("B",3);
	      Tile t3 = new Tile("O",3);
	      Tile t4 = new Tile("R",3);
	      Tile t5 = new Tile("R",5);
	      Tile t6 = new Tile("R",1);
	      Tile t7 = new Tile("R",4);
	      Tile t8 = new Tile("R",3);
	      Tile t9 = new Tile("G",1);
	      
	      c3.drawATile(t2);
	      c3.drawATile(t3);
	      c3.drawATile(t4);

	      
	      c1.drawATile(t8);
	      c1.drawATile(t9);
	      c2.drawATile(t9);
	      
	      //p.hasSet();
	      c1.sort();
	      
	      	System.out.println("Computer 1 round");
			c1.initialedFirstMeld = true;
			c1.printHandTile();
			c1.computerTurn(c1, gameTable, gameDeck);
	
			   c2.sort();
			//player2 round
			System.out.println("\n");
			System.out.println("Computer 2 round");
			c2.initialedFirstMeld = true;
			c2.printHandTile();
			c2.computerTurn(c2, gameTable, gameDeck);
			//player3 round
			
			   c3.sort();
			System.out.println("\n");
			System.out.println("Computer 3 round");
			c3.initialedFirstMeld = true;
			c3.printHandTile();
			c3.computerTurn(c3, gameTable, gameDeck);

	      
	}

}

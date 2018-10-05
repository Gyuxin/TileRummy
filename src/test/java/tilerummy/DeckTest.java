package tilerummy;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

    public void testTileNumber(){

        //check there are 104 tiles in the deck

        Deck deck = new Deck();

        assertEquals(104, deck.getDeckSize());

    }

}

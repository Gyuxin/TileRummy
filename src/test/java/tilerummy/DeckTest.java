package tilerummy;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

    public void testTileNumberWithJoker(){

        //check there are 104 tiles in the deck

        Deck deck = new Deck();
        deck.buildDeck();

        assertEquals(106, deck.getDeckSize());

    }


}

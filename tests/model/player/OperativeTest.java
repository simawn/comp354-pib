package model.player;

import java.util.ArrayList;
import model.board.Board;
import model.board.Card;
import model.board.CardBuilder;
import model.board.CardType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for CardTest class.
 * 
 * @author David Gray
 * @date 02/07/2019
 *
 * @author Max Page-Slowik, David Gray
 */
public class OperativeTest {
    Board board;
    
    public OperativeTest() {
    }

    @Before
    public void setUp() {
        Card[] cards = CardBuilder.buildAll();
        board = new Board(cards);
    }

    /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        Operative randInstance = new Operative(CardType.Blue, board, new randomOperativeStrategy());
        Card c = randInstance.makeMove();
        assertEquals("Checking that the Operative makes a legal selection", board.getCards().contains(c), true);
    }
    
    /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeRandomMove() {
        System.out.println("Testing that random operative makes somewhat random selections");
        ArrayList<Card> picks = new ArrayList<>();
        Operative randInstance = new Operative(CardType.Blue, board, new randomOperativeStrategy());

        Card firstPick = randInstance.makeMove();
        System.out.println("firstPick: " + firstPick);
        for(int i = 0; i < 10; i++) {
            Card pick = randInstance.makeMove();
            System.out.println("Pick: " + i + ": " + pick);
            picks.add(pick);
        }
        picks.removeIf(c -> c == firstPick);
        assertTrue("Verifying that the random Operative didn't pick the same card 10 times in a row", picks.size() > 0);
    }  
}

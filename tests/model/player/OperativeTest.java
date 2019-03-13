package model.player;

import model.board.Board;
import model.board.Card;
import model.board.CardBuilder;
import model.board.CardType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import model.board.Bipartite;
import model.board.Clue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for CardTest class.
 * 
 * @author David Gray
 * @date 02/07/2019
 *
 * @author Max Page-Slowik, David Gray
 */
public class OperativeTest {
    Card[] cards;
    Board board;
    Bipartite bp;

    
    public OperativeTest() {
    }

    @Before
    public void setUp() {
        Card[] cards = CardBuilder.buildAll();
        board = new Board(cards);
        bp = new Bipartite(board);

        
    }

    /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        Operative randInstance = new Operative(CardType.Blue, board, new randomOperativeStrategy());
        Card c = randInstance.makeMove(new Clue("Pyramid",1),bp);
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

        Card firstPick = randInstance.makeMove(new Clue("Pyramid",1),bp);
        System.out.println("firstPick: " + firstPick);
        for(int i = 0; i < 10; i++) {
            Card pick = randInstance.makeMove(new Clue("Pyramid",1),bp);
            System.out.println("Pick: " + i + ": " + pick);
            picks.add(pick);
        }
        picks.removeIf(c -> c == firstPick);
        assertTrue("Verifying that the random Operative didn't pick the same card 10 times in a row", picks.size() > 0);
    }  
}

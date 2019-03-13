package model.player;

import model.board.Card;
import model.board.CardType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import model.board.Bipartite;
import model.board.Board;
import model.board.CardBuilder;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author david
 */
public class randomOperativeStrategyTest {
    
        Card[] cards;
    Board board;
    Bipartite bp;
    
    public randomOperativeStrategyTest() {
    }
    
    @Before
    public void setUp() {
               cards = CardBuilder.buildAll();
        board = new Board(cards);
        bp = new Bipartite(board);
    }

    /**
     * Test of pickCard method, of class randomOperativeStrategy.
     */
    @Test
    public void testPickCard() {
        System.out.println("Testing randomness of RandomOperativeStrategy pickCard");
        randomOperativeStrategy instance = new randomOperativeStrategy();
        ArrayList<Card> picks = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            
            Card pick = instance.pickCard(board.getCards(),bp);
            System.out.println("Pick: " + i + ": " + pick);
            picks.add(pick);
        }
        Card firstCard = picks.get(0);
        picks.removeIf(c -> c == firstCard);
        assertTrue("Verifying that the random Operative didn't pick the same card 10 times in a row", picks.size() > 0);
    }
    
}

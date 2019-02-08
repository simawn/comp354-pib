package model.player;

import java.util.ArrayList;
import model.board.Card;
import model.board.CardType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class randomOperativeStrategyTest {
    
    ArrayList<Card> cards;
    
    public randomOperativeStrategyTest() {
    }
    
    @Before
    public void setUp() {
        cards = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            cards.add(new Card("Card" + i, CardType.Bystander));
        }
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
            Card pick = instance.pickCard(cards);
            System.out.println("Pick: " + i + ": " + pick);
            picks.add(pick);
        }
        Card firstCard = picks.get(0);
        picks.removeIf(c -> c == firstCard);
        assertTrue("Verifying that the random Operative didn't pick the same card 10 times in a row", picks.size() > 0);
    }
    
}

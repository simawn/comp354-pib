package model.board;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for CardTest class.
 * 
 * @author David Gray
 * @date 02/07/2019
 */
public class CardTest {
    
    public CardTest() {
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new Card("word", CardType.Bystander);
        String expResult = "word";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}

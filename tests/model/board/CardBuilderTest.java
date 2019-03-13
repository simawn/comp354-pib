package model.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * Unit test for CardBuilder class.
 * 
 * @author David Gray
 * @date 02/07/2019
 */
public class CardBuilderTest {
    Card[] cards;
    Board board;
    
    public CardBuilderTest() {
    }
    @Before
    public void setUp() {
        cards = CardBuilder.buildAll();
    }

    /**
     * Test of buildAll method, of class CardBuilder
     */
    @Test
    public void testBuildAllBuilds25() {
        System.out.println("Testing CardBuilder:");
        assertTrue("There are 25 cards", cards.length == 25);

    }
    
    /**
     * Test of buildAll method, of class CardBuilder
     */
    @Test
    public void testBuildAllNoDuplicates() {
        //Verify that none of the cards are null and that there are no duplicates
        for(int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
            assertTrue("Element " + i + " is not a null Card", cards[i] != null);
            for(int j = i + 1; j < cards.length; j++) {
                assertTrue("Card " + i + " " + cards[i].word + " is not the same as card " + 
                        j  + " " + cards[j].word, !cards[i].word.equals(cards[j].word));
            }
        }
    }

    /**
     * Test of buildAll method, of class CardBuilder.
     */
    @Test
    public void testBuildAll() {
        System.out.println("buildAll");
        Card[] expResult = null;
        Card[] result = CardBuilder.buildAll();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   
}

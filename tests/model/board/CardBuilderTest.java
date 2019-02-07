/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class CardBuilderTest {
    Card[] cards;
    Board board;
    
    public CardBuilderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cards = CardBuilder.buildAll();
    }
    
    @After
    public void tearDown() {
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
   
}

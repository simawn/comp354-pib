/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.board;

import java.io.IOException;
import java.util.ArrayList;
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
public class BoardTest {    
    Board instance;
    Card[] cards;
    public BoardTest() {
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
        instance = new Board(cards);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class Board.
     */
    @Test
    public void testDraw_Card() {
        System.out.println("draw");
        
        Card firstCard = instance.getCards().get(0);
        instance.remove(firstCard);
        assertFalse("Verify that firstCard is no longer in the board", instance.getCards().contains(firstCard));
    }

    /**
     * Test of getCards method, of class Board.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
       
        ArrayList<Card> result = (ArrayList<Card>) instance.getCards();
        assertEquals("New board is 25 cards", 25, result.size()); 
        //Check whether or not elements are unique (by card object and by words)
    }

    /**
     * Test of at method, of class Board.
     */
    @Test
    public void testAt() {
        System.out.println("at");
        
        for(int i = 0; i < 25; i++) {
            Card result = instance.getCards().get(i);
            assertEquals(instance.getCards().get(i), result);
            for(int j = i + 1; j < 25; j++){
                System.out.println("Verifying that " + i + ": " + instance.getCards().get(i) + 
                        " is different than " + j + ": " + instance.getCards().get(j));
                assertNotEquals(instance.getCards().get(j), result);
            }
        }
    }
    
    /**
     * Test that at method throws IndexOutOfBoundsException for index 25
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testAtOutOFBounds() {
        System.out.println("at");

        Card none = instance.getCards().get(25);
    }
    
}

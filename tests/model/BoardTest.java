/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
        Card c = null;
        Board instance = null;
        try {
            instance = new Board();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Missing keyCards.txt or words.txt to create a Board.");
        }
        
        Card firstCard = instance.at(0);
        boolean removedFirstCard = instance.draw(firstCard);
        assertEquals(removedFirstCard, true);
        boolean removedFirstCardAgain = instance.draw(firstCard);
        assertEquals(removedFirstCardAgain, false);
    }

    /**
     * Test of getCards method, of class Board.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        Board instance = null;
        try {
            instance = new Board();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Missing keyCards.txt or words.txt to create a Board.");
        }
        ArrayList<Card> result = instance.getCards();
        assertEquals("New board is 25 cards", 25, result.size()); 
        //Check whether or not elements are unique (by card object and by words)
    }

    /**
     * Test of at method, of class Board.
     */
    @Test
    public void testAt() {
        System.out.println("at");
        Board instance = null;
        try {
            instance = new Board();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Missing keyCards.txt or words.txt to create a Board.");
        }
        
        for(int i = 0; i < 25; i++) {
            Card result = instance.at(i);
            assertEquals(instance.at(i), result);
            for(int j = i + 1; j < 25; j++){
                System.out.println("Verifying that " + i + ": " + instance.at(i) + 
                        " is different than " + j + ": " + instance.at(j));
                assertNotEquals(instance.at(j), result);
            }
        }
    }
    
    /**
     * Test that at method throws IndexOutOfBoundsException for index 25
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testAtOutOFBounds() {
        System.out.println("at");
        Board instance = null;
        try {
            instance = new Board();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Missing keyCards.txt or words.txt to create a Board.");
        }

        Card none = instance.at(25);
    }
    
}

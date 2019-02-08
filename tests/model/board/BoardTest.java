/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.board;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for Board class.
 * 
 * @author David Gray
 * @date 02/07/2019
 */
public class BoardTest {    
    Board instance;
    Card[] cards;
    public BoardTest() {
    }

    @Before
    public void setUp() {
        cards = CardBuilder.buildAll();
        instance = new Board(cards);
    }
    
    /**
     * Test of remove method, of class Board.
     */
    @Test
    public void tesRemove_Card() {
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
     * Test of getNumCardsOfType method, of class Board.
     */
    @Test
    public void testGetNumCardsOfType() {
        System.out.println("at");
        int numRedCards = instance.getNumCardsOfType(CardType.Red);
        int numBlueCards = instance.getNumCardsOfType(CardType.Blue);
        int numAssassinCards = instance.getNumCardsOfType(CardType.Assassin);
        int numBystanderCards = instance.getNumCardsOfType(CardType.Bystander);
        assertEquals("Just 1 assassin on the board", numAssassinCards, 1);
        assertEquals("7 Bystanders on the board", numBystanderCards, 7);
        if(numRedCards == 9) {
            assertEquals("9 red cards and 8 blue cards", numBlueCards, 8);
        } else if (numRedCards == 8) {
            assertEquals("8 red cards and 9 blue cards", numBlueCards, 9);
        } else {
            fail("Wrong number of colored cards");
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

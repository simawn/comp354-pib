/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.board.Bipartite;
import model.board.Board;
import model.board.Card;
import model.board.CardBuilder;
import model.board.CardType;
import model.board.Clue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Page-Slowik
 */
public class HumanOperativeStrategyTest {
    
    Card[] cards;
    Board board;
    
    
    public HumanOperativeStrategyTest() {
    }
    
    @Before
    public void setUp() {
               cards = CardBuilder.buildAll();
        board = new Board(cards);
    }

    /**
     * Test of pickCard method, of class HumanOperativeStrategy.
     */
    @Test
    public void testPickCard() {
    		System.out.println("pickCard");
    		
    		cards = new Card[10];
        // Make a "board" that only contains blue cards, and the assassin
        cards[0] = new Card("AGENT", CardType.Assassin);
        cards[1] = new Card("AMAZON", CardType.Blue);
        cards[2] = new Card("ANTARCTICA", CardType.Blue);
        cards[3] = new Card("ATLANTIS", CardType.Blue);
    		    		
        Bipartite bp = new Bipartite(board);;
        List<Card> cardslist = Arrays.asList(cards);
//        
        HumanOperativeStrategy instance = new HumanOperativeStrategy();
        Card expResult = cards[0];
        Card result = instance.pickCard(cardslist, bp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getClue method, of class HumanOperativeStrategy.
     */
    @Test
    public void testGetClue() {
        System.out.println("getClue");
        HumanOperativeStrategy instance = new HumanOperativeStrategy();
        Clue expResult = new Clue("Foo",1);
        instance.setClue(expResult);
        Clue result = instance.getClue();
        	
        
        System.out.println("sdsdsd " + result + " sdsdsds");
        assertTrue(result.getClueWord() == expResult.getClueWord() && result.getClueNum() == expResult.getClueNum());
    }

    /**
     * Test of setClue method, of class HumanOperativeStrategy.
     */
    @Test
    public void testSetClue() {
        System.out.println("setClue");
        Clue clue = new Clue("Foo",2);
        
        HumanOperativeStrategy instance = new HumanOperativeStrategy();
        instance.setClue(clue);
        

        assertTrue(clue.getClueWord() == "Foo");
    }
    
}

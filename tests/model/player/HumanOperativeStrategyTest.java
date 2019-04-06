/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.util.List;
import model.board.Bipartite;
import model.board.Card;
import model.board.Clue;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Page-Slowik
 */
public class HumanOperativeStrategyTest {
    
    public HumanOperativeStrategyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of pickCard method, of class HumanOperativeStrategy.
     */
    @Test
    public void testPickCard() {
        System.out.println("pickCard");
        List<Card> cards = null;
        Bipartite bipartite = null;
        HumanOperativeStrategy instance = new HumanOperativeStrategy();
        Card expResult = null;
        Card result = instance.pickCard(cards, bipartite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClue method, of class HumanOperativeStrategy.
     */
    @Test
    public void testGetClue() {
        System.out.println("getClue");
        HumanOperativeStrategy instance = new HumanOperativeStrategy();
        Clue expResult = null;
        Clue result = instance.getClue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClue method, of class HumanOperativeStrategy.
     */
    @Test
    public void testSetClue() {
        System.out.println("setClue");
        Clue clue = null;
        HumanOperativeStrategy instance = new HumanOperativeStrategy();
        instance.setClue(clue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

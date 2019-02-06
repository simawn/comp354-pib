/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import control.BoardControl;
import java.util.ArrayList;
import model.Card;
import model.constant.CardType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Page-Slowik
 */
public class OperativeTest {
    BoardControl boardControl;
    
    public OperativeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //what needs to be done before setting up this test class
        //something configured for all test cases
    }
    
    @AfterClass
    public static void tearDownClass() {
        //clean up the resources from setUpclass
    }
    
    @Before
    public void setUp() {
        boardControl = new BoardControl();
    }
    
    @After
    public void tearDown() {
        //what needs to be done after invoking each test case
    }
    

    /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        Operative randInstance = new Operative(CardType.Blue, boardControl, new randomOperativeStrategy());
        Card c = randInstance.makeMove();
        assertEquals("Checking that the Operative makes a legal selection", boardControl.getCards().contains(c), true);
    }
    
        /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeRandomMove() {
        System.out.println("Testing that random operative makes somewhat random selections");
        ArrayList<Card> picks = new ArrayList<>();
        Operative randInstance = new Operative(CardType.Blue, boardControl, new randomOperativeStrategy());

        Card firstPick = randInstance.makeMove();
        System.out.println("firstPick: " + firstPick);
        for(int i = 0; i < 10; i++) {
            Card pick = randInstance.makeMove();
            System.out.println("Pick: " + i + ": " + pick);
            picks.add(pick);
        }
        picks.removeIf(c -> c == firstPick);
        assertTrue("Verifying that the random Operative didn't pick the same card 10 times in a row", picks.size() > 0);
    }  
}

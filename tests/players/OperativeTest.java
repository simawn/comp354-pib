/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import control.BoardControl;
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
        //what needs to be done before invoking each test case
    }
    
    @After
    public void tearDown() {
        //what needs to be done after invoking each test case
    }
    

    /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeLegalMove() {
        System.out.println("makeMove");
        Card[] cards = null;
        Operative instance = new Operative(CardType.Blue, new BoardControl(), new randomOperativeStrategy());
        Card c = instance.makeMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeIllegalMove() {
        System.out.println("makeMove");
        Card[] cards = null;
        Operative instance = new Operative(CardType.Blue, new BoardControl(), new randomOperativeStrategy());
        Card c = instance.makeMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeAssasinMove() {
        System.out.println("makeMove");
        Card[] cards = null;
        Operative instance = new Operative(CardType.Blue, new BoardControl(), new randomOperativeStrategy());
        Card c = instance.makeMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
            /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeBystanderMove() {
        System.out.println("makeMove");
        Card[] cards = null;
        Operative instance = new Operative(CardType.Blue, new BoardControl(), new randomOperativeStrategy());
        Card c = instance.makeMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
            /**
     * Test of makeMove method, of class Operative.
     */
    @Test
    public void testMakeOppositeColourMove() {
        System.out.println("makeMove");
        Card[] cards = null;
        Operative instance = new Operative(CardType.Blue, new BoardControl(), new randomOperativeStrategy());
        Card c = instance.makeMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

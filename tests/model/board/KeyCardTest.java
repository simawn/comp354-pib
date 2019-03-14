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
 * @author Max Page-Slowik
 */
public class KeyCardTest {

    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testing the parse method to see if it returns an array of keyCards.
     * In addition we are checking that that list returned is not empty or null
     */
    @Test
    public void testKeyCardparse() throws Exception {
        System.out.println("parse");
        KeyCard instance = new KeyCard();
        CardType[] expResult = null;
        CardType[] result = instance.parse();
        System.out.println("length of array: " + result.length);
        assertTrue("return an array of 25 key cards", result.length == 25 && result != null);
        
    }
    
}

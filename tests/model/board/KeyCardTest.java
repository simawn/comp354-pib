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
        
        //Checking if the amount of card type is accurate
        int[] amount = {0, 0, 0, 0}; //0: Assassin, 1: Bystanders, 2: Blue, 3: Red
        for(CardType card : result) {
        	if(card == card.Assassin) amount[0]++;
        	if(card == card.Bystander) amount[1]++;
        	if(card == card.Blue) amount[2]++;
        	if(card == card.Red) amount[3]++;
        }
        
        assertTrue("The amount of assassin is 1", amount[0] == 1);
        assertTrue("The amount of bystanders is 7", amount[1] == 7);
        
        if(amount[2] == 8) { //If blue is 8, then red is 9
        	assertTrue("The amount of blue is 8", amount[2] == 8);
        	assertTrue("The amount of red is 9", amount[3] == 9);
        } else if (amount[3] == 8) { //If red is 8, then blue is 9
        	assertTrue("The amount of blue is 8", amount[3] == 8);
        	assertTrue("The amount of red is 9", amount[2] == 9);
        } else {
        	fail("Red and/or blue card amount invalid");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.board;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Page-Slowik
 */
public class CardTypeTest {
    
    public CardTypeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }


    /**
     * Test of charOf method, of class CardType.
     */
    @Test
    public void testCharOf() {
        System.out.println("charOf");
        char arg = 'R';
        CardType expResult = CardType.Red;
        CardType result = CardType.charOf(arg);
        assertEquals(expResult, result);

    }

    /**
     * Test of pathOf method, of class CardType.
     */
    @Test
    public void testPathOf() {
        System.out.println("pathOf");
        CardType type = CardType.Red;
        String expResult = "file:resources/RedFemale.png";
        String result = CardType.pathOf(type);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }
    
}

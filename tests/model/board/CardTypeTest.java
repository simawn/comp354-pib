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
     * Test of values method, of class CardType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        CardType[] expResult = null;
        CardType[] result = CardType.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class CardType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        CardType expResult = null;
        CardType result = CardType.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of charOf method, of class CardType.
     */
    @Test
    public void testCharOf() {
        System.out.println("charOf");
        char arg = ' ';
        CardType expResult = null;
        CardType result = CardType.charOf(arg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pathOf method, of class CardType.
     */
    @Test
    public void testPathOf() {
        System.out.println("pathOf");
        CardType type = null;
        String expResult = "";
        String result = CardType.pathOf(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

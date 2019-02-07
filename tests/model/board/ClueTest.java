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
 * @author david
 */
public class ClueTest {
    
    public ClueTest() {
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
     * Test of getClueWord method, of class Clue.
     */
    @Test
    public void testGetClueWord() {
        System.out.println("getClueWord");
        Clue instance = new Clue("Clue", 3);
        String expResult = "Clue";
        String result = instance.getClueWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClueNum method, of class Clue.
     */
    @Test
    public void testGetClueNum() {
        System.out.println("getClueWord");
        Clue instance = new Clue("Clue", 3);
        int result = instance.getClueNum();
        assertEquals(3, result);
    }
    
}

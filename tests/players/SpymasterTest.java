/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
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
public class SpymasterTest {    
    public SpymasterTest() {
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
     * Test of draw method, of class Board.
     */
    @Test
    public void testClue() {
        System.out.println("clue");
        int clueNum = rand.nextInt(4);
        String clueWord = possibleClueWords[rand.nextInt(possibleClueWords.length)];
        Clue clue = new Clue(clueWord, clueNum);
        Spymaster instance = new Spymaster(CardType.Blue, new BoardControl(), new randomSpymasterStrategy());
        try {
           Card c = instance.makeMove();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to give clue.");
        }
        assertNotEquals(clueWord, null);
        if(clueNum >= 0 && cluenum < 10 ){
            assertEquals(clueNum, clueNum);
        }
        assertNotEquals(clue, null);

    }

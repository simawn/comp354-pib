/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.io.IOException;
import model.Board;
import model.player.randomSpyStrategy;
import model.Clue;
import model.component.CardType;
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
    Board board;

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
        try {
            board = new Board();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        Spymaster instance = new Spymaster(CardType.Blue, board, new randomSpyStrategy());
        Clue c = instance.makeMove();
        assertNotEquals(c.getClueWord(), null);
        assertTrue(c.getClueNum() < 10 && c.getClueNum() >= 0);
        assertNotEquals(c, null);
    }

}
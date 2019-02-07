/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.io.IOException;
import model.board.Board;
import model.board.Card;
import model.board.CardBuilder;
import model.player.randomSpyStrategy;
import model.board.Clue;
import model.board.CardType;
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
        Card[] cards = CardBuilder.buildAll();
        board = new Board(cards);
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
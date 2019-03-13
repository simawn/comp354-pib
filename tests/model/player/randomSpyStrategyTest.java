/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.board.Card;
import model.board.Clue;
import org.junit.Test;

import java.util.ArrayList;
import model.board.Bipartite;
import model.board.Board;
import model.board.CardBuilder;

import static org.junit.Assert.assertTrue;
import org.junit.Before;

/**
 *
 * @author david
 */
public class randomSpyStrategyTest {
    Card[] cards;
    Board board;
    Bipartite bp;
    public randomSpyStrategyTest() {
    }
     @Before
    public void setUp() {
        Card[] cards = CardBuilder.buildAll();
        board = new Board(cards);
        bp = new Bipartite(board);
    }
    /**
     * Test of giveClue method, of class randomSpyStrategy.
     */
    @Test
    public void testGiveClue() {
        randomSpyStrategy instance = new randomSpyStrategy();
        ArrayList<Card> cards = new ArrayList<>(); //Empty arraylist since randomSpy doesn't care what the words are.
        Clue clue = instance.giveClue(board.getCards(),bp);

        assertTrue("randomSpyStrategy does not give null clue", clue != null);
        assertTrue("randomSpyStrategy gives clue number in range 0 - 9", clue.getClueNum() >=0 && clue.getClueNum() <= 9);
    }
    
    /**
     * Test of giveClue method, of class randomSpyStrategy.
     * Verifying that the strategy is somewhat random and doesn't give the same clue every time.
     */
    @Test
    public void testGiveClueRandomly() {
        System.out.println("Testing randomness of RandomSpyStrategy's giveClue()");
        randomSpyStrategy instance = new randomSpyStrategy();

        ArrayList<Clue> clues = new ArrayList<>();
        ArrayList<Card> cards = new ArrayList<>(); //Empty arraylist since randomSpy doesn't care what the words are.
        for(int i = 0; i < 10; i++) {
            Clue clue = instance.giveClue(board.getCards(),bp);
            System.out.println("Clue: " + i + ": " + clue.getClueWord() + " " + clue.getClueNum());
            clues.add(clue);
        }
        
        Clue firstClue = clues.get(0);
        clues.removeIf(c -> c.getClueWord().equals(firstClue.getClueWord()));
        assertTrue("Random Spymaster strategy doesn't give same clue word 10 times in a row", clues.size() > 0);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.board.Card;
import model.board.CardType;
import model.board.Clue;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author david
 */
public class randomSpyStrategyTest {
    
    public randomSpyStrategyTest() {
    }

    /**
     * Test of giveClue method, of class randomSpyStrategy.
     */
    @Test
    public void testGiveClue() {
        Strategy instance = new Spymaster();
        ArrayList<Card> cards = new ArrayList<>(); //Empty arraylist since randomSpy doesn't care what the words are.
        Clue clue = (Clue) instance.play(CardType.Red);

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
        Spymaster instance = new Spymaster();

        ArrayList<Clue> clues = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Clue clue = instance.play(CardType.Red);
            System.out.println("Clue: " + i + ": " + clue.getClueWord() + " " + clue.getClueNum());
            clues.add(clue);
        }
        
        Clue firstClue = clues.get(0);
        clues.removeIf(c -> c.getClueWord().equals(firstClue.getClueWord()));
        assertTrue("Random Spymaster strategy doesn't give same clue word 10 times in a row", clues.size() > 0);
    }
    
}

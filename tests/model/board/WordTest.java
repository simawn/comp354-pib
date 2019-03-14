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
public class WordTest {
    
	Card[] cards;
    Board board;
    Bipartite bp;
    Card blueCard;
    Card redCard;
    
    @Before
    public void setUp() {
    	cards = CardBuilder.buildAll();
        board = new Board(cards);
        bp = new Bipartite(board);
                for(int i = 0; i<cards.length;++i){
            if(cards[i].type == CardType.Blue){
                blueCard = cards[i];
                break;
            }
        }
        for(int i = 0; i<cards.length;++i){
            if(cards[i].type == CardType.Red){
                redCard = cards[i];
                break;
            }
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class Word. MAke sure a list is returned and is not empty
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        Word instance = new Word();
        String[] expResult = null;
        expResult = instance.parse();
        System.out.println("Size of returned array is :" + expResult.length);
        assertTrue("Making sure the method returned a list fo words ", expResult.length > 0);
        
    }
    
    @Test
    /**
     * test to see if the pare method retrieve 25 random words from codename file
     * @throws Exception
     */
    public void testListofWords() throws Exception {
        System.out.println("parse");
        Word instance = new Word();
        String[] expResult = null;
        expResult = instance.parse();
        System.out.println("Size of returned array is :" + expResult.length);
        assertTrue("Making sure that 25 words were returned ", expResult.length == 25);
        
    }
    
    
}

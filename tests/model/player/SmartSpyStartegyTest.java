package model.player;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;


import model.board.Bipartite;
import model.board.Board;
import model.board.Card;
import model.board.CardType;
import model.board.Clue;
import org.junit.Test;

public class SmartSpyStartegyTest {
	
	Card[] cards = new Card[2];
    Board board;
    Bipartite bp;
    Card blueCard;
    Card redCard;
    
    /**
     * Setup board and assign a default list of cards for testing purposes
     */
    @Before
    public void setUp() 
    {
        cards[0] = new Card("LONDON" , CardType.Blue);
        cards[1] = new Card("ATLANTIS" , CardType.Blue);
        board = new Board(cards);
        bp = new Bipartite(board);

    }
    
    
    // testing to see if the giveClue method will return the common clue for the player's words
    // in this specific case, our method should return "city" as the most optimal clue
    @Test
    public void TestSmartSpyStrategy()
    {
board = new Board(cards);
        bp = new Bipartite(board);
        
    	SmartSpyStrategy blueStrategy = new SmartSpyStrategy(CardType.Blue);
    	
    	for(int i = 0; i < cards.length; i++)
    	{
    		System.out.println(Arrays.deepToString(cards));
    	}
    	
    	Clue clue = blueStrategy.giveClue(board.getCards(), bp);
    	// in this test case, the common clue is city so now we need to check if our method has returned expected result
    	String word = "city";
    	
    	assertTrue("", clue.getClueWord().equalsIgnoreCase(word));
    }

}

package model.player;

import model.board.Card;
import model.board.CardType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import model.board.Bipartite;
import model.board.Board;
import model.board.CardBuilder;
import model.board.Clue;

import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Simon Huang
 *
 */

public class BotOperativeStrategyTest {
    
    Card[] cards;
    Board board;
    Bipartite bp;
    Card blueCard;
    Card redCard;
    
    /**
     * Setup board
     */
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

    /**
     * Test of pickCard method of class HardOperativeStrategy for blue.
     */
    @Test
    public void testPickCardHardBlue() {
    	BotOperativeStrategy hardStrategyBlue = new BotOperativeStrategy(CardType.Blue,1);
    	//ArrayList<Card> bluePicks = new ArrayList<Card>();
        
        Clue c = new Clue(blueCard.word,1); //need to make a card and and a clue
        System.out.println("Current Clue: "+c.getClueWord()+ " for "+blueCard.word);
        hardStrategyBlue.setClue(c);
        Card pickedCard = hardStrategyBlue.pickCard(board.getCards(),bp);
        
    	//Picking cards
//    	for(int i = 0; i < (this.BLUE_CARDS); i++) {
//    		bluePicks.add(hardStrategyBlue.pickCard(board.getCards(),bp));
//    	}
    	
    	//Checking picks
    	assertTrue("Making sure that the picked card is the actual card",blueCard.word.equals(pickedCard.word));
 //   	assertTrue("Check if there are exactly (RED_CARDS) red picks", redPicks.size() == RED_CARDS);
    	
    	//Checking pick contents
//    	for(Card card : bluePicks) {
//    		assertTrue("Checking if all the picks are blue.", card.getTypeProperty() == CardType.Blue);
//    	}

    }
    /**
     * Test of pickCard method of class HardOperativeStrategy for blue.
     */
    @Test
    public void testPickCardHardRed() {
    	BotOperativeStrategy hardStrategyRed = new BotOperativeStrategy(CardType.Red,1);
    	//ArrayList<Card> redPicks = new ArrayList<Card>();
    	
    	//Picking cards
//    	for(int i = 0; i < (this.RED_CARDS); i++) {
//            redPicks.add(hardStrategyRed.pickCard(board.getCards(),bp));
//    	}
    	Clue c = new Clue(redCard.word,1);
        hardStrategyRed.setClue(c);
        System.out.println("Current Clue: "+c.getClueWord()+ " for "+redCard.word);
        Card pickedCard = hardStrategyRed.pickCard(board.getCards(),bp);
    	//Checking picks
    	//assertTrue("Check if there are exactly (BLUE_CARDS) blue picks", bluePicks.size() == BLUE_CARDS);
    	assertTrue("Making sure that the picked card is the actual card",redCard.word.equals(pickedCard.word));    	
    	//Checking pick contents
//    	for(Card card : redPicks) {
//    		assertTrue("Checking if all the picks are red.", card.getTypeProperty() == CardType.Red);
//    	}
    }
}

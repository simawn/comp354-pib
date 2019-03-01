package model.player;

import model.board.Card;
import model.board.CardType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Simon Huang
 *
 */

public class HardOperativeStrategyTest {
    
    ArrayList<Card> cards;
    final int RED_CARDS = 99;
    final int BLUE_CARDS = 99;
    
    /**
     * Setup board
     */
    @Before
    public void setUp() {
    	cards = new ArrayList<Card>();
    	
    	//Add assassin
    	cards.add(new Card("Assassin", CardType.Assassin));
    	//Add bystanders
    	for(int i = 0; i < 10; i++) {
    		cards.add(new Card("Bystander", CardType.Bystander));
    	}
    	//Add blue
    	for(int i = 0; i < BLUE_CARDS; i++) {
    		cards.add(new Card("Blue", CardType.Blue));
    	}
    	//Add red
    	for(int i = 0; i < RED_CARDS; i++) {
    		cards.add(new Card("Red", CardType.Red));
    	}
    }

    /**
     * Test of pickCard method of class HardOperativeStrategy.
     */
    @Test
    public void testPickCard() {
    	HardOperativeStrategy hardStrategyBlue = new HardOperativeStrategy(CardType.Blue);
    	HardOperativeStrategy hardStrategyRed = new HardOperativeStrategy(CardType.Red);
    	ArrayList<Card> bluePicks = new ArrayList<Card>();
    	ArrayList<Card> redPicks = new ArrayList<Card>();
    	
    	//Picking cards
    	for(int i = 0; i < (this.BLUE_CARDS + this.RED_CARDS); i++) {
    		if(i % 2 == 0) bluePicks.add(hardStrategyBlue.pickCard(cards));
    		else redPicks.add(hardStrategyRed.pickCard(cards));
    	}
    	
    	//Checking picks
    	assertTrue("Check if there are exactly (BLUE_CARDS) blue picks", bluePicks.size() == BLUE_CARDS);
    	assertTrue("Check if there are exactly (RED_CARDS) red picks", redPicks.size() == RED_CARDS);
    	
    	//Checking pick contents
    	for(Card card : bluePicks) {
    		assertTrue("Checking if all the picks are blue.", card.getTypeProperty() == CardType.Blue);
    	}
    	for(Card card : redPicks) {
    		assertTrue("Checking if all the picks are red.", card.getTypeProperty() == CardType.Red);
    	}
    }
}

package model.player;

import java.util.ArrayList;

import org.junit.*;

import model.board.Card;
import model.board.CardType;
import model.board.Clue;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * This unit test will see if our SimpleSpyStrategy class
 * where the program will always return a clue that has 1 word associated with it
 * @author Mair
 *
 */

public class SimpleSpyStrategyTest {
	
	ArrayList<Card> cards;
    final int RED_CARDS = 10;
    final int BLUE_CARDS = 10;
    
    /**
     * Setup board
     */
    @Before
    public void setUp() {
    	cards = new ArrayList<Card>();
    	
//    	//Add assassin
//    	cards.add(new Card("Assassin", CardType.Assassin));
//    	//Add bystanders
//    	for(int i = 0; i < 2; i++) {
//    		cards.add(new Card("Bystander", CardType.Bystander));
//    	}
    	//Add blue
//    	for(int i = 0; i < BLUE_CARDS; i++) {
//    		cards.add(new Card("Blue", CardType.Blue));
//    	}
//    	//Add red
//    	for(int i = 0; i < RED_CARDS; i++) {
//    		cards.add(new Card("Red", CardType.Red));
//    	}
    }
    
    @Test
    /**
     * Test out the giveClue method from the class to see if it generates expected result
     */
    public void SimpleStategyTestForBlue()
    {
    	SimpleSpyStrategy blueStrategy = new SimpleSpyStrategy(CardType.Blue);
    	
    	cards.add(new Card("BELL" , CardType.Blue));
    	
    	//for(int i = 0; i < cards.size(); i++)
    		//System.out.println(cards.get(i).toString());
    	
    	//the following will return one of the clues that is generated for bell
    	Clue clue = blueStrategy.giveClue(cards);
    	//System.out.println(clue.toString());
    	
    	assertTrue(clue.getClueWord().equalsIgnoreCase("chime") || clue.getClueWord().equalsIgnoreCase("gong") ||
    	clue.getClueWord().equalsIgnoreCase("buzzer") || clue.getClueWord().equalsIgnoreCase("doorbell"));
    	//assertNotEquals(blueStrategy, null);
    }
    
    @Test
    public void SimpleStategyTestForRed()
    {
    	SimpleSpyStrategy redStrategy = new SimpleSpyStrategy(CardType.Red);
    	
    	cards.add(new Card("ROBOT" , CardType.Red));
    	
    	//for(int i = 0; i < cards.size(); i++)
    		//System.out.println(cards.get(i).toString());
    	
    	//the following will return one of the clues that is generated for bell
    	Clue clue = redStrategy.giveClue(cards);
    	//System.out.println(clue.toString());
    	
    	assertTrue(clue.getClueWord().equalsIgnoreCase("golem") || clue.getClueWord().equalsIgnoreCase("robo") ||
    			clue.getClueWord().equalsIgnoreCase("automaton") || clue.getClueWord().equalsIgnoreCase("robotics"));
    	//assertNotEquals(redStrategy, null);
    }
}

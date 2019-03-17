package model.player;

import java.util.ArrayList;
import model.board.Bipartite;
import model.board.Board;

import org.junit.*;

import model.board.Card;
import model.board.CardBuilder;
import model.board.CardType;
import model.board.Clue;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * This unit test will see if our SimpleSpyStrategy class where the program will
 * always return a clue that has 1 word associated with it
 * 
 * @author Mair
 *
 */

public class SimpleSpyStrategyTest {

	Card[] cards = new Card[2];
	Board board;
	Bipartite bp;
	Card blueCard;
	Card redCard;

	/**
	 * Setup board and assign cards to the list for testing purposes
	 */
	@Before
	public void setUp() {
		cards[0] = new Card("BELL", CardType.Blue);
		cards[1] = new Card("TORCH", CardType.Red);
		board = new Board(cards);
		bp = new Bipartite(board);
	}

	@Test
	/**
	 * Test out the giveClue method from the class to see if it generates expected
	 * result for a specific word
	 */
	public void SimpleStategyTestForBlue() {
		SimpleSpyStrategy blueStrategy = new SimpleSpyStrategy(CardType.Blue);

		// the following will return one of the clues that is generated for bell
		Clue clue = blueStrategy.giveClue(board.getCards(), bp);

		System.out.println("Current clue: " + clue.getClueWord());
		assertTrue(clue.getClueWord().equalsIgnoreCase("chime") || clue.getClueWord().equalsIgnoreCase("gong")
				|| clue.getClueWord().equalsIgnoreCase("buzzer") || clue.getClueWord().equalsIgnoreCase("door"));
	}

	@Test
	public void SimpleStategyTestForRed() {
		SimpleSpyStrategy redStrategy = new SimpleSpyStrategy(CardType.Red);

		// the following will return one of the clues that is generated for bell
		Clue clue = redStrategy.giveClue(board.getCards(), bp);

		assertTrue(clue.getClueWord().equalsIgnoreCase("flashlight") || clue.getClueWord().equalsIgnoreCase("light")
				|| clue.getClueWord().equalsIgnoreCase("lantern") || clue.getClueWord().equalsIgnoreCase("blowlamp"));
	}

	@Test
	public void SimpleStrategy() {
		cards = CardBuilder.buildAll();
		board = new Board(cards);
		bp = new Bipartite(board);
		for (int i = 0; i < cards.length; ++i) {
			if (cards[i].type == CardType.Blue) {
				blueCard = cards[i];
				break;
			}
		}
		for (int i = 0; i < cards.length; ++i) {
			if (cards[i].type == CardType.Red) {
				redCard = cards[i];
				break;
			}
		}

		SimpleSpyStrategy blueStrategy = new SimpleSpyStrategy(CardType.Blue);

		// the following will return one of the clues that is generated for bell
		Clue clue = blueStrategy.giveClue(board.getCards(), bp);

		System.out.println("Current clue: " + blueCard.word);

		assertTrue("making sure clue has been returned", clue.getClueWord() != null);
	}
}

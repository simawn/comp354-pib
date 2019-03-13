package model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.board.Bipartite;
import model.board.Card;
import model.board.CardType;
import model.board.Clue;
import model.board.Constants;

/**
 * This is a simple spy strategy: it randomly selects a word of their team and
 * gives a random clue of the selected word. It won't try to combine words while
 * giving the clues, so it will always return 1 word per clue.
 * 
 * @author Simon Huang
 *
 */
public class SimpleSpyStrategy implements SpyStrategy {

	private CardType team;

	/**
	 * Constructor for SimpleSpyStrategy.
	 * 
	 * @param team The spy's team
	 */
	public SimpleSpyStrategy(CardType team) {
		this.team = team;
	}

	/**
	 * Selects a card from their team at random. Gives out a clue a random from the
	 * selected word
	 */
	@Override
	public Clue giveClue(List<Card> cards, Bipartite bipartite) {

		ArrayList<Card> toChooseFrom = new ArrayList<Card>();

		for (Card card : cards) {
			if (card.getTypeProperty() == team) {
				toChooseFrom.add(card);
			}
		}

		Random rand = new Random();

		String chosenWord = toChooseFrom.get(rand.nextInt(toChooseFrom.size())).getStringProperty();
		String[] availClues = bipartite.getWordsToClues().get(chosenWord)
				.toArray(new String[bipartite.getWordsToClues().get(chosenWord).size()]);
		String chosenClue = availClues[rand.nextInt(availClues.length)];

		// DEBUG
		if (Constants.DEBUG) {
			System.out.println();
			System.out.println("=== SIMPLE SPY STRAT ===");
			System.out.println("Turn: " + team);
			System.out.println("Chosen word: " + chosenWord);
			System.out.println("Clue given: " + chosenClue);
			System.out.println("Available clues: " + Arrays.toString(availClues));
			System.out.println("=== SIMPLE SPY STRAT ===");
			System.out.println();
		}

		return new Clue(chosenClue.toUpperCase(), 1);
	}

}

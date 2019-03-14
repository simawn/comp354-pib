package model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.HashMultimap;

import model.board.Bipartite;
import model.board.Card;
import model.board.CardType;
import model.board.Clue;
import model.board.Constants;

/**
 * Allows the spy to choose a clue that includes many words on the board.
 * The Spymaster will select a clue that is the most common amongst the words given to a particular player
 * instead of just selecting a clue at random.
 * 
 * @author Simon Huang
 *
 */
public class SmartSpyStrategy implements SpyStrategy {

	private CardType team;

	/**
	 * Constructor for SmartSpyStrategy.
	 * 
	 * @param team The spy's team
	 */
	public SmartSpyStrategy(CardType team) {
		this.team = team;
	}

	/**
	 * Selects a card from their team at random. This method will search for the most optimal
	 * clue meaning the clue that is shared between the words belonging to the current player and return that
	 * specific clue
	 * 
	 * @param cards		list of codename cards belonging to a player
	 * @param bipartite   show the current relation between words and clues
	 * 
	 * @return 			the most optimal clue among a player's list of cards
	 */
	@Override
	public Clue giveClue(List<Card> cards, Bipartite bipartite) {
		ArrayList<Card> toChooseFrom = new ArrayList<Card>();

		//stores all cards that belong to the current player into out list
		for (Card card : cards) {
			if (card.getTypeProperty() == team) {
				toChooseFrom.add(card);
			}
		}

		// Filter out words that are not in their team
		HashMultimap<String, String> filterWordsToClues = bipartite.getWordsToClues();

		// Regenerate a new bipartite clues -> words
		HashMultimap<String, String> newCluesToWords = HashMultimap.create();

		for (Card card : toChooseFrom) {
			String cardWord = card.getStringProperty();
			for (String clue : filterWordsToClues.get(cardWord)) {
				newCluesToWords.put(clue, cardWord);
			}
		}

		// Picks the clue with the most words associated with it
		int highestNumOfWords = 0;
		String chosenClue = "";

		for (String clue : newCluesToWords.keySet()) {
			int wordCount = newCluesToWords.get(clue).size();
			if (wordCount > highestNumOfWords) {
				chosenClue = clue;
				highestNumOfWords = wordCount;
			}
		}

		// DEBUG
		if (Constants.DEBUG) {
			String[] chosenWords = newCluesToWords.get(chosenClue)
					.toArray(new String[newCluesToWords.get(chosenClue).size()]);
			System.out.println();
			System.out.println("=== SMART SPY STRAT ===");
			System.out.println("Turn: " + team);
			System.out.println("Available words to choose from: " + toChooseFrom.toString());
			System.out.println("Filtered clue list: " + newCluesToWords.toString());
			System.out.println("Chosen words: " + Arrays.deepToString(chosenWords));
			System.out.println("Clue given: " + chosenClue);
			System.out.println("Number given: " + highestNumOfWords);
			System.out.println("=== SMART SPY STRAT ===");
			System.out.println();
		}

		return new Clue(chosenClue.toUpperCase(), highestNumOfWords);
	}
}

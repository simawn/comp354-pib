package model.player;

import model.board.Bipartite;
import model.board.Card;
import model.board.CardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import model.board.Clue;
import model.board.Constants;

/**
 * Operative strategy used by bots. The difficulty is determined by the accuracy parameter
 * Any accuracy greater than 0.95 is considered hard (almost impossible mode), the bot will always
 * choose the correct card according to the clue and if there are no more words related to the clue,
 * it will still choose a card of their team.
 * 
 * @author Simon Huang
 *
 */

public class BotOperativeStrategy implements OperativeStrategy {

	private CardType team;
	private Clue currentClue;
	private double accuracy;

	/**
	 * Constructor for BotOperativeStrategy
	 * 
	 * @param team The team of the Operative (Takes a CardType)
	 * @param accuracy Accuracy of the bot. 0.95+ is hard mode
	 */
	public BotOperativeStrategy(CardType team, double accuracy) {
		this.team = team;
		this.accuracy = accuracy;
	}

	/**
	 * Loops through all the cards and add the cards of their team into an ArrayList
	 * @param cards		list of codename cards belonging to a player
	 * @param bipartite shows the current relation between words and clues
	 * 
	 *  @return 
	 */
	@Override
	public Card pickCard(List<Card> cards, Bipartite bipartite) {
		//Friendly sets of cards
		Set<String> cardsToChoose = new HashSet<String>(); 
		
		//Used when returning the card
		HashMap<String, Card> hashMapCards = new HashMap<String, Card>(); 
		
		//loops through the list and assign a card based on the cardType to the list
		for (Card card : cards) {
			
			if (card.getTypeProperty() == team) { 
				cardsToChoose.add(card.getStringProperty()); //Add to friendly set
			}
			hashMapCards.put(card.getStringProperty(), card); //Maps word to card
		}

		//List of all of the words (including the opposite teams) that are related to the current clue
		Set<String> possibleWordsToChooseFrom = bipartite.getCluesToWords().get(this.currentClue.getClueWord().toLowerCase());
		
		
		Set<String> possibleFriendlyWords = Sets.intersection(possibleWordsToChooseFrom, cardsToChoose);
		Set<String> possibleEnemyWords = Sets.difference(possibleWordsToChooseFrom, cardsToChoose);
		
		
		//converting to array for rng pick
		String[] arr_friendWord = possibleFriendlyWords.toArray(new String[possibleFriendlyWords.size()]);
		String[] arr_enemyWord = possibleEnemyWords.toArray(new String[possibleEnemyWords.size()]);
		
		//Choose a word
		String chosenWord = "";
		Random rand = new Random();
		double rng = rand.nextDouble();
		
		//Choose the correct word depending on accuracy
		if(rng < this.accuracy) { 
			if(arr_friendWord.length != 0) {
				chosenWord = arr_friendWord[rand.nextInt(arr_friendWord.length)];
			}
		} 
		
		//If rng from above fails, go to here, then pick from enemy. We might want to change how this works.
		else 
		{ 
			if(arr_enemyWord.length != 0) {
				chosenWord = arr_enemyWord[rand.nextInt(arr_enemyWord.length)];
			}
		}
		
		//If there are no chosen word, choose at random
		if(chosenWord == "") 
		{
			if(Constants.DEBUG) System.out.println("No more words, choosing at random...");
			
			//If accuracy is less than 0.95, the next word is chosen at random
				if(accuracy < 0.95) 
				{ 
					Object[] randomKey = hashMapCards.keySet().toArray();
					chosenWord = (String) randomKey[rand.nextInt(randomKey.length)];
				} 
				
				//If accuracy is greater than or equal to 0.95, the next word chosen is of the team's color
				else 
				{ 
					chosenWord = cardsToChoose.iterator().next();
				}
		}
		
		
		if(Constants.DEBUG) {
			System.out.println();
			System.out.println("=== BOT OPERATIVE STRAT ===");
			System.out.println("Team: " + this.team);
			System.out.println("Current clue: " + this.currentClue.getClueWord());
			System.out.println("Current num: " + this.currentClue.getClueNum());
			System.out.println("Friendly Words: " + possibleFriendlyWords.toString());
			System.out.println("Enemy Words: " + possibleEnemyWords.toString());
			System.out.println("Accuracy: " + this.accuracy);
			System.out.println("RNG: " + rng);
			System.out.println("Chosen word: " + chosenWord);
			System.out.println("=== BOT OPERATIVE STRAT ===");
			System.out.println();
		}
		
		return hashMapCards.get(chosenWord);
	}

	@Override
	/**
	 * returns a string representing the current clue of a word
	 */
	public Clue getClue() {
		return currentClue;
	}

	@Override
	/**
	 * sets a given string as the clue
	 */
	public void setClue(Clue clue) {
		currentClue = clue;
	}


}

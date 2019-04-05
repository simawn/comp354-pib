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

/**
 * Operative strategy used by humans. Used to identify human operatives.
 * 
 * @author Alexia Soucy
 *
 */

public class HumanOperativeStrategy implements OperativeStrategy {

	private Clue currentClue;

	/**
	 * Constructor for BotOperativeStrategy
	 * 
	 * @param team The team of the Operative (Takes a CardType)
	 * @param accuracy Accuracy of the bot. 0.95+ is hard mode
	 */
	public HumanOperativeStrategy() {
	}
	
	/**
	 * Not used for human players; returns the top card.
	 * 
	 *  @return the first card in the list
	 */
	@Override
	public Card pickCard(List<Card> cards, Bipartite bipartite) {
		return cards.iterator().next();
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

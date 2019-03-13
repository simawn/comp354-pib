/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import control.game.Difficulty;
import model.board.Bipartite;
import model.board.Card;

import java.util.List;
import java.util.Random;
import model.board.Clue;

/**
 * The random strategy for operator that will choose cards by random as they
 * play the game.
 * 
 * @author david
 */
public class randomOperativeStrategy implements OperativeStrategy {

	private Clue currentClue;

	/**
	 * Picks a card at random according to the amount of cards available.
     * @param cards
     * @param bipartite
     * @return The card
	 */
	@Override
	public Card pickCard(List<Card> cards, Bipartite bipartite) {
		Random rand = new Random();
		return cards.get(rand.nextInt(cards.size()));
	}

	@Override
	public Clue getClue() {
		return currentClue;
	}

	@Override
	public void setClue(Clue clue) {
		currentClue = clue;
	}


}

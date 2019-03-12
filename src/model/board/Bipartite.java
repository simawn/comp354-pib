package model.board;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Creates a bipartite graph showing the relation between words and clues
 * @author Simon Huang
 *
 */
public class Bipartite {

	private Multimap<String, String> wordsToClues;
	private Multimap<String, String> cluesToWords;
	
	public Bipartite(Board board) {
		wordsToClues = HashMultimap.create();
		cluesToWords = HashMultimap.create();
	}
	
	private void processCards(Board board) {
		for(board.getCards())
	}
}

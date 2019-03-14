package model.board;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.common.collect.HashMultimap;

/**
 * Creates a bipartite graph showing the relation between words and clues Using
 * HashMultiMap since it allows the insertion of multiple values to a single key
 * without overwriting the data It is simpler than doing: HashMap<String,
 * ArrayList<String>>
 * 
 * @author Simon Huang
 *
 */
public class Bipartite {

	private HashMultimap<String, String> wordsToClues; // Note: We cannot dump the "syn" array directly to a
														// HashMap<S,S[]> since JSONArray does not behave like a regular
														// array
	private HashMultimap<String, String> cluesToWords; // One clue can be associated with multiple words. Operatives use
														// it as a cheat sheet

	/**
	 * one parameter constructor that accepts a Board object as a parameter.
	 * 
	 * Creates a new, empty HashMultimap with the default initial capacities and set them to our variables 
	 * @param board		board that represents all the codename cards
	 */
	public Bipartite(Board board) {
		wordsToClues = HashMultimap.create();
		cluesToWords = HashMultimap.create();
		processCards(board);
	}

	/**
	 * Creates a bipartite graph with only the words on the current board
	 * 
	 * @param board		represents the board of our game
	 */
	private void processCards(Board board) {
		// Read .json for clues
		JSONObject jsonObj = JSONProcessor.ProcessCurrentJSON();

		// Words to Clues
		for (Card card : board.getCards()) {
			String word = card.getStringProperty();
			JSONArray synArr = (JSONArray) (((JSONObject) jsonObj.get(word))).get("syn");
			for (Object clue : synArr) {
				wordsToClues.put(word, (String) clue);
			}
		}

		// Clues to Words
		for (String word : wordsToClues.keys()) {
			for (String clue : wordsToClues.get(word)) {
				cluesToWords.put(clue, word);
			}
		}
		debug();
	}

	/**
	 * Returns the hash map that contains the mapping of words to clues
	 * 
	 * @return HashMap with Words to Clues relation
	 */
	public HashMultimap<String, String> getWordsToClues() {
		return this.wordsToClues;
	}

	/**
	 * Returns the multi map that contains the mapping of clues to words
	 * 
	 * @return MultiMap with Clues to Words relation
	 */
	public HashMultimap<String, String> getCluesToWords() {
		return this.cluesToWords;
	}
    
	/**
	 * this method returns a string representation of a string which in this case is a clue 
	 * @param cardWord		
	 * @return	a clue for a specific word
	 */
	public String getClue(String cardWord){
        String cl = "";
        cl =wordsToClues.get(cardWord).iterator().next();
        return cl;
    }
	/**
	 * Removes a word from the bipartite including it's related clues
	 * 
	 * @param word Word to remove
	 */
	public void removeWord(String word) {
		for (String clue : wordsToClues.get(word)) {
			cluesToWords.remove(clue, word);
		}
		wordsToClues.removeAll(word);

	}

	private void debug() {
		if (Constants.DEBUG) {
			System.out.println();
			System.out.println("====== BIPARTITE DEBUG ======");
			System.out.println("WORDS ---> CLUES");
			System.out.println(this.wordsToClues.size());
			System.out.println(this.wordsToClues.toString());
			System.out.println();
			System.out.println("CLUES ---> WORDS");
			System.out.println(this.cluesToWords.size());
			System.out.println(this.cluesToWords.toString());
			System.out.println();
		}
	}
}

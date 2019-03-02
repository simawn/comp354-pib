package model.player;

import model.board.Card;
import model.board.CardType;
import model.board.Clue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This is a simple spy strategy: it randomly selects a word of their team and gives a random clue of the selected word.
 * It won't try to combine words while giving the clues, so it will always return 1 word per clue.
 * 
 * @author Simon Huang
 *
 */
public class SimpleSpyStrategy implements SpyStrategy {

	private CardType team;
	
	/**
	 * Constructor for SompleSpyStrategy.
	 * @param team The spy's team
	 */
	public SimpleSpyStrategy(CardType team) {
		this.team = team;
	}
	
	/**
	 * Selects a card from their team at random. Gives out a clue a random from the selected word
	 */
	@Override
	public Clue giveClue(List<Card> cards) {
		ArrayList<Card> toChooseFrom = new ArrayList<Card>();
		
		for(Card card : cards) {
			if(card.getTypeProperty() == team) {
				toChooseFrom.add(card);
			}
		}
		
		Random rand = new Random();
		
		String chosen = toChooseFrom.get(rand.nextInt(toChooseFrom.size())).getStringProperty(); //Choese a word
		String clue = "";
		
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(PATH.toString()));
        
			JSONObject jsonObj = (JSONObject) obj; //The actual .json
			JSONObject word = (JSONObject) jsonObj.get(chosen); //Narrow down to chosen word
			JSONArray syns = (JSONArray) word.get("syn"); //Narrow down to synonyms
			
			clue = (String) syns.get(rand.nextInt(syns.size()));
			
			//DEBUG
			System.out.println();
			System.out.println("Turn: " + team);
			System.out.println("Chosen word: " + chosen);
			System.out.println("Available clues: " + syns);
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error reading file.");
			System.exit(1);
		} catch (ParseException e) {
			System.err.println("Error parsing file.");
			System.exit(1);
		}
		return new Clue(clue.toUpperCase(), 1);
	}

}

package model.board;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.board.Constants;

/*
 * The .jar (in /lib folder) will need to be imported:
 * How to import in Eclipse:
 * Project > Properties > Java Build Path > Libraries > Add External JARs >
 * Choose “json-simple-1.1.1.jar” in the /lib folder
 */
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
* Extractor is an abstract class for reading lines of a text file doing something
* with (parsing) them.
* 
* @author Rani Rafid, Simon Huang
* @date 02/06/19
*/
abstract class Extractor {
    static final int SIZE = 25;

    List<String> build(Path Path) throws IOException {
    	
    	if (!Files.exists(Path)) {
            throw new IOException("Error: Missing " + Path);
        }

        List<String> list = Files.readAllLines(Path);
        
        return list;
    }

    abstract Object[] parse() throws IOException, ParseException;
}

/**
* Word class is responsible for reading the codename words from a text file,
* and returning the first 25 of them.
* 
* @author David Gray, Rani Rafid, Simon Huang
* @date 02/06/19
*/
class Word extends Extractor {
    private static final Path PATH = Constants.WORDS_PATH; //new file format

    String[] parse() throws IOException, ParseException {
        List<String> temp = build(PATH);
        
        //Need to convert temp into an actual string. .toString() converts it into an invalid format
        StringBuilder sb = new StringBuilder();
        for(String str : temp) {
        	sb.append(str);
        }
        
        //Start .jsonParse
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(sb.toString()); //Read .json data
        
        JSONObject jsonObj = (JSONObject) obj;
        
        ArrayList<String> jsonList = new ArrayList<String>();
        
        for(Iterator it = jsonObj.keySet().iterator(); it.hasNext();) { //Loop through keys
        	String key = (String) it.next();
        	//System.out.println(key);
        	jsonList.add(key);
        }
        
        Collections.shuffle(jsonList); //Shuffle words
        
        return jsonList.toArray(new String[SIZE]);
    }

}

/**
* KeyCard parses a random line of the text file containing keycards by 
* mapping them to an array of enum CardType variables.
* 
* @author David Gray, Rani Rafid, Simon Huang
* @date 02/06/19
*/
class KeyCard extends Extractor {
    private static final Path PATH = Constants.KEYCARDS_PATH;

    CardType[] parse() throws IOException, ParseException {
        List<String> list = build(PATH);
        
        Collections.shuffle(list); //Moved shuffle from build to here
        
        String temp = list.remove(0);

        if (temp.length() != SIZE) {
            throw new IllegalArgumentException();
        }

        CardType[] types = new CardType[Extractor.SIZE];
        for (int i = 0; i < temp.length(); i++) {
            types[i] = CardType.charOf(temp.charAt(i));
        }
        return types;
    }
}
/**
* CardBuilder creates an array of Card objects based on a 
* random selection of 25 words and a key card.
* 
* @author David Gray, Rani Rafid, Simon Huang
* @date 02/06/19
*/
public class CardBuilder {

    /**
     * Use the KeyCard and Word classes above to create an array of 25 Cards,
     * (the core of the board).
     * 
     * @return Array of Cards 
     */
    public static Card[] buildAll() {
        String[] words;
        CardType[] types;
        Extractor extractor;
        Card[] cards = new Card[Extractor.SIZE];

        try {
            words = new Word().parse();
            types = new KeyCard().parse();

            for (int i = 0; i < Extractor.SIZE; i++) {
                cards[i] = new Card(words[i], types[i]);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error in finding path to resources/words.txt | resources/keyCards.txt");
            System.exit(0);
        } catch (ParseException e) {
			System.err.println("Error parsing .json file");
			System.exit(1);
		}

        return cards;
    }
}

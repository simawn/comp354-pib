package model.board;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
* Extractor is an abstract class for reading lines of a text file doing something
* with (parsing) them.
* 
* @author Rani Rafid
* @date 02/06/19
*/
abstract class Extractor {
    static final int SIZE = 25;

    List<String> build(Path Path) throws IOException {
        if (!Files.exists(Path)) {
            throw new IOException("Error: Missing " + Path);
        }

        List<String> list = Files.readAllLines(Path);
        Collections.shuffle(list);

        return list;
    }

    abstract Object[] parse() throws IOException;
}

/**
* Word class is responsible for reading the codename words from a text file,
* and returning the first 25 of them.
* 
* @author David Gray, Rani Rafid
* @date 02/06/19
*/
class Word extends Extractor {
    private static final Path PATH = Paths.get("resources/words.txt");

    String[] parse() throws IOException {
        List<String> temp = build(PATH);
        return temp.toArray(new String[SIZE]);
    }

}

/**
* KeyCard parses a random line of the text file containing keycards by 
* mapping them to an array of enum CardType variables.
* 
* @author David Gray, Rani Rafid
* @date 02/06/19
*/
class KeyCard extends Extractor {
    private static final Path PATH = Paths.get("resources/keyCards.txt");

    CardType[] parse() throws IOException {
        List<String> list = build(PATH);

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
* @author David Gray, Rani Rafid
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
        }

        return cards;
    }
}

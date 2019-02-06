package model.board;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;


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


class Word extends Extractor {


    private static final Path PATH = Paths.get("resources/words.txt");

    String[] parse() throws IOException {
        List<String> temp = build(PATH);
        return temp.toArray(new String[SIZE]);
    }

}


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

public class CardBuilder {

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

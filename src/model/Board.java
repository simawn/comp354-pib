package model;

import command.CommandManager;
import command.guessCardCommand;
import model.component.CardType;
import model.component.Component;
import view.Listener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Extractor {
    static final int SIZE = 25;

    static List<String> build(Path Path) throws IOException {
        if (!Files.exists(Path)) {
            throw new IOException("Error: Missing " + Path);
        }

        List<String> list = Files.readAllLines(Path);
        Collections.shuffle(list);

        return list;
    }
}


class Word {

    private static final Path PATH = Paths.get("resources/words.txt");

    static String[] parse() throws IOException {
        List<String> temp = Extractor.build(PATH);
        return temp.toArray(new String[Extractor.SIZE]);
    }

}


class KeyCard {
    private static final Path PATH = Paths.get("resources/keyCards.txt");

    static CardType[] parse() throws IOException {
        List<String> list = Extractor.build(PATH);

        String temp = list.remove(0);

        if (temp.length() != Extractor.SIZE) {
            throw new IllegalArgumentException();
        }

        CardType[] types = new CardType[Extractor.SIZE];
        for (int i = 0; i < temp.length(); i++) {
            types[i] = CardType.charOf(temp.charAt(i));
        }
        return types;
    }
}



public class Board {
    private ArrayList<Card> cards;
    private CommandManager deckCommandManager;
    private int nextSubscription = 0;

    public Board() throws IOException {
        deckCommandManager = new CommandManager();
        String[] words = Word.parse();
        CardType[] keycards = KeyCard.parse();
        cards = new ArrayList<>();
        
        for (int i = 0; i < Component.SIZE; i++) {
            cards.add(new Card(words[i], keycards[i]));
        }
    }

    public void pick(Card c) {
        guessCardCommand pickCmd = new guessCardCommand(c, this);
        deckCommandManager.storeAndExecute(pickCmd);
    }

    public void addSubscriber(Listener listener) throws IndexOutOfBoundsException {
        Card c = cards.get(nextSubscription++);
        c.attach(listener);
        c.push(0, c.word);
    }


    // to remove a specific card. Returns true if the card is removed.
    public void remove(Card c) {
        boolean removed = cards.remove(c);
        c.push(1, CardType.pathOf(c.type));
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getNumCardsOfType(CardType type) {
        ArrayList<Card> redCards = (ArrayList<Card>) cards.clone();
        redCards.removeIf(s -> (s.type != type));
        return redCards.size();
    }
}
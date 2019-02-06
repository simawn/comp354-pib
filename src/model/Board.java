package model;

import command.CommandManager;
import command.guessCardCommand;
import model.component.Component;
import model.component.KeyCard;
import model.component.Word;
import model.constant.CardType;
import ui.component.Listener;

import java.io.IOException;
import java.util.ArrayList;

public class Board {
    private ArrayList<Card> cards;
    private CommandManager deckCommandManager;
    private int nextSubscription = 0;

    public Board() throws IOException {
        deckCommandManager = new CommandManager();
        String[] words = new Word().build();
        CardType[] keycards = new KeyCard().build();
        cards = new ArrayList<>();
        
        for (int i = 0; i < Component.SIZE; i++) {
            cards.add(new Card(words[i], keycards[i]));
        }
    }

    public boolean pick(Card c) {
        guessCardCommand pickCmd = new guessCardCommand(c, this);
        deckCommandManager.storeAndExecute(pickCmd);
        return false;
    }

    public void addSubscriber(Listener listener) throws IndexOutOfBoundsException {
        Card c = at(nextSubscription);
        c.attach(listener);
        c.push(0, c.word);
        nextSubscription++;
    }


    // to remove a specific card. Returns true if the card is removed.
    public boolean draw(Card c) {
        boolean removed = cards.remove(c);
        c.push(1, CardType.pathOf(c.type));
        return removed;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getNumCardsOfType(CardType type) {
        ArrayList<Card> redCards = (ArrayList<Card>) cards.clone();
        redCards.removeIf(s -> (s.type != type));
        return redCards.size();
    }

    public Card at(int index) {
        return cards.get(index);
    }
}
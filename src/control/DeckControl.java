package control;

import model.Card;
import model.Deck;
import model.constant.CardType;
import ui.component.Listener;

import java.io.IOException;
import java.util.Collections;
import command.guessCardCommand;
import command.CommandManager;

public class DeckControl {
    private Deck deck;
    private int nextSubscription;
    private CommandManager deckCommandManager;

    public DeckControl() {
        try {
            deck = new Deck();
        } catch (IOException e) {
            e.printStackTrace();
        }
        deckCommandManager = new CommandManager();
        nextSubscription = 0;
    }

    public void addSubscriber(Listener listener) throws IndexOutOfBoundsException {
        Card c = deck.at(nextSubscription);
        c.bind(listener);
        c.push(0, c.word);
        nextSubscription++;
    }
    
    public boolean pick(Card c) {
        guessCardCommand pickCmd = new guessCardCommand(c, deck);
        deckCommandManager.storeAndExecute(pickCmd);
        return false;
    }

    // Deprecated since DeckControl needs to go through the command pattern
    public CardType pick() {
        Collections.shuffle(deck.getUnchosenCards());
        try {
            CardType ret = deck.getUnchosenCards().get(0).type;
            pick(deck.getUnchosenCards().get(0));
            return ret;
            //return deck.draw();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Can no longer pick a card.");
            return null;
        }
    }

}

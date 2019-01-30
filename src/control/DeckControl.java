package control;

import model.Deck;
import model.constant.CardType;
import ui.listener.Listener;

import java.io.IOException;

public class DeckControl {
    Deck deck;
    private int nextSubscription;

    DeckControl() {
        deck = new Deck();
        nextSubscription = 0;
    }

    void addSubscriber(Listener listener) throws IndexOutOfBoundsException {
        deck.at(nextSubscription).bind(listener);
        nextSubscription++;
    }

    CardType pick() throws IndexOutOfBoundsException, IOException {
        return deck.draw();
    }
}

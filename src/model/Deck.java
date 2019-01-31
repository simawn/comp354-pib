package model;

import model.component.Component;
import model.component.KeyCard;
import model.component.Word;
import model.constant.CardType;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.ArrayList;


public class Deck {
    private ArrayList<Card> cards;

    public Deck() throws IOException {
        String[] words = new Word().build();
        CardType[] keycards = new KeyCard().build();
        cards = new ArrayList<>();

        for (int i = 0; i < Component.SIZE; i++) {
            cards.add(new Card(words[i], keycards[i]));
        }
    }

    // draw() will be a random draw.
    public CardType draw() throws IndexOutOfBoundsException {
        Card c = cards.remove(0);
        c.push(1, CardType.pathOf(c.type));
        return c.type;
    }

    public List<Card> getUnchosenCards() {
        return cards;
    }


    public Card at(int index) {
        return cards.get(index);
    }
}
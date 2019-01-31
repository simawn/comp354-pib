package model;

import model.component.Component;
import model.component.KeyCard;
import model.component.Word;
import model.constant.CardType;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;


public class Deck {
    private Stack<Card> cards;

    public Deck() throws IOException {
        String[] words = new Word().build();
        CardType[] keycards = new KeyCard().build();
        cards = new Stack<>();

        for (int i = 0; i < Component.SIZE; i++) {
            cards.push(new Card(words[i], keycards[i]));
        }
    }


    public CardType draw() throws EmptyStackException {
        Card c = cards.pop();
        c.push(1, CardType.pathOf(c.type));
        return c.type;
    }

    public List<Card> toList() {
        return cards;
    }


    public Card at(int index) {
        return ((List<Card>) cards).get(index);
    }
}
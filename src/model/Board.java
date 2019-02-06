package model;

import model.component.Component;
import model.component.KeyCard;
import model.component.Word;
import model.constant.CardType;

import java.io.IOException;
import java.util.ArrayList;

public class Board {
    private ArrayList<Card> cards;

    public Board() throws IOException {
        String[] words = new Word().build();
        CardType[] keycards = new KeyCard().build();
        cards = new ArrayList<>();
        
        for (int i = 0; i < Component.SIZE; i++) {
            cards.add(new Card(words[i], keycards[i]));
        }
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

    public Card at(int index) {
        return cards.get(index);
    }
}
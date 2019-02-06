package model;

import model.component.CardType;
import model.component.Subject;

public class Card extends Subject {
    public String word;
    public CardType type;

    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
        System.out.println("Creating a card " + word + ": " + type);
    }
    
    @Override
    public String toString() {
        return word;
    }
}

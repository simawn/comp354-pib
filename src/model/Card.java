package model;

import model.component.Subject;
import model.constant.CardType;

public class Card extends Subject {
    public String word;
    public CardType type;

    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
    }
}

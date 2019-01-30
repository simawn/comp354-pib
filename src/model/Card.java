package model;

import model.component.Subject;
import model.constant.CardType;

public class Card extends Subject {
    String word;
    CardType type;
    boolean isOpened;

    public Card() {
    }

    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
        isOpened = false;
    }
}

package model.board;

import model.util.Verbose;

/**
* Represents a card on the code names board. Keeps track of the color given to the
* board by the key card. Each card is a subject of the observers in the View.
*
* @author Anthony Funiecello, David Gray, Rani Rafid
* @date 02/06/19
*/


public class Card extends Subject {
    /**
     * The "code name"
     */
    public String word;
    /**
     * The color given to this card by the Key Card.
     */
    public CardType type;

    public Card() {
        word = null;
        type = null;
    }

    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
        Verbose.log("Creating a card " + word + ": " + type);
    }

    public void setType(String word) {
        this.word = word;
        push();
    }

    @Override
    public String toString() {
        return word;
    }

    /**
     * Overrides the getStringProperty() from Subject.
     * Tells the observer's what the code name is.
     */
    @Override
    public String getStringProperty() {
        return word;
    }


    /**
     * Overrides the getStringProperty() from Subject.
     * Tells the observer's what the card color is.
     */
    @Override
    public CardType getTypeProperty() {
        return type;
    }
}

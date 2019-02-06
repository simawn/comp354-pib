package model.board;

public class Card extends Subject {
    public String word;
    public CardType type;

    public Card() {
        word = null;
        type = null;
    }

    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
        System.out.println("Creating a card " + word + ": " + type);
    }

    public void setType(String word) {
        this.word = word;
        push();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public String getStringProperty() {
        return word;
    }

    @Override
    public CardType getTypeProperty() {
        return type;
    }
}

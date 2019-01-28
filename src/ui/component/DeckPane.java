package ui.component;

import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;
import model.Card;

/*
    Manages the behaviour and representation of all graphical card nodes
 */
class DeckPane extends TilePane {

    private DeckPane(Card[] cards) {
        setPadding(new Insets(4, 4, 4, 4));
        setVgap(4);
        setHgap(4);
        setPrefColumns(5);
        for (Card card : cards) {
            getChildren().add(CardPane.build(card));
        }
    }

    static TilePane build(Card[] cards) {
        return new DeckPane(cards);
    }
}

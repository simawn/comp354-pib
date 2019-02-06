package ui.component;

import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;
import model.Board;
import model.component.Component;

/*
    Manages the behaviour and representation of all graphical card nodes
 */
public class BoardPane extends TilePane {

    public BoardPane(Board deckcontrol) {
        setPadding(new Insets(4, 4, 4, 4));
        setVgap(4);
        setHgap(4);
        setPrefColumns(5);
        for (int i = 0; i < Component.SIZE; i++) {
            getChildren().add(CardPane.build(deckcontrol));
        }
    }

    static TilePane build(Board deckcontrol) {
        return new BoardPane(deckcontrol);
    }
}

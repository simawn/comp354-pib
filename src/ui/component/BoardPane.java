package ui.component;

import control.BoardControl;
import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;
import model.component.Component;

/*
    Manages the behaviour and representation of all graphical card nodes
 */
class BoardPane extends TilePane {

    private BoardPane(BoardControl deckcontrol) {
        setPadding(new Insets(4, 4, 4, 4));
        setVgap(4);
        setHgap(4);
        setPrefColumns(5);
        for (int i = 0; i < Component.SIZE; i++) {
            getChildren().add(CardPane.build(deckcontrol));
        }
    }

    static TilePane build(BoardControl deckcontrol) {
        return new BoardPane(deckcontrol);
    }
}

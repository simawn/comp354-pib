package ui.component;

import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;

/*
    Manages the behaviour and representation of all graphical card nodes
 */
public class BoardPane extends TilePane {

    public BoardPane(CardPane[] arr) {
        setPadding(new Insets(4, 4, 4, 4));
        setVgap(4);
        setHgap(4);
        setPrefColumns(5);
        for (CardPane cardPane : arr) {
            getChildren().add(cardPane);
        }
    }
}

package ui.component;

import control.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import model.Board;

/*
    Sets the inner scene within the application view
    Contains all properties that can modify the interaction behaviours
 */
class BoardScene extends Scene {

    private BoardScene(Board deckcontrol) {
        super(BoardPane.build(deckcontrol));
        setFill(Paint.valueOf("877567"));
        setOnKeyPressed(new KeyHandler(deckcontrol)); //todo rever the parameter of KeyHandler to default
    }

    static BoardScene build(Board deckcontrol) {
        return new BoardScene(deckcontrol);
    }
}

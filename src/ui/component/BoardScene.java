package ui.component;

import control.DeckControl;
import control.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;

/*
    Sets the inner scene within the application view
    Contains all properties that can modify the interaction behaviours
 */
class BoardScene extends Scene {

    private BoardScene(DeckControl deckcontrol) {
        super(DeckPane.build(deckcontrol));
        setFill(Paint.valueOf("877567"));
        setOnKeyPressed(new KeyHandler(deckcontrol)); //todo rever the parameter of KeyHandler to default
    }

    static BoardScene build(DeckControl deckcontrol) {
        return new BoardScene(deckcontrol);
    }
}

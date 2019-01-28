package ui.component;

import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import model.Card;
import ui.listener.KeyHandler;

/*
    Sets the inner scene within the application view
    Contains all properties that can modify the interaction behaviours
 */
class BoardScene extends Scene {

    private BoardScene(Card[] cards) {
        super(DeckPane.build(cards));
        setFill(Paint.valueOf("877567"));
        setOnKeyPressed(new KeyHandler(cards)); //todo rever the parameter of KeyHandler to default
    }

    static Scene build(Card[] cards) {
        return new BoardScene(cards);
    }
}

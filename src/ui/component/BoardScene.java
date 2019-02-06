package ui.component;

import control.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;

/*
    Sets the inner scene within the application view
    Contains all properties that can modify the interaction behaviours
 */
public class BoardScene extends Scene {

    public BoardScene(BoardPane board) {
        super(board);
        setFill(Paint.valueOf("877567"));
        setOnKeyPressed(new KeyHandler()); //todo rever the parameter of KeyHandler to default
    }
}

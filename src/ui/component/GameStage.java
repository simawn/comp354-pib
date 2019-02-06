package ui.component;

import javafx.stage.Stage;
import model.Board;

/*
    Holds the application's properties with respect to the kernel's virtual screen
 */
public class GameStage extends Stage {
    public GameStage(Board deckcontrol) {
        setTitle("Codenames Game");
        setResizable(false);
        setScene(BoardScene.build(deckcontrol));
    }

}

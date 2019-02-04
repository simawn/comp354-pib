package ui.component;

import control.BoardControl;
import javafx.stage.Stage;

/*
    Holds the application's properties with respect to the kernel's virtual screen
 */
public class GameStage extends Stage {
    public GameStage(BoardControl deckcontrol) {
        setTitle("Codenames Game");
        setResizable(false);
        setScene(BoardScene.build(deckcontrol));
    }
}

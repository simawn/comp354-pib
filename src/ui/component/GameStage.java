package ui.component;

import control.DeckControl;
import javafx.stage.Stage;

/*
    Holds the application's properties with respect to the kernel's virtual screen
 */
public class GameStage extends Stage {
    public GameStage(DeckControl deckcontrol) {
        setTitle("Codenames Game");
        setResizable(false);
        setScene(BoardScene.build(deckcontrol));
    }
}

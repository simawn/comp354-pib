package ui.component;

import javafx.stage.Stage;
import model.Card;

/*
    Holds the application's properties with respect to the kernel's virtual screen
 */
public class GameStage extends Stage {
    public GameStage(Card[] cards) {
        setTitle("Codenames Game");
        setResizable(false);
        setScene(BoardScene.build(cards));
    }
}

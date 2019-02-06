package control.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/*
    Handles all KeyEvents pressed by the user
 */
public class GameHandler implements EventHandler<KeyEvent> {

    private PlayerControl playerControl;

    public GameHandler(PlayerControl playerControl) {
        this.playerControl = playerControl;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            playerControl.doNextTurn();

        }
    }
}

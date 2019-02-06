package control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Board;

/*
    Handles all KeyEvents pressed by the user
 */
public class KeyHandler implements EventHandler<KeyEvent> {

    //todo erase all this after

    private PlayerControl playerControl;

    public KeyHandler(Board board) {
        playerControl = new PlayerControl(board);
    }
    //todo end of erase

    @Override
    public void handle(KeyEvent keyEvent) {
        //todo this is NOT the intended function. Simply a test for iteration 1
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                playerControl.doNextTurn();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        //todo end of erase
    }
}

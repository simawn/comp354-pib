package control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Board;

/**
 * Handles all KeyEvents for when keys are pressed by the user.
 * 
 * @author Rani Rafid
 * @date 02/06/19
 */
public class KeyHandler implements EventHandler<KeyEvent> {

    private PlayerControl playerControl;

    public KeyHandler(Board board) {
        playerControl = new PlayerControl(board);
    }

    /**
     * When the user presses ENTER, the KeyHandler triggers the playerControl to play the next turn.
     * 
     * @param keyEvent 
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                playerControl.doNextTurn();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
    }
}

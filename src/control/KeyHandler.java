package control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/*
    Handles all KeyEvents pressed by the user
 */
public class KeyHandler implements EventHandler<KeyEvent> {

    //todo erase all this after
    private DeckControl deckcontrol;

    public KeyHandler(DeckControl deckcontrol) {
        this.deckcontrol = deckcontrol;
    }
    //todo end of erase

    @Override
    public void handle(KeyEvent keyEvent) {
        //todo this is NOT the intended function. Simply a test
        if (keyEvent.getCode() == KeyCode.ENTER) {
            try {
                deckcontrol.pick();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        //todo end of erase
    }
}

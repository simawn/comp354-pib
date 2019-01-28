package ui.listener;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Card;

import java.util.Random;

/*
    Handles all KeyEvents pressed by the user
 */
public class KeyHandler implements EventHandler<KeyEvent> {

    //todo erase all this after
    private Card[] cards;
    private Random rand;

    public KeyHandler(Card[] cards) {
        rand = new Random();
        this.cards = cards;
    }
    //todo end of erase

    @Override
    public void handle(KeyEvent keyEvent) {
        //todo this is NOT the intended function. Simply a test
        if (keyEvent.getCode() == KeyCode.ENTER) {
            int x;
            do {
                x = rand.nextInt(cards.length);
            } while (cards[x].isOpened());
            cards[x].open();

        }
        //todo end of erase
    }
}

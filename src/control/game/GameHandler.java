package control.game;

import control.command.CommandManager;
import control.command.NextTurnCommand;
import model.board.Card;
import model.board.GameManager;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import view.CardPane;
import view.ScoreView;
import view.VerboseView;

/**
 * Handles all Events for when keys are pressed and cards are clicked by the user.
 *
 * @author Rani Rafid, Alexia Soucy
 * @date 02/06/19
 */
public class GameHandler implements EventHandler<Event> {

    private GameManager game;
    private VerboseView view;
    private ScoreView score;
    private CommandManager commandManager;

    public GameHandler(GameManager game, VerboseView view, ScoreView score) {
        this.game = game;
        this.view = view;
        this.score = score;
        this.commandManager = new CommandManager();
        score.open();
    }

    /**
     * Interprets various events by casting them to the appropriate event type.
     * When the user presses ENTER, the KeyHandler triggers the playerControl to play the next turn.
     * When the user clicks a card, the MouseEvent triggers the board to remove that card. (Only in operative mode)
     *
     * @param event
     */
    @Override
    public void handle(Event event) {
    	
    	if (event instanceof KeyEvent) {
    		KeyEvent keyEvent = (KeyEvent) event;
        	
            if (keyEvent.getCode() == KeyCode.ENTER) {
                commandManager.storeAndExecute(new NextTurnCommand(game));
            } else if (keyEvent.getCode() == KeyCode.V && view != null) {
                view.open();
            }
    	}
    	else if (event instanceof MouseEvent) {
    		MouseEvent mouseEvent = (MouseEvent) event;
    		
    		if (GameMode.getGameMode() == 1) {
    			CardPane cp = (CardPane) mouseEvent.getSource();
    			game.humanClick((Card) cp.getSubject());
    		}
    	}
    }


}

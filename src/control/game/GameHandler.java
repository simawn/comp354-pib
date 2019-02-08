package control.game;

import control.command.CommandManager;
import control.command.NextTurnCommand;
import model.board.GameManager;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.VerboseView;

/**
 * Handles all KeyEvents for when keys are pressed by the user.
 *
 * @author Rani Rafid
 * @date 02/06/19
 */
public class GameHandler implements EventHandler<KeyEvent> {

    private GameManager game;
    private VerboseView view;
    private CommandManager commandManager;

    public GameHandler(GameManager game, VerboseView view) {
        this.game = game;
        this.view = view;
        this.commandManager = new CommandManager();
    }

    /**
     * When the user presses ENTER, the KeyHandler triggers the playerControl to play the next turn.
     *
     * @param keyEvent
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            commandManager.storeAndExecute(new NextTurnCommand(game));
        } else if (keyEvent.getCode() == KeyCode.V && view != null) {
            view.open();
        }
    }


}

package control.command;

import model.board.GameManager;

/**
 * A Command to be used by control.GameHandler to tell the GameManager to run the next turn.
 *
 * @author David Gray
 * @date 02/05/19
 */
public class NextTurnCommand implements Command{
    
    /**
     * The part of the model that controls turn flow
     */
    GameManager game;
            
    public NextTurnCommand(GameManager game) {
        this.game = game;
    }

    /**
     * To execute this command, make the model run the next turn.
     */
    @Override
    public void execute() {
        System.out.println("Executing next turn");
        game.doNextTurn();
    }
}

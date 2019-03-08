package model.player;

/**
 * The abstract class for all players (Spymaster or Strategy)
 * 
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
import model.board.CardType;
import model.board.Clue;

public abstract class Player {
    /**
     * The players team (Red or Blue)
     */
    private CardType team;

    public Player(CardType team) {
        this.team = team;
    }

    public CardType getTeam() {
        return team;
    }
 
    /**
     * To be implemented by Operatives and Spymasters. 
     * Operatives return a Card selection and Spymasters return a Clue.
     * 
     * @return 
     */
    public abstract Object makeMove(Clue clue);
}

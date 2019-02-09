package model.player;

/**
 * The abstract class for all players (Spymaster or Strategy)
 * 
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
import model.board.CardType;

public class Player {
    /**
     * The players team (Red or Blue)
     */
    private CardType team;
    private Strategy strat;

    public Player() {
        team = null;
        strat = null;
    }

    public void setTeam(CardType team) {
        this.team = team;
    }

    public CardType getTeam() {
        return team;
    }

    public void switchTeam() {
        if (this.team == null) {
            throw new IllegalStateException();
        }

        this.team = team == CardType.Red ? CardType.Blue : CardType.Red;
    }

    public Strategy getStrategy() {
        return strat;
    }

    public void setStrategy(Strategy strat) {
        this.strat = strat;
    }
 
    /**
     * To be implemented by Operatives and Spymasters. 
     * Operatives return a Card selection and Spymasters return a Clue.
     * 
     * @return 
     */
    public Object play() {
        if (team == null || strat == null) {
            throw new IllegalStateException();
        }
        return strat.play(team);
    }
}

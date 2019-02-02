package players;
/**
 * Enter -> PlayerControl -> runs Strategy , returned cardtype -> Playercontroller -> command
 */

import model.constant.CardType;

public abstract class Player {
    private CardType team;
    
    public Player(CardType team) {
        this.team = team;
    }
    
    public CardType getTeam() {
        return team;
    }
 
    public abstract Object makeMove();
}

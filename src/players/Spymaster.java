package players;

import control.BoardControl;
import model.Clue;
import model.constant.CardType;


public class Spymaster extends Player{
    
    BoardControl deckController;
    SpyStrategy spyStrat;

    public Spymaster(CardType team) {
        super(team);
    }
    
    public Spymaster(CardType team, BoardControl deckController, SpyStrategy strategy) {
        super(team);
        this.spyStrat = strategy;
        this.deckController = deckController;
    }

    @Override
    public Clue makeMove() {
        return spyStrat.giveClue(deckController.getCards());
    }

}


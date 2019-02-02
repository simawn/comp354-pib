package players;

import control.DeckControl;
import model.Clue;
import model.constant.CardType;


public class Spymaster extends Player{
    
    DeckControl deckController;
    SpyStrategy spyStrat;

    public Spymaster(CardType team) {
        super(team);
    }
    
    public Spymaster(CardType team, DeckControl deckController, SpyStrategy strategy) {
        super(team);
        this.spyStrat = strategy;
        this.deckController = deckController;
    }

    @Override
    public Clue makeMove() {
        return spyStrat.giveClue(deckController.getCards());
    }

}


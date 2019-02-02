package players;

import control.DeckControl;
import model.Card;
import model.constant.CardType;

//import model.ModelManager;

public class Operative extends Player{
    
    DeckControl deckController;
    OperativeStrategy opStrat;

    public Operative(CardType team) {
        super(team);
    }
    
    public Operative(CardType team, DeckControl deckController, OperativeStrategy strategy) {
        super(team);
        this.opStrat = strategy;
        this.deckController = deckController;
    }

    @Override
    public Card makeMove() {
        return opStrat.pickCard(deckController.getCards());
    }

}


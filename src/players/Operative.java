package players;

import model.Board;
import model.Card;
import model.constant.CardType;

//import model.ModelManager;

public class Operative extends Player{

    Board deckController;
    OperativeStrategy opStrat;

    public Operative(CardType team) {
        super(team);
    }

    public Operative(CardType team, Board deckController, OperativeStrategy strategy) {
        super(team);
        this.opStrat = strategy;
        this.deckController = deckController;
    }

    @Override
    public Card makeMove() {
        return opStrat.pickCard(deckController.getCards());
    }

}


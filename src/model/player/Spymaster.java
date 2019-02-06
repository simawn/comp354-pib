package model.player;

import model.Board;
import model.Clue;
import model.component.CardType;


public class Spymaster extends Player{

    Board deckController;
    SpyStrategy spyStrat;

    public Spymaster(CardType team) {
        super(team);
    }

    public Spymaster(CardType team, Board deckController, SpyStrategy strategy) {
        super(team);
        this.spyStrat = strategy;
        this.deckController = deckController;
    }

    @Override
    public Clue makeMove() {
        return spyStrat.giveClue(deckController.getCards());
    }

}


package model.player;

import model.board.Board;
import model.board.CardType;
import model.board.Clue;


public class Spymaster extends Player{

    private Board deckController;
    private SpyStrategy spyStrat;

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


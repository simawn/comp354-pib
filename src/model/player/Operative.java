package model.player;

import model.Board;
import model.Card;
import model.component.CardType;





public class Operative extends Player{

    Board board;
    OperativeStrategy opStrat;

    public Operative(CardType team) {
        super(team);
    }

    public Operative(CardType team, Board board, OperativeStrategy strategy) {
        super(team);
        this.opStrat = strategy;
        this.board = board;
    }

    @Override
    public Card makeMove() {
        return opStrat.pickCard(board.getCards());
    }

}


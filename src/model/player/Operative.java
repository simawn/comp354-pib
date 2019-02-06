package model.player;

import model.board.Board;
import model.board.Card;
import model.board.CardType;





public class Operative extends Player{

    private Board board;
    private OperativeStrategy opStrat;

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


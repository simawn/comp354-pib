package model.player;

import model.board.Board;
import model.board.Card;
import model.board.CardType;
import model.board.Clue;




/**
 * The implemented class for all operators.
 * Defines the basic functions and constructor that the operator strategies will use.
 * 
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
public class Operative extends Player{


     /**
     * The player's board they will play on.
     */
    private Board board; 
     /**
     * The player's strategy they will use (ie. random).
     */
    private OperativeStrategy opStrat;

    public Operative(CardType team) {
        super(team);
    }

     /**
     * Instantiate operative to the team, board and strategy they will use.
     */
    public Operative(CardType team, Board board, OperativeStrategy strategy) {
        super(team);
        this.opStrat = strategy;
        this.board = board;
    }

    @Override
    public Card makeMove(Clue clue) {
        opStrat.setClue(clue);
        return opStrat.pickCard(board.getCards());
    }

}


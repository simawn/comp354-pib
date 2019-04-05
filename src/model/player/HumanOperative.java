package model.player;

import model.board.Bipartite;
import model.board.Board;
import model.board.Card;
import model.board.CardType;
import model.board.Clue;




/**
 * The implemented class for human operatives.
 * Defines the basic functions and constructor that the operator strategies will use.
 * Deprecated.
 * 
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
public class HumanOperative extends Player{


     /**
     * The player's board they will play on.
     */
    private Board board; 
     /**
     * The player's strategy they will use (ie. random).
     */
    private OperativeStrategy opStrat;

    public HumanOperative(CardType team) {
        super(team);
    }

     /**
     * Instantiate operative to the team, board and strategy they will use.
     */
    public HumanOperative(CardType team, Board board) {
        super(team);
        this.board = board;
    }
    
    @Override
    public Card makeMove(Clue clue, Bipartite bipartite) {
        opStrat.setClue(clue);
        return opStrat.pickCard(board.getCards(), bipartite);
    }

}


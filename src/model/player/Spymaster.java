package model.player;

import model.board.Board;
import model.board.CardType;
import model.board.Clue;

/**
 * The implemented class for all spymasters.
 * Defines the basic functions and constructor that the spymaster strategies will use.
 *
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
public class Spymaster extends Player {

    /**
     * The spymaster's board they will use to "look" at.
     */
    private Board board;
    /**
     * The spymaster's strategy they will use when they play.
     */
    private SpyStrategy spyStrat;

    public Spymaster(CardType team) {
        super(team);
    }

    /**
     * Instantiate a spymaster to the team, board and strategy they will use.
     */
    public Spymaster(CardType team, Board board, SpyStrategy strategy) {
        super(team);
        this.spyStrat = strategy;
        this.board = board;
    }

    @Override
    public Clue makeMove() {
        return spyStrat.giveClue(board.getCards());
    }

}


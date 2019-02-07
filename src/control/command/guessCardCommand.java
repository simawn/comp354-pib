package control.command;

import model.board.Board;
import model.board.Card;
import model.util.Verbose;

/**
 * A Command to be used in the game when the Operatives guess a card.
 *
 * @author David Gray
 * @date 02/05/19
 */
public class guessCardCommand implements Command {
    /** The card to be chosen
     */
    private final Card c;
    /** The Board object that the card is on.
     */
    private final Board board;
    
    public guessCardCommand(Card c, Board board) {
        this.c = c;
        this.board = board;
    }

    /** To guess a card, you simply "remove" it from the board. Once guessed, the corresponding color
     *  from the key card is revealed, and a card can never be guessed again, so it is removed from the set of cards
     *  on the board available to be removed.
     */
    @Override
    public void execute() {
        Verbose.log("guessCardCommand: removing " + c.word + " from deck ");
        board.remove(c);
    }
    
}

package model.player;

import model.board.Card;
import model.board.Clue;
import model.board.Constants;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * The interface for strategies for spymasters. (Strategy Pattern)
 *
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
public interface SpyStrategy {
    /**
     * Spymasters choose a clue based on the cards on the board.
     */
    Clue giveClue(List<Card> cards);
    
    //TODO: Read from an .ini file instead of direct path for both SpyStrategy and CardBuilder?
    static final Path PATH = Constants.WORDS_PATH;
}

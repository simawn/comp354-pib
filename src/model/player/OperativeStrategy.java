package model.player;

import model.board.Bipartite;
import model.board.Card;

import java.util.List;
import model.board.Clue;


/**
 * The interface for strategies for Operatives. (Strategy Pattern)
 *
 * @author Anthony Funiciello, David Gray
 * @date 02/07/19
 */
public interface OperativeStrategy {
    
    /**
     * Operatives pick a card from a list of cards.
     */
    Card pickCard(List<Card> cards, Bipartite bipartite);
    public Clue getClue();
    public void setClue(Clue clue);

}

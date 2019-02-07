package model.player;

import model.board.Card;

import java.util.List;


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
    Card pickCard(List<Card> cards);
}

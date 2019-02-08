package model.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* The board represents the code name Cards, and the operations available to them, for example
* operatives guessing them.
* 
* @author Anthony Funiecello, David Gray, Rani Rafid
* @date 02/06/19
*/
public class Board {
    /**
     * The list of Card objects. At the beginning of the game the list is made up of 25 cards.
     * When cards are guessed by operatives they are removed from the list.
    */
    private List<Card> cards;
    
    public Board(Card[] cards) {
        this.cards = new ArrayList<>();
        Collections.addAll(this.cards, cards);
        
    }

    /**
     * To remove a specific card from the board. After it's removed the card's push
     * method is called to update the cards observer(s).
    */
    public void remove(Card c) {
        cards.remove(c);
        c.push();
    }

    /**
     * @return Cards left on board.
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Check the board to see how many cards of CardType type remain. This is
     * useful for determining who goes first (whichever team has 9 cards left), and for
     * checking which team is winning.
     * 
     * @param type (color of card)
     * @return number of cards left of CardType type
     */
    public int getNumCardsOfType(CardType type) {
        int count = 0;
        for (Card obj : cards) {
            if (obj.type == type) {
                count++;
            }
        }
        return count;
    }
}
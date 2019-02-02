/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import java.util.ArrayList;
import model.Card;
import model.Clue;

public interface SpyStrategy {
    /**
     * Spymasters will choose a clue based on the cards on the board.
     */
    public Clue giveClue(ArrayList<Card> cards);
}

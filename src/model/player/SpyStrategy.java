/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.Card;
import model.Clue;

import java.util.ArrayList;

public interface SpyStrategy {
    /**
     * Spymasters will choose a clue based on the cards on the board.
     */
    Clue giveClue(ArrayList<Card> cards);
}

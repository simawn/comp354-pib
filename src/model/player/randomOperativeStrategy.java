/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.board.Card;

import java.util.List;
import java.util.Random;

/**
<<<<<<< HEAD
 * The random strategy for operator that will choose cards by random as they play the game.
=======
>>>>>>> 95d6f74b9ef566c17a8c3fa07de8236823b5d4f0
 * @author david
 */
public class randomOperativeStrategy implements OperativeStrategy {


     /**
    * Picks a card at random according to the amount of cards available.
    */
    @Override
    public Card pickCard(List<Card> cards) {
        Random rand = new Random();
        return cards.get(rand.nextInt(cards.size()));
    }

}

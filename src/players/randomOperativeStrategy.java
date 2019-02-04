/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import java.util.ArrayList;
import java.util.Random;
import model.Card;

/**
 *
 * @author david
 */
public class randomOperativeStrategy implements OperativeStrategy {


    @Override
    public Card pickCard(ArrayList<Card> cards) {
        Random rand = new Random();
        return cards.get(rand.nextInt(cards.size()));
    }
    
}

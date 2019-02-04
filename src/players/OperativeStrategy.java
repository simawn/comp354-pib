/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import java.util.ArrayList;
import model.Card;

/**
 *
 * @author david
 */
public interface OperativeStrategy {
    public Card pickCard(ArrayList<Card> cards);
}

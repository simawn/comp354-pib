/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.Card;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public interface OperativeStrategy {
    Card pickCard(ArrayList<Card> cards);
}

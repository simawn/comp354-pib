package strategy;

import model.Card;
import control.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public interface PlayerStrategy {

    public void makeMove(Card[] cards);
}

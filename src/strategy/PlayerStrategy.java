package strategy;

import model.Card;
import control.Player;



public interface PlayerStrategy {

    public void makeMove(Card[] cards);
}

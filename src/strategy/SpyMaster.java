/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import model.Card;
import model.component.Clue;

import java.util.Random;

public class SpyMaster implements PlayerStrategy {
    
    Clue clue;
     private Random rand;
       public void makeMove(Card[] cards){
       rand = new Random();
       int x;         
       x = rand.nextInt(cards.length);
           //m.giveClue(clue.doSomething(), x);
           //todo clue.doSomething();
       /*
       if(cards[x].getType() == CardType.BLUE){
           //give clue to blue
       }
        if(cards[x].getType() == CardType.RED){
           //give clue to red
       } */
       }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import java.util.Random;
import model.Card;
import model.ModelManager;
import model.constant.CardType;

public class SpyMaster implements PlayerStrategy {
    ModelManager m = new ModelManager();
     private Random rand;
       public void makeMove(Card[] cards){
       rand = new Random();
       int x;         
       x = rand.nextInt(cards.length);
       m.giveClue("gf", x);
       
       /*
       if(cards[x].getType() == CardType.BLUE){
           //give clue to blue
       }
        if(cards[x].getType() == CardType.RED){
           //give clue to red
       } */
       }
}

package strategy;

import control.DeckControl;
import control.Player;
import model.Card;

import java.util.Random;

//import model.ModelManager;

public class Operative implements PlayerStrategy {
    
    Player player;
    private Random rand;
    DeckControl d; // todo remember, we'll need to have the same reference for both strats
    //make a guess for a card
    @Override
    public void makeMove(Card[] cards){
      
       rand = new Random();
       int x;
       
        //do{   
         x = rand.nextInt(cards.length);
        //m.pickCard(x);
        d.pick(); //todo that looks easier to do?
        /*}while (cards[x].isOpen());
         cards[x].open();
         
        if(player.getTeam() == 0){
            if(cards[x].getType() != CardType.BLUE){
                //give turn to red
            }
            if(cards[x].getType() == CardType.ASSASSIN){
                //lose game
            }
            if(cards[x].getType() == CardType.BYSTANDER){
                //do bystander stuff
            }
        }
        else if(player.getTeam() == 1){
            if(cards[x].getType() != CardType.RED){
                //give turn to blue
            }
            if(cards[x].getType() == CardType.ASSASSIN){
                //lose game
            }
            if(cards[x].getType() == CardType.BYSTANDER){
                //do bystander stuff
            }
        */
        }

}


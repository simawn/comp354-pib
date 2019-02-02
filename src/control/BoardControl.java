package control;

import model.Card;
import model.Board;
import model.constant.CardType;
import ui.component.Listener;

import java.io.IOException;
import java.util.Collections;
import command.guessCardCommand;
import command.CommandManager;
import java.util.ArrayList;

/*
    The purpose of this class is to provide an interface to the board.  
    The GUI uses BoardControl to attach itself as an observer to the cards.
    The players use BoardControl to modify the board.
*/
public class BoardControl {
    private Board deck;
    private int nextSubscription;
    private CommandManager deckCommandManager;

    public BoardControl() {
        try {
            deck = new Board();
        } catch (IOException e) {
            e.printStackTrace();
        }
        deckCommandManager = new CommandManager();
        nextSubscription = 0;
    }

    public void addSubscriber(Listener listener) throws IndexOutOfBoundsException {
        Card c = deck.at(nextSubscription);
        c.bind(listener);
        c.push(0, c.word);
        nextSubscription++;
    }
    
    public boolean pick(Card c) {
        guessCardCommand pickCmd = new guessCardCommand(c, deck);
        deckCommandManager.storeAndExecute(pickCmd);
        return false;
    }
    
    public ArrayList<Card> getCards(){
        return deck.getCards();
    }
    
    
    public int getNumRedCards() {
        ArrayList<Card> redCards = (ArrayList<Card>) deck.getCards().clone();
        redCards.removeIf(s -> (s.type == CardType.Blue) || (s.type == CardType.Assassin) || (s.type == CardType.Bystander));
        return redCards.size();
    }
   
    public int getNumBlueCards() {
        ArrayList<Card> blueCards = (ArrayList<Card>) deck.getCards().clone();
        blueCards.removeIf(s -> (s.type == CardType.Red) || (s.type == CardType.Assassin) || (s.type == CardType.Bystander));
        return blueCards.size();
    }
    
    
    
    
    
    
    
    
    
    // Deprecated since DeckControl needs to go through the command pattern
    public CardType pick() {
        Collections.shuffle(deck.getCards());
        try {
            CardType ret = deck.getCards().get(0).type;
            pick(deck.getCards().get(0));
            return ret;
            //return deck.draw();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Can no longer pick a card.");
            return null;
        }
    }

}

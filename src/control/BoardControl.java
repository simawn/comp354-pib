package control;

import command.CommandManager;
import command.guessCardCommand;
import model.Board;
import model.Card;
import model.constant.CardType;
import ui.component.Listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
    The purpose of this class is to provide an interface to the board.  
    The GUI uses BoardControl to attach itself as an observer to the cards.
    The players use BoardControl to modify the board.
*/
public class BoardControl {
    private Board board;
    private int nextSubscription;
    private CommandManager deckCommandManager;

    public BoardControl() {
        try {
            board = new Board();
        } catch (IOException e) {
            e.printStackTrace();
        }
        deckCommandManager = new CommandManager();
        nextSubscription = 0;
    }

    public void addSubscriber(Listener listener) throws IndexOutOfBoundsException {
        Card c = board.at(nextSubscription);
        c.attach(listener);
        c.push(0, c.word);
        nextSubscription++;
    }
    
    public boolean pick(Card c) {
        guessCardCommand pickCmd = new guessCardCommand(c, board);
        deckCommandManager.storeAndExecute(pickCmd);
        return false;
    }
    
    public ArrayList<Card> getCards(){
        return board.getCards();
    }
    
    
    public int getNumCardsOfType(CardType type) {
        ArrayList<Card> redCards = (ArrayList<Card>) board.getCards().clone();
        redCards.removeIf(s -> (s.type != type));
        return redCards.size();
    }

    
    
    
    // Deprecated since DeckControl needs to go through the command pattern
    public CardType pick() {
        Collections.shuffle(board.getCards());
        try {
            CardType ret = board.getCards().get(0).type;
            pick(board.getCards().get(0));
            return ret;
            //return deck.draw();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Can no longer pick a card.");
            return null;
        }
    }

}

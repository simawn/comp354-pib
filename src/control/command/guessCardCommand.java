package control.command;

//import control.DeckControl;

import model.board.Board;
import model.board.Card;

/**
 *
 * @author david
 */
public class guessCardCommand implements Command {
    private final Card c;
    /*
    * I think we specified that we would be using these commands from PlayerControl (doesn't exist yet)
    *   to the DeckControl. The way it's written now it would exist between the DeckControl and Deck, because
    *   DeckControl has the instance of Deck which would be passed to the guessCardCommand constructor.
    *   Alternatively, we could give this command a DeckControl instance and add a function to DeckControl
    *   that execute() can call to remove a specified card.
    *
    * Also note that the invoker of the commands needs to have a List<Command> history object.
    */
    private Board deck;
    
    public guessCardCommand(Card c, Board deck) {
        this.c = c;
        this.deck = deck;
    }
    @Override
    public void execute() {
        System.out.println("guessCardCommand: removing " + c.word + " from deck " );
        deck.remove(c);
    }
    
}

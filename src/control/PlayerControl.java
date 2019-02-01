package control;
import command.guessCardCommand;
import model.Deck;
import control.DeckControl;
import model.constant.CardType;
import strategy.PlayerStrategy;
/**
 *
 * @author david
 */
public class PlayerControl {
    
    PlayerStrategy[] players;
    DeckControl deckControl;
    int whosTurn;

    public PlayerControl(DeckControl deckControl) {
        //use deck to determine who goes first. (count how many red cards, if 9, red goes first, else, blue goes first)
        // initialize PlayerStrategies with new [redRandSpy,redRandOp,blueRandSpy,blueRandOp]
        // set turn to 0, or 2 depending on who goes first.
       this.deckControl = deckControl;
       for(int i=0;i<deckControl.getBoardAmount();i++){
           if(deckControl.getBoard()[i] == CardType.Red){
               
           }
       }
    }
    
    //Called by EventHandler on pressing enter
    public void doNextTurn(){
        // If spy turn, call their function and set hint
        // 
        // if operative turn, call their function, passing them the cards, and getting the card they want to pick
        //  call DeckControl.pick(card) from whatever card the operative picks.
        
        // If the card is a different color than the players team, set whosTurn to (whosTurn + 1)%4
    }
    
}

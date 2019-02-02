package control;

import model.Card;
import model.Clue;
import model.constant.CardType;
import players.Operative;
import players.Player;
import players.Spymaster;
import players.randomOperativeStrategy;
import players.randomSpyStrategy;
/**
 *
 * @author david
 */
public class PlayerControl {
    
    Player[] players;
    DeckControl deckControl;
    int whosTurn;
    int numOpGuesses;
    Clue currentClue; // Have to keep track of how many guesses the operative has made.
    
    public PlayerControl(DeckControl deckControl) {
        players = new Player[4];
        players[0] = new Spymaster(CardType.Red, deckControl, new randomSpyStrategy());
        players[1] = new Operative(CardType.Red, deckControl, new randomOperativeStrategy());
        players[2] = new Spymaster(CardType.Blue, deckControl, new randomSpyStrategy());
        players[3] = new Operative(CardType.Blue, deckControl, new randomOperativeStrategy());
        whosTurn = 0;
        if(deckControl.getNumBlueCards() == 9) {
            System.out.println("Blue going first");
            whosTurn = 2; //blue goes first because there are 9 blue cards
        }
        this.numOpGuesses = 0;
        this.deckControl = deckControl;
    }
    
    //Called by EventHandler on pressing enter
    public void doNextTurn(){
        if((whosTurn % 2) == 0) { //SpyMasters turn
            currentClue = (Clue)players[whosTurn].makeMove();
            System.out.println(players[whosTurn].getTeam() + " spymaster gave clue " 
                    + currentClue.getClueWord() + ": " + currentClue.getClueNum());
            endTurn();
        } else {
            Card guess =  (Card)players[whosTurn].makeMove();
            System.out.println(players[whosTurn].getTeam() + " operative guessed " + guess.word);
            deckControl.pick(guess);
            numOpGuesses += 1;
            if(guess.type != players[whosTurn].getTeam()){
                System.out.println("Wrong color! " + players[whosTurn].getTeam() + "'s turn ends.");
                endTurn();
            }
            if(numOpGuesses >= currentClue.getClueNum() + 1) {
                System.out.println(players[whosTurn].getTeam() + "'s is out of guesses, turn over."); 
                endTurn();
            }
        }
    }
    
    private void endTurn() {
        whosTurn = (whosTurn + 1) % 4;
        numOpGuesses = 0;
    }
    
}

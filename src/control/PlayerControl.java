package control;

import model.Board;
import model.Card;
import model.Clue;
import model.component.CardType;
import model.player.*;

/**
 *
 * @author david
 */
public class PlayerControl {
    
    Player[] players;
    Board deckControl;
    int whosTurn;
    int numOpGuesses;
    boolean gameOver;
    Clue currentClue; // Have to keep track of how many guesses the operative has made.

    public PlayerControl(Board deckControl) {
        players = new Player[4];
        players[0] = new Spymaster(CardType.Red, deckControl, new randomSpyStrategy());
        players[1] = new Operative(CardType.Red, deckControl, new randomOperativeStrategy());
        players[2] = new Spymaster(CardType.Blue, deckControl, new randomSpyStrategy());
        players[3] = new Operative(CardType.Blue, deckControl, new randomOperativeStrategy());
        whosTurn = 0;
        if(deckControl.getNumCardsOfType(CardType.Blue) == 9) {
            System.out.println("Blue going first");
            whosTurn = 2; //blue goes first because there are 9 blue cards
        }
        this.numOpGuesses = 0;
        this.deckControl = deckControl;
        gameOver = false;
    }
    
    //Called by EventHandler on pressing enter
    public void doNextTurn(){
        if(gameOver) {
            System.out.println("Game over");
            return;
        }
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
            checkGameState(guess);
        }
    }
    
    private void checkGameState(Card guess) {
        // If current team just choose their last card
        if(deckControl.getNumCardsOfType(players[whosTurn].getTeam()) == 0) {
            gameOver = true;
            System.out.println("Game Over, " + players[whosTurn].getTeam() + " wins!");
        }
        
        // If current team chose the wrong card
        if(guess.type != players[whosTurn].getTeam()){ // Chose wrong color
            CardType otherTeamColor = players[(whosTurn + 1)%4].getTeam();
            
            // If they chose their opponents last card or chose the assassin card
            if ((deckControl.getNumCardsOfType(otherTeamColor) == 0) ||
                    (guess.type == CardType.Assassin)) {
                System.out.println("Game Over, " + otherTeamColor + " wins!");
                gameOver = true;
                return;
            }
            
            System.out.println("Wrong color! " + players[whosTurn].getTeam() + "'s turn ends.");
            endTurn();
        }
        
        // If the operatives have used all of their guesses for this turn
        if(numOpGuesses >= currentClue.getClueNum() + 1) { // Choose cluenum + 1 times, turn over.
            System.out.println(players[whosTurn].getTeam() + "'s is out of guesses, turn over.");
            endTurn();
        }
    }
    
    private void endTurn() {
        whosTurn = (whosTurn + 1) % 4;
        numOpGuesses = 0;
    }
    
}

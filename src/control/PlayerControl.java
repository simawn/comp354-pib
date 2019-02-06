package control;

import model.Board;
import model.Card;
import model.Clue;
import model.component.CardType;
import model.player.*;

/**
 * PlayerControl keeps track of which players turn it is, and calls them to make their turns.
 * 
 * @author David Gray, Rani Rafid
 * @date 02/06/2019
 */
public class PlayerControl {
    
    /**
     * An array of the players in the game
     */
    Player[] players;
    /**
     * An index into Player[] players to keep track of which players turn it is.
     */
    int whosTurn;

    /**
     * The instance of the game board.
     */
    Board board;
    
    /**
     * Number of guesses the current operator has made so far in their turn.
     */
    int numOpGuesses;
  
    boolean gameOver;
    
    /**
     * To keep track of the number given in the clue, to limit operatives number of guesses
     */
    Clue currentClue; 

    /**
     * Constructor.  Creates the players for the game. Initializes turn state depending on the key card.
     * 
     * @param board 
     */
    public PlayerControl(Board board) {
        players = new Player[4];
        players[0] = new Spymaster(CardType.Red, board, new randomSpyStrategy());
        players[1] = new Operative(CardType.Red, board, new randomOperativeStrategy());
        players[2] = new Spymaster(CardType.Blue, board, new randomSpyStrategy());
        players[3] = new Operative(CardType.Blue, board, new randomOperativeStrategy());
        whosTurn = 0;
        if(board.getNumCardsOfType(CardType.Blue) == 9) {
            System.out.println("Blue going first");
            whosTurn = 2; //blue goes first because there are 9 blue cards
        }
        this.numOpGuesses = 0;
        this.board = board;
        gameOver = false;
    }
    
    /**
     * Do the next turn
     */
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
        } else { //Operatives turn
            Card guess =  (Card)players[whosTurn].makeMove();
            System.out.println(players[whosTurn].getTeam() + " operative guessed " + guess.word);
            board.pick(guess);
            numOpGuesses += 1;
            checkGameState(guess);
        }
    }
    
    /**
     * Called at the end of an operatives turn.  
     * Checks if game is over.
     * Checks whether the operative picked the Assassin, or the other teams card. 
     * Checks if the operative is out of guesses. Updates turn state accordingly.
     * @param guess 
     */
    private void checkGameState(Card guess) {
        // If current team just choose their last card
        if(board.getNumCardsOfType(players[whosTurn].getTeam()) == 0) {
            gameOver = true;
            System.out.println("Game Over, " + players[whosTurn].getTeam() + " wins!");
        }
        
        // If current team chose the wrong card
        if(guess.type != players[whosTurn].getTeam()){ // Chose wrong color
            CardType otherTeamColor = players[(whosTurn + 1)%4].getTeam();
            
            // If they chose their opponents last card or chose the assassin card
            if ((board.getNumCardsOfType(otherTeamColor) == 0) ||
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
    
    /**
     * Circularly increment the turn array index whosTurn, and reset numOpGuesses to 0.
     */
    private void endTurn() {
        whosTurn = (whosTurn + 1) % 4;
        numOpGuesses = 0;
    }
    
}

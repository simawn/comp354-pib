package model.board;

import model.player.*;
import model.util.Verbose;

/**
 * PlayerControl keeps track of which players turn it is, and calls them to make their turns.
 *
 * @author David Gray, Rani Rafid
 * @date 02/06/2019
 */
public class GameManager extends Subject {

    /**
     * Game state data. 
     * players: array of Players in the game. 
     * whosTurn: index into players to keep track of whose turn it is.
     * winningTeam: null until a team wins, then it is their colour.
     * currentClue
     */
    private Player[] players;
    private int whosTurn;
    private CardType winningTeam;
    private Clue currentClue;

    /**
     * Number of guesses the current operative has made so far in their turn.
     */
    private int numOpGuesses;

    /**
     * The instance of the game board.
     */
    private Board board;
            
    /**
     * Constructor.  Creates the players for the game. Initializes turn state depending on the key card.
     *
     * @param board
     */
    public GameManager(Board board) {
        players = new Player[4];
        players[0] = new Spymaster(CardType.Red, board, new SmartSpyStrategy(CardType.Red));
        players[1] = new Operative(CardType.Red, board, new randomOperativeStrategy());
        players[2] = new Spymaster(CardType.Blue, board, new SmartSpyStrategy(CardType.Red));
        players[3] = new Operative(CardType.Blue, board, new randomOperativeStrategy());
        whosTurn = 0;
        if(board.getNumCardsOfType(CardType.Blue) == 9) {
            Verbose.log("Blue going first");
            whosTurn = 2; //blue goes first because there are 9 blue cards
        }
        this.numOpGuesses = 0;
        this.board = board;
        this.winningTeam = null;
    }
    
    /**
     * Do the next turn
     */
    public void doNextTurn(){
        if(gameIsOver()) {
            Verbose.log("Game Over");
            return;
        }
        if ((whosTurn % 2) == 0) { //SpyMasters turn
            takeTurn((Spymaster) players[whosTurn]);
        } else { //Operatives turn
            takeTurn((Operative) players[whosTurn]);
        }
    }
    /**
     * Have a Spymaster make a logical hint based on wordnet
     * @param p the spymaster making that move
     */
    private void takeSmartTurn(Spymaster p){
        
    }
    /**
     * Have the operative make a smart guess based on the clue
     * @param p the operative making that move
     */
    private void takeSmartTurn(Operative p){
        
    }
    /**
     * Have a Spymaster take their turn
     * @param p 
     */
    private void takeTurn(Spymaster p) {
        currentClue = p.makeMove();
        Verbose.log(players[whosTurn].getTeam() + " spymaster gave clue "
                + currentClue.getClueWord() + ": " + currentClue.getClueNum());
        endTurn();
        this.push();
    }
    
    /**
     * Have an Operative take their turn
     * @param p 
     */
    private void takeTurn(Operative p) {
        Card guess = p.makeMove();
        Verbose.log(players[whosTurn].getTeam() + " operative guessed " + guess.word);
        board.remove(guess);
        numOpGuesses += 1;
        if (gameIsOver()) {
            winningTeam = declareWinner(p, guess);
            Verbose.log(winningTeam + " wins! Game Over.");
            this.push();
            return;
        }
        if (isTurnOver(p, guess, currentClue.getClueNum())) {
            Verbose.log(players[whosTurn].getTeam() + " turn ends.");
            endTurn();
        }
        this.push();
    }

    /**
     * Called at the end of an Operatives turn.
     * If they choose a card that isn't their teams, or they are out of guesses, their turn is over.
     *
     * @param p     Player whose turn it is
     * @param guess the Card the player guessed
     * @param clueNum the number given by the clue.
     * @return whether the turn is over.
     */
    public boolean isTurnOver(Player p, Card guess, int clueNum) {
        boolean outOfGuesses = (clueNum != 0) &&
                (numOpGuesses >= clueNum + 1);
        return (outOfGuesses || (p.getTeam() != guess.type));
    }
    
    /**
     * Determines if the game is over. 
     * The game is over if a team has been declared winner already, or if all of a teams
     * cards have been chosen, or the assassin has been chosen.
     * @return
     */
    public boolean gameIsOver() {
        if(winningTeam != null) { return true; }
        if(board.getNumCardsOfType(CardType.Assassin) != 1) { return true;
        }
        if (board.getNumCardsOfType(CardType.Blue) == 0) {
            return true; }
        return board.getNumCardsOfType(CardType.Red) == 0;
    }
    
    /**
     * Determine the winner based on the last player to make a move before game ended,
     * and what card they guessed. If they guessed their card, and the game ended, they must have won.
     * Otherwise the other team won because either they chose the other teams last card, or they chose
     * the Assassin.
     * 
     * @param lastPlayer
     * @param lastGuess
     * @return
     */
    public CardType declareWinner(Player lastPlayer, Card lastGuess) {
        if(lastGuess.type == lastPlayer.getTeam()){
            return lastPlayer.getTeam();
        } else {
            if(lastPlayer.getTeam() == CardType.Blue) {
                return CardType.Red;
            } else {
                return CardType.Blue;
            }
        }
    }

    /**
     * Circularly increment the turn array index whosTurn, and reset numOpGuesses to 0.
     */
    private void endTurn() {
        whosTurn = (whosTurn + 1) % 4;
        numOpGuesses = 0;
    }   

    /**
     * Get the number of blue cards left to guess.
     * @return 
     */
    public int getBlueScore() {
        return board.getNumCardsOfType((CardType.Blue));
    }
    
    /**
     * Get the number of red cards left to guess.
     * @return 
     */
    public int getRedScore() {
        return board.getNumCardsOfType((CardType.Red));
    }
    /**
     * Get the winning team.
     * @return 
     */
    public CardType getWinner() {
        return winningTeam;
    }

    /**
     * Get the current clue being given.
     * @return 
     */
    public Clue getCurrentClue() {
        return currentClue;
    }

    /**
     * The "String" property of this Subject is the current clue,
     * or a game over message.
     * @return 
     */
    @Override
    public String getStringProperty() {
        if(currentClue == null) { return ""; }
        if(gameIsOver()) { return "Game Over.";}
        return "Current Clue: " + currentClue.toString();
    }

    /**
     * The "TypeProperty" of this Subject is the team who's current turn it is,
     * or the winner if the game is over.
     * @return 
     */
    @Override
    public CardType getTypeProperty() {
        if(gameIsOver()) { return winningTeam;
        }
        return players[whosTurn].getTeam();
    }
}

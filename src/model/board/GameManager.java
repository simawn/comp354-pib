package model.board;

import model.player.Operative;
import model.player.Player;
import model.player.Spymaster;
import model.player.Strategy;
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
    private Player player;
    private Strategy operative, spymaster;
    private CardType winningTeam;
    private Clue currentClue;


    /**
     * The instance of the game board.
     */
    Board board;
            
    /**
     * Constructor.  Creates the players for the game. Initializes turn state depending on the key card.
     *
     * @param board
     */
    public GameManager(Board board) {
        player = new Player();
        operative = new Operative(board);
        spymaster = new Spymaster();

        if(board.getNumCardsOfType(CardType.Blue) == 9) {
            Verbose.log("Blue going first");
            player.setTeam(CardType.Blue);
        } else {
            Verbose.log("Red going first");
            player.setTeam(CardType.Red);
        }

        this.board = board;
        winningTeam = null;
    }
    
    /**
     * Do the next turn
     */
    public void doNextTurn(){
        if(gameIsOver()) {
            Verbose.log("Game Over");
            return;
        }
        if (currentClue == null || currentClue.getClueNum() == 0) { //SpyMasters turn
            spyPlay();
        } else { //Operatives turn
            opPlay();
        }
    }
    
    /**
     * Have a Spymaster take their turn
     */
    private void spyPlay() {
        player.setStrategy(spymaster);
        currentClue = (Clue) player.play();
        Verbose.log(player.getTeam() + " spymaster gave clue "
                + currentClue.getClueWord() + ": " + (currentClue.getClueNum() == Integer.MAX_VALUE ? "0" : currentClue.getClueNum()));
        currentClue.addClueNum();
        player.setStrategy(operative);
    }
    
    /**
     * Have an Operative take their turn
     */
    private void opPlay() {
        Card guess = (Card) player.play();
        Verbose.log(player.getTeam() + " operative guessed " + guess.word);
        board.remove(guess);
        currentClue.consumeClueNum();
        if (gameIsOver()) {
            winningTeam = declareWinner(player, guess);
            Verbose.log(winningTeam + " wins! Game Over.");
            this.push();
            return;
        }
        /*
          If they choose a card that isn't their teams, or they are out of guesses, their turn is over.
         */
        if (currentClue.getClueNum() == 0 || player.getTeam() != guess.type) {
            Verbose.log(player.getTeam() + " turn ends.");
            player.switchTeam();
            currentClue.setClueNum(0);
        }
    }
    
    /**
     * Determines if the game is over. 
     * The game is over if a team has been declared winner already, or if all of a teams
     * cards have been chosen, or the assassin has been chosen.
     * @return 
     */
    private boolean gameIsOver() {
        if(winningTeam != null) { return true; }
        if(board.getNumCardsOfType(CardType.Assassin) != 1) { return true; }
        if (board.getNumCardsOfType(CardType.Blue) == 0) {
            return true;
        }
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
    private CardType declareWinner(Player lastPlayer, Card lastGuess) {
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
     * The "String" property of this Subject is the current clue,
     * or a game over message.
     * @return 
     */
    @Override
    public String getStringProperty() {
        if(currentClue == null) { return ""; }
        if(gameIsOver()) { return "Game Over.";}
        return currentClue.toString();
    }

    /**
     * The "TypeProperty" of this Subject is the team who's current turn it is,
     * or the winner if the game is over.
     * @return 
     */
    @Override
    public CardType getTypeProperty() {
        if(gameIsOver()) { return winningTeam ;}
        return player.getTeam();
    }
}

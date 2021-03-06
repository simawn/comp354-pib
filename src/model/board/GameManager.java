package model.board;

import control.game.Difficulty;
import model.player.*;
import model.board.Constants;
import model.util.Verbose;
import view.CardPane;
import control.game.GameHandler;
import control.game.GameMode;
import javafx.event.EventType;

/**
 * PlayerControl keeps track of which players turn it is, and calls them to make
 * their turns.
 *
 * @author David Gray, Rani Rafid
 * @date 02/06/2019
 */
public class GameManager extends Subject {

    /**
     * Game state data. players: array of Players in the game. whosTurn: index
     * into players to keep track of whose turn it is. winningTeam: null until a
     * team wins, then it is their colour. currentClue humanTurn: allows the
     * GameManager to verify if a user's click is a valid move in turn order.
     */
    private Player[] players;
    private int whosTurn;
    private CardType winningTeam;
    private Clue currentClue;
    private CardPane cp;
    private String playerTurn = "Hit Enter Until Blue Spymaster gives a clue";

    /**
     * Number of guesses the current operative has made so far in their turn.
     */
    private int numOpGuesses;

    /**
     * The instance of the game board.
     */
    private Board board;

    /**
     * Shows the relationship between words and clues
     */
    private Bipartite bipartite;

    /**
     * Constructor. Creates the players for the game. Initializes turn state
     * depending on the key card.
     *
     * @param board
     */
    public GameManager(Board board) {
        players = new Player[4];
        this.board = board;
        if (Difficulty.getDifficulty() == 0) {
            if (GameMode.getGameMode() == 0) {
                Verbose.log("Easy Difficulty");
                setStrategies(new randomOperativeStrategy(), new randomOperativeStrategy(), new randomSpyStrategy(), new randomSpyStrategy());
            } else if (GameMode.getGameMode() == 1) {
                Verbose.log("Easy Difficulty");
                setStrategies(new randomOperativeStrategy(), new HumanOperativeStrategy(), new randomSpyStrategy(), new randomSpyStrategy());
            }
        } else if (Difficulty.getDifficulty() == 1) {
            if (GameMode.getGameMode() == 0) {
                Verbose.log("Medium difficulty");
                setStrategies(new BotOperativeStrategy(CardType.Red, 0.5), new BotOperativeStrategy(CardType.Blue, 0.5), new SimpleSpyStrategy(CardType.Red), new SimpleSpyStrategy(CardType.Blue));
            } else if (GameMode.getGameMode() == 1) {
                Verbose.log("Medium difficulty");
                setStrategies(new BotOperativeStrategy(CardType.Red, 0.5), new HumanOperativeStrategy(), new SimpleSpyStrategy(CardType.Red), new SimpleSpyStrategy(CardType.Blue));
            }
        } else if (Difficulty.getDifficulty() == 2) {
            if (GameMode.getGameMode() == 0) {
                Verbose.log("Hard difficulty");
                setStrategies(new BotOperativeStrategy(CardType.Red, 0.75), new BotOperativeStrategy(CardType.Blue, 0.95), new SmartSpyStrategy(CardType.Red), new SmartSpyStrategy(CardType.Blue));
                //0.95+ is god mode
            } else if (GameMode.getGameMode() == 1) {
                Verbose.log("Hard difficulty");
                setStrategies(new BotOperativeStrategy(CardType.Red, 0.75), new HumanOperativeStrategy(), new SmartSpyStrategy(CardType.Red), new SmartSpyStrategy(CardType.Blue));
            }
        }

        whosTurn = 0;
        if (board.getNumCardsOfType(CardType.Blue) == 9) {
            Verbose.log("Blue going first");
            whosTurn = 2; //blue goes first because there are 9 blue cards
        }
        this.numOpGuesses = 0;

        this.winningTeam = null;
        this.bipartite = new Bipartite(board);
    }

    /**
     * Set up the player arrays with their strategies
     *
     * @param os1 Red Operative
     * @param os2 Blue Operative
     * @param ss1 Red Spy Master
     * @param ss2 Blue Spy Master
     */
    private void setStrategies(OperativeStrategy os1, OperativeStrategy os2, SpyStrategy ss1, SpyStrategy ss2) {
        players[0] = new Spymaster(CardType.Red, board, ss1);
        players[1] = new Operative(CardType.Red, board, os1);
        players[2] = new Spymaster(CardType.Blue, board, ss2);
        players[3] = new Operative(CardType.Blue, board, os2);
    }

    /**
     * Do the next turn
     */
    public void doNextTurn() {
        if (gameIsOver()) {
            
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
     * Have a Spymaster take their turn
     *
     * @param p
     */
    private void takeTurn(Spymaster p) {
        currentClue = p.makeMove(currentClue, bipartite);
        Verbose.log(players[whosTurn].getTeam() + " spymaster gave clue "
                + currentClue.getClueWord() + ": " + currentClue.getClueNum());
        if(players[whosTurn].getTeam().equals(CardType.Blue)&&((Operative) players[3]).isHuman()){
             playerTurn = "Click Now.";
        }
        endTurn();
        this.push();
    }

    /**
     * Have an Operative take their turn. Automatic for AI, but will simply wait
     * for a command for humans.
     *
     * @param p
     */
    private void takeTurn(Operative p) {
        if (!p.isHuman()) {
            Card guess = p.makeMove(currentClue, bipartite);
            Verbose.log(players[whosTurn].getTeam() + " operative guessed " + guess.word);
            board.remove(guess);
            bipartite.removeWord(guess.getStringProperty());
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
        else{     
            playerTurn = "Click Now.";
            Verbose.log(playerTurn);
        }
    }

    /**
     * Receives card selection from a human operative if it is currently their
     * turn.
     *
     * @param c
     */
    public void humanClick(Card c) {
        if (whosTurn == Constants.HUMAN && board.getCards().contains(c)) {
            Operative p = (Operative) players[Constants.HUMAN];
            Verbose.log(players[whosTurn].getTeam() + " operative guessed " + c.word);
            playerTurn = "Click Now.";
            Verbose.log(playerTurn);
            board.remove(c);
            bipartite.removeWord(c.getStringProperty());
            numOpGuesses += 1;
            if (gameIsOver()) {
                winningTeam = declareWinner(p, c);
                playerTurn = "";
                Verbose.log(winningTeam + " wins! Game Over.");
                this.push();
                return;
            }
            if (isTurnOver(p, c, currentClue.getClueNum())) {
                Verbose.log(players[whosTurn].getTeam() + " turn ends.");
                playerTurn = "Hit Enter Until Blue Spymaster gives a clue";
                Verbose.log(playerTurn);
                endTurn();
            }
            this.push();
        }
    }

    /**
     * Called at the end of an Operatives turn. If they choose a card that isn't
     * their teams, or they are out of guesses, their turn is over.
     *
     * @param p Player whose turn it is
     * @param guess the Card the player guessed
     * @param clueNum the number given by the clue.
     * @return whether the turn is over.
     */
    public boolean isTurnOver(Player p, Card guess, int clueNum) {
        boolean outOfGuesses = (clueNum != 0)
                && (numOpGuesses >= clueNum + 1);
        return (outOfGuesses || (p.getTeam() != guess.type));
    }

    /**
     * Determines if the game is over. The game is over if a team has been
     * declared winner already, or if all of a teams cards have been chosen, or
     * the assassin has been chosen.
     *
     * @return
     */
    public boolean gameIsOver() {
        if (winningTeam != null) {
            return true;
        }
        if (board.getNumCardsOfType(CardType.Assassin) != 1) {
            return true;
        }
        if (board.getNumCardsOfType(CardType.Blue) == 0) {
            return true;
        }
        return board.getNumCardsOfType(CardType.Red) == 0;
    }

    /**
     * Determine the winner based on the last player to make a move before game
     * ended, and what card they guessed. If they guessed their card, and the
     * game ended, they must have won. Otherwise the other team won because
     * either they chose the other teams last card, or they chose the Assassin.
     *
     * @param lastPlayer
     * @param lastGuess
     * @return
     */
    public CardType declareWinner(Player lastPlayer, Card lastGuess) {
        if (lastGuess.type == lastPlayer.getTeam()) {
            return lastPlayer.getTeam();
        } else {
            if (lastPlayer.getTeam() == CardType.Blue) {
                return CardType.Red;
            } else {
                return CardType.Blue;
            }
        }
    }

    /**
     * Circularly increment the turn array index whosTurn, and reset
     * numOpGuesses to 0.
     */
    private void endTurn() {
        whosTurn = (whosTurn + 1) % 4;
        numOpGuesses = 0;
    }

    /**
     * Ends the current turn if the current player is human.
     * 
     * @return whether a human's turn was ended
     */
    public boolean endHumanTurn() {
        if (whosTurn == Constants.HUMAN) {
            whosTurn = (whosTurn + 1) % 4;
            numOpGuesses = 0;
            playerTurn = "Hit Enter Until Blue Spymaster gives a clue";
            return true;
        }
        return false;
    }

    /**
     * Get the number of blue cards left to guess.
     *
     * @return
     */
    public int getBlueScore() {
        return board.getNumCardsOfType((CardType.Blue));
    }

    /**
     * Get the number of red cards left to guess.
     *
     * @return
     */
    public int getRedScore() {
        return board.getNumCardsOfType((CardType.Red));
    }

    /**
     * Get the winning team.
     *
     * @return
     */
    public CardType getWinner() {
        return winningTeam;
    }

    /**
     * Get the current clue being given.
     *
     * @return
     */
    public Clue getCurrentClue() {
        return currentClue;
    }

    /**
     * The "String" property of this Subject is the current clue, or a game over
     * message.
     *
     * @return
     */
    @Override
    public String getStringProperty() {
        if (currentClue == null) {
            return "";
        }
        if (gameIsOver()) {
            return "Game Over.";
        }
        return "Current Clue: " + currentClue.toString();
    }

    /**
     * The "TypeProperty" of this Subject is the team who's current turn it is,
     * or the winner if the game is over.
     *
     * @return
     */
    @Override
    public CardType getTypeProperty() {
        if (gameIsOver()) {
            return winningTeam;
        }
        return players[whosTurn].getTeam();
    }
    
    public String getPlayerTurn(){
        return playerTurn;
    }
}

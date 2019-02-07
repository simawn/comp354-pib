import control.game.GameHandler;
import control.game.PlayerControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.board.Board;
import model.board.Card;
import model.board.CardBuilder;
import model.util.Verbose;
import view.GameScene;
import view.VerboseView;

/**
 * This application is a prototype GUI program of the popular board game Codenames. 
 * Codenames is a 2-team game consisting of a 5x5 grid of cards containing nouns (called Codenames).
 * Team's are made up of 1 Spymaster, and operatives. Teams take turns trying to guess all of the 
 * cards on the grid assigned to their team in a KeyCard, given 1 word noun hints by the teams Spymaster,
 * and a corresponding number of cards related to that noun.
 * 
 * 
 * @author Anthony Funiciello, David Gray, Rani Rafid
 * @date 02/07/19
 */
public class Codenames extends Application {

    /*
    Entry Point of the program
    */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start() is where the GUI, game model, and game controls are instantiated.
     * @param root 
     */
    @Override
    public void start(Stage root) {

        Card[] cards = CardBuilder.buildAll();
        Board board = new Board(cards);
        PlayerControl playerControl = new PlayerControl(board);

        VerboseView view = new VerboseView(Verbose.get());
        Verbose.bind(view);

        GameHandler handler = new GameHandler(playerControl, view);
        Scene scene = GameScene.build(cards, handler);
        root.setScene(scene);
        root.setResizable(false);
        root.setTitle("Codenames - Game");
        root.show(); // Shows the final Stage based on the scene
    }
}

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


public class Codenames extends Application {

    /*
    Entry Point of the program
    */
    public static void main(String[] args) {
        launch(args);
    }

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

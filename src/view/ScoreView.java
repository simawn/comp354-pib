package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.board.CardType;
import model.board.Subject;
import model.board.GameManager;
import model.player.Player;
import model.board.Card;
import model.board.Board;
/**
* VerboseView logs game play information, in an optionally visible window.
* 
* @author Anthony Funiciello
* @date 02/06/19
*/
public class ScoreView implements Observer {
    //private HBox hbox;
    private Stage stage;
    private Subject subject;
    private Label t = new Label();
    private Label redScore = new Label();
    private Label blueScore = new Label();
    private GameManager game;
    private CardType winningTeam;
    // private Player player; can remove
    // private Card card; can remove
    // private Board board; can remove
    /**
     * Create the VerboseView with a Subject s that it will be bound to.
     * @param game
     */
    public ScoreView(GameManager game) {
        this.subject = game;
        this.game = game;
        Scene scene = new Scene(t, 300, 250);
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.S) {
                open();
            }
        });
        Group root = new Group();
        
        redScore.setTranslateY(50);
        blueScore.setTranslateY(65);
        stage = new Stage();
        stage.setTitle("Codenames - Score");
        root.getChildren().add(t);
        root.getChildren().add(redScore);
        root.getChildren().add(blueScore);
        stage.setScene(new Scene(root, 300, 250));
   
    }

    /**
     * Print a message to the VerboseView.
     * @param arg 
     */
    public void log(String arg) {
        if (subject.getTypeProperty() == CardType.Blue) { // CHANGED
            t.setTextFill(Color.BLUE);
            t.setText("Blue's Turn");
        } else if (subject.getTypeProperty() == CardType.Red) { // CHANGED
             t.setTextFill(Color.RED);
             t.setText("Red's Turn");
        }
        
        redScore.setText("Red: ");
        blueScore.setText("Blue: ");
        blueScore.setText("Blue: " + game.getBlueScore()); // CHANGED
        redScore.setText("Red: " + game.getRedScore());
        
        if(game.getWinner() != null){
            t.setText(game.getWinner() + " Wins!");
        }
        
        //If you call this, it will return either "Current Clue: Clue: num" OR "Game Over".
        // game.getStringProperty() but you can also do it the way you had it.
        //hbox.getChildren().add(t);
    }

    /**
     * Open the VerboseView window.
     */
    public void open() {
        if (!stage.isShowing()) {
            stage.show();
        } else {
            stage.hide();
        }
    }

    /**
     * Get the subjects current string property and log it.
     */
    @Override
    public void update() {
        log(subject.getStringProperty());
    }
}

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
    private Player player;
    private Card card;
    /**
     * Create the VerboseView with a Subject s that it will be bound to.
     * @param s 
     */
    public ScoreView(Subject s) {
        this.subject = s;

        
        
        Scene scene = new Scene(t, 300, 250);
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.S) {
                open();
            }
        });
        Group root = new Group();
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

        if (arg.contains("Blue")) {
             t.setTextFill(Color.BLUE);
           t.setText("Blue's Turn");
        } else if (arg.contains("Red")) {
             t.setTextFill(Color.RED);
             t.setText("Red's Turn");
        }
        /*if(game.declareWinner(player, card) == CardType.Red){
            t.setText("Red wins!");
        }else{
            t.setText("Blue wins!");
        }*/
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

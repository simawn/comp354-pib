package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.board.CardType;
import model.board.Subject;
import model.board.GameManager;

/**
* ScoreView Shows game score information, in an optionally visible window.
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
    private Label currentClue = new Label();
    private GameManager game;
    private CardType winningTeam;
 
    /**
     * Create the ScoreView with a Subject s that it will be bound to.
     * @param game
     */
    public ScoreView(GameManager game) {
        this.subject = game;
        this.game = game;
        Scene scene = new Scene(t, 100, 150);
       
        //open();
         
        Group root = new Group();
        
        redScore.setTranslateY(50);
        blueScore.setTranslateY(65);
        currentClue.setTranslateY(25);
        stage = new Stage();
        stage.setTitle("Codenames - Score");
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
 
        //set Stage boundaries to the lower right corner of the visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 400);
        stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 300);
        stage.setWidth(400);
        stage.setHeight(300);
        
        root.getChildren().add(t);
        root.getChildren().add(redScore);
        root.getChildren().add(blueScore);
        root.getChildren().add(currentClue);
        stage.setScene(new Scene(root, 300, 250));
   
    }

    /**
     * Print a message to the VerboseView.
     * @param arg 
     */
    public void log(String arg) {
        if (subject.getTypeProperty() == CardType.Blue) {
            t.setTextFill(Color.BLUE);
            t.setText("Blue's Turn");
        } else if (subject.getTypeProperty() == CardType.Red) {
             t.setTextFill(Color.RED);
             t.setText("Red's Turn");
        }
        
        currentClue.setText("Clue: " + game.getCurrentClue());
        blueScore.setTextFill(Color.BLUE);
        blueScore.setText("Blue: " + game.getBlueScore()); 
        redScore.setTextFill(Color.RED);
        redScore.setText("Red: " + game.getRedScore());
        
        if(game.getWinner() != null){
            t.setText(game.getWinner() + " Wins!");
        }
        
        //If you call this, it will return either "Current Clue: Clue: num" OR "Game Over".
        // game.getStringProperty() but you can also do it the way you had it.
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
     * Closes the window for house keeping and restarting the game
     */
    public void close(){
        if (stage.isShowing()){
            stage.close();
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

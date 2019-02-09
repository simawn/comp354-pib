package view;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.board.Subject;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;



import javafx.util.Duration;
/**
* VerboseView logs game play information, in an optionally visible window.
* 
* @author Anthony Funiciello
* @date 02/06/19
*/
public class ScoreView implements Observer {
    private VBox vbox;
    private Stage stage;
    private Subject subject;

    /**
     * Create the VerboseView with a Subject s that it will be bound to.
     * @param s 
     */
    public ScoreView(Subject s) {
          this.subject = s;
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

       StackPane root = new StackPane();
        root.getChildren().add(btn);
 Scene scene = new Scene(root, 300, 250);

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.S) {
                open();
            }
        });

        

        stage = new Stage();
        stage.setTitle("Codenames - Score");
        stage.setScene(scene);
        
    }

    /**
     * Print a message to the VerboseView.
     * @param arg 
     */
    public void log(String arg) {
        Text t = new Text(arg);
        if (arg.contains("Blue")) {
            t.setFill(Color.BLUE);
        } else if (arg.contains("Red")) {
            t.setFill(Color.RED);
        }
        vbox.getChildren().add(t);
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

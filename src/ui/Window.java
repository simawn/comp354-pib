package ui;

import control.BoardControl;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.component.GameStage;


public class Window extends Application {

    /*
    Entry Point of the program
    */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage root) {
        
        BoardControl deckcontrol = new BoardControl();
        
        root = new GameStage(deckcontrol); //points the root stage to the GameStage

        root.show(); // Shows the final Stage based on the scene
    }
}

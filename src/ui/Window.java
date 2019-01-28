package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Card;
import model.ModelManager;
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

        ModelManager model = new ModelManager();

        root = new GameStage(model.getBoard()); //points the root stage to the GameStage

        root.show(); // Shows the final Stage based on the scene
    }

}

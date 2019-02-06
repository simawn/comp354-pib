package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Board;

import java.io.IOException;


public class Window extends Application {

    /*
    Entry Point of the program
    */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage root) {

        Board board = null;
        try {
            board = new Board();
        } catch (IOException e) {
            e.printStackTrace();
        }
        root = new GameStage(board);

        root.show(); // Shows the final Stage based on the scene
    }
}

package ui;

import command.CommandManager;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Board;
import ui.component.BoardPane;
import ui.component.BoardScene;
import ui.component.CardPane;

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
        CardPane[] cardpanes;
        try {
            board = new Board();
            CommandManager deckCommandManager = new CommandManager();

            cardpanes = new CardPane[25];

            for (int i = 0; i < 25; i++) {
                cardpanes[i] = new CardPane();
                cardpanes[i].bind(board.at(i));
                board.at(i).push(0, board.at(i).word);
            }


            root.setTitle("Codenames Game");
            root.setResizable(false);
            root.setScene(new BoardScene(new BoardPane(cardpanes)));

        } catch (IOException e) {
            e.printStackTrace();
        }


        root.show(); // Shows the final Stage based on the scene
    }
}

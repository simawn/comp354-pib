/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.game.GameHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.board.Board;
import model.board.Card;
import model.board.CardBuilder;
import model.board.GameManager;
import model.util.Verbose;

/**
 *
 * @author Max Page-Slowik
 */
public class Preview {
    private static Stage stage;

    public static void setUp(Stage root) {
        stage = root;
        VBox vb = new VBox();
        Scene scene = new Scene(vb);
        final ComboBox difficultyComboBox = new ComboBox();
        difficultyComboBox.getItems().addAll(
                "Easy",
                "Medium",
                "Hard"
        );

        Button startB = new Button("Start");
        startB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                start_game(root);
            }
        });
        ((VBox) scene.getRoot()).getChildren().addAll(difficultyComboBox);
        ((VBox) scene.getRoot()).getChildren().addAll(startB);
        root.setScene(scene);
        root.show();
        //return scene;
    }
    public static Stage getStage(){
        return stage;
    }
    /**
     * Game model, and game controls are instantiated.
     * @param root For the instantiated
     */
    public static void start_game(Stage root) {
        
        Card[] cards = CardBuilder.buildAll();

        Board board = new Board(cards);
        GameManager game = new GameManager(board);

        VerboseView view = new VerboseView(Verbose.get());
        view.close();
        Verbose.bind(view);
        ScoreView score = new ScoreView(game);
        score.close();
        game.attach(score);

        GameHandler handler = new GameHandler(game, view, score);
        Scene scene = GameScene.build(cards, handler);
        root.setScene(scene);
        root.setResizable(false);
        root.setTitle("Codenames - Game");
        root.show(); // Shows the final Stage based on the scene
    }
}

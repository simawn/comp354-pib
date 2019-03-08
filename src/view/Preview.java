/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.game.Difficulty;
import control.game.GameHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
        vb.setPadding(new Insets(5,5,5,5));
        vb.setSpacing(5);
        vb.setBackground(new Background(new BackgroundFill(Color.valueOf("877567"), CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(vb);
        final Label difficultyLbl = new Label("Difficulty:");
        difficultyLbl.setTextFill(Paint.valueOf("FFFFFF"));
        final ComboBox difficultyComboBox = new ComboBox();
        difficultyComboBox.getItems().addAll(
                "Easy",
                "Medium",
                "Hard"
        );
        difficultyComboBox.setMinWidth(100);
        difficultyComboBox.setOnAction(Difficulty.setDifficulty());
        VBox innerVbCombo = new VBox(difficultyLbl,difficultyComboBox);
        Button startB = new Button("Start");
        startB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                start_game(root);
            }
        });
        difficultyComboBox.setPadding(new Insets(5,5,5,5));
        startB.setPadding(new Insets(5,5,5,5));
        ((VBox) scene.getRoot()).getChildren().addAll(innerVbCombo);
        ((VBox) scene.getRoot()).getChildren().addAll(startB);
        
        root.setTitle("Codenames - Game");
        root.setScene(scene);
        root.setMinHeight(100);
        root.setMinWidth(300);
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
        Verbose.bind(view);
        ScoreView score = new ScoreView(game);
        game.attach(score);
        GameHandler handler = new GameHandler(game, view, score);
        Scene scene = GameScene.build(cards, handler);
        root.setScene(scene);
        root.setResizable(false);
        root.setTitle("Codenames - Game");
        root.show(); // Shows the final Stage based on the scene
    }
}

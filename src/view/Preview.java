/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.game.Difficulty;
import control.game.GameHandler;
import control.game.GameMode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
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
 * This class sets up a default window template that will be used for our game when it is started or restarted. 
 * @author Max Page-Slowik
 */
public class Preview {
    private static Stage stage;

    /**
     * this method creates a default platform that will be used for our game
     * @param root	a default platform template for our game
     */
    public static void setUp(Stage root) {
        stage = root;
        VBox vb = new VBox();
        vb.setPadding(new Insets(5,5,5,5));
        vb.setSpacing(5);
        vb.setBackground(new Background(new BackgroundFill(Color.valueOf("877567"), CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(vb);
        
        //creates a label for difficulty
        final Label difficultyLbl = new Label("Difficulty:");
        difficultyLbl.setTextFill(Paint.valueOf("FFFFFF"));
        
        //creates a drop down menu where difficulty level will be selected
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
        
        //When start button is pressed, the game begins
        startB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                start_game(root);
            }
        });
        final ToggleGroup modes = new ToggleGroup();
        RadioButton rb1 = new RadioButton();
        rb1.setText("Viewer");
        rb1.setToggleGroup(modes);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton();
        rb2.setText("Operative");
        rb2.setToggleGroup(modes);
        modes.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
            if (modes.getSelectedToggle() != null) {
                System.out.println(new_toggle.getUserData().toString());
                System.out.println(old_toggle.getUserData().toString());
                //System.out.println(modes.getSelectedToggle().getUserData().toString());
            }
        });
        //modes.selectedToggleProperty().addListener(GameMode.changeGameMode().changed(modes.getToggles()., rb1, rb2));
        HBox innerHbRadio = new HBox(rb1,rb2);
        //adjust the settings of our object
        difficultyComboBox.setPadding(new Insets(5,5,5,5));
        startB.setPadding(new Insets(5,5,5,5));
        ((VBox) scene.getRoot()).getChildren().addAll(innerVbCombo);
        ((VBox) scene.getRoot()).getChildren().addAll(innerHbRadio);
        ((VBox) scene.getRoot()).getChildren().addAll(startB);
        
        //set the title of our platform as well as the height and width of screen.
        root.setTitle("Codenames - Game");
        root.setScene(scene);
        root.setMinHeight(100);
        root.setMinWidth(300);
        //set the visibility to true and show the window
        root.show();
     
    }
    /**
     * Return the stage for restarting
     * @return 
     */
    public static Stage getStage(){
        return stage;
    }
    /**
     * Spawn new about window
     * @param root 
     */
    public static void start_about(){
        Stage aboutView = new Stage();

        VBox vb = new VBox();
        vb.setPadding(new Insets(5,5,5,5));
        vb.setSpacing(5);
        vb.setBackground(new Background(new BackgroundFill(Color.valueOf("877567"), CornerRadii.EMPTY, Insets.EMPTY)));
        TextArea ta = new TextArea();
        
        String content = "Controls:"
                + "\nv: Open the verbose view"
                + "\nEnter: Go to next step of the turn (Giving a clue or choosing)"
                + "\nRestart under Action starts a new game of the same difficulty"
                + "\nQuit exits the game"
                + "\nPick difficulty before clicking the start button"
                + "\n\nExplanation:"
                + "\nVerbose view shows every step"
                + "\nScore view shows the current score";
        Scene scene = new Scene(vb);
        ta.setText(content);
        ta.setWrapText(true);
        ta.setEditable(false);
        //ta.setStyle("-fx-text-fill: white ;  -fx-background-color: #877567;") ;
        ((VBox) scene.getRoot()).getChildren().addAll(ta);
        aboutView.setTitle("Codenames - About");
        aboutView.setScene(scene);
        aboutView.setMinHeight(200);
        aboutView.setMinWidth(200);
        //set the visibility to true and show the window
        aboutView.show();
    }
    /**
     * Game model, and game controls are instantiated.
     * 
     * @param root a default platform template for our game
     */
    public static void start_game(Stage root) {
        
        Card[] cards = CardBuilder.buildAll();
        Board board = new Board(cards);
        GameManager game = new GameManager(board);

        //assign a view with a Subject that it will be bound to 
        VerboseView view = new VerboseView(Verbose.get());
        Verbose.bind(view);
        
        //create a view that will show the scores and attach it to our window
        ScoreView score = new ScoreView(game);
        game.attach(score);
        
        GameHandler handler = new GameHandler(game, view, score);
        Scene scene = GameScene.build(cards, handler);
        root.setScene(scene);
        root.setResizable(false);
        root.setTitle("Codenames - Game");
        
     // Shows the final Stage based on the scene
        root.show(); 
    }
}

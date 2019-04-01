package view;

import control.game.Difficulty;
import control.game.GameControls;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.board.CardType;
import model.board.Subject;

/**
 * The GameScene is the GUI window with 25 CardPanes.
 */
public class GameScene {

    /**
     * GameScene.build() creates the GameScene given an array of 25 Subjects (Cards), and the EventHandler for user input.
     * @param subjects
     * @param handler
     * @return the GUI Scene.
     */
    public static Scene build(Subject subjects[],EventHandler<Event> handler) {
        VBox vb = new VBox();
             
        Scene scene = new Scene(vb);
        //MENU AREA

        // --- Menu Action for start and quit
        Menu menuAction = new Menu("Action");
                MenuItem start = new MenuItem("Restart");
                start.setOnAction(GameControls.setEvents());
                MenuItem quit = new MenuItem("Quit");
                quit.setOnAction(GameControls.setEvents());

 
        menuAction.getItems().addAll(start,quit);

        // --- Menu About section
        Menu menuHelp = new Menu("Help");
        MenuItem menuAbout = new MenuItem("About");
        menuAbout.setOnAction(GameControls.setAbout());
        menuHelp.getItems().add(menuAbout);
        
        MenuBar menuBar = new MenuBar(menuAction,menuHelp);        
        TilePane tile = new TilePane();
                tile.setPadding((new Insets(4, 4, 4, 4)));
        tile.setBackground(new Background(new BackgroundFill(Color.valueOf("877567"), CornerRadii.EMPTY, Insets.EMPTY)));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(5);

       for (Subject subject : subjects) {
    	   CardPane newCard = new CardPane(subject);
    	   newCard.setOnMouseClicked(handler);
             tile.getChildren().add(newCard);
        }
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
        ((VBox) scene.getRoot()).getChildren().addAll(tile);

        

        scene.setOnKeyPressed(handler);
        return scene;
    }
}

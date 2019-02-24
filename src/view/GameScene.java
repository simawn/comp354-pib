package view;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.board.CardType;
import model.board.Subject;

/**
* CardPane represents the GUI of 1 card. Each card pane observes 1 card, and is updated
* when that card is "covered" by a colored card (revealing the cards true identity).
* 
* @author Rani Rafid
* @date 02/06/19
*/
class CardPane extends StackPane implements Observer {
    /**
     * A card object to be observed.
     */
    private Subject subject;
    /**
     * The card template image.
    */
    private ImageView image;

    CardPane(Subject subject) {
        this.subject = subject;
        subject.attach(this);
        image = new ImageView("file:resources/CardTemplate.png");
        Text text = new Text(subject.getStringProperty());

        setBackground(null);
        getChildren().addAll(image, text);
        setMargin(text, new Insets(15, 15, 15, 15));
        setAlignment(text, Pos.BOTTOM_CENTER);
    }

    @Override
    /**
     * When the subject of this class calls update, the image changes to reveal the card color.
     */
    public void update() {
        image.setImage(new Image(CardType.pathOf(subject.getTypeProperty())));
    }
}


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
    public static Scene build(Subject[] subjects, EventHandler<KeyEvent> handler) {
        VBox vb = new VBox();
        
        TilePane tile = new TilePane();
        Scene scene = new Scene(vb);

        tile.setPadding((new Insets(4, 4, 4, 4)));
        tile.setBackground(new Background(new BackgroundFill(Color.valueOf("877567"), CornerRadii.EMPTY, Insets.EMPTY)));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(5);

        for (Subject subject : subjects) {
            tile.getChildren().add(new CardPane(subject));
        }


                MenuBar menuBar = new MenuBar();
 
        // --- Menu Action for start and quit
        Menu menuAction = new Menu("Action");
                MenuItem start = new MenuItem("Start");
                MenuItem quit = new MenuItem("Quit");

 
        menuAction.getItems().addAll(start,quit);
 
        // --- Menu Difficulty
        Menu menuDiff = new Menu("Difficulty");
                MenuItem easy = new MenuItem("Easy");
                MenuItem med = new MenuItem("Medium");
                MenuItem hard = new MenuItem("Hard");
         menuDiff.getItems().addAll(easy,med,hard);

        // --- Menu About section
        Menu menuAbout = new Menu("About");
 
        menuBar.getMenus().addAll(menuAction, menuDiff, menuAbout);
 
        ((VBox) scene.getRoot()).getChildren().addAll(menuBar);
        ((VBox) scene.getRoot()).getChildren().addAll(tile);

        scene.setOnKeyPressed(handler);
        return scene;
    }
}

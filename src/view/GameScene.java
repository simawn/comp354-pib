package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.board.CardType;
import model.board.Subject;

class CardPane extends StackPane implements Observer {
    private Subject subject;
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
    public void update() {
        image.setImage(new Image(CardType.pathOf(subject.getTypeProperty())));
    }
}


public class GameScene {

    public static Scene build(Subject[] subjects, EventHandler<KeyEvent> handler) {
        TilePane tile = new TilePane();

        tile.setPadding((new Insets(4, 4, 4, 4)));
        tile.setBackground(new Background(new BackgroundFill(Color.valueOf("877567"), CornerRadii.EMPTY, Insets.EMPTY)));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(5);

        for (Subject subject : subjects) {
            tile.getChildren().add(new CardPane(subject));
        }

        Scene scene = new Scene(tile);
        scene.setOnKeyPressed(handler);
        return scene;
    }
}

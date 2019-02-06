package view;

import control.KeyHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Board;
import model.component.Component;

class CardPane extends StackPane implements Listener {
    private Text text;
    private ImageView image;

    CardPane(Board board) {
        board.addSubscriber(this);
        image = new ImageView("file:resources/CardTemplate.png");
        getChildren().addAll(image, text);
        setMargin(text, new Insets(15, 15, 15, 15));
        setAlignment(text, Pos.BOTTOM_CENTER);
    }

    public void update(int code, String message) {
        if (code == 0) {
            if (text == null) {
                text = new Text(message);
            } else {
                text.setText(message);
            }
        } else if (code == 1) {
            image.setImage(new Image(message));
        }
    }
}


public class GameStage extends Stage {
    public GameStage(Board board) {
        TilePane tile = new TilePane();
        tile.setPadding(new Insets(4, 4, 4, 4));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(5);
        for (int i = 0; i < Component.SIZE; i++) {
            tile.getChildren().add(new CardPane(board));
        }

        Scene scene = new Scene(tile);
        scene.setFill(Paint.valueOf("877567"));
        scene.setOnKeyPressed(new KeyHandler(board)); //todo rever the parameter of KeyHandler to default

        setTitle("Codenames Game");
        setResizable(false);
        setScene(scene);
    }
}
package ui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.component.Subject;

/*
    Binds the concept of the card model to the actual graphical representation
    Listens on the model for future updates being pushed
 */
public class CardPane extends StackPane implements Listener {
    private Text text;
    private ImageView image;

    public CardPane() {
        text = new Text("NULL");
        image = new ImageView("file:resources/CardTemplate.png");
        getChildren().addAll(image, text);
        setMargin(text, new Insets(15, 15, 15, 15));
        setAlignment(text, Pos.BOTTOM_CENTER);
    }

    public void bind(Subject c) {
        c.attach(this);
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

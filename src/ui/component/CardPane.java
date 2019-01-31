package ui.component;

import control.DeckControl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/*
    Binds the concept of the card model to the actual graphical representation
    Listens on the model for future updates being pushed
 */
class CardPane extends StackPane implements Listener {
    private Text text;
    private ImageView image;

    private CardPane(DeckControl deckcontrol) {
        deckcontrol.addSubscriber(this);
        image = new ImageView("file:resources/CardTemplate.png");
        getChildren().addAll(image, text);
        setMargin(text, new Insets(15, 15, 15, 15));
        setAlignment(text, Pos.BOTTOM_CENTER);
    }

    static CardPane build(DeckControl deckcontrol) {
        return new CardPane(deckcontrol);
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

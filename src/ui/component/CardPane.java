package ui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.Card;
import model.constant.Type;
import ui.listener.Listener;

import java.util.Random;

/*
    Binds the concept of the card model to the actual graphical representation
    Listens on the model for future updates being pushed
 */
class CardPane extends StackPane implements Listener {
    private Text text;
    private Random sex = new Random(); // todo erase later on
    private ImageView image;
    private Card card;

    private CardPane(Card c) {
        this.card = c;
        c.bind(this);
        text = new Text(c.getName());
        image = new ImageView("/resources/CardTemplate.png");
        getChildren().addAll(image, text);
        setMargin(text, new Insets(15, 15, 15, 15));
        setAlignment(text, Pos.BOTTOM_CENTER);
    }

    public void update() {
        String temp = card.getName();
        if (!temp.equals(text.toString())) {
            text.setText(temp);
        }

        if (card.isOpened()) {
            temp = "/resources/";
            if (card.getType() == Type.Assassin) {
                temp += card.getType();
            } else {
                if (sex.nextBoolean()) {
                    temp += "Male";
                } else {
                    temp += "Female";
                }
                if (card.getType() == Type.Agent) {
                    temp += card.getTeam();
                } else {
                    temp += card.getType();
                }
            }
            temp += ".png";
            image.setImage(new Image(temp));
        }
    }

    static StackPane build(Card c) {
        return new CardPane(c);
    }
}

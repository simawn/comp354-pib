package ui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.Card;
import model.constant.CardType;
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
        text = new Text(c.getWord());
        image = new ImageView("file:./resources/CardTemplate.png");
        getChildren().addAll(image, text);
        setMargin(text, new Insets(15, 15, 15, 15));
        setAlignment(text, Pos.BOTTOM_CENTER);
    }

    public void update() {
        String temp = card.getWord();
        if (!temp.equals(text.toString())) {
            text.setText(temp);
        }

        if (card.isOpen()) {
            temp = "file:./resources/";
            if (card.getType() == CardType.ASSASSIN) {
                temp += "Assassin";
            } else {
                if (sex.nextBoolean()) {
                    temp += "Male";
                } else {
                    temp += "Female";
                }

                switch (card.getType()) {
                    case BLUE:
                        temp += "Blue";
                        break;
                    case RED:
                        temp += "Red";
                        break;
                    case BYSTANDER:
                        temp += "Bystander";
                        break;
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

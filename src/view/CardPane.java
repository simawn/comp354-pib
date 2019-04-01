package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
public class CardPane extends StackPane implements Observer {
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
        
    /**
     * Returns a reference to the subject (i.e. the card object)
     * @return subject
     */
    public Subject getSubject() {
    	return subject;
    }
}

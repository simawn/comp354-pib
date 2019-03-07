/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import static javafx.scene.layout.StackPane.setAlignment;
import static javafx.scene.layout.StackPane.setMargin;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.board.Card;
import model.board.CardBuilder;
import model.board.CardType;
import model.board.Subject;
import view.Observer;

/**
 *
 * @author Max Page-Slowik
 */
public class GameControls {

    public static EventHandler<ActionEvent> setEvents() {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                MenuItem m = (MenuItem) event.getSource();
                String s = m.getText();
                if (s.equals("Restart")) {
                    //Card[] cards = CardBuilder.buildAll();
                    //startGame(cards);
                }
                if (s.equals("Quit")) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        };
    }
}


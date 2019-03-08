/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Window;
import view.Preview;


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
                    Preview.start_game(Preview.getStage());
                }
                if (s.equals("Quit")) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        };
    }
}


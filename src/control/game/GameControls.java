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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Window;
import view.Preview;


/**
 * This class is responsible for handling the events regarding the Restart option or Quit. If Restart has 
 * been selected then the program will automatically restart the game and set up a new board.
 * 
 * If Quit has been selected then program will terminate
 * @author Max Page-Slowik
 */
public class GameControls {

    public static EventHandler<ActionEvent> setEvents() {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                MenuItem m = (MenuItem) event.getSource();
                String s = m.getText();
                //If Restart has been retrieved then game is restarted and new board is set up
                if (s.equals("Restart")) {
                    Preview.start_game(Preview.getStage());
                }
                
                //If Quit string has been retrieved then the program is terminated
                if (s.equals("Quit")) {
                    Platform.exit();
                    System.exit(0);
                }
                //if it is the about command it will open a new window giving a brief description
                if (s.equals("About")) {
                    Preview.start_about();
                }
            }
        };
    }
    public static EventHandler<ActionEvent> setAbout() {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                MenuItem m = (MenuItem) event.getSource();
                String s = m.getText();
                //If it is the about command it will open a new window giving a brief description
                if (s.equals("About")) {
                    Preview.start_about();
                }
            }
        };
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.game;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;

/**
 * This class is responsible for setting the difficulty of our game
 * @author Max Page-Slowik
 */
public class Difficulty {

    private static int difficulty = 0;

    public  Difficulty() {
    }
    /**
     * Event Handler that is responsible for setting the game difficulty based on input provided.
     * @return
     */
    public static EventHandler<ActionEvent> setDifficulty() {
        return (ActionEvent event) -> {
            ComboBox cb = (ComboBox) event.getSource();
            
            /*retrieve the string that will be used to determine the difficulty of the game
            * If easy then difficulty level is set to 0
            * If medium is retrieved then level is set to 1
            * If Hard then level is set to 2
            */
            String s = (String) cb.getValue();
            if (s.equals("Easy")) {
                difficulty = 0;
            } else if (s.equals("Medium")) {
                difficulty = 1;
            } else if (s.equals("Hard")) {
                difficulty = 2;
            }
        };
    }
   
    /**
     * this method retrieves the difficulty level of out game
     * @return integer representation for difficulty level
     */
    public static int getDifficulty(){
        return difficulty;
    }
    /**
     * returns a string representation of the level of difficulty of our game
     * @return difficulty level string
     */
    public static String getStringDifficulty(){
        if (difficulty == 0){
            return "Easy";
        }
        else if(difficulty == 1){
            return "Medium";
        }
        else if(difficulty == 2){
            return "Hard";
        }
        else{
            return "";
        }
    }
}

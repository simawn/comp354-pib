/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.game;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Toggle;

/**
 *
 * @author Max Page-Slowik
 */
public class GameMode {
    private static int gameMode = 0;

    public GameMode(){}
    public static ChangeListener<Toggle> changeGameMode() {
        return (ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            if(newValue.getUserData().toString().equals("Viewer")){
                gameMode =  0;
                System.out.println(newValue.getUserData().toString());
            }
            else if(newValue.getUserData().toString().equals("Operative")){
                System.out.println(newValue.getUserData().toString());
                gameMode = 1;
            }
        };
    }
    public static int getGameMode(){
        return gameMode;
    }
}

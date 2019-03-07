/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Max Page-Slowik
 */
public class Preview{

    public static void setUp() {
        Stage stage = new Stage();
        VBox vb = new VBox();
        Scene scene = new Scene(vb);
        final ComboBox difficultyComboBox = new ComboBox();
        difficultyComboBox.getItems().addAll(
                "Easy",
                "Medium",
                "Hard"
        );

        Button startB = new Button("Start");
        startB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
            }
        });
        ((VBox) scene.getRoot()).getChildren().addAll(difficultyComboBox);
        ((VBox) scene.getRoot()).getChildren().addAll(startB);
        stage.setScene(scene);
        stage.show();
        //return scene;
    }
}

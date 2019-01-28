package ui;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Card;
import model.ModelManager;
import ui.component.GameStage;


public class Window extends Application {

    /*
    Entry Point of the program
    */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage root) {


//        //todo this should be replaced later on for a model that would create the array
//        Card[] arr = new Card[25];
//        Type t;
//        Team t2;
//        for (int i = 0; i < 25; i++) {
//
//            if (i < 16) {
//                t = Type.Agent;
//                if (i < 7) {
//                    t2 = Team.Blue;
//                } else {
//                    t2 = Team.Red;
//                }
//            } else {
//                if (i < 24) {
//                    t = Type.Bystander;
//                } else {
//                    t = Type.Assassin;
//                }
//                t2 = Team.None;
//            }
//
//            arr[i] = new Card("Card #" + (i + 1), t, t2);
//        }
//        //todo end of erase
        ModelManager model = new ModelManager();


        root = new GameStage(model.getBoard()); //points the root stage to the GameStage


        root.show(); // Shows the final Stage based on the scene
    }

}

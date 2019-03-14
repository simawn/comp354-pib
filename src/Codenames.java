
import javafx.application.Application;
import javafx.stage.Stage;
import view.Preview;


/**
 * This application is a prototype GUI program of the popular board game Codenames. 
 * Codenames is a 2-team game consisting of a 5x5 grid of cards containing nouns (called Codenames).
 * Team's are made up of 1 Spymaster, and operatives. Teams take turns trying to guess all of the 
 * cards on the grid assigned to their team in a KeyCard, given 1 word noun hints by the teams Spymaster,
 * and a corresponding number of cards related to that noun.
 * 
 * 
 * @author Anthony Funiciello, David Gray, Rani Rafid
 * @date 02/07/19
 */
public class Codenames extends Application {

    /*
    Entry Point of the program
    */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start() is where the starting GUI, with difficulty selection 
     * @param root 
     */
    @Override
    public void start(Stage root) {
        Preview.setUp(root);

    }
}

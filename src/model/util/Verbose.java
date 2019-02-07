package model.util;

import model.board.CardType;
import model.board.Subject;
import view.Observer;

/**
* Verbose is the models interface to the view's VerboseView, following the Observer Pattern.
* The model uses Verbose to log things, and optionally by attaching VerboseView to Verbose, 
* the logs are printed to a visible GUI window. Verbose is a Singleton.
* 
* @author Rani Rafid
* @date 02/06/19
*/
public class Verbose extends Subject {
    private static final Verbose instance = new Verbose();
    private String state;

    private Verbose() {
    }

    /**
     * Called by Observers in order to be alerted to changes in Verbose's state.
     * @param o 
     */
    public static void bind(Observer o) {
        instance.attach(o);
    }

    /**
     * Set state to some message, and alert Observers that there is a message.
     * @param arg 
     */
    public static void log(String arg) {
        instance.state = arg;
        instance.push();
    }

    /**
     * Get the one instance of Verbose (Singleton).
     * @return instance
     */
    public static Verbose get() {
        return instance;
    }

    /**
     * Get current message.
     * @return 
     */
    @Override
    public String getStringProperty() {
        return state;
    }

    @Deprecated
    public CardType getTypeProperty() {
        return null;
    }
}

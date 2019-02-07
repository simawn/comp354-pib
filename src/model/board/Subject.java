package model.board;

import view.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Part of the Observer pattern. A subject has a list of observers, and is agnostic to
 * who is observing them.
 * 
 * @author David Gray
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    /**
     *  An object extending Observer can be added to the list by calling attach(this).
     * @param observer 
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * When a subject changes state it should call push() to notify its observers
     * to its state change.
     */
    void push() {
        for (Observer in : observers) {
            in.update();
        }
    }

    /**
     * Observers in our program can get a subjects state in the form of a string.
     * @return 
     */
    public abstract String getStringProperty();

     /**
     * Observers can get a subjects CardType.
     * @return 
     */
    public abstract CardType getTypeProperty();
}

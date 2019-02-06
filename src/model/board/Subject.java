package model.board;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    void push() {
        for (Observer in : observers) {
            in.update();
        }
    }

    public abstract String getStringProperty();

    public abstract CardType getTypeProperty();
}

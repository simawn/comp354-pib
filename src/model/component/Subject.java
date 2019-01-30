package model.component;

import ui.listener.Listener;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Listener> listeners = new ArrayList<>();

    public void bind(Listener listener) {
        listeners.add(listener);
    }

    public void push(int code, String message) {
        for (Listener in : listeners) {
            in.update(code, message);
        }
    }
}

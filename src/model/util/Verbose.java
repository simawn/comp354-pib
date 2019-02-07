package model.util;

import model.board.CardType;
import model.board.Subject;
import view.Observer;

public class Verbose extends Subject {
    private static final Verbose instance = new Verbose();
    private String state;

    private Verbose() {
    }

    public static void bind(Observer o) {
        instance.attach(o);
    }

    public static void log(String arg) {
        instance.state = arg;
        instance.push();
    }

    public static Verbose get() {
        return instance;
    }

    @Override
    public String getStringProperty() {
        return state;
    }

    @Deprecated
    public CardType getTypeProperty() {
        return null;
    }
}

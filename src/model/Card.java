package model;

import ui.listener.Listener;
import model.constant.CardType;
import java.util.ArrayList;
import java.util.List;

public class Card {
    private CardType type;
    private final String word;
    private boolean isOpen;
    private List<Listener> listeners;
    
    public Card(String word, CardType type) {
        this.word = word;
        this.type = type;
        isOpen = false;
        listeners = new ArrayList<>();
    }
        
    public void bind(Listener e) {
        listeners.add(e);
    }
    private void push() {
        for(Listener in : listeners) {
            in.update();
        }
    }
    
    public String getWord() {
        return word;
    }
    
    public CardType getType() {
        return type;
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public void open() {
        isOpen = true;
        push();
    }
}

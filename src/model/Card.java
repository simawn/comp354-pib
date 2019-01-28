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

//public class Card {
//    private Type type;
//    private String name;
//    private Team team;
//    private boolean isOpened;
//    private List<Listener> list;
//
//    public Card() {
//        this("NULL", Type.Agent, Team.Blue);
//    }
//
//    public Card(String s, Type t, Team t2) {
//        name = s;
//        type = t;
//        isOpened = false;
//        team = t2;
//        list = new ArrayList<>();
//    }
//
//    public Type getType() {
//        return type;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void bind(Listener e) {
//        list.add(e);
//    }
//
//    private void push() {
//        for(Listener in : list) {
//            in.update();
//        }
//    }
//
//    public boolean isOpened() {
//        return isOpened;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team t) {
//        this.team = t;
//    }
//
//    public void open() {
//        isOpened = true;
//        push();
//    }
//
//
}

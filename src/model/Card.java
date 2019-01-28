package model;

import model.constant.Team;
import model.constant.Type;
import ui.listener.Listener;

import java.util.ArrayList;
import java.util.List;

/*
    THIS IS A DUMMY
 */


public class Card {
    private Type type;
    private String name;
    private Team team;
    private boolean isOpened;
    private List<Listener> list;

    public Card() {
        this("NULL", Type.Agent, Team.Blue);
    }

    public Card(String s, Type t, Team t2) {
        name = s;
        type = t;
        isOpened = false;
        team = t2;
        list = new ArrayList<>();
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        push();
    }

    public void setType(Type type) {
        this.type = type;
        push();
    }

    public void bind(Listener e) {
        list.add(e);
    }

    private void push() {
        for(Listener in : list) {
            in.update();
        }
    }

    public boolean isOpened() {
        return isOpened;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team t) {
        this.team = t;
    }

    public void open() {
        isOpened = true;
        push();
    }


}

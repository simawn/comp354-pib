package control;

import model.Card;
import strategy.PlayerStrategy;

public class Player {
    private int id;
    private String name;
    private int score;
    private PlayerStrategy strategy;

    public Player(PlayerStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Card[] card) {
        strategy.makeMove(card);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
        //if (player == card.type && card.isOpen())
        //return 1 else return 0
    }
}

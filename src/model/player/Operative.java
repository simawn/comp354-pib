package model.player;

import model.board.Board;
import model.board.Card;
import model.board.CardType;

import java.util.List;
import java.util.Random;


public class Operative implements Strategy {

    private Board board;
    private Random r;

    public Operative(Board board) {
        this.board = board;
        r = new Random();
    }

    @Override
    public Card play(CardType team) {
        List<Card> list = board.getCards();
        int index = r.nextInt(list.size());
        return list.get(index);
    }

}


package model.player;

import model.board.CardType;

public interface Strategy {
    Object play(CardType team);
}

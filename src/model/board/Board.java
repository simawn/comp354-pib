package model.board;

import control.command.CommandManager;
import control.command.guessCardCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Board {
    private List<Card> cards;
    private CommandManager deckCommandManager;

    public Board(Card[] cards) {
        this.cards = new ArrayList<>();
        Collections.addAll(this.cards, cards);
        deckCommandManager = new CommandManager();
    }

    public void pick(Card c) {
        guessCardCommand pickCmd = new guessCardCommand(c, this);
        deckCommandManager.storeAndExecute(pickCmd);
    }

    // to remove a specific card. Returns true if the card is removed.
    public void remove(Card c) {
        cards.remove(c);
        c.push();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getNumCardsOfType(CardType type) {
        int count = 0;
        for (Card obj : cards) {
            if (obj.type == type) {
                count++;
            }
        }
        return count;
    }
}
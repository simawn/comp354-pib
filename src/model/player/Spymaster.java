/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import model.board.CardType;
import model.board.Clue;

import java.util.Random;

/**
    * The random strategy for spymaster that will choose clues by random as they play the game.
 * @author david
 */
public class Spymaster implements Strategy {
    private String[] possibleClueWords = {"PLANT", "ANIMAL", "FURNITURE",
                                        "COUNTRY", "WEAPON", "PROFESSIONAL",
                                        "VEHICLE", "PLANET", "CONCEPT", "WEATHER"};
    private Random r;

    public Spymaster() {
        r = new Random();
    }
    /**
    * Returns a clue at random according to the amount of cards available.
    */
    @Override
    public Clue play(CardType team) {
        int clueNum = r.nextInt(4);
        String clueWord = possibleClueWords[r.nextInt(possibleClueWords.length)];
        return new Clue(clueWord, clueNum);
    }
    
}

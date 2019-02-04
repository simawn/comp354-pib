/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import java.util.ArrayList;
import java.util.Random;
import model.Card;
import model.Clue;

/**
 *
 * @author david
 */
public class randomSpyStrategy implements SpyStrategy{
    String[] possibleClueWords = {"PLANT", "ANIMAL", "FURNITURE",
                                        "COUNTRY", "WEAPON", "PROFESSIONAL",
                                        "VEHICLE", "PLANET", "CONCEPT", "WEATHER"};
    @Override
    public Clue giveClue(ArrayList<Card> cards) {
        Random rand = new Random();
        int clueNum = rand.nextInt(4);
       
        String clueWord = possibleClueWords[rand.nextInt(possibleClueWords.length)];
        return new Clue(clueWord, clueNum);
    }
    
}

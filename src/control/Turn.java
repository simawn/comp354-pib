/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.Card;
import control.Player;


public class Turn {
    private int turnNumber;
    
    private int[] numberOfPlayers;

    public int getTurnNumber() {
        return turnNumber;
    }
    
    public int getNumberOfPlayers(){
        return numberOfPlayers.length;
    }
    //in progress
    public int getWinner(){
        int sum = 0;
        int survivor = 0;
        for(int i= 0;i < getNumberOfPlayers();i++){
            sum++;
            survivor =i;
           // if(getScore(player) == maxScore )
                //return i
        }
        
        return 0;
    }
}

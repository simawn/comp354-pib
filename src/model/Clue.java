/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author david
 */
public class Clue {
    private String clueWord;
    private int clueNum;
    
    public Clue(String clueWord, int clueNum){
        this.clueNum = clueNum;
        this.clueWord = clueWord;
    }
    
    public String getClueWord(){
        return clueWord;
    }

    public int getClueNum(){
        return clueNum;
    }
    
}

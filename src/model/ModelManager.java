/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ModelManager {
   // Data Members
    private ArrayList<String> allWords;
    private Card[] board;
    private KeyCard keycard;
    private String currentClue;
    private int currentClueNum;
    
   // keycard
   // blue spymaster
   // blue operative
   // red spymaster
   // red operative
   
   /*
   * CONSTRUCTOR
   */
   public ModelManager() {
    File folder = new File(".");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }
       board = new Card[25];   
       keycard = new KeyCard(getRandomKeyCardFromFile("src/resources/keyCards.txt"));
       setBoardFromFile("src/resources/words.txt");       
   }
   
   /*
    * METHODS
    */
   public Card[] getBoard() {
       return board;
   }
   
   // Open file at fName, read all lines, and pick a random one.
   private static String getRandomKeyCardFromFile(String fName){
       File file = new File(fName);
       ArrayList<String> keyCardStrings = new ArrayList<String>();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                keyCardStrings.add(input.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("KeyCard file not found, using default keycard");
            return "BBBBBBBBBYYYYYYYARRRRRRRR";
        }
        
        if(keyCardStrings.size() > 0) {
            Random rand = new Random();
            int n = rand.nextInt(keyCardStrings.size());
            return keyCardStrings.get(n);
        } else{
            System.out.println("No keyCardStrings found in file, using default keycard");
            return "BBBBBBBBBYYYYYYYARRRRRRRR";
        }
   }
   
   // Open file fName, save all codenames from the file, and pick 25 of them at random to populate the board.
   private void setBoardFromFile(String fName) {
       File file = new File(fName);
       allWords = new ArrayList<String>();
       Scanner input;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Code names file not found");
            return;
        }
        while (input.hasNextLine()) {
            allWords.add(input.nextLine());
        }
        
        ArrayList<String> copyAllWords = (ArrayList<String>) allWords.clone();
        Collections.shuffle(copyAllWords);
        
        for(int i = 0; i < 25; i++) {
            System.out.println("Creating card: " + copyAllWords.get(i) + " of color " + keycard.colorAt(i));
            board[i] = new Card(copyAllWords.get(i), keycard.colorAt(i));
        }
   }
   
}


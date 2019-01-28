package model;
import model.constant.CardType;

public class KeyCard {
    private CardType[] key;
    private CardType whoGoesFirst;
    
    // CONSTRUCTOR
    public KeyCard(String keyCardInit) {
        System.out.println(keyCardInit);
        String keyCardColors = keyCardInit.substring(1);
        char cardColor = keyCardInit.charAt(0);
        
        this.key = new CardType[25];
                
        if(!isValidKeyCard(keyCardInit)) {
            //If passed an invalid string, just set the keycard to this known valid one.
            System.out.println("Invalid keycard initialization string, using default keycard.");
            cardColor = 'R';
            keyCardColors = "BBBBBBBBBYYYYYYYARRRRRRRR";
        }
        switch(cardColor){
            case 'R': whoGoesFirst = CardType.RED;
            case 'B': whoGoesFirst = CardType.BLUE;
        }
        // iterate through keyCardColors setting the key
        for(int i = 0; i < 25; i++) {
            switch(keyCardColors.charAt(i)) {
                case 'R': this.key[i] = CardType.RED; break;
                case 'B': this.key[i] = CardType.BLUE; break;
                case 'A': this.key[i] = CardType.ASSASSIN; break;
                case 'Y': this.key[i] = CardType.BYSTANDER; break;
            }
        }
        for(int ix = 0; ix < 25; ix++) {
            System.out.println(key[ix]);
        }
    }
    
    public CardType whoGoesFirst() {
        return whoGoesFirst;
    }

    public CardType colorAt(int i) {
        if(i >= 0 && i < 25) {
            return key[i];
        } else {    
            // Not on the board so it is "neutral".
            return CardType.BYSTANDER;
        }
    }
    
    
    private static boolean isValidKeyCard(String keyCardInit) {
        // keyCardInit must be 26 characters
        // First character (must be R or B) is the color of the outside of the keycard (who goes first)
        // There must be 9 of the same character as the first one, and 8 of the other, and one A
        
        char cardColor = keyCardInit.charAt(0);
        char otherColor = 'N';
        if(cardColor == 'B') {
            otherColor = 'R';
        } else if (cardColor == 'R') {
            otherColor = 'B';
        } else {
            return false;
        }
        
        System.out.println("board color: " + cardColor + " keycard: " + keyCardInit.substring(1));
        String keyCardColors = keyCardInit.substring(1);

        // Verify that this string is a valid keycard
        if(keyCardInit.length() == 26) {
            if(charCount(keyCardColors, cardColor) != 9) {
                System.out.println(cardColor + "Wrong number of cardColor " + charCount(keyCardColors, cardColor));
                return false;
            }
            if(charCount(keyCardColors, otherColor) != 8) {
                System.out.println("Wrong number of otherColor " + otherColor + charCount(keyCardColors, otherColor));
                return false;
            }
            if(charCount(keyCardColors, 'Y') != 7 ) {
                System.out.println("Wrong number of N");
                return false;
            }
            if(charCount(keyCardColors, 'A') != 1 ) {
                System.out.println("Wrong number of A");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    
    // Helper to calculate how many times char c occurs in str
    private static int charCount(String str, char c){
        return str.length() - str.replace("" + c, "").length();
    }
}

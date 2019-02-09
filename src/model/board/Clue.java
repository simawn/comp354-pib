package model.board;

/**
 * Represents a Clue given by a spymaster.
 * 
 * @author David Gray
 * @date 02/06/19
 */
public class Clue {
    /**
     * The clue word (a noun)
     */
    private String clueWord;
    /**
     * The number of cards corresponding to the clue word.
     */
    private int clueNum;
    
    public Clue(String clueWord, int clueNum){
        this.clueNum = clueNum == 0 ? Integer.MAX_VALUE : clueNum;
        this.clueWord = clueWord;
    }

    public void setClueNum(int i) {
        this.clueNum = i;
    }
    public String getClueWord(){
        return clueWord;
    }

    public void consumeClueNum() {
        if (clueNum == 0) {
            throw new IllegalStateException();
        }
        clueNum--;
    }

    public void addClueNum() {
        clueNum++;
    }

    public int getClueNum(){
        return clueNum;
    }
    
    public String toString() {
        return clueWord + ": " + clueNum;
    }
    
}

package model.board;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for ClueTest class.
 * 
 * @author David Gray
 * @date 02/07/2019
 */
public class ClueTest {
    
    public ClueTest() {
    }
    
    /**
     * Test of getClueWord method, of class Clue.
     */
    @Test
    public void testGetClueWord() {
        System.out.println("getClueWord");
        Clue instance = new Clue("Clue", 3);
        String expResult = "Clue";
        String result = instance.getClueWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClueNum method, of class Clue.
     */
    @Test
    public void testGetClueNum() {
        System.out.println("getClueWord");
        Clue instance = new Clue("Clue", 3);
        int result = instance.getClueNum();
        assertEquals(3, result);
    }
    
}

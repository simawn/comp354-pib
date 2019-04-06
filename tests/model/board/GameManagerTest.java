package model.board;

import model.player.Operative;
import model.player.Player;
import model.player.randomOperativeStrategy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 * Test of GameManager class in model.board.
 * @author David Gray
 * @date 02/08/2019
 */
public class GameManagerTest {
    Board board;
    Card[] cards;
    GameManager instance;
    
    public GameManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of isTurnOver method, of class GameManager.
     */
    @Test
    public void testIsTurnOver() {
        System.out.println("Testing GameManager.isTurnOver()");

        cards = CardBuilder.buildAll();
        board = new Board(cards);
        instance = new GameManager(board);
        System.out.println("isTurnOver");
        Player red = new Operative(CardType.Red, board, new randomOperativeStrategy());
        Player blue = new Operative(CardType.Blue, board, new randomOperativeStrategy());
        
        assertTrue("Turn should end if red chooses a blue card", instance.isTurnOver(red, new Card("card", CardType.Blue), 0));
        assertFalse("Turn shouldn't end if red chooses a red card", instance.isTurnOver(red, new Card("card", CardType.Red),0));
        assertTrue("Turn should end if red chooses the Assassin", instance.isTurnOver(red, new Card("card", CardType.Assassin),0));
        assertTrue("Turn should end if red chooses a Bystander", instance.isTurnOver(red, new Card("card", CardType.Bystander),0));

        assertTrue("Turn should end if blue chooses a red card", instance.isTurnOver(blue, new Card("card", CardType.Red), 0));
        assertFalse("Turn shouldn't end if blue chooses a blue card", instance.isTurnOver(blue, new Card("card", CardType.Blue),0));
        assertTrue("Turn should end if blue chooses the Assassin", instance.isTurnOver(blue, new Card("card", CardType.Assassin),0));
        assertTrue("Turn should end if blue chooses a Bystander", instance.isTurnOver(blue, new Card("card", CardType.Bystander),0));
    }

    /**
     * Test of gameIsOver method, of class GameManager.
     */
    @Test
    public void testGameIsOver() {
        System.out.println("Testing GameManager.gameIsOver()");
        cards = new Card[10];
        // Make a "board" that only contains blue cards, and the assassin
        cards[0] = new Card("AGENT", CardType.Assassin);
        cards[1] = new Card("AMAZON", CardType.Blue);
        cards[2] = new Card("ANTARCTICA", CardType.Blue);
        cards[3] = new Card("ATLANTIS", CardType.Blue);
        cards[4] = new Card("BATTERY", CardType.Blue);
        cards[5] = new Card("BEAR", CardType.Blue);
        cards[6] = new Card("BEIJING", CardType.Blue);
        cards[7] = new Card("BELL", CardType.Blue);
        cards[8] = new Card("BRIDGE", CardType.Blue);
        cards[9] = new Card("BUCK", CardType.Blue);
        
        board = new Board(cards);
        instance = new GameManager(board); 
        assertTrue("Game is over because all reds cards are chosen", instance.gameIsOver());
        
        cards[1] = new Card("AGENT", CardType.Red);
        board = new Board(cards);
        instance = new GameManager(board);
        assertFalse("Game not over as board as red, blue, and assassin card", instance.gameIsOver());
        
        cards[0] = new Card("BUG", CardType.Red);
        board = new Board(cards);
        instance = new GameManager(board);
        assertTrue("Game is over because someone chose the assassin", instance.gameIsOver());

    }

    /**
     * Test of declareWinner method, of class GameManager.
     */
    @Test
    public void testDeclareWinner() {
        cards = CardBuilder.buildAll();
        board = new Board(cards);
        instance = new GameManager(board);
        Player red = new Operative(CardType.Red, board, new randomOperativeStrategy());
        Player blue = new Operative(CardType.Blue, board, new randomOperativeStrategy());
        
        Card redCard = new Card("Red", CardType.Red);
        Card blueCard = new Card("Blue", CardType.Blue);
        Card assassinCard = new Card("Assassin", CardType.Assassin);
        
        System.out.println("Testing declareWinner chooses correct winners");
        assertEquals("Red wins after choosing red", instance.declareWinner(red, redCard), CardType.Red);
        assertEquals("Blue wins after choosing blue", instance.declareWinner(blue, blueCard), CardType.Blue);
        assertEquals("Red wins after blue chooses red", instance.declareWinner(red, blueCard), CardType.Blue);
        assertEquals("Blue wins after red chooses blue", instance.declareWinner(blue, redCard), CardType.Red);
        assertEquals("Blue wins after red chooses assassin", instance.declareWinner(red, assassinCard), CardType.Blue);
        assertEquals("Red wins after blue chooses assassin", instance.declareWinner(blue, assassinCard), CardType.Red);
    }

    /**
     * Test of doNextTurn method, of class GameManager.
     */
    @Test
    public void testDoNextTurn() {
        cards = CardBuilder.buildAll();
        board = new Board(cards);
        instance = new GameManager(board);
        instance.doNextTurn();
        int EXPECTED_SIZE = 24;
        int size = board.getCards().size();
        assertEquals(EXPECTED_SIZE,size);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of humanClick method, of class GameManager.
     */
    @Test
    public void testHumanClick() {
        System.out.println("humanClick");
        Card c = null;
        GameManager instance = null;
        instance.humanClick(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endHumanTurn method, of class GameManager.
     */
    @Test
    public void testEndHumanTurn() {
        System.out.println("endHumanTurn");
        GameManager instance = null;
        boolean expResult = false;
        boolean result = instance.endHumanTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlueScore method, of class GameManager.
     */
    @Test
    public void testGetBlueScore() {
        System.out.println("getBlueScore");
        GameManager instance = null;
        int expResult = 0;
        int result = instance.getBlueScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRedScore method, of class GameManager.
     */
    @Test
    public void testGetRedScore() {
        System.out.println("getRedScore");
        GameManager instance = null;
        int expResult = 0;
        int result = instance.getRedScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWinner method, of class GameManager.
     */
    @Test
    public void testGetWinner() {
        System.out.println("getWinner");
        GameManager instance = null;
        CardType expResult = null;
        CardType result = instance.getWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentClue method, of class GameManager.
     */
    @Test
    public void testGetCurrentClue() {
        System.out.println("getCurrentClue");
        GameManager instance = null;
        Clue expResult = null;
        Clue result = instance.getCurrentClue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringProperty method, of class GameManager.
     */
    @Test
    public void testGetStringProperty() {
        System.out.println("getStringProperty");
        GameManager instance = null;
        String expResult = "";
        String result = instance.getStringProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeProperty method, of class GameManager.
     */
    @Test
    public void testGetTypeProperty() {
        System.out.println("getTypeProperty");
        GameManager instance = null;
        CardType expResult = null;
        CardType result = instance.getTypeProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerTurn method, of class GameManager.
     */
    @Test
    public void testGetPlayerTurn() {
        System.out.println("getPlayerTurn");
        GameManager instance = null;
        String expResult = "";
        String result = instance.getPlayerTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

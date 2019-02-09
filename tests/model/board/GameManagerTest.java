package model.board;

import model.player.Operative;
import model.player.Player;
import model.player.randomOperativeStrategy;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        cards[0] = new Card("Assassin", CardType.Assassin);
        for(int i = 1; i < cards.length; i++) {
            cards[i] = new Card("card" + i, CardType.Blue);
        }
        board = new Board(cards);
        instance = new GameManager(board); 
        assertTrue("Game is over because all reds cards are chosen", instance.gameIsOver());
        
        cards[1] = new Card("Red", CardType.Red);
        board = new Board(cards);
        instance = new GameManager(board);
        assertFalse("Game not over as board as red, blue, and assassin card", instance.gameIsOver());
        
        cards[0] = new Card("Red", CardType.Red);
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
    
}

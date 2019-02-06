/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class PlayerTest {    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of draw method, of class Board.
     */
    @Test
    public void testGetTeam() {
        System.out.println("get team");
        CardType team;
        Player instance = new Player();
        try {
            instance.getTeam()
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to return player team.");
        }
        
        asserEquals(team, CardType.Red || CardType.Blue)
    }


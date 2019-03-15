/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Max Page-Slowik
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.board.CardBuilderTest.class, model.board.BoardTest.class, model.board.ExtractorTest.class, model.board.ClueTest.class, model.board.KeyCardTest.class, model.board.CardTest.class, model.board.GameManagerTest.class, model.board.WordTest.class})
public class BoardTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

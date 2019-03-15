/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

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
@Suite.SuiteClasses({model.player.randomOperativeStrategyTest.class, model.player.OperativeTest.class, model.player.SimpleSpyStrategyTest.class, model.player.SmartSpyStartegyTest.class, model.player.BotOperativeStrategyTest.class, model.player.SpymasterTest.class, model.player.randomSpyStrategyTest.class})
public class PlayerTestSuite {

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.board;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Max Page-Slowik
 */
public class ExtractorTest {
    
    public ExtractorTest() {
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
     * Test of build method, of class Extractor.
     */
    @Test
    public void testBuild() throws Exception {
        System.out.println("build");
        Path Path = null;
        Extractor instance = new ExtractorImpl();
        List<String> expResult = null;
        List<String> result = instance.build(Path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parse method, of class Extractor.
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        Extractor instance = new ExtractorImpl();
        Object[] expResult = null;
        Object[] result = instance.parse();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ExtractorImpl extends Extractor {

        public Object[] parse() throws IOException, ParseException {
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Season;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom
 */
public class ServSeasonTest {
    
    public ServSeasonTest() {
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
     * Test of selectAllSeasons method, of class ServSeason.
     */
//    @Test
//    public void testSelectAllSeasons() throws Exception {
//        System.out.println("selectAllSeasons");
//        List expResult = null;
//        List result = ServSeason.selectAllSeasons();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertSeason method, of class ServSeason.
     */
//    @Test
//    public void testInsertSeason() throws Exception {
//        System.out.println("insertSeason");
//        String name = "";
//        String description = "";
//        ServSeason.insertSeason(name, description);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteSeason method, of class ServSeason.
     */
//    @Test
//    public void testDeleteSeason() throws Exception {
//        System.out.println("deleteSeason");
//        int id = 0;
//        ServSeason.deleteSeason(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of updateWorld method, of class ServSeason.
     */
    @Test
    public void testUpdateWorld() throws Exception {
        System.out.println("updateWorld");
        String seasonName = "geupdated";
        String seasonDescription = "geupdated";
        int seasonid = 5;
        ServSeason.updateWorld(seasonName, seasonDescription, seasonid);

    }

    /**
     * Test of selectOneById method, of class ServSeason.
     */
//    @Test
//    public void testSelectOneById() {
//        System.out.println("selectOneById");
//        int id = 0;
//        Season expResult = null;
//        Season result = ServSeason.selectOneById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

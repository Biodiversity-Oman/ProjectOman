/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

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
 * @author Eric
 */
public class DaSeasonTest {
    
    public DaSeasonTest() {
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
     * Test of selectAll method, of class DaSeason.
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println("selectAllSeason");
        List<Season> expResult = null;
        List<Season> result = DaSeason.selectAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectOneByIdSeason method, of class DaSeason.
     */
    @Test
    public void testSelectOneByIdSeason() {
        System.out.println("selectOneByIdSeason");
        int seasonId = 0;
        Season expResult = null;
        Season result = DaSeason.selectOneByIdSeason(seasonId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllByOrganismSeason method, of class DaSeason.
     */
    @Test
    public void testSelectAllByOrganismSeason() throws Exception {
        System.out.println("selectAllByOrganismSeason");
        int organismId = 0;
        List<Season> expResult = null;
        List<Season> result = DaSeason.selectAllByOrganismSeason(organismId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSeason method, of class DaSeason.
     */
    @Test
    public void testUpdateSeason() throws Exception {
        System.out.println("updateSeason");
        Season seas = null;
        int seasonId = 0;
        DaSeason.updateSeason(seas, seasonId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSeason method, of class DaSeason.
     */
    @Test
    public void testDeleteSeason() throws Exception {
        System.out.println("deleteSeason");
        int id = 1;
        DaSeason.deleteSeason(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertSeason method, of class DaSeason.
     */
    @Test
    public void testInsertSeason() throws Exception {
        System.out.println("insertSeason");
        Season s = new Season();
        s.setSeasonName("test");
        s.setSeasonDescription("test");
        DaSeason.insertSeason(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
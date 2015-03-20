/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Organism;
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
public class DaOrganismTest {
    
    public DaOrganismTest() {
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
     * Test of checkOrganismExist method, of class DaOrganism.
     */
//    @Test
//    public void testCheckOrganismExist_String_Integer() throws Exception {
//        System.out.println("checkOrganismExist");
//        String scientificname = "";
//        Integer id = null;
//        boolean expResult = false;
//        boolean result = DaOrganism.checkOrganismExist(scientificname, id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkOrganismExist method, of class DaOrganism.
//     */
//    @Test
//    public void testCheckOrganismExist_String() throws Exception {
//        System.out.println("checkOrganismExist");
//        String scientificname = "";
//        boolean expResult = false;
//        boolean result = DaOrganism.checkOrganismExist(scientificname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAll method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAll() throws Exception {
//        System.out.println("selectAll");
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectPhotoById method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectPhotoById() throws Exception {
//        System.out.println("selectPhotoById");
//        int id = 0;
//        byte[] expResult = null;
//        byte[] result = DaOrganism.selectPhotoById(id);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectOneById method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectOneById() throws Exception {
//        System.out.println("selectOneById");
//        int id = 0;
//        Organism expResult = null;
//        Organism result = DaOrganism.selectOneById(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllByNameLike method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllByNameLike() throws Exception {
//        System.out.println("selectAllByNameLike");
//        String name = "";
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllByNameLike(name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllBySubfamily method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllBySubfamily() {
//        System.out.println("selectAllBySubfamily");
//        int id = 0;
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllBySubfamily(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllByFamily method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllByFamily() {
//        System.out.println("selectAllByFamily");
//        int id = 0;
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllByFamily(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of selectAllByWorld method, of class DaOrganism.
     */
    @Test
    public void testSelectAllByWorld() throws Exception {
        System.out.println("selectAllByWorld");
        List<Organism> expResult = null;
        List<Organism> result = DaOrganism.selectAllByWorld();
        System.out.println(result);

    }

//    /**
//     * Test of selectAllByHabitat method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllByHabitat() {
//        System.out.println("selectAllByHabitat");
//        int id = 0;
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllByHabitat(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllBySeason method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllBySeason() {
//        System.out.println("selectAllBySeason");
//        int id = 0;
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllBySeason(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insert method, of class DaOrganism.
//     */
//    @Test
//    public void testInsert() throws Exception {
//        System.out.println("insert");
//        Organism organism = null;
//        DaOrganism.insert(organism);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteOrganism method, of class DaOrganism.
//     */
//    @Test
//    public void testDeleteOrganism() throws Exception {
//        System.out.println("deleteOrganism");
//        int id = 0;
//        DaOrganism.deleteOrganism(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class DaOrganism.
//     */
//    @Test
//    public void testUpdate() throws Exception {
//        System.out.println("update");
//        Organism organism = null;
//        DaOrganism.update(organism);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePending method, of class DaOrganism.
//     */
//    @Test
//    public void testUpdatePending() throws Exception {
//        System.out.println("updatePending");
//        Organism organism = null;
//        DaOrganism.updatePending(organism);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllForValidation method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllForValidation() throws Exception {
//        System.out.println("selectAllForValidation");
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllForValidation();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllPublished method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllPublished() throws Exception {
//        System.out.println("selectAllPublished");
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllPublished();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of publishFromQueue method, of class DaOrganism.
//     */
//    @Test
//    public void testPublishFromQueue() throws Exception {
//        System.out.println("publishFromQueue");
//        int organismId = 0;
//        DaOrganism.publishFromQueue(organismId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchOrganismTable method, of class DaOrganism.
//     */
//    @Test
//    public void testSearchOrganismTable() throws Exception {
//        System.out.println("searchOrganismTable");
//        String keyword = "";
//        List expResult = null;
//        List result = DaOrganism.searchOrganismTable(keyword);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchOrganismPendingTable method, of class DaOrganism.
//     */
//    @Test
//    public void testSearchOrganismPendingTable() throws Exception {
//        System.out.println("searchOrganismPendingTable");
//        String keyword = "";
//        List expResult = null;
//        List result = DaOrganism.searchOrganismPendingTable(keyword);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectEaten method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectEaten() throws Exception {
//        System.out.println("selectEaten");
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectEaten();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

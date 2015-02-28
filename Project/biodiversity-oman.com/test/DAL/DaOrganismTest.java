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
 * @author Eric
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
//    public void testCheckOrganismExist_String_Integer() {
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
//    public void testCheckOrganismExist_String() {
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
//     * Test of sellectAll method, of class DaOrganism.
//     */
//    @Test
//    public void testSellectAll() {
//        System.out.println("sellectAll");
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.sellectAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectOneById method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectOneById() {
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
//    public void testSelectAllByNameLike() {
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
//
//    /**
//     * Test of selectAllByWorld method, of class DaOrganism.
//     */
//    @Test
//    public void testSelectAllByWorld() {
//        System.out.println("selectAllByWorld");
//        int id = 0;
//        List<Organism> expResult = null;
//        List<Organism> result = DaOrganism.selectAllByWorld(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
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
//     * Test of insertOrganism method, of class DaOrganism.
//     */
    @Test
    public void testInsertOrganism() {
        try{
        System.out.println("insertOrganism");
        Organism organism = new Organism();
        organism.setBenefits("test");
        organism.setCommonName("test");
        organism.setCultivated(Boolean.TRUE);
        organism.setDangerous("test");
        organism.setDescription("test");
        organism.setEatenByOrganism(null);
        organism.setEatingOrganisms(null);
        organism.setEndangered(Boolean.TRUE);
        organism.setFamily(null);
        organism.setFoodDescription("test");
        organism.setFoodName("test");
        organism.setGeolocations(null);
        organism.setHabitat(null);
        organism.setIndigenous(Boolean.TRUE);
        organism.setInsertedOn(null);
        organism.setLinks(null);
        organism.setLinks("test");
        organism.setLocalName("test");
        organism.setMedicinal(Boolean.TRUE);
        organism.setOpportunities("test");
        organism.setPhoto(null);
        organism.setPopulation("test");
        organism.setScientificName("test");
        organism.setSeason(null);
        organism.setSubfamily(null);
        organism.setThreats("test");
        organism.setUpdatedOn(null);
        organism.setValidated(Boolean.TRUE);
        organism.setWorld(null);
            System.out.println("gelukt");
        }
        catch(Exception e){System.out.println("niet gelukt"+e);}
        
        
        
        
    }
//
//    /**
//     * Test of deleteOrganism method, of class DaOrganism.
//     */
//    @Test
//    public void testDeleteOrganism() {
//        System.out.println("deleteOrganism");
//        int id = 0;
//        int expResult = 0;
//        int result = DaOrganism.deleteOrganism(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateOrganism method, of class DaOrganism.
//     */
//    @Test
//    public void testUpdateOrganism() {
//        System.out.println("updateOrganism");
//        Organism organism = null;
//        int expResult = 0;
//        int result = DaOrganism.updateOrganism(organism);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of selectAllForValidation method, of class DaOrganism.
     */
    @Test
    public void testSelectAllForValidation() throws Exception {
        System.out.println("selectAllForValidation");
        List<Organism> result = DaOrganism.selectAllForValidation();
            for (Organism o : result) {
            
            System.out.println(o.getUpdatedOn());
            System.out.println(o.getCommonName());
            System.out.println(o.getScientificName());
        }
    }
    

    /**
     * Test of selectAllPublished method, of class DaOrganism.
     */
    @Test
    public void testSelectAllPublished() throws Exception {
        System.out.println("selectAllPublished");
        List<Organism> result = DaOrganism.selectAllPublished();
        for (Organism o : result) {
            System.out.println(o.getUpdatedOn());
            System.out.println(o.getCommonName());
            System.out.println(o.getScientificName());
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Habitat;
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
public class DaHabitatTest {
    
    public DaHabitatTest() {
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
     * Test of selectAll method, of class DaHabitat.
     */
//    @Test
//    public void testSelectAll() throws Exception {
//        System.out.println("selectAll");
//        List<Habitat> result = DaHabitat.selectAll();
//        System.out.println(result);
//    }

    /**
     * Test of selectOneByIDHabitat method, of class DaHabitat.
     */
//    @Test
//    public void testSelectOneByIDHabitat() throws Exception {
//        System.out.println("selectOneByIDHabitat");
//        int id = 1;
//        Habitat result = DaHabitat.selectOneByIDHabitat(id);
//        System.out.println(result);
//    }


    /**
     * Test of insertHabitat method, of class DaHabitat.
     */
//    @Test
//    public void testInsertHabitat() throws Exception {
//        System.out.println("insertHabitat");
//        Habitat h = new Habitat();
//        h.setHabitatDescription("insert test");
//        h.setHabitatName("insert test");
//        try{
//            DaHabitat.insertHabitat(h);
//            System.out.println("insert gelukt");
//            
//        }
//        catch(Exception e){ 
//            System.out.println("insert niet gelukt" + e);
//        
//        }
//    }
//    
    /**
     * Test of updateHabitat method, of class DaHabitat.
     */
    @Test
    public void testUpdateHabitat() throws Exception {
        System.out.println("updateHabitat");
        Habitat h = new Habitat();
        h.setHabitatName("update test2");
        h.setHabitatDescription("update test");
        // Make sure that the id given to update is equal to the new id in the previous test
        h.setHabitatId(19);
        
        try{
            DaHabitat.update(h);
            System.out.println("update gelukt");
            
        }
        catch(Exception e){ 
            System.out.println("update niet gelukt" + e);
        
        }
    }
    
        /**
     * Test of deleteHabitat method, of class DaHabitat.
     */
//    @Test
//    public void testDeleteHabitat() throws Exception {
//        System.out.println("deleteHabitat");
//        // Make sure that the id given to update is equal to the new id in the previous test
//        int id = 17;
//        try{
//            DaHabitat.deleteHabitat(id);
//            System.out.println("delete gelukt");
//            
//        }
//        catch(Exception e){ 
//            System.out.println("delete niet gelukt" + e);
//        
//        }

//    }
    
}

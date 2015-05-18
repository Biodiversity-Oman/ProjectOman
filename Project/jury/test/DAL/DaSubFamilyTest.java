/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Subfamily;
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
public class DaSubFamilyTest {
    
    public DaSubFamilyTest() {
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
     * Test of selectAllSubfamily method, of class DaSubFamily.
     */
    @Test
    public void testSelectAllSubfamily() throws Exception {
        System.out.println("selectAllSubfamily");
       
        List<Subfamily> result = DaSubfamily.selectAll();
        System.out.println(result);
    }

//    /**
//     * Test of selectOneByIDSubfamily method, of class DaSubFamily.
//     */
    @Test
    public void testSelectOneByIDSubfamily() throws Exception {
        System.out.println("selectOneByIDSubfamily");
        int id = 1;
        Subfamily result = DaSubfamily.selectOneByID(id);
        System.out.println(result);
    }
//
//    /**
//     * Test of selectAllByFamilySubfamily method, of class DaSubFamily.
//     */
    @Test
    public void testSelectAllByFamilySubfamily() throws Exception {
        System.out.println("selectAllByFamilySubfamily");
        int id = 4;
        List<Subfamily> result = DaSubfamily.selectAllByFamily(id);
        System.out.println(result);
        
    }
//
//    /**
//     * Test of insertSubfamily method, of class DaSubFamily.
//     */
    @Test
    public void testInsertSubfamily() throws Exception {
        System.out.println("insertSubfamily");
        Subfamily subfamily = new Subfamily();
        subfamily.setFamilyId(1);
        subfamily.setSubFamilyDescription("insert");
        subfamily.setSubfamilyName("insert");
        try{
        DaSubfamily.insert(subfamily);
            System.out.println("gelukt");
    }catch(Exception e){System.out.println("niet gelukt"+e);}
    }
//
//
//    /**
//     * Test of updateSubfamily method, of class DaSubFamily.
//     */
    @Test
    public void testUpdateSubfamily() throws Exception {
        System.out.println("updateSubfamily");
        Subfamily subfamily = new Subfamily();
        subfamily.setFamilyId(1);
        subfamily.setSubFamilyDescription("insert");
        subfamily.setSubfamilyName("insert");
        try{
        DaSubfamily.insert(subfamily);
            System.out.println("gelukt");
    }catch(Exception e){System.out.println("niet gelukt"+e);}
    }
    //    /**
//     * Test of deleteSubfamily method, of class DaSubFamily.
//     */
    @Test
    public void testDeleteSubfamily() throws Exception {
        System.out.println("deleteSubfamily");
        int id = 6;
        DaSubfamily.delete(id);
        
    }
    
}

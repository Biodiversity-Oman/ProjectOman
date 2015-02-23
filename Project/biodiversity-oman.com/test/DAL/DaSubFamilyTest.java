/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Subfamilyold;
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
        List<Subfamilyold> expResult = null;
        List<Subfamilyold> result = DaSubFamilyold.selectAllSubfamily();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectOneByIDSubfamily method, of class DaSubFamily.
     */
    @Test
    public void testSelectOneByIDSubfamily() throws Exception {
        System.out.println("selectOneByIDSubfamily");
        int id = 0;
        Subfamilyold expResult = null;
        Subfamilyold result = DaSubFamilyold.selectOneByIDSubfamily(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllByFamilySubfamily method, of class DaSubFamily.
     */
    @Test
    public void testSelectAllByFamilySubfamily() throws Exception {
        System.out.println("selectAllByFamilySubfamily");
        int id = 0;
        List<Subfamilyold> expResult = null;
        List<Subfamilyold> result = DaSubFamilyold.selectAllByFamilySubfamily(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertSubfamily method, of class DaSubFamily.
     */
    @Test
    public void testInsertSubfamily() throws Exception {
        System.out.println("insertSubfamily");
        Subfamilyold subfamily = null;
        DaSubFamilyold.insertSubfamily(subfamily);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSubfamily method, of class DaSubFamily.
     */
    @Test
    public void testDeleteSubfamily() throws Exception {
        System.out.println("deleteSubfamily");
        int id = 2;
        DaSubFamilyold.deleteSubfamily(id);
    }

    /**
     * Test of updateSubfamily method, of class DaSubFamily.
     */
    @Test
    public void testUpdateSubfamily() throws Exception {
        System.out.println("updateSubfamily");
        Subfamilyold subfamily = null;
        DaSubFamilyold.updateSubfamily(subfamily);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Family;
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
public class DaFamilyTest {
    
    public DaFamilyTest() {
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
     * Test of selectAllfamily method, of class DaFamily.
     */
    @Test
    public void testSelectAllfamily() throws Exception {
        System.out.println("selectAllfamily");
        List<Family> result = DaFamily.selectAllfamily();
        System.out.println(result.toString());
    }

//    /**
//     * Test of selectOneByIDfamily method, of class DaFamily.
//     */
    @Test
    public void testSelectOneByIDfamily() throws Exception {
        System.out.println("selectOneByIDfamily");
        int id = 3;
        Family result = DaFamily.selectOneByIDfamily(id);
        System.out.println(result);
    }
//
//    /**
//     * Test of selectAllFamilyByWorld method, of class DaFamily.
//     */
    @Test
    public void testSelectAllFamilyByWorld() throws Exception {
        System.out.println("selectAllFamilyByWorld");
        int id = 2;
        Family result = DaFamily.selectAllFamilyByWorld(id);
        System.out.println(result);
    }
//

//
//    /**
//     * Test of insertFamily method, of class DaFamily.
//     */
    @Test
    public void testInsertFamily() throws Exception {
        System.out.println("insertFamily");
        Family fami = new Family();
        fami.setFamilyDescription("testing");
        fami.setFamilyName("testing");
        fami.setWorldId(2);
        try{
        DaFamily.insertFamily(fami);
            System.out.println("gelukt");
        }catch(Exception e){System.out.println("niet gelukt"+e);}
    }
    
    //
//    /**
//     * Test of updateFamily method, of class DaFamily.
//     */
    @Test
    public void testUpdateFamily() throws Exception {
        System.out.println("updateFamily");
        Family fam = new Family();
        fam.setFamilyDescription("testupdate");
        fam.setFamilyName("testing");
        fam.setWorldId(2);
        int familyId = 7;
        try{
	DaFamily.updateFamily(fam);
    
            System.out.println("gelukt");
    }catch(Exception e)
    {
        System.out.println("niet gelukt" + e);}
    }
//    /**
//     * Test of deleteFamily method, of class DaFamily.
//     */
    @Test
    public void testDeleteFamily() throws Exception {
        System.out.println("deleteFamily");
        int familyId = 8;
        DaFamily.deleteFamily(familyId);
    }
    
}

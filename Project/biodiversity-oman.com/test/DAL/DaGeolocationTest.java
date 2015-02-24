/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Geolocation;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oualid
 */
public class DaGeolocationTest {
    
    public DaGeolocationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of selectAllGeolocation method, of class DaGeolocation.
     */
    @Test
    public void testSelectAllGeolocation() throws Exception {
        System.out.println("selectAllGeolocation");
        List<Geolocation> results = DaGeolocation.selectAllGeolocation();
        
        for (Geolocation result : results) {
            System.out.println(result.getAreaName());
        }
    }

    /**
     * Test of selectOneByIDGeolocation method, of class DaGeolocation.
     */
    @Test
    public void testSelectOneByIDGeolocation() throws Exception {
        System.out.println("selectOneByIDGeolocation");
        int id = DaGeolocation.selectAllGeolocation().get(0).getGeolocationId();
        Geolocation result = DaGeolocation.selectOneByIDGeolocation(id);
        
        System.out.println(result.getAreaName());
    }

    /**
     * Test of selectAllByOrganismGeolocation method, of class DaGeolocation.
     */
    @Test
    public void testSelectAllByOrganismGeolocation() throws Exception {
        System.out.println("selectAllByOrganismGeolocation");
        int organismId = DaOrganism.sellectAll().get(0).getOrganismId();
        List<Geolocation> results = DaGeolocation.selectAllByOrganismGeolocation(organismId);
        for (Geolocation result : results) {
            System.out.println("byOrganism: " + result.getAreaName());
        }
    }

    /**
     * Test of insertGeolocation method, of class DaGeolocation.
     */
    @Test
    public void testInsertGeolocation() throws Exception {
        System.out.println("insertGeolocation");
        Geolocation geolocation = new Geolocation();
        geolocation.setAreaName("test");
        geolocation.setAreaDescription("insert test");
        geolocation.setCoordinates("00,00");
        DaGeolocation.insertGeolocation(geolocation);
    }

    /**
     * Test of deleteGeolocation method, of class DaGeolocation.
     */
//    @Test
//    public void testDeleteGeolocation() throws Exception {
//        System.out.println("deleteGeolocation");
//        int id = DaGeolocation.selectAllGeolocation().get(0).getGeolocationId();
//        DaGeolocation.deleteGeolocation(id);
//    }

    /**
     * Test of updateGeolocation method, of class DaGeolocation.
     */
    @Test
    public void testUpdateGeolocation() throws Exception {
        System.out.println("updateGeolocation");
        Geolocation geolocation = DaGeolocation.selectAllGeolocation().get(0);
        geolocation.setAreaName("update");
        geolocation.setAreaDescription("success");
        geolocation.setCoordinates("100,100");
        DaGeolocation.updateGeolocation(geolocation);
    }
    
}

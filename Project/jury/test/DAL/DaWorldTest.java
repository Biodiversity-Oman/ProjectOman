/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.*;
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
public class DaWorldTest {
    
    public DaWorldTest() {
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
     * Test of selectAllWold method, of class DaWorld.
     */
//    @Test
//    public void testSelectAll() {
//       System.out.println("selectAll");
//        List<World> worlds = DaWorld.selectAll();
//        System.out.println(worlds);
//        
//    }
//
//    /**
//     * Test of selectOneByIdWorld method, of class DaWorld.
//     */
//    @Test
//    public void testSelectOneByIdWorld() {
//        System.out.println("selectOneByIdWorld");
//        int worldId = 3;
//        World expResult = null;
//        World result = DaWorld.selectOneByIdWorld(worldId);
//        assertEquals("micro", result.getWorldName());
//
//    }
//
    /**
     * Test of insertWorld method, of class DaWorld.
     */
    @Test
    public void testInsertWorld() throws Exception {
        System.out.println("insertWorld");
        World w = new World();
        w.setWorldName("zerereerr");
        w.setDescription("zzzzz");
        DaWorld.insert(w);

    }
//
//    /**
//     * Test of deleteWorld method, of class DaWorld.
//     */
//    @Test
//    public void testDeleteWorld() throws Exception {
//        System.out.println("deleteWorld");
//        int worldId = 4;
//        DaWorld.deleteWorld(worldId);
//
//    }
//
//    /**
//     * Test of updateWorld method, of class DaWorld.
//     */
//    @Test
//    public void testUpdateWorld() throws Exception {
//        System.out.println("updateWorld");
//        World world = DAL.DaWorld.selectOneByIdWorld(3);
//       
//        world.setDescription("dit een UPDATE APDATE");
//        int worldId = 3;
//        DaWorld.updateWorld(world);
//
//    }

//	/**
//	 * Test of checkWorldExist method, of class DaWorld.
//	 */
//	@Test
//	public void testCheckWorldExist() throws Exception {
//		System.out.println("checkWorldExist");
//		String worldName = "test";
//		boolean result = DaWorld.checkWorldExist(worldName);
//		System.out.println(result);
//	}

}

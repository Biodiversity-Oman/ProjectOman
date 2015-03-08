/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Post;
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
public class DaPostTest {
    
    public DaPostTest() {
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
     * Test of selectAllPost method, of class DaPost.
     */
//    @Test
//    public void testSelectAllPost() throws Exception {
//        System.out.println("selectAllPost");
//        List<Post> expResult = null;
//        List<Post> result = DaPost.selectAllPost();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectOneByIdPost method, of class DaPost.
//     */
//    @Test
//    public void testSelectOneByIdPost() throws Exception {
//        System.out.println("selectOneByIdPost");
//        int id = 0;
//        Post expResult = null;
//        Post result = DaPost.selectOneByIdPost(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllPostByOrganisme method, of class DaPost.
//     */
//    @Test
//    public void testSelectAllPostByOrganisme() throws Exception {
//        System.out.println("selectAllPostByOrganisme");
//        int organismId = 0;
//        List<Post> expResult = null;
//        List<Post> result = DaPost.selectAllPostByOrganisme(organismId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of insertPost method, of class DaPost.
     */
    @Test
    public void testInsertPost() throws Exception {
        System.out.println("insertPost");
        Post p = new Post();
        p.setOrganismId(1);
        p.setPostFirstName("voornaam");
        p.setPostLastName("achternaam");
        p.setPostEmail("@email");
        p.setPostDescription("dit is een test");
        p.setPostLongitude("125468");
        p.setPostLatitude("987412");
        DaPost.insert(p);
        
    }

//    /**
//     * Test of insertPostPhoto method, of class DaPost.
//     */
//    @Test
//    public void testInsertPostPhoto() throws Exception {
//        System.out.println("insertPostPhoto");
//        String file = "";
//        int postId = 0;
//        DaPost instance = new DaPost();
//        String expResult = "";
//        String result = instance.insertPostPhoto(file, postId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePost method, of class DaPost.
//     */
//    @Test
//    public void testDeletePost() throws Exception {
//        System.out.println("deletePost");
//        int id = 0;
//        DaPost.deletePost(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePost method, of class DaPost.
//     */
//    @Test
//    public void testUpdatePost() throws Exception {
//        System.out.println("updatePost");
//        Post p = null;
//        DaPost.updatePost(p);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

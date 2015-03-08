/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Subscriber;
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
public class DaSubscriberTest {
    
    public DaSubscriberTest() {
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
     * Test of selectAllSubscriber method, of class DaSubscriber.
     */
    @Test
    public void testSelectAllSubscriber() {
        System.out.println("selectAllSubscriber");
       
        List<Subscriber> result = DaSubscriber.selectAll(); 
        
        for (Subscriber s : result) {
            System.out.println(s.getSubscriberFirstName());
            System.out.println(s.getSubscriberLastName());
            System.out.println(s.getSubscriberEmail());
            
        }
        System.out.println(result.toString());
    }

//    /**
//     * Test of insertSubscriber method, of class DaSubscriber.
//     */
//    @Test
//    public void testInsertSubscriber() throws Exception {
//        System.out.println("insertSubscriber");
//        Subscriber s = null;
//        DaSubscriber.insertSubscriber(s);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteSubscriber method, of class DaSubscriber.
//     */
//    @Test
//    public void testDeleteSubscriber() throws Exception {
//        System.out.println("deleteSubscriber");
//        int subScriberId = 0;
//        DaSubscriber.deleteSubscriber(subScriberId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

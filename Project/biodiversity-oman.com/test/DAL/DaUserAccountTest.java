/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.UserAccount;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lennyasus
 */
public class DaUserAccountTest {
	
	public DaUserAccountTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of insertUser method, of class DaUserAccount.
	 */
	@org.junit.Test
	public void testInsertUserAccount() throws Exception {
		System.out.println("insertUser");
		UserAccount user = new UserAccount();
		user.setAddress("test");
		user.setCity("test");
		user.setCountry("test");
		user.setEmail("fsdfsdf");
		user.setIsAdmin(false);
		user.setFirstName("test");
		user.setUserName("test");
		user.setLastName("test");
		user.setPassword("test");
		user.setPhone(22222);
		DaUserAccount.insertUserAccount(user);
		
	}
	
}

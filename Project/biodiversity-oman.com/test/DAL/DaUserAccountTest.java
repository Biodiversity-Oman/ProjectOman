/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.UserAccount;
import java.util.List;
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

	/**
	 * Test of updateUserAccount method, of class DaUserAccount.
	 */
	@Test
	public void testUpdateUserAccount() throws Exception {
		System.out.println("updateUserAccount");
		UserAccount user = new UserAccount();
		user.setFirstName("test1");
		user.setLastName("test1");
		user.setEmail("test1");
		user.setCity("test1");
		user.setCountry("test1");
		user.setUserName("test");
		user.setPhone(121212);
		DaUserAccount.updateUserAccount(user);
		
	}

	/**
	 * Test of selectByUsername method, of class DaUserAccount.
	 */
	@Test
	public void testSelectByUsername() throws Exception {
		System.out.println("selectByUsername");
		String username = "";
		UserAccount expResult = null;
		UserAccount result = DaUserAccount.selectByUsername(username);
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of deleteUserAccount method, of class DaUserAccount.
	 */
	@Test
	public void testDeleteUserAccount() throws Exception {
		System.out.println("deleteUserAccount");
		String username = "";
		DaUserAccount.deleteUserAccount(username);
		
	}

	/**
	 * Test of update method, of class DaUserAccount.
	 */
	@Test
	public void testUpdatePassword() throws Exception {
		System.out.println("updatePassword");
		String password = "";
		String username = "";
		DaUserAccount.updatePassword(password, username);
		
	}

	/**
	 * Test of checkPassword method, of class DaUserAccount.
	 */
	@Test
	public void testCheckPassword() throws Exception {
		System.out.println("checkPassword");
		String username = "";
		String password = "";
		boolean expResult = false;
		boolean result = DaUserAccount.checkPassword(username, password);
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of checkUsername method, of class DaUserAccount.
	 */
	@Test
	public void testCheckUsername() throws Exception {
		System.out.println("checkUsername");
		String username = "";
		boolean expResult = false;
		boolean result = DaUserAccount.checkUsername(username);
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setSuperUser method, of class DaUserAccount.
	 */
	@Test
	public void testSetSuperUser() throws Exception {
		System.out.println("setSuperUser");
		String username = "";
		DaUserAccount.setSuperUser(username);
		
	}

	/**
	 * Test of selectAll method, of class DaUserAccount.
	 */
	@Test
	public void testSelectAll() throws Exception {
		System.out.println("selectAll");
		List<UserAccount> expResult = null;
		List<UserAccount> result = DaUserAccount.selectAll();
		
	}
	
}

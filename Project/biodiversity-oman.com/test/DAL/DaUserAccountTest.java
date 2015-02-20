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

//	/**
//	 * Test of insertUserAccount method, of class DaUserAccount.
//	 */
//	@Test
//	public void testInsertUserAccount() throws Exception {
//		System.out.println("insertUserAccount");
//		UserAccount user = new UserAccount();
//		user.setFirstName("test1");
//		user.setLastName("test1");
//		user.setCity("test1");
//		user.setEmail("test1@test");
//		user.setIsAdmin(false);
//		user.setCountry("test1");
//		user.setPassword("test");
//		user.setPhone("12211");
//		user.setUserName("test1");
//		DaUserAccount.insertUserAccount(user);
//		
//	}
//
//	/**
//	 * Test of selectByUsername method, of class DaUserAccount.
//	 */
//	@Test
//	public void testSelectByUsername() throws Exception {
//		System.out.println("selectByUsername");
//		String username = "test";
//		UserAccount result = DaUserAccount.selectByUsername(username);
//		System.out.println(result);
//		
//	}
//
//	/**
//	 * Test of updateUserAccount method, of class DaUserAccount.
//	 */
//	@Test
//	public void testUpdateUserAccount() throws Exception {
//		System.out.println("updateUserAccount");
//		UserAccount user = new UserAccount();
//		user.setFirstName("test122");
//		user.setLastName("testzzzzz");
//		user.setCity("test2");
//		user.setCountry("belgie");
//		user.setEmail("something@something");
//		user.setPhone("51223");
//		user.setUserName("test");
//		DaUserAccount.updateUserAccount(user);
//		
//	}
//
//	/**
//	 * Test of deleteUserAccount method, of class DaUserAccount.
//	 */
//	@Test
//	public void testDeleteUserAccount() throws Exception {
//		System.out.println("deleteUserAccount");
//		String username = "test1";
//		DaUserAccount.deleteUserAccount(username);
//		
//	}
//
//	/**
//	 * Test of updatePassword method, of class DaUserAccount.
//	 */
//	@Test
//	public void testUpdatePassword() throws Exception {
//		System.out.println("updatePassword");
//		String password = "";
//		String username = "";
//		DaUserAccount.updatePassword(password, username);
//		
//	}
//
//	/**
//	 * Test of checkPassword method, of class DaUserAccount.
//	 */
//	@Test
//	public void testCheckPassword() throws Exception {
//		System.out.println("checkPassword");
//		String username = "";
//		String password = "";
//		
//		boolean result = DaUserAccount.checkPassword(username, password);
//		
//	}
//
//	/**
//	 * Test of checkUsername method, of class DaUserAccount.
//	 */
//	@Test
//	public void testCheckUsername() throws Exception {
//		System.out.println("checkUsername");
//		String username = "";
//		
//		boolean result = DaUserAccount.checkUsername(username);
//		System.out.println(result);
//	}
//
//	/**
//	 * Test of setSuperUser method, of class DaUserAccount.
//	 */
//	@Test
//	public void testSetSuperUser() throws Exception {
//		System.out.println("setSuperUser");
//		String username = "admin1";
//		DaUserAccount.setSuperUser(username);
//		
//	}
//
//	/**
//	 * Test of selectAll method, of class DaUserAccount.
//	 */
//	@Test
//	public void testSelectAll() throws Exception {
//		System.out.println("selectAll");
//		
//		List<UserAccount> result = DaUserAccount.selectAll();
//		System.out.println(result);
//	}
//
//	/**
//	 * Test of isAdmin method, of class DaUserAccount.
//	 */
//	@Test
//	public void testIsAdmin() throws Exception {
//		System.out.println("isAdmin");
//		String username = "";
//		DaUserAccount instance = new DaUserAccount();
//		boolean result = instance.isAdmin(username);
//		System.out.println(result);
//		
//	}
//
//	/**
//	 * Test of setNormalUser method, of class DaUserAccount.
//	 */
//	@Test
//	public void testSetNormalUser() throws Exception {
//		System.out.println("setNormalUser");
//		String username = "admin";
//		DaUserAccount.setNormalUser(username);
//		
//	}

	/**
	 * Test of searchByUserNameFirstNameLastName method, of class DaUserAccount.
	 */
	@Test
	public void testSearchByUserNameFirstNameLastName() throws Exception {
		System.out.println("searchByUserNameFirstNameLastName");
		String keyword = "lenny donnez";
		
		List result = DaUserAccount.searchUserAccount(keyword);
		System.out.println(result);
		
	}
	
}

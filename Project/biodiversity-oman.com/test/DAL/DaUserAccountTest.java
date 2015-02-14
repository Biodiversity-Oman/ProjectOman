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
	@Test
	public void testInsertUser() throws Exception {
		System.out.println("insertUser");
		UserAccount user = new UserAccount();
		user.setAdress("qsdfsdfdsf");
		user.setCity("sqdfsdf");
		user.setCountry("qsdfsdfs");
		user.setEmail("qsdfsdf");
		user.setFirstName("sqdfsqdf");
		user.setLastName("sqdfsd");
		user.setPassword("sqdfsdt");
		user.setPhone(111111);
		user.setUserName("xsqfsdfdsftest");
		DaUserAccount.insertUser(user);

	}
	
}

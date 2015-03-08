/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.UserAccount;
import DAL.DaUserAccount;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lennyasus
 */
public class ServUserAccount {

	public static boolean checkPassword(String username, String password) throws SQLException {

		boolean exist;
		exist = DaUserAccount.checkPassword(username, password) == true;
		return exist;
	}

	public static boolean isAdmin(String username) throws SQLException {

		boolean exist;
		exist = DaUserAccount.isAdmin(username) == true;
		return exist;
	}

	public static UserAccount selectUserAccountByUsername(String username) throws SQLException {

		UserAccount user = DaUserAccount.selectByUsername(username);
		return user;
	}

	public static void updateUserAccount(String username, String firstname, String lastname, String city, String country, String phone, String email) throws SQLException {

		UserAccount user = new UserAccount();
		user.setUserName(username);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setCity(city);
		user.setCountry(country);
		user.setPhone(phone);
		user.setEmail(email);
		DaUserAccount.updateUserAccount(user);
	}

	public static void updatePassword(String password, String username) throws SQLException {

		DaUserAccount.updatePassword(password, username);
	}

	public static void deleteUserAccount(String username) throws SQLException {

		DaUserAccount.deleteUserAccount(username);
	}

	public static List<UserAccount> selectAll() throws SQLException {

		return DaUserAccount.selectAll();
	}

	public static void setSuperUser(String username) throws SQLException {

		DaUserAccount.setSuperUser(username);
	}

	public static void insertUserAccount(String username, String firstname, String lastname, String city, String country, String phone, String email, String isadmin, String password) throws SQLException {

		UserAccount user = new UserAccount();
		user.setUserName(username);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setCity(city);
		user.setCountry(country);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		if (isadmin.equals("true")) {
			user.setIsAdmin(true);
		} else if (isadmin.equals("false")) {
			user.setIsAdmin(false);
		}
		DaUserAccount.insertUserAccount(user);
	}

	public static boolean checkUsername(String username) throws SQLException {

		return DaUserAccount.checkUsername(username);
	}

	public static void setNormalUser(String username) throws SQLException {

		DaUserAccount.setNormalUser(username);
	}

	public static List<UserAccount> searchUserAccount(String keyword) throws SQLException {

		return DaUserAccount.searchUserAccount(keyword);
	}
        
        public static boolean isLastUser() throws SQLException
        {
            return DaUserAccount.isLastUser();
        }
}

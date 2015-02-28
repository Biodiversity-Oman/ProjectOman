/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author lennyasus
 */
public class DaUserAccount {

	private static Connection conn;
	private static PreparedStatement stmt;

	public static void insertUserAccount(UserAccount user) throws SQLException {

		String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

		try {
			// set autocommit to false to control when the query has to be commited, this gives a huge performance boost
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO user_account"
				+ "(username, password, first_name, last_name, email, city, country, isadmin, phone) VALUES (?,?,?,?,?,?,?,?,?)");
			// set my query strings fro mmy user object(parameter)
			stmt.setString(1, user.getUserName());
			stmt.setString(2, password);
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getCity());
			stmt.setString(7, user.getCountry());
			stmt.setBoolean(8, user.getIsAdmin());
			stmt.setString(9, user.getPhone());
			stmt.executeUpdate();
			// do my commit
			conn.commit();
		} catch (SQLException ex) {
			// if someting goes wrong with the query will the commit be rolled back
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static UserAccount selectByUsername(String username) throws SQLException {

		UserAccount us = new UserAccount();
		try {
			conn = DataSource.getConnection();
			
			stmt = conn.prepareStatement("SELECT first_name, last_name, email, city, country, isadmin, phone FROM user_account where username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			us.setFirstName(rs.getString("first_name"));
			us.setLastName(rs.getString("last_name"));
			us.setEmail(rs.getString("email"));
			us.setCity(rs.getString("city"));
			us.setCountry(rs.getString("country"));
			us.setIsAdmin(rs.getBoolean("isadmin"));
			us.setPhone(rs.getString("phone"));
			System.out.println(us.getUserName());
		} catch (SQLException ex) {

		} 
		return us;
	}

	public static void updateUserAccount(BLL.UserAccount user) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_account SET first_name=?, last_name=?, email=?, city=?, country=?, phone=? WHERE username=?");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getCity());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getPhone());
			stmt.setString(7, user.getUserName());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static void deleteUserAccount(String username) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("DELETE FROM user_account where username=?");
			stmt.setString(1, username);
			conn.commit();
			stmt.executeUpdate();
		} catch (SQLException ex) {

		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static void updatePassword(String password, String username) throws SQLException {

		String newpassword = BCrypt.hashpw(password, BCrypt.gensalt());
		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_account SET password = ? WHERE username=?");
			stmt.setString(1, newpassword);
			stmt.setString(2, username);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
	}

	// returns true or false
	public static boolean checkPassword(String username, String password) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT password FROM user_account where username = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		String pass = rs.getString("password");
		match = BCrypt.checkpw(password, pass);
		return match;
	}

	// returns true or false
	public static boolean checkUsername(String username) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT COUNT(*) FROM user_account WHERE username = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		match = rs.getInt(1) == 1;
		return match;
	}

	public static void setSuperUser(String username) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_account SET isadmin = '1' WHERE username=?");
			stmt.setString(1, username);
			conn.commit();
			stmt.executeUpdate();

		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static List<UserAccount> selectAll() throws SQLException {

		List<UserAccount> users = new ArrayList();
		try {
			conn = DataSource.getConnection();
			stmt = conn.prepareStatement("SELECT first_name, last_name, email, city, country, username, phone, isadmin FROM user_account");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserAccount user = new UserAccount();
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				user.setCountry(rs.getString("country"));
				user.setUserName(rs.getString("username"));
				user.setPhone(rs.getString("phone"));
				user.setIsAdmin(rs.getBoolean("isadmin"));
				users.add(user);
			}
			
		} catch (SQLException e) {
			
		} 

		return users;
	}

	public static boolean isAdmin(String username) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT isadmin FROM user_account WHERE username = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		match = rs.getInt(1) == 1;
		return match;
	}

	public static void setNormalUser(String username) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_account SET isadmin = '0' WHERE username=?");
			stmt.setString(1, username);
			conn.commit();
			stmt.executeUpdate();

		} catch (SQLException ex) {

		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static List searchUserAccount(String keyword) throws SQLException {

		List<UserAccount> result = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT first_name, last_name, email, city, country, username, phone, isadmin\n"
			+ "FROM user_account \n"
			+ "WHERE (CONCAT(username,first_name,last_name,email) LIKE '%"+ keyword +"%') OR (CONCAT_WS(' ', first_name, last_name) LIKE '%"+ keyword +"%')");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			UserAccount user = new UserAccount();
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setCity(rs.getString("city"));
			user.setCountry(rs.getString("country"));
			user.setUserName(rs.getString("username"));
			user.setPhone(rs.getString("phone"));
			user.setIsAdmin(rs.getBoolean("isadmin"));
			result.add(user);
		}
		
		return result;
	}

}

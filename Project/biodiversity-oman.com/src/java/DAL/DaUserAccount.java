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
			stmt = conn.prepareStatement("INSERT INTO user_accounts "
				+ "(first_name, last_name, email, city, country, address, password, username, isadmin, phone) VALUES (?,?,?,?,?,?,?,?,?,?)");
			// set my query strings fro mmy user object(parameter)
			stmt.setString(1, user.getAddress());
			stmt.setString(2, user.getCity());
			stmt.setString(3, user.getCountry());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getFirstName());
			stmt.setString(6, user.getLastName());
			stmt.setString(7, password);
			stmt.setString(8, user.getUserName());
			stmt.setBoolean(9, user.getIsAdmin());
			stmt.setInt(10, user.getPhone());
			stmt.executeUpdate();
			// do my commit
			conn.commit();

		} catch (SQLException ex) {
			// if someting goes wrong with the query will the commit be rolled back
			conn.rollback();
		} finally {
			// autocommit back on true, NEVER FORGET THIS!!
			conn.setAutoCommit(true);
		}
	}

	public static UserAccount selectByUsername(String username) throws SQLException {
		UserAccount user = new UserAccount();

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("SELECT first_name, last_name, email, city, country, address, username, phone, isadmin FROM user_accounts WHERE username=" + username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				user.setCountry(rs.getString("country"));
				user.setAddress(rs.getString("address"));
				user.setUserName(rs.getString("username"));
				user.setPhone(rs.getInt("phone"));
				user.setIsAdmin(rs.getBoolean("isadmin"));
			}
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}

		return user;
	}

	public static void updateUserAccount(BLL.UserAccount user) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_accounts SET first_name=? ,last_name=?, email=?, city=?, country=?, address=?, phone=? WHERE username=?");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getCity());
			stmt.setString(5, user.getCountry());
			stmt.setString(6, user.getAddress());
			stmt.setInt(7, user.getPhone());
			stmt.setString(8, user.getUserName());
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

			stmt = conn.prepareStatement("DELETE FROM user_accounts where username=?");
			stmt.setString(1, username);
			stmt.executeUpdate();
			conn.commit();

		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static void updatePassword(String password, String username) throws SQLException {

		String newpassword = BCrypt.hashpw(password, BCrypt.gensalt());
		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_accounts SET password = ? WHERE username=?");
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
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("SELECT password FROM user_accounts where username = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		conn.commit();
		rs.next();
		String pass = rs.getString("password");
		match = BCrypt.checkpw(password, pass);
		conn.setAutoCommit(true);
		return match;
	}

	// returns true or false
	public static boolean checkUsername(String username) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement("SELECT COUNT(*) FROM user_accounts WHERE username = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		conn.commit();
		rs.next();
		match = rs.getInt(1) == 1;
		conn.setAutoCommit(true);
		return match;
	}

	public static void setSuperUser(String username) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE user_accounts SET isadmin = '1' WHERE username=?");
			stmt.executeUpdate();
			conn.commit();
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
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("SELECT first_name, last_name, email, city, country, address, username, phone, isadmin FROM user_accounts");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserAccount user = new UserAccount();
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				user.setCountry(rs.getString("country"));
				user.setAddress(rs.getString("address"));
				user.setUserName(rs.getString("username"));
				user.setPhone(rs.getInt("phone"));
				user.setIsAdmin(rs.getBoolean("isadmin"));
				users.add(user);
			}
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}

		return users;
	}
	
	
	
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author lennyasus
 */
public class DaUserAccount {
	

	private static Connection conn;
	private static PreparedStatement stmt;	

	public static void insertUserAccount(BLL.UserAccount user) throws SQLException{

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
	
} 

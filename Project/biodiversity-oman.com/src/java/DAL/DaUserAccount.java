/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.Statement;
=======
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
>>>>>>> origin/master

/**
 *
 * @author lennyasus
 */
public class DaUserAccount {
	
<<<<<<< HEAD
}
=======
	private static Connection conn;
	private static PreparedStatement stmt;	

	public static void insertUser(BLL.UserAccount user) throws SQLException{

		String password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());	

		try {
			// set autocommit to false to control when the query has to be commited, this gives a huge performance boost
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO admin " 
						   + "(address, city, country, email, first_name, last_name, password, username) VALUES (?,?,?,?,?,?,?,?)");
			// set my query strings fro mmy user object(parameter)
			stmt.setString(1, user.getAdress());
			stmt.setString(2, user.getCity());
			stmt.setString(3, user.getCountry());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getFirstName());
			stmt.setString(6, user.getLastName());
			stmt.setString(7, password);
			stmt.setString(8, user.getUserName());
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
>>>>>>> origin/master
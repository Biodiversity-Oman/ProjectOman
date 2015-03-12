/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Subscriber;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Tom
 */
public class DaSubscriber {

	private static Connection conn;
	private static PreparedStatement stmt;

	public static List<Subscriber> selectAll() throws SQLException {

		List<Subscriber> subScriber = new ArrayList<>();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM subscriber");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Subscriber s = new Subscriber();
			s.setSubscriberId(rs.getInt("subscriber_id"));
			s.setSubscriberFirstName(rs.getString("subscriber_first_name"));
			s.setSubscriberLastName(rs.getString("subscriber_last_name"));
			s.setSubscriberEmail(rs.getString("subscriber_email"));
			subScriber.add(s);
		}
		conn.close();
		return subScriber;
	}

	public static void insert(Subscriber s) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO subscriber (subscriber_first_name, subscriber_last_name, subscriber_email) VALUES (?,?,?)");
			stmt.setString(1, s.getSubscriberFirstName());
			stmt.setString(2, s.getSubscriberFirstName());
			stmt.setString(3, s.getSubscriberEmail());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			System.out.println(ex.getMessage());
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static void delete(int subScriberId) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("DELETE FROM subscriber WHERE subscriber_id=" + subScriberId + "");
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			System.out.println(ex.getMessage());
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}
}

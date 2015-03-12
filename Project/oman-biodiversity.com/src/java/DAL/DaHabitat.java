/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Habitat;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Eric
 */
public class DaHabitat {

	private static Connection conn;
	private static PreparedStatement stmt;

	public static List<Habitat> selectAll() throws SQLException {

		List<Habitat> habitats = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM habitat");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Habitat h = new Habitat();
			h.setHabitatId(rs.getInt("habitat_id"));
			h.setHabitatName(rs.getString("habitat_name"));
			h.setHabitatDescription(rs.getString("habitat_description"));
			habitats.add(h);
		}
		conn.close();
		return habitats;
	}

	public static Habitat selectOneByID(int id) throws SQLException {

		Habitat h = new Habitat();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM habitat WHERE habitat_id=" + id);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		h.setHabitatId(rs.getInt("habitat_id"));
		h.setHabitatName(rs.getString("habitat_name"));
		h.setHabitatDescription(rs.getString("habitat_description"));
		conn.close();
		return h;
	}

	public static void delete(int id) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("DELETE FROM habitat WHERE HABITAT_ID=" + id + "");
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

	public static void update(Habitat h) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE habitat SET habitat_name=?, habitat_description=? WHERE habitat_id=" + h.getHabitatId());
			stmt.setString(1, h.getHabitatName());
			stmt.setString(2, h.getHabitatDescription());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			System.out.println(ex);
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static void insert(Habitat h) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO habitat "
					+ "(habitat_name, habitat_description) VALUES (?,?)");
			stmt.setString(1, h.getHabitatName());
			stmt.setString(2, h.getHabitatDescription());
			stmt.executeUpdate();
			conn.commit();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static boolean checkIfExists(String habitatName) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT COUNT(*) habitat_name FROM habitat WHERE habitat_name = ?");
		stmt.setString(1, habitatName);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		match = rs.getInt(1) == 1;
		conn.close();
		return match;
	}
}

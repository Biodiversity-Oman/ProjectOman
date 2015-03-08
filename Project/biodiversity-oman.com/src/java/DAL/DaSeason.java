/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Season;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Eric
 */
public class DaSeason {

	private static Connection conn;
	private static PreparedStatement stmt;

	public static List<Season> selectAll() throws SQLException {

		List<Season> seasons = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM season");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Season s = new Season();
			s.setSeasonId(rs.getInt("season_id"));
			s.setSeasonName(rs.getString("season_name"));
			s.setSeasonDescription(rs.getString("season_description"));
			seasons.add(s);
		}
		conn.close();
		return seasons;
	}

	public static Season selectOneByID(int seasonId) throws SQLException {

		Season s = new Season();

		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT season.season_id, season.season_name, season.season_description \n"
				+ "FROM season \n"
				+ "WHERE season_id=?");
		stmt.setInt(1, seasonId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			s.setSeasonId(rs.getInt("season_id"));
			s.setSeasonName(rs.getString("season_name"));
			s.setSeasonDescription(rs.getString("season_description"));
		}
		conn.close();
		return s;
	}

	public static List<Season> selectAllByOrganism(int organismId) throws SQLException {

		List<Season> seasons = new ArrayList();

		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM organism_season "
				+ "INNER JOIN season ON season.season_id = organism_season.season_id "
				+ "WHERE organism_id=" + organismId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Season season = new Season();
			season.setSeasonId(rs.getInt("season_id"));
			season.setSeasonName(rs.getString("name"));
			season.setSeasonDescription(rs.getString("description"));
			seasons.add(season);
		}
		conn.close();
		return seasons;
	}

	public static void update(Season seas) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE season "
					+ "SET season_name=?, season_description=? WHERE season_id=" + seas.getSeasonId() + "");
			stmt.setString(1, seas.getSeasonName());
			stmt.setString(2, seas.getSeasonDescription());
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

	public static void delete(int id) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("DELETE FROM season WHERE season_id=" + id + "");
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

	public static void insert(Season s) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO season "
					+ "(season_name, season_description) VALUES (?,?)");
			stmt.setString(1, s.getSeasonName());
			stmt.setString(2, s.getSeasonDescription());
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

	public static boolean checkIfExists(String seasonName) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT COUNT(*) season_name FROM season WHERE season_name = ?");
		stmt.setString(1, seasonName);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		match = rs.getInt(1) == 1;
		conn.close();
		return match;
	}
}

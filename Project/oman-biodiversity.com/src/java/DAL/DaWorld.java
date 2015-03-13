/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.World;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Tom
 */
public class DaWorld {

	private static Connection conn;
	private static PreparedStatement stmt;

	public static List<World> selectAll() throws SQLException {

		List<World> worlds = new ArrayList<>();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT world_id, world_name, world_description FROM world");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			World w = new World();
			w.setWorldId(rs.getInt("world_id"));
			w.setWorldName(rs.getString("world_name"));
			w.setDescription(rs.getString("world_description"));
			worlds.add(w);
		}
		conn.close();
		return worlds;
	}

	public static World selectOneByID(int worldId) throws SQLException {

		World w = new World();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT world_name, world_description FROM world WHERE world_id=?");
                stmt.setInt(1, worldId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			w.setWorldName(rs.getString("world_name"));
			w.setDescription(rs.getString("world_description"));
		}
		return w;
	}

	public static void insert(World world) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO world (world_name, world_description) VALUES (?,?)");
			stmt.setString(1, world.getWorldName());
			stmt.setString(2, world.getDescription());
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

	public static void delete(int worldId) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(true);
			stmt = conn.prepareStatement("UPDATE family SET world_id=null WHERE world_id=?");
                        stmt.setString(1, Integer.toString(worldId));
			stmt.executeUpdate();
			stmt = conn.prepareStatement("UPDATE download SET world_id=null WHERE world_id=?");
                        stmt.setInt(1, worldId);
			stmt.executeUpdate();
			stmt = conn.prepareStatement("DELETE FROM world WHERE world_id=?");
                        stmt.setInt(1, worldId);
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

	public static void update(World world) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE world set world_name = ?, world_description = ? WHERE world_id=?");
			stmt.setString(1, world.getWorldName());
			stmt.setString(2, world.getDescription());
                        stmt.setInt(3, world.getWorldId());
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

	public static boolean checkIfExists(String worldName) throws SQLException {

		boolean match;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT COUNT(*) world_name FROM world WHERE world_name = ?");
		stmt.setString(1, worldName);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		match = rs.getInt(1) == 1;
		conn.close();
		return match;
	}
}

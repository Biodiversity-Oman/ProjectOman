/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class DaWorld {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<World> selectAllWold() {

        List<World> world = new ArrayList<>();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT world_id, world_name, world_description FROM world");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                World w = new World();
                w.setWorldId(rs.getInt("world_id"));
                w.setWorldName(rs.getString("world_name"));
                w.setDescription(rs.getString("world_description"));
                world.add(w);
            }
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return world;
    }

    public static World selectOneByIdWorld(int worldId) {
        World w = new World();

        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT world_name, world_description FROM world WHERE world_id=" + worldId + "");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                w.setWorldName(rs.getString("world_name"));
                w.setDescription(rs.getString("world_description"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return w;
    }

    public static void insertWorld(World world) throws SQLException {

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
        }
    }

    public static void deleteWorld(int worldId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("DELETE FROM world WHERE world_id=" + worldId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
            System.out.println(ex.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void updateWorld(World world, int worldId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE world (world_name, world_description ) VALUES (?,?) WHERE world_id=" + worldId + "");
            stmt.setString(1, world.getWorldName());
            stmt.setString(2, world.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);

        } finally {
            conn.setAutoCommit(true);
        }
    }
}

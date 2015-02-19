/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Eric
 */
public class DaHabitat {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Habitat> selectAllfamily() throws SQLException {
        List<Habitat> habitats = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.habitat");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Habitat h = new Habitat();
                h.setHabitatId(rs.getInt("habitat_id"));
                h.setHabitatName(rs.getString("habitat_name"));
                h.setDescription(rs.getString("habitat_description"));
                habitats.add(h);
            }

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return habitats;
    }

    public static Habitat selectOneByIDHabitat(int id) throws SQLException {
        Habitat h = new Habitat();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.habitat WHERE habitat_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            h.setHabitatId(rs.getInt("habitat_id"));
            h.setHabitatName(rs.getString("habitat_name"));
            h.setDescription(rs.getString("habitat_description"));

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return h;
    }

    public static void deleteHabitat(Habitat h) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM habitat WHERE HABITAT_ID=" + h.getHabitatId() + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void updateHabitat(Habitat h) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE habitat "
                    + "(name, description, world_id) VALUES (?,?,?) WHERE habitat_id=" + h.getHabitatId() + "");
            stmt.setString(1, h.getHabitatName());
            stmt.setString(2, h.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void insertHabitat(Habitat h) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO habitat "
                    + "(name, description) VALUES (?,?)");
            stmt.setString(1, h.getHabitatName());
            stmt.setString(2, h.getDescription());
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }

}

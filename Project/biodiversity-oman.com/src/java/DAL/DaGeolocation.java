/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Geolocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oualid
 */
public class DaGeolocation {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Geolocation> selectAll() throws SQLException {

        List<Geolocation> geolocations = new ArrayList();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM geolocation");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Geolocation geolocation = new Geolocation();
                geolocation.setGeolocationId(rs.getInt("geolocation_id"));
                geolocation.setAreaName(rs.getString("area_name"));
                geolocation.setAreaDescription(rs.getString("area_description"));
                geolocation.setCoordinates("coordinates");
                geolocations.add(geolocation);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return geolocations;
    }

    public static Geolocation selectOneByID(int id) throws SQLException {

        Geolocation geolocation = new Geolocation();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM geolocation WHERE geolocation_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            geolocation.setGeolocationId(id);
            geolocation.setAreaName(rs.getString("area_name"));
            geolocation.setAreaDescription(rs.getString("area_description"));
            geolocation.setCoordinates(rs.getString("coordinates"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return geolocation;
    }

    public static List<Geolocation> selectAllByOrganism(int organismId) throws SQLException {

        List<Geolocation> geolocations = new ArrayList();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM geolocation "
                    + "INNER JOIN geolocation_organism ON geolocation_organism.geolocation_id = geolocation.geolocation_id "
                    + "INNER JOIN organism ON organism.organism_id = geolocation_organism.organism_id "
                    + "WHERE organism.organism_id=" + organismId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Geolocation geolocation = new Geolocation();
                geolocation.setGeolocationId(rs.getInt("geolocation_id"));
                geolocation.setAreaName(rs.getString("area_name"));
                geolocation.setAreaDescription(rs.getString("area_description"));
                geolocation.setCoordinates(rs.getString("coordinates"));
                geolocations.add(geolocation);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return geolocations;
    }

    public static void insert(Geolocation geolocation) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO geolocation(area_name, "
                    + "area_description, coordinates) VALUES(?, ?, ?)");
            stmt.setString(1, geolocation.getAreaName());
            stmt.setString(2, geolocation.getAreaDescription());
            stmt.setString(3, geolocation.getCoordinates());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void delete(int id) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM geolocation WHERE geolocation_id=" + id);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void update(Geolocation geolocation) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE geolocation SET area_name=?, "
                    + "area_description=?, coordinates=? WHERE geolocation_id=?");
            stmt.setString(1, geolocation.getAreaName());
            stmt.setString(2, geolocation.getAreaDescription());
            stmt.setString(3, geolocation.getCoordinates());
            stmt.setInt(4, geolocation.getGeolocationId());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static boolean checkGeoExist(String areaName) throws SQLException {

        boolean match;
        conn = DataSource.getConnection();
        stmt = conn.prepareStatement("SELECT COUNT(*) area_name FROM geolocation WHERE area_name = ?");
        stmt.setString(1, areaName);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        match = rs.getInt(1) == 1;
        return match;
    }
}

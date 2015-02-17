/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.GeoLocation;
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

    public static List<GeoLocation> selectAllGeolocation() throws SQLException {
        List<GeoLocation> geolocations = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.geolocation");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                GeoLocation geolocation = new GeoLocation();
                geolocation.setGeolocationId(rs.getInt("geolocation_id"));
                geolocation.setAreaName(rs.getString("area_name"));
                geolocation.setAreaDescription(rs.getString("area_description"));
                geolocations.add(geolocation);
            }
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return geolocations;
    }
    
    public static GeoLocation selectOneByIDGeolocation(int id) throws SQLException {
        GeoLocation geolocation = new GeoLocation();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.geolocation WHERE geolocation_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            geolocation.setGeolocationId(id);
            geolocation.setAreaName(rs.getString("area_name"));
            geolocation.setAreaDescription(rs.getString("area_description"));
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return geolocation;
    }
    
    public static List<GeoLocation> selectAllByOrganismGeolocation(int organismId) throws SQLException {
        List<GeoLocation> geolocations = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.geolocation "
                    + "INNER JOIN omandb.geolocation_organisme ON geolocation_organisme.geolocation_id = geolocation.geolocation_id "
                    + "INNER JOIN omandb.organism ON organism.organism_id = geolocation_organisme.organism_id "
                    + "WHERE organism.organism_id=" + organismId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                GeoLocation geolocation = new GeoLocation();
                geolocation.setGeolocationId(rs.getInt("geolocation_id"));
                geolocation.setAreaName(rs.getString("area_name"));
                geolocation.setAreaDescription(rs.getString("area_description"));
                geolocations.add(geolocation);
            }
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return geolocations;
    }
    
    public static void insertGeolocation(GeoLocation geolocation) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.geolocation(area_name, "
                    + "area_description) VALUES(?, ?)");
            stmt.setString(1, geolocation.getAreaName());
            stmt.setString(2, geolocation.getAreaDescription());
            stmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    public static void deleteGeolocation(int id) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM omandb.geolocation WHERE geolocation_id=" + id);
            stmt.executeUpdate();
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    public static void updateGeolocation(GeoLocation geolocation) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE omandb.geolocation SET area_name=?, "
                    + "area_description=? WHERE geolocation_id=?");
            stmt.setString(1, geolocation.getAreaName());
            stmt.setString(2, geolocation.getAreaDescription());
            stmt.setInt(3, geolocation.getGeolocationId());
            stmt.executeUpdate();
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

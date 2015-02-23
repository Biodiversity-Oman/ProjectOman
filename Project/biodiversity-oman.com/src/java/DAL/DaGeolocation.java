/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Geolocationold;
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

    public static List<Geolocationold> selectAllGeolocation() throws SQLException {
        List<Geolocationold> geolocations = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.geolocation");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Geolocationold geolocation = new Geolocationold();
                geolocation.setGeolocationId(rs.getInt("geolocation_id"));
                geolocation.setAreaName(rs.getString("area_name"));
                geolocation.setAreaDescription(rs.getString("area_description"));
                geolocation.setCoordinates("coordinates");
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
    
    public static Geolocationold selectOneByIDGeolocation(int id) throws SQLException {
        Geolocationold geolocation = new Geolocationold();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.geolocation WHERE geolocation_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            geolocation.setGeolocationId(id);
            geolocation.setAreaName(rs.getString("area_name"));
            geolocation.setAreaDescription(rs.getString("area_description"));
            geolocation.setCoordinates(rs.getString("coordinates"));
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return geolocation;
    }
    
    public static List<Geolocationold> selectAllByOrganismGeolocation(int organismId) throws SQLException {
        List<Geolocationold> geolocations = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.geolocation "
                    + "INNER JOIN omandb.geolocation_organism ON geolocation_organism.geolocation_id = geolocation.geolocation_id "
                    + "INNER JOIN omandb.organism ON organism.organism_id = geolocation_organism.organism_id "
                    + "WHERE organism.organism_id=" + organismId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Geolocationold geolocation = new Geolocationold();
                geolocation.setGeolocationId(rs.getInt("geolocation_id"));
                geolocation.setAreaName(rs.getString("area_name"));
                geolocation.setAreaDescription(rs.getString("area_description"));
                geolocation.setCoordinates(rs.getString("coordinates"));
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
    
    public static void insertGeolocation(Geolocationold geolocation) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.geolocation(area_name, "
                    + "area_description, coordinates) VALUES(?, ?, ?)");
            stmt.setString(1, geolocation.getAreaName());
            stmt.setString(2, geolocation.getAreaDescription());
            stmt.setString(3, geolocation.getCoordinates());
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
    
    public static void updateGeolocation(Geolocationold geolocation) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE omandb.geolocation SET area_name=?, "
                    + "area_description=?, coordinates=? WHERE geolocation_id=?");
            stmt.setString(1, geolocation.getAreaName());
            stmt.setString(2, geolocation.getAreaDescription());
            stmt.setString(3, geolocation.getCoordinates());
            stmt.setInt(4, geolocation.getGeolocationId());
            stmt.executeUpdate();
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

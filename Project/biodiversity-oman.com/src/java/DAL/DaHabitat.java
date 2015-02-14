/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BLL.Habitat;

/**
 *
 * @author Eric
 */
public class DaHabitat {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    
    
    public static List selectHabitat(int habitatId) throws SQLException {

        List<Habitat> habitat = new ArrayList<>();
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("select NAME, DESCRIPTION, ID FROM habitat WHERE HABITAT_ID =" + habitatId +"");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Habitat hab = new Habitat();
                hab.setDescription(rs.getString("DESCRIPTION"));
                hab.setName(rs.getString("NAME"));
                hab.setWorldId(Integer.parseInt(rs.getString("WORLD_ID")));
                habitat.add(hab);
            }
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return habitat;
    }
    
    
 
    
    public static void deleteHabitat(int habitatId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("DELETE FROM habitat WHERE HABITAT_ID=" + habitatId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    
    public static void updateHabitat(Habitat habi, int habitatId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE habitat "
                    + "(NAME, DESCRIPTION, WORLD_ID) VALUES (?,?,?) WHERE HABITAT_ID=" + habitatId +"");
            stmt.setString(1, habi.getName());
            stmt.setString(2, habi.getDescription());
            stmt.setInt(3, habi.getWorldId());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    
    
    public static void saveHabitat(Habitat habi) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO habitat "
                    + "(NAME, DESCRIPTION, WORLD_ID) VALUES (?,?,?)");
            stmt.setString(1, habi.getName());
            stmt.setString(2, habi.getDescription());
            stmt.setInt(3, habi.getWorldId());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
}
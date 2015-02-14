/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Family;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric
 */
public class DaFamily {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    
    
    public static List selectFamily(int familyId) throws SQLException {

        List<Family> family = new ArrayList<>();
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("select FAMILY_NAME, DESCRIPTION, ID FROM family WHERE FAMILY_ID =" + familyId +"");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Family fam = new Family();
                fam.setDescription(rs.getString("DESCRIPTION"));
                fam.setFamilyName(rs.getString("FAMILY_NAME"));
                family.add(fam);
            }
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return family;
    }
    
    
 
    
    public static void deleteFamily(int familyId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("DELETE FROM family WHERE Family_ID=" + familyId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    
    public static void updateFamily(Family fam, int familyId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE family "
                    + "(FAMILY_NAME, DESCRIPTION ) VALUES (?,?) WHERE FAMILY_ID=" + familyId +"");
            stmt.setString(1, fam.getFamilyName());
            stmt.setString(2, fam.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    
    
    public static void saveFamily(Family fami) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO family "
                    + "(FAMILY_NAME, DESCRIPTION) VALUES (?,?)");
            stmt.setString(1, fami.getFamilyName());
            stmt.setString(2, fami.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
}

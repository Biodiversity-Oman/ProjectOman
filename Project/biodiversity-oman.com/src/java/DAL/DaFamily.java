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
public class DaFamily {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Family> selectAllfamily() throws SQLException {
        List<Family> families = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.family");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Family f = new Family();
                f.setFamilyId(rs.getInt("family_id"));
                f.setFamilyName(rs.getString("family_name"));
                f.setFamilyDescription(rs.getString("family_description"));
                f.setWorldId(rs.getInt("world_id"));
                families.add(f);
            }

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return families;
    }

    public static Family selectOneByIDfamily(int id) throws SQLException {
        Family f = new Family();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.family WHERE family_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            f.setFamilyId(rs.getInt("family_id"));
            f.setFamilyName(rs.getString("family_name"));
            f.setFamilyDescription(rs.getString("family_description"));
            f.setWorldId(rs.getInt("world_id"));

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return f;
    }
    
     public static Family selectAllFamilyByWorld(int id) throws SQLException {
        Family f = new Family();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.family WHERE world_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            f.setFamilyId(rs.getInt("family_id"));
            f.setFamilyName(rs.getString("family_name"));
            f.setFamilyDescription(rs.getString("family_description"));

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return f;
    }

    public static void deleteFamily(int familyId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM omandb.family WHERE family_id=" + familyId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
           System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void updateFamily(Family fam, int familyId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE omandb.family "
                    + "(family_name, family_description, world_id ) VALUES (?,?,?) WHERE family_id=" + familyId + "");
            stmt.setString(1, fam.getFamilyName());
            stmt.setString(2, fam.getFamilyDescription());
            stmt.setInt(3, fam.getWorldId());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void insertFamily(Family fami) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.family "
                    + "(family_name, family_description, world_id) VALUES (?,?,?)");
            stmt.setString(1, fami.getFamilyName());
            stmt.setString(2, fami.getFamilyDescription());
            stmt.setInt(3, fami.getWorldId());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }

}

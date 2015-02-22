/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.SubFamily;
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
public class DaSubFamily {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<SubFamily> selectAllSubfamily() throws SQLException {
        List<SubFamily> subfamilies = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.subfamily");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SubFamily subfamily = new SubFamily();
                subfamily.setSubfamilyId(rs.getInt("subfamily_id"));
                subfamily.setFamilyId(rs.getInt("family_id"));
                subfamily.setSubfamilyName(rs.getString("subfamily_name"));
                subfamily.setSubFamilyDescription(rs.getString("subfamily_description"));
                subfamilies.add(subfamily);
            }

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return subfamilies;
    }

    public static SubFamily selectOneByIDSubfamily(int id) throws SQLException {
        SubFamily subfamily = new SubFamily();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.subfamily WHERE subfamily_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            subfamily.setSubfamilyId(id);
            subfamily.setFamilyId(rs.getInt("family_id"));
            subfamily.setSubfamilyName(rs.getString("subfamily_name"));
            subfamily.setSubFamilyDescription(rs.getString("subfamily_description"));

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return subfamily;
    }

    public static List<SubFamily> selectAllByFamilySubfamily(int id) throws SQLException {
        List<SubFamily> subfamilies = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.subfamily WHERE family_id=" + id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SubFamily subfamily = new SubFamily();
                subfamily.setSubfamilyId(rs.getInt("subfamily_id"));
                subfamily.setFamilyId(id);
                subfamily.setSubfamilyName(rs.getString("subfamily_name"));
                subfamily.setSubFamilyDescription(rs.getString("subfamily_description"));
                subfamilies.add(subfamily);
            }

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return subfamilies;
    }

    public static void insertSubfamily(SubFamily subfamily) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.subfamily(family_id, "
                    + "subfamily_name, subfamily_description) VALUES(?, ?, ?)");
            stmt.setInt(1, subfamily.getFamilyId());
            stmt.setString(2, subfamily.getSubfamilyName());
            stmt.setString(3, subfamily.getSubFamilyDescription());
            stmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void deleteSubfamily(int id) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM omandb.subfamily WHERE subfamily_id=" + id);
            stmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void updateSubfamily(SubFamily subfamily) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE omandb.subfamily SET family_id=?, "
                    + "subfamily_name=?, subfamily_description=? WHERE subfamily_id=?");
            stmt.setInt(1, subfamily.getFamilyId());
            stmt.setString(2, subfamily.getSubfamilyName());
            stmt.setString(3, subfamily.getSubFamilyDescription());
            stmt.setInt(4, subfamily.getSubfamilyId());
            stmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

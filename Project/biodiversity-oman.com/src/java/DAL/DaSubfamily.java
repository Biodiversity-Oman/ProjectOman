/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Subfamily;
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
public class DaSubfamily {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Subfamily> selectAllSubfamily() throws SQLException {
        List<Subfamily> subfamilies = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT subfamily.subfamily_id, family.family_id, subfamily.subfamily_name, subfamily.subfamily_description, family.family_name \n" +
					 "FROM subfamily\n" +
					 "LEFT JOIN family on family.family_id = subfamily.family_id");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Subfamily subfamily = new Subfamily();
                subfamily.setSubfamilyId(rs.getInt("subfamily_id"));
                subfamily.setFamilyId(rs.getInt("family_id"));
                subfamily.setSubfamilyName(rs.getString("subfamily_name"));
                subfamily.setSubFamilyDescription(rs.getString("subfamily_description"));
		subfamily.setSubFamilyFamilyName(rs.getString("family_name"));
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

    public static Subfamily selectOneByIDSubfamily(int id) throws SQLException {
        Subfamily subfamily = new Subfamily();

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

    public static List<Subfamily> selectAllByFamilySubfamily(int id) throws SQLException {
        List<Subfamily> subfamilies = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.subfamily WHERE family_id=" + id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Subfamily subfamily = new Subfamily();
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

    public static void insertSubfamily(Subfamily subfamily) throws SQLException {
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

    public static void updateSubfamily(Subfamily subfamily) throws SQLException {
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

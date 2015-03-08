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

	public static List<Subfamily> selectAll() throws SQLException {

		List<Subfamily> subfamilies = new ArrayList();
		try {
			conn = DataSource.getConnection();
			stmt = conn.prepareStatement("SELECT subfamily.subfamily_id, family.family_id, subfamily.subfamily_name, subfamily.subfamily_description, family.family_name "
				+ "FROM subfamily "
				+ "LEFT JOIN family on family.family_id = subfamily.family_id");
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
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return subfamilies;
	}

	public static Subfamily selectOneByID(int id) throws SQLException {

		Subfamily subfamily = new Subfamily();
		try {
			conn = DataSource.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM subfamily WHERE subfamily_id=" + id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			subfamily.setSubfamilyId(id);
			subfamily.setFamilyId(rs.getInt("family_id"));
			subfamily.setSubfamilyName(rs.getString("subfamily_name"));
			subfamily.setSubFamilyDescription(rs.getString("subfamily_description"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return subfamily;
	}

	public static List<Subfamily> selectAllByFamily(int id) throws SQLException {

		List<Subfamily> subfamilies = new ArrayList();
		try {
			conn = DataSource.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM subfamily WHERE family_id=" + id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Subfamily subfamily = new Subfamily();
				subfamily.setSubfamilyId(rs.getInt("subfamily_id"));
				subfamily.setFamilyId(id);
				subfamily.setSubfamilyName(rs.getString("subfamily_name"));
				subfamily.setSubFamilyDescription(rs.getString("subfamily_description"));
				subfamilies.add(subfamily);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return subfamilies;
	}

	public static void insert(Subfamily subfamily) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO subfamily(family_id, "
				+ "subfamily_name, subfamily_description) VALUES(?, ?, ?)");
			stmt.setInt(1, subfamily.getFamilyId());
			stmt.setString(2, subfamily.getSubfamilyName());
			stmt.setString(3, subfamily.getSubFamilyDescription());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			System.out.println(ex.getMessage());
		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static void delete(int id) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
                                                stmt = conn.prepareStatement("UPDATE organism SET subfamily_id=null WHERE subfamily_id=" + id);
                                                stmt.executeUpdate();
			stmt = conn.prepareStatement("DELETE FROM subfamily WHERE subfamily_id=" + id);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			System.out.println(ex.getMessage());
		} finally {
			conn.setAutoCommit(true);
		}
	}

	public static void update(Subfamily subfamily) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE subfamily SET family_id=?, "
				+ "subfamily_name=?, subfamily_description=? WHERE subfamily_id=?");
			stmt.setInt(1, subfamily.getFamilyId());
			stmt.setString(2, subfamily.getSubfamilyName());
			stmt.setString(3, subfamily.getSubFamilyDescription());
			stmt.setInt(4, subfamily.getSubfamilyId());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			System.out.println(ex.getMessage());
		} finally {
			conn.setAutoCommit(true);
		}
	}
        
         public static boolean checkIfExists(String subFamilyName) throws SQLException {

        boolean match;
        conn = DataSource.getConnection();
        stmt = conn.prepareStatement("SELECT COUNT(*) subfamily_name FROM subfamily WHERE subfamily_name = ?");
        stmt.setString(1, subFamilyName);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        match = rs.getInt(1) == 1;
        return match;
    }
         
         public static List searchSubfamily(String keyword) throws SQLException {

        List<Subfamily> result = new ArrayList();
        conn = DataSource.getConnection();
        stmt = conn.prepareStatement("SELECT subfamily.subfamily_id, subfamily.subfamily_name, subfamily.subfamily_description, family.family_name, family.family_id\n"
                + "FROM subfamily \n"
                + "LEFT JOIN family on family.family_id = subfamily.family_id\n"
                + "WHERE (CONCAT(subfamily.subfamily_name, family.family_name) LIKE '%" + keyword + "%') AND subfamily.isvalidated = '1'");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Subfamily s = new Subfamily();
            s.setSubfamilyId(rs.getInt("subfamily_id"));
            s.setSubFamilyDescription(rs.getString("subfamily_description"));
            s.setSubfamilyName(rs.getString("subfamily_name"));
            s.setSubFamilyFamilyName(rs.getString("family_name"));        

            result.add(s);
        }
        return result;
    }
}

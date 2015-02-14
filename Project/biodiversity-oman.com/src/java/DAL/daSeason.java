/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BLL.Season;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Eric
 */
public class DaSeason {
    
    private static Connection conn;
    private static PreparedStatement stmt;
    
    
    public static List select(int seasonId) throws SQLException {

        List<Season> season = new ArrayList<>();
        try {
            Connection conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("select NAME, DESCRIPTION, ID FROM season WHERE SEASON_ID =" + seasonId +"");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Season seaso = new Season();
                seaso.setDescription(rs.getString("DESCRIPTION"));
                seaso.setName(rs.getString("NAME"));
                season.add(seaso);
            }
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return season;
    }
    
    public static void updateSeason(Season seas, int seasonId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE season "
                    + "(NAME, DESCRIPTION) VALUES (?,?) WHERE SEASON_ID=" + seasonId +"");
            stmt.setString(1, seas.getName());
            stmt.setString(2, seas.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    public static void deleteSeason(int seasonId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("DELETE FROM season where SEASON_ID=" + seasonId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    
    public static void saveSeason(Season seas) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO season "
                    + "(NAME, DESCRIPTION) VALUES (?,?)");
            stmt.setString(1, seas.getName());
            stmt.setString(2, seas.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
}

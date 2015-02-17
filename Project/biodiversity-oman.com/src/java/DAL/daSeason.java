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
public class daSeason {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List selectSeason(int seasonId) throws SQLException {

        List<Season> season = new ArrayList<>();
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT name, description, id FROM season WHERE season_id =" + seasonId + "");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Season seaso = new Season();
                seaso.setDescription(rs.getString("description"));
                seaso.setSeasonName(rs.getString("name"));
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
    
    public static List<Season> selectAllByOrganismSeason(int organismId) throws SQLException {
        List<Season> seasons = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.organism_season "
                    + "INNER JOIN omandb.season ON season.season_id = organism_season.season_id "
                    + "WHERE organism_id=" + organismId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Season season = new Season();
                season.setSeasonId(rs.getInt("season_id"));
                season.setSeasonName(rs.getString("name"));
                season.setDescription(rs.getString("description"));
                seasons.add(season);
            }

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return seasons;
    }

    public static void updateSeason(Season seas, int seasonId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE season "
                    + "(name, description) VALUES (?,?) WHERE season_id=" + seasonId + "");
            stmt.setString(1, seas.getSeasonName());
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

            stmt = conn.prepareStatement("DELETE FROM season WHERE season_id=" + seasonId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void insertSeason(Season seas) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO season "
                    + "(name, description) VALUES (?,?)");
            stmt.setString(1, seas.getSeasonName());
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

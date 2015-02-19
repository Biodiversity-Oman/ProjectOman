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
public class DaSeason {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Season> selectAllSeason() throws SQLException {
        List<Season> seasons = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.season");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Season s = new Season();
                s.setSeasonId(rs.getInt("season_id"));
                s.setSeasonName(rs.getString("season_name"));
                s.setDescription(rs.getString("season_description"));

                seasons.add(s);
            }

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return seasons;
    }
    
     public static Season selectOneByIdSeason(int seasonId) {
        Season s = new Season();

        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM omandb.season WHERE season_id=" + seasonId + "");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                s.setSeasonId(rs.getInt("season_id"));
                s.setSeasonName(rs.getString("season_name"));
                s.getDescription(rs.getString("season_description"));


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return s;
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

    public static void deleteSeason(Season s) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("DELETE FROM omandb.season WHERE season_id=" + s.getSeasonId() + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void insertSeason(Season s) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.season "
                    + "(name, description) VALUES (?,?)");
            stmt.setString(1, s.getSeasonName());
            stmt.setString(2, s.getDescription());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

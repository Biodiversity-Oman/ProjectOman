/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Download;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Oualid
 */
public class DaDownload {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Download> selectAll() throws SQLException {

        List<Download> downloads = new ArrayList();
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM download");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Download download = new Download();
                download.setDownloadId(rs.getInt("download_id"));
                download.setWorldId(rs.getInt("world_id"));
                download.setDownloadFunStuff(rs.getString("download_funstuff"));
                downloads.add(download);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return downloads;
    }

    public static Download selectOneByID(int id) throws SQLException {

        Download download = new Download();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM download WHERE download_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            download.setDownloadId(id);
            download.setWorldId(rs.getInt("world_id"));
            download.setDownloadFunStuff(rs.getString("download_funstuff"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return download;
    }

    public static List<Download> selectAllByWorld(int id) throws SQLException {

        List<Download> downloads = new ArrayList();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM download WHERE world_id=" + id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Download download = new Download();
                download.setDownloadId(rs.getInt("download_id"));
                download.setWorldId(rs.getInt("world_id"));
                download.setDownloadFunStuff(rs.getString("download_funstuff"));
                downloads.add(download);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return downloads;
    }

    public static void insert(Download download) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO download"
                    + "(world_id, download_funstuff) VALUES(?, ?)");
            stmt.setInt(1, download.getWorldId());
            stmt.setString(2, download.getDownloadFunStuff());
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void delete(int id) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM download WHERE download_id=" + id);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void update(Download download) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE download SET world_id=?, "
                    + "download_funstuff=? WHERE download_id=?");
            stmt.setInt(1, download.getWorldId());
            stmt.setString(2, download.getDownloadFunStuff());
            stmt.setInt(3, download.getDownloadId());
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

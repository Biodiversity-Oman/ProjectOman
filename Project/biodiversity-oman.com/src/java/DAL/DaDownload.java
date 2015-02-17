/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Download;
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
public class DaDownload {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Download> selectAllDownload() throws SQLException {
        List<Download> downloads = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.downloads");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Download download = new Download();
                download.setDownloadId(rs.getInt("downloads_id"));
                download.setWorldId(rs.getInt("world_id"));
                download.setDownloadFunStuff(rs.getString("download_funstuff"));
                downloads.add(download);
            }
            
            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return downloads;
    }
    
    public static Download selectOneByIDDownload(int id) throws SQLException {
        Download download = new Download();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.downloads WHERE downloads_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            download.setDownloadId(id);
            download.setWorldId(rs.getInt("world_id"));
            download.setDownloadFunStuff(rs.getString("download_funstuff"));
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return download;
    }
    
    public static List<Download> selectAllByWorldDownload(int id) throws SQLException {
        List<Download> downloads = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.downloads WHERE world_id=" + id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Download download = new Download();
                download.setDownloadId(rs.getInt("downloads_id"));
                download.setWorldId(rs.getInt("world_id"));
                download.setDownloadFunStuff(rs.getString("download_funstuff"));
                downloads.add(download);
            }
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        
        return downloads;
    }
    
    public static void insertDownload(Download download) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.downloads" +
                    "(world_id, download_funstuff) VALUES(?, ?)");
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
    
    public static void deleteDownload(int id) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM omandb.downloads WHERE downloads_id=" + id);
            stmt.executeUpdate();
            
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    public static void updateDownload(Download download) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE omandb.downloads SET world_id=?, "
                    + "download_funstuff=? WHERE downloads_id=?");
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

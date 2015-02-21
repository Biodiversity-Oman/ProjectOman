/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.*;
import java.io.*;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Tom
 */
public class DaPost {

    private static Connection conn;
    private static PreparedStatement stmt;

//    public  Image getPhoto()
//    {
//        try {
//            conn = DataSource.getConnection();
//            stmt = conn.prepareStatement("select photo from post");
//           ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                image = ImageIO.read(rs.getBinaryStream("post_photo"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DaPost.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(DaPost.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return image;
//         
//            
//               
//    }
    public static List<Post> selectAllPost() throws SQLException {
        List<Post> posts = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.post");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                Post p = new Post();
                p.setPostId(rs.getInt("post_id"));
                p.setOrganismId(rs.getInt("organism_id"));
                p.setPostFirstName(rs.getString("post_first_name"));
                p.setPostLastName(rs.getString("post_last_name"));
                p.setPostEmail(rs.getString("post_email"));
                p.setPostDescription(rs.getString("post_description"));
                p.setPostPhoto(rs.getBytes("post_photo"));
                p.setPostLongitude(rs.getString("post_longitude"));
                p.setPostLatitude(rs.getString("post_latitude"));
                posts.add(p);
            }

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return posts;
    }

    public static Post selectOneByIdPost(int id) throws SQLException {
        Post p = new Post();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.post WHERE post_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            p.setOrganismId(rs.getInt("organism_id"));
            p.setPostFirstName(rs.getString("post_first_name"));
            p.setPostLastName(rs.getString("post_last_name"));
            p.setPostEmail(rs.getString("post_email"));
            p.setPostDescription(rs.getString("post_description"));
            p.setPostPhoto(rs.getBytes("post_photo"));
            p.setPostLongitude(rs.getString("post_longitude"));
            p.setPostLatitude(rs.getString("post_latitude"));

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return p;
    }

    public static List<Post> selectAllPostByOrganisme(int organismId) throws SQLException {
        List<Post> posts = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.post WHERE organism_id=" + organismId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post p = new Post();
                p.setPostId(rs.getInt("post_id"));
                p.setPostFirstName(rs.getString("post_first_name"));
                p.setPostLastName(rs.getString("post_last_name"));
                p.setPostEmail(rs.getString("post_email"));
                p.setPostDescription(rs.getString("post_description"));
                p.setPostPhoto(rs.getBytes("post_photo"));
                p.setPostLongitude(rs.getString("post_longitude"));
                p.setPostLatitude(rs.getString("post_latitude"));
                posts.add(p);
            }

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return posts;
    }

    public static void insertPost(Post p) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO omandb.post (organism_id, post_first_name, post_last_name, post_email, post_description,  post_longitude, post_latitude VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getOrganismId());
            stmt.setString(2, p.getPostFirstName());
            stmt.setString(3, p.getPostLastName());
            stmt.setString(4, p.getPostEmail());
            stmt.setString(5, p.getPostDescription());
            stmt.setString(6, p.getPostLongitude());
            stmt.setString(7, p.getPostLatitude());

            stmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public String insertPostPhoto(String file, int postId) throws SQLException, FileNotFoundException {
        try {
            File f = new File(file);
            FileInputStream fins = new FileInputStream(f);
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO omandb.post set post_photo=? where id =" + postId);
            stmt.setBinaryStream(1, fins);
            stmt.execute();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conn.close();
        return file;
    }

    public static void deletePost(int id) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("DELETE FROM omandb.post WHERE post_id=" + id);
            stmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void updatePost(Post p) throws SQLException {
        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE omandb.post SET (organism_id, post_first_name, post_last_name, post_email, post_description,  post_longitude, post_latitude VALUES(?, ?, ?, ?, ?, ?, ?, ?)  WHERE post_id=" + p.getPostId());
            stmt.setInt(1, p.getOrganismId());
            stmt.setString(2, p.getPostFirstName());
            stmt.setString(3, p.getPostLastName());
            stmt.setString(4, p.getPostEmail());
            stmt.setString(5, p.getPostDescription());
            stmt.setString(6, p.getPostLongitude());
            stmt.setString(7, p.getPostLatitude());

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

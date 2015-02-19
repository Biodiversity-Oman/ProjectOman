/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Tom
 */
public class DaPost {

    private static Connection conn;
    private static PreparedStatement stmt;
    Image image;

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
    public List<Post> selectAllPost() throws SQLException {
        List<Post> posts = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.post");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                image = ImageIO.read(rs.getBinaryStream("post_photo"));
                Post p = new Post();
                p.setOrganismId(rs.getInt("organism_id"));
                p.setPostFirstName(rs.getString("post_first_name"));
                p.setPostLastName(rs.getString("post_last_name"));
                p.setPostEmail("post_email");
                p.setPostDescription("post_description");
                p.setPostPhoto(image);
                p.setPostLongitude("post_longitude");
                p.setPostLatitude("post_latitude");
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

    public Post selectOneByIdPost(int id) throws SQLException {
        Post p = new Post();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.post WHERE post_id=" + id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            p.setOrganismId(rs.getInt("organism_id"));
            p.setPostFirstName(rs.getString("post_first_name"));
            p.setPostLastName("post_last_name");
            p.setPostEmail("post_email");
            p.setPostDescription("post_description");
            p.setPostPhoto(image);
            p.setPostLongitude("post_longitude");
            p.setPostLatitude("post_latitude");

            conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return p;
    }

    public List<Post> selectAllPostByOrganisme(int organismId) throws SQLException {
        List<Post> posts = new ArrayList();

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("SELECT * FROM omandb.post WHERE organism_id=" + organismId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                image = ImageIO.read(rs.getBinaryStream("post_photo"));
                Post p = new Post();
                p.setPostId(rs.getInt("post_id"));
                p.setPostFirstName(rs.getString("post_first_name"));
                p.setPostLastName("post_last_name");
                p.setPostEmail("post_email");
                p.setPostDescription("post_description");
                p.setPostPhoto(image);
                p.setPostLongitude("post_longitude");
                p.setPostLatitude("post_latitude");
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Foutje", JOptionPane.INFORMATION_MESSAGE);
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

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
//    }
	public static List<Post> selectAll() throws SQLException {

		List<Post> posts = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT post.post_id, post.post_email,"
				+ "post.organism_id, organism.common_name AS organism_name\n"
				+ "FROM post\n"
				+ "LEFT JOIN organism ON post.organism_id = organism.organism_id");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Post p = new Post();
			p.setPostId(rs.getInt("post_id"));
			p.setPostEmail(rs.getString("post_email"));
			p.setOrganismId(rs.getInt("organism_id"));
			p.setOrganismName(rs.getString("organism_name"));
			posts.add(p);
		}
		conn.close();
		return posts;
	}

	public static Post selectOneByID(int id) throws SQLException {

		Post p = new Post();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM post WHERE post_id=?");
                stmt.setInt(1, id);
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
		return p;
	}

	public static List<Post> selectAllByOrganism(int organismId) throws SQLException {

		List<Post> posts = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT * FROM post WHERE organism_id=?");
                stmt.setInt(1, organismId);
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
		conn.close();
		return posts;
	}

	public static void insert(Post p) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO post (organism_id, post_first_name, post_last_name, post_email, post_description,  post_longitude, post_latitude VALUES(?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, p.getOrganismId());
			stmt.setString(2, p.getPostFirstName());
			stmt.setString(3, p.getPostLastName());
			stmt.setString(4, p.getPostEmail());
			stmt.setString(5, p.getPostDescription());
			stmt.setString(6, p.getPostLongitude());
			stmt.setString(7, p.getPostLatitude());
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			System.out.println(ex.getMessage());
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

//    public String insertPostPhoto(String file, int postId) throws SQLException, FileNotFoundException {
//        try {
//            File f = new File(file);
//            FileInputStream fins = new FileInputStream(f);
//            conn = DataSource.getConnection();
//            stmt = conn.prepareStatement("INSERT INTO post set post_photo=? where id =" + postId);
//            stmt.setBinaryStream(1, fins);
//            stmt.execute();
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//            conn.rollback();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        conn.close();
//        return file;
//    }
	public static void delete(int id) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("DELETE FROM post WHERE post_id=?");
                        stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static void update(Post p) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE post SET (organism_id=?, post_first_name=?, "
					+ "post_last_name=?, post_email=?, post_description=?,  post_longitude=?, post_latitude=? WHERE post_id=?");
			stmt.setInt(1, p.getOrganismId());
			stmt.setString(2, p.getPostFirstName());
			stmt.setString(3, p.getPostLastName());
			stmt.setString(4, p.getPostEmail());
			stmt.setString(5, p.getPostDescription());
			stmt.setString(6, p.getPostLongitude());
			stmt.setString(7, p.getPostLatitude());
                        stmt.setInt(1, p.getPostId());
			conn.commit();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}
}

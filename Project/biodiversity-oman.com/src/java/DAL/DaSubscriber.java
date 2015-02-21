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
public class DaSubscriber {

    private static Connection conn;
    private static PreparedStatement stmt;

    public static List<Subscriber> selectAllSubscriber() {

        List<Subscriber> subScriber = new ArrayList<>();
        try {
            conn = DataSource.getConnection();
            stmt = conn.prepareStatement("SELECT subscriber_id, subscriber_firstname, subscriber_lastname, subscriber_email FROM subscriber");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Subscriber s = new Subscriber();
                s.setSubscriberId(rs.getInt("subscriber_id"));
                s.setSubscriberFirstName(rs.getString("subscriber_firstname"));
                s.setSubscriberLastName(rs.getString("subscriber_lastname"));
                s.setSubscriberEmail(rs.getString("subscriber_email"));
                subScriber.add(s);
            }
            conn.commit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return subScriber;
    }

    public static void insertSubscriber(Subscriber s) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("INSERT INTO subscriber (subscriber_firstname, subscriber_lastname, subscriber_email) VALUES (?,?,?)");
            stmt.setString(1, s.getSubscriberFirstName());
            stmt.setString(2, s.getSubscriberFirstName());
            stmt.setString(3, s.getSubscriberEmail());
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            System.out.println(ex.getMessage());

        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void deleteSubscriber(int subScriberId) throws SQLException {

        try {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("DELETE FROM subscriber WHERE subscriber_id=" + subScriberId + "");
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            conn.rollback();
            System.out.println(ex.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
    }

}

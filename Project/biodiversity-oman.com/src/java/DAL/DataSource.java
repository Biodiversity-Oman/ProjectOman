/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lennyasus
 */
public class DataSource {

    public static java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/omandb", "admin", "0manDiversity");
    }
}

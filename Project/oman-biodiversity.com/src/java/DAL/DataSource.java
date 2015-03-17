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

    private static boolean language;


    public static java.sql.Connection getConnection() throws SQLException {
       
        if (isLanguage()) {
            return (DriverManager.getConnection("jdbc:mysql://localhost:3306/omandb", "oman", "0manDiversity"));
        } else {
            return (DriverManager.getConnection("jdbc:mysql://localhost:3306/omandbarabic", "oman", "0manDiversity"));
        }

    
    }

   
    /**
     * @return the language
     */
    public static boolean isLanguage() {
        return language;
    }

    /**
     * @param aLanguage the language to set
     */
    public static void setLanguage(boolean aLanguage) {
        language = aLanguage;
    }
}
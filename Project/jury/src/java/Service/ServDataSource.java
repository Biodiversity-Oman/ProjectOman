/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAL.DataSource;
import java.sql.SQLException;

/**
 *
 * @author Tom
 */
public class ServDataSource {
    public static void switchDataSource(boolean language) throws SQLException{
       
           DataSource.setLanguage(language);
       
      
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.*;
import DAL.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Tom
 */
public class ServSubscriber {
    
    public static List selectAllSubsriber() throws SQLException {
        
        return DaSubscriber.selectAll();
    }
    
    public static boolean checkSubscriber(String email) throws SQLException {

		return DaSubscriber.checkIfExists(email);
	}
    
    public static String insertSubscriber(String firstName, String lastName, String email) throws SQLException {
        
        try {
            if (DaSubscriber.checkIfExists(email) == false) {
                Subscriber s = new Subscriber();
                s.setSubscriberFirstName(firstName);
                s.setSubscriberLastName(lastName);
                s.setSubscriberEmail(email);
                DaSubscriber.insert(s);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }
    
    public static void deleteSubsriber(int id) throws SQLException {
        
        DaSubscriber.delete(id);
    }
    
}

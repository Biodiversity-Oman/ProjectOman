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
		
		return DaSubscriber.selectAllSubscriber();
	}
	
	public static void insertSubscriber(String firstName, String lastName, String email) throws SQLException {
            
           // Subscriber s = new Subscriber();
         
            
           
	}
	
	public static void deleteSubsriber(int id) throws SQLException{
		
		DaSubscriber.deleteSubscriber(id);
	}
    
    
}
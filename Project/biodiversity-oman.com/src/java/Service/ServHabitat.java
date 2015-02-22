/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Habitat;
import DAL.DaHabitat;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lennyasus
 */
public class ServHabitat {
	
	public static List selectAllHabitats() throws SQLException {
		
		return DaHabitat.selectAll();
	}
        
        
	
	public static void insertHabitat(String name, String description) throws SQLException {
		
		Habitat habitat = new Habitat();
		habitat.setHabitatName(name);
		habitat.setHabitatDescription(description);
		DaHabitat.insertHabitat(habitat);
	}
	
	public static void deleteHabitat(int id) throws SQLException{
		
		DaHabitat.deleteHabitat(id);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Family;
import DAL.DaFamily;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class ServFamily {
    
    public static List selectAllFamily() throws SQLException {
		
		return DaFamily.selectAllfamily();
	}
	
	public static void insertFamily(String name, String description, int worldId) throws SQLException {
            
            Family fam = new Family();
            fam.setDescription(description);
            fam.setFamilyName(name);
            fam.setWorldId(worldId);
            
            DaFamily.insertFamily(fam);
	}
	
	public static void deleteFamily(int id) throws SQLException{
		
		DaFamily.deleteFamily(id);
	}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.SubFamily;
import DAL.DaSubFamily;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class ServSubFamily {
    
    public static List selectAllSubFamily() throws SQLException {
		
		return DaSubFamily.selectAllSubfamily();
	}
	
	public static void insertSubFamily(String name, String description, int familyId) throws SQLException {
            
            SubFamily subfam = new SubFamily();
            subfam.setSubFamilyDescription(description);
            subfam.setSubfamilyName(name);
            subfam.setFamilyId(familyId);
            
            DaSubFamily.insertSubfamily(subfam);
	}
	
	public static void deleteSubFamily(int id) throws SQLException{
		
		DaSubFamily.deleteSubfamily(id);
	}
    
}

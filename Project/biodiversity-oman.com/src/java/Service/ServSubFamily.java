/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Subfamily;
import DAL.DaSubFamilyold;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class ServSubFamily {
    
    public static List selectAllSubFamily() throws SQLException {
		
		return DaSubFamilyold.selectAllSubfamily();
	}
	
	public static void insertSubFamily(String name, String description, int familyId) throws SQLException {
            
            Subfamily subfam = new Subfamily();
            subfam.setSubFamilyDescription(description);
            subfam.setSubfamilyName(name);
            subfam.setFamilyId(familyId);
            
            DaSubFamilyold.insertSubfamily(subfam);
	}
	
	public static void deleteSubFamily(int id) throws SQLException{
		
		DaSubFamilyold.deleteSubfamily(id);
	}
    
}

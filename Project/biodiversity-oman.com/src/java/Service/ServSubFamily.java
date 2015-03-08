/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.*;
import DAL.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class ServSubFamily {
    
    public static boolean checkSubFamilyExist(String subFamilyName) throws SQLException {

		return DaSubfamily.checkIfExists(subFamilyName);
	}

	public static List selectAllSubFamily() throws SQLException {

		return DaSubfamily.selectAll();
	}
        
         public static BLL.Subfamily selectOneById(int id) throws SQLException {

                return DaSubfamily.selectOneByID(id);
         
         }
        

	public static void insertSubFamily(String name, String description, int familyId) throws SQLException {

		Subfamily subfam = new Subfamily();
		subfam.setSubFamilyDescription(description);
		subfam.setSubfamilyName(name);
		subfam.setFamilyId(familyId);

		DaSubfamily.insert(subfam);
	}
        
        public static void updateSubFamily(String name, String description, int familyId,int subFamilyId) throws SQLException {

		Subfamily subfam = new Subfamily();
		subfam.setSubFamilyDescription(description);
		subfam.setSubfamilyName(name);
		subfam.setFamilyId(familyId);
                subfam.setSubfamilyId(subFamilyId);

		DaSubfamily.update(subfam);
	}
        
        

	public static void deleteSubFamily(int id) throws SQLException {

		DaSubfamily.delete(id);
	}
        
        public static List SearchSubFamily(String keyword) throws SQLException {
                
        return DaSubfamily.searchSubfamily(keyword);
    }

}

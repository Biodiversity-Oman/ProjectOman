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
		
		return DaFamily.selectAll();
    }

    public static String insertFamily(String name, String description, int worldId) {

		try {
			if(DaFamily.checkIfExists(name) == false ){
				Family fam = new Family();
				fam.setFamilyDescription(description);
				fam.setFamilyName(name);
				fam.setWorldId(worldId);
				DaFamily.insert(fam);
				return "succes";
			} else {
				return "exists";
			}
		} catch (SQLException ex) {
			return "sql";
		}
    }

    public static void deleteFamily(int id) throws SQLException {

		DaFamily.delete(id);
    }

    public static String updateFamily(String familyName, String familydescription, int familyWorldId, int familyId) {
		
		try {
			Family f = new Family();
			f.setFamilyName(familyName);
			f.setFamilyDescription(familydescription);
			f.setFamilyWorldName(familyName);
			f.setWorldId(familyWorldId);
			f.setFamilyId(familyId);
			DaFamily.update(f);
			return "succes";
		} catch(SQLException ex) {
			return "sql";
		}
        
    }

    public static BLL.Family selectOneById(int id) throws SQLException {

        return DaFamily.selectOneByID(id);
    }
}

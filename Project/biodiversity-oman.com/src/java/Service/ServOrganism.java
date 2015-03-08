/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAL.DaOrganism;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bert
 */
public class ServOrganism {

    public static byte[] selectPhotoById(int id) {
		
		byte[] photo = new byte[2];
		try {
			 photo =  DAL.DaOrganism.selectPhotoById(id);
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
		return photo;
    }

    public static BLL.Organism selectOneById(int id) throws SQLException {
		
        return DaOrganism.selectOneById(id);
    }

    // Anders dan bij de dal methodes worden hier de parameters als primitive types meegegeven. Geen Lists of objecten maar variables
    // en arrays. In deze methode worden ze in objecten gestoken om naar de DAL te sturen.
    public static String insert(String scientificname, String commonname, String localname, String description,
            int subfamilyid, int[] habitatid, String population, int[] seasonid,
            Boolean indigenous, Boolean cultivated, Boolean endangered, Boolean medicinal,
            String benefits, String dangerous, String threats, String opportunities, byte[] photo, String links,
            int[] eatenbyorganismid, int[] eatingorganismid, String foodname,
            String fooddescription, int[] geolocationid) {
		
		try {
			if (!DaOrganism.checkOrganismExist(scientificname)) {
				List<BLL.Habitat> habitat = new ArrayList<>();
				List<BLL.Season> season = new ArrayList<>();
				List<BLL.Organism> eatenbyorganism = new ArrayList<>();
				List<BLL.Organism> eatingorganism = new ArrayList<>();
				List<BLL.Geolocation> geolocation = new ArrayList<>();
				if (habitatid != null) {
					for (int i = 0; i < habitatid.length; i++) {
						habitat.add(new BLL.Habitat(Array.getInt(habitatid, i)));
					}
				}
				if (seasonid != null) {
					for (int i = 0; i < seasonid.length; i++) {
						season.add(new BLL.Season(Array.getInt(seasonid, i)));
					}
				}
				if (eatenbyorganismid != null) {
					for (int i = 0; i < eatenbyorganismid.length; i++) {
						eatenbyorganism.add(new BLL.Organism(Array.getInt(eatenbyorganismid, i)));
					}
				}
				if (eatingorganismid != null) {
					for (int i = 0; i < eatingorganismid.length; i++) {
						eatingorganism.add(new BLL.Organism(Array.getInt(eatingorganismid, i)));
					}
				}
				if (geolocationid != null) {
					for (int i = 0; i < geolocationid.length; i++) {
						geolocation.add(new BLL.Geolocation(Array.getInt(geolocationid, i)));
					}
				}
				DaOrganism.insert(new BLL.Organism(scientificname, commonname, localname, description,
						new BLL.Subfamily(subfamilyid), habitat, population, season,
						indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats,
						opportunities, photo, links, eatenbyorganism, eatingorganism, foodname,
						fooddescription, geolocation));
				return "succes";
			} else {
				return "exists";
			}
		} catch (SQLException ex) {
			return "sql";
		}
    }

    // Anders dan bij de dal methodes worden hier de parameters als primitive types meegegeven. Geen Lists of objecten maar variables
    // en arrays. In deze methode worden ze in objecten gestoken om naar de DAL te sturen.
    public static String update(int id, String scientificname, String commonname, String localname, 
            String description, int subfamilyid, int[] habitatid, String population,
            int[] seasonid, Boolean indigenous, Boolean cultivated, Boolean endangered, Boolean medicinal,
            String benefits, String dangerous, String threats, String opportunities, byte[] photo, String links,
            int[] eatenbyorganismid, int[] eatingorganismid, String foodname,
            String fooddescription, int[] geolocationid, Boolean validated)  {
		
		try {
			if (!DaOrganism.checkOrganismExist(scientificname, id)) {
				List<BLL.Habitat> habitat = new ArrayList<>();
				List<BLL.Season> season = new ArrayList<>();
				List<BLL.Organism> eatenbyorganism = new ArrayList<>();
				List<BLL.Organism> eatingorganism = new ArrayList<>();
				List<BLL.Geolocation> geolocation = new ArrayList<>();
				if (habitatid != null) {
					for (int i = 0; i < habitatid.length; i++) {
						habitat.add(new BLL.Habitat(Array.getInt(habitatid, i)));
					}
				}
				if (seasonid != null) {
					for (int i = 0; i < seasonid.length; i++) {
						season.add(new BLL.Season(Array.getInt(seasonid, i)));
					}
				}
				if (eatenbyorganismid != null) {
					for (int i = 0; i < eatenbyorganismid.length; i++) {
						eatenbyorganism.add(new BLL.Organism(Array.getInt(eatenbyorganismid, i)));
					}
				}
				if (eatingorganismid != null) {
					for (int i = 0; i < eatingorganismid.length; i++) {
						eatingorganism.add(new BLL.Organism(Array.getInt(eatingorganismid, i)));
					}
				}
				if (geolocationid != null) {
					for (int i = 0; i < geolocationid.length; i++) {
						geolocation.add(new BLL.Geolocation(Array.getInt(geolocationid, i)));
					}
				}
				DaOrganism.update(new BLL.Organism(id, scientificname, commonname, localname,
						description, new BLL.Subfamily(subfamilyid),  habitat, population,
						season, indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats,
						opportunities, photo, links, eatenbyorganism, eatingorganism, foodname,
						fooddescription, geolocation, validated));
				return "succes";
			} else {
				return "exists";
			}
		} catch (SQLException ex) {
			return "sql";
		}
    }

    public static String updatePending(int id, String scientificname, String commonname, String localname, String description,
            int subfamilyid, int[] habitatid, String population,
            int[] seasonid, Boolean indigenous, Boolean cultivated, Boolean endangered, Boolean medicinal,
            String benefits, String dangerous, String threats, String opportunities, byte[] photo, String links,
            int[] eatenbyorganismid, int[] eatingorganismid, String foodname,
            String fooddescription, int[] geolocationid, Boolean validated) {
		
		try {
			if (!DaOrganism.checkOrganismExist(scientificname, id)) {
				List<BLL.Habitat> habitat = new ArrayList<>();
				List<BLL.Season> season = new ArrayList<>();
				List<BLL.Organism> eatenbyorganism = new ArrayList<>();
				List<BLL.Organism> eatingorganism = new ArrayList<>();
				List<BLL.Geolocation> geolocation = new ArrayList<>();
				if (habitatid != null) {
					for (int i = 0; i < habitatid.length; i++) {
						habitat.add(new BLL.Habitat(Array.getInt(habitatid, i)));
					}
				}
				if (seasonid != null) {
					for (int i = 0; i < seasonid.length; i++) {
						season.add(new BLL.Season(Array.getInt(seasonid, i)));
					}
				}
				if (eatenbyorganismid != null) {
					for (int i = 0; i < eatenbyorganismid.length; i++) {
						eatenbyorganism.add(new BLL.Organism(Array.getInt(eatenbyorganismid, i)));
					}
				}
				if (eatingorganismid != null) {
					for (int i = 0; i < eatingorganismid.length; i++) {
						eatingorganism.add(new BLL.Organism(Array.getInt(eatingorganismid, i)));
					}
				}
				if (geolocationid != null) {
					for (int i = 0; i < geolocationid.length; i++) {
						geolocation.add(new BLL.Geolocation(Array.getInt(geolocationid, i)));
					}
				}
				DaOrganism.updatePending(new BLL.Organism(id, scientificname, commonname, localname,
						description, new BLL.Subfamily(subfamilyid), habitat, population,
						season, indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats,
						opportunities, photo, links, eatenbyorganism, eatingorganism, foodname,
						fooddescription, geolocation, validated));
				return "succes";
			} else {
				return "exists";
			}
		} catch (SQLException ex) {
			return "sql";
		}
    }

    public static void delete(int id) throws SQLException {
	
        DaOrganism.deleteOrganism(id);
    }

    public static List selectOrganismsToValidate() throws SQLException {
		
        return DaOrganism.selectAllForValidation();
    }

    public static List selectOrganismsPublished() throws SQLException {
		
        return DaOrganism.selectAllPublished();
    }

    public static void PublishFromQueue(int organismId) throws SQLException {

       DaOrganism.publishFromQueue(organismId);
    }
    
    public static List SearchOrganism(String keyword) throws SQLException {
                
        return DaOrganism.searchOrganismTable(keyword);
    }
    
    public static List SearchOrganismPending(String keyword) throws SQLException {
                
        return DaOrganism.searchOrganismPendingTable(keyword);
    }
    
    public static List SelectEaten() throws SQLException {
                
        return DaOrganism.selectEaten();
    }
}

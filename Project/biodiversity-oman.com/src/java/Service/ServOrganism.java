/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAL.DaOrganism;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bert
 */
public class ServOrganism {
    
    public static java.util.List<BLL.Organism> selectAll()
    {
        return DaOrganism.sellectAll();
    }
    
    public static BLL.Organism selectOneById(int id)
    {
        return DaOrganism.selectOneById(id);
    }
    
    // Anders dan bij de dal methodes worden hier de parameters als primitive types meegegeven. Geen Lists of objecten maar variables
    // en arrays. In deze methode worden ze in objecten gestoken om naar de DAL te sturen.
    public static String insert(String scientificname, String commonname, String localname, String description,
                        int subfamilyid, int familyid, int worldid, int[] habitatid, String population, 
                        int[] seasonid, Boolean indigenous, Boolean cultivated, Boolean endangered, Boolean medicinal,
                        String benefits, String dangerous, String threats, String opportunities, byte[] photo, String links,
                        int[] eatenbyorganismid, int[] eatingorganismid, Boolean validated, String foodname, 
                        String fooddescription,int[] geolocationid)
    {
        int result;
        if (!DaOrganism.checkOrganismExist(scientificname))
        {
            java.util.List<BLL.Habitat> habitat = new java.util.ArrayList<>();
            java.util.List<BLL.Season> season = new java.util.ArrayList<>();
            java.util.List<BLL.Organism> eatenbyorganism = new java.util.ArrayList<>();
            java.util.List<BLL.Organism> eatingorganism = new java.util.ArrayList<>();
            java.util.List<BLL.Geolocation> geolocation = new java.util.ArrayList<>();

            for (int i =0; i < habitatid.length; i++)          {habitat.add(new BLL.Habitat(java.lang.reflect.Array.getInt(habitatid, i)));}
            for (int i =0; i < seasonid.length; i++)           {season.add(new BLL.Season(java.lang.reflect.Array.getInt(seasonid, i)));}
            for (int i =0; i < eatenbyorganismid.length; i++)  {eatenbyorganism.add(new BLL.Organism(java.lang.reflect.Array.getInt(eatenbyorganismid, i)));}
            for (int i =0; i < eatingorganismid.length; i++)   {eatingorganism.add(new BLL.Organism(java.lang.reflect.Array.getInt(eatingorganismid, i)));}
            for (int i =0; i < geolocationid.length; i++)      {geolocation.add(new BLL.Geolocation(java.lang.reflect.Array.getInt(geolocationid, i)));}

            result = DaOrganism.insertOrganism(new BLL.Organism(scientificname, commonname, localname, description,
                                        new BLL.Subfamily(subfamilyid), new BLL.Family(familyid), new BLL.World(worldid), habitat,
                                        population, season, indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats,
                                        opportunities, photo, links, eatenbyorganism, eatingorganism, validated, foodname, 
                                        fooddescription, geolocation));
        }
        else
        {
            return "error1";
        }
        if (result < 1)  {return "error2";}
        return "succes";
    }
    
    // Anders dan bij de dal methodes worden hier de parameters als primitive types meegegeven. Geen Lists of objecten maar variables
    // en arrays. In deze methode worden ze in objecten gestoken om naar de DAL te sturen.
    public static String update(int id, String scientificname, String commonname, String localname, String description,
                        int subfamilyid, int familyid, int worldid, int[] habitatid, String population, 
                        int[] seasonid, Boolean indigenous, Boolean cultivated, Boolean endangered, Boolean medicinal,
                        String benefits, String dangerous, String threats, String opportunities, byte[] photo, String links,
                        int[] eatenbyorganismid, int[] eatingorganismid, Boolean validated, String foodname, 
                        String fooddescription,int[] geolocationid)
    {
        int result;
        if (!DaOrganism.checkOrganismExist(scientificname, id))
        {
            java.util.List<BLL.Habitat> habitat = new java.util.ArrayList<>();
            java.util.List<BLL.Season> season = new java.util.ArrayList<>();
            java.util.List<BLL.Organism> eatenbyorganism = new java.util.ArrayList<>();
            java.util.List<BLL.Organism> eatingorganism = new java.util.ArrayList<>();
            java.util.List<BLL.Geolocation> geolocation = new java.util.ArrayList<>();

            for (int i =0; i < habitatid.length; i++)          {habitat.add(new BLL.Habitat(java.lang.reflect.Array.getInt(habitatid, i)));}
            for (int i =0; i < seasonid.length; i++)           {season.add(new BLL.Season(java.lang.reflect.Array.getInt(seasonid, i)));}
            for (int i =0; i < eatenbyorganismid.length; i++)  {eatenbyorganism.add(new BLL.Organism(java.lang.reflect.Array.getInt(eatenbyorganismid, i)));}
            for (int i =0; i < eatingorganismid.length; i++)   {eatingorganism.add(new BLL.Organism(java.lang.reflect.Array.getInt(eatingorganismid, i)));}
            for (int i =0; i < geolocationid.length; i++)      {geolocation.add(new BLL.Geolocation(java.lang.reflect.Array.getInt(geolocationid, i)));}

            result = DaOrganism.updateOrganism(new BLL.Organism(id, scientificname, commonname, localname, description,
                                        new BLL.Subfamily(subfamilyid), new BLL.Family(familyid), new BLL.World(worldid), habitat,
                                        population, season, indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats,
                                        opportunities, photo, links, eatenbyorganism, eatingorganism, validated, foodname, 
                                        fooddescription, geolocation));
        }
        else
        {
            return "An organism with this scientific name allready exists.";
        }
        if (result < 1)  {return "Service not available. Please contact an administrator if the problem persists.";}
        return "The organism was updated successfully.";
    }
    
    public static String delete(int id)
    {
        int result = DaOrganism.deleteOrganism(id);
        
        if (result < 1)  {return "Service not available. Please contact an administrator if the problem persists.";}
        return "The organism was added successfully.";
    }
    
    public static List selectOrganismsToValidate()
    {
	return DaOrganism.selectAllForValidation();
    }
    public static List selectOrganismsPublished()
    {
	return DaOrganism.selectAllPublished();
    }
}

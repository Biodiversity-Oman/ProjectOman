/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT;
import BLL.*;
import DAL.*;
import java.util.List;
/**
 *
 * @author bert
 */
public class UtDaOrganism {
    
    public static void main(String[] args)
    {
        SubFamily sf = new SubFamily();
        sf.setSubfamilyId(1);
        Season season1 = new Season();
        season1.setSeasonId(1);
        Season season2 = new Season();
        season2.setSeasonId(2);
        List<Season> seasons = new java.util.ArrayList<>();
        seasons.add(season1);
        seasons.add(season2);
        
        Organism newOrganism = new Organism();
        newOrganism.setBenefits("benefitinserttest");
        newOrganism.setCommonName("CommonNameTest");
        newOrganism.setCultivated(Boolean.TRUE);
        newOrganism.setValidated(Boolean.TRUE);
        newOrganism.setSubfamily(sf);
        newOrganism.setSeason(seasons);
        
        
        int newOrganismId = 0;
        try{
        newOrganismId = DaOrganism.insertOrganism(newOrganism);
        }
        catch(java.sql.SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        List<Organism> organisms = DaOrganism.sellectAll();
        
        System.out.println("-----Select All organisms-----");
        for (Organism o : organisms) {
            System.out.println(o.getCommonName());
        }
        
        if (newOrganismId > 0)
        {
            Organism organism = DaOrganism.selectOneById(newOrganismId);
            System.out.println("-----Select one organism-----");
            System.out.println(organism.getCommonName());
            System.out.println(organism.getSubfamily().getSubfamilyName());
            int i=1;
            for (Season s : organism.getSeason()) {
                System.out.println("Season " + i + ": " + s.getSeasonName());
                i++;
            }
        }
        else
        {
            System.out.println("ErrorCode: "+ newOrganismId);
        }
        
        SubFamily sf2 = new SubFamily();
        sf.setSubfamilyId(2);
        
        Season season3 = new Season();
        season3.setSeasonId(3);
        Season season4 = new Season();
        season4.setSeasonId(4);
        List<Season> seasons2 = new java.util.ArrayList<>();
        seasons.add(season3);
        seasons.add(season4);
        
        Organism updatedOrganism = new Organism();
        updatedOrganism.setOrganismId(newOrganismId);
        updatedOrganism.setBenefits("updatedbenefit");
        updatedOrganism.setCommonName("CommonNameUpdated");
        updatedOrganism.setCultivated(false);
        updatedOrganism.setValidated(false);
        updatedOrganism.setSubfamily(sf2);
        updatedOrganism.setSeason(seasons2);
        DaOrganism.updateOrganism(updatedOrganism);
        
        if (newOrganismId > 0)
        {
            Organism organism = DaOrganism.selectOneById(newOrganismId);
            System.out.println("-----updated organism-----");
            System.out.println(organism.getCommonName());
            System.out.println(organism.getSubfamily().getSubfamilyName());
            int i=1;
            for (Season s : organism.getSeason()) {
                System.out.println("Season " + i + ": " + s.getSeasonName());
                i++;
            }
        }
        else
        {
            System.out.println("ErrorCode: "+ newOrganismId);
        }
        
    }
}
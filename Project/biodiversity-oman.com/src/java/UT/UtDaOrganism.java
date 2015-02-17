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
        sf.setSubFamilyId(1);
        
        Organism newOrganism = new Organism();
        newOrganism.setBenefits("benefitinserttest");
        newOrganism.setCommonName("CommonNameTest");
        newOrganism.setCultivated(Boolean.TRUE);
        newOrganism.setValidated(Boolean.TRUE);
        newOrganism.setSubFamily(sf);
        
        try{
        DaOrganism.insertOrganism(newOrganism);
        }
        catch(java.sql.SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        List<Organism> organisms = DaOrganism.sellectAll();
        
        System.out.println("Select All organisms:");
        for (Organism o : organisms) {
            System.out.println(o.getCommonName());
        }
        
//        Organism organism = DaOrganism.selectOneById(2);
//        System.out.println("Select one organism:");
//        System.out.println(organism.getCommonName());
//        organism = DaOrganism.selectOneById(3);
//        System.out.println("Select one organism:");
//        System.out.println(organism.getCommonName());
//        organism = DaOrganism.selectOneById(4);
//        System.out.println("Select one organism:");
//        System.out.println(organism.getCommonName());
//        organism = DaOrganism.selectOneById(5);
//        System.out.println("Select one organism:");
//        System.out.println(organism.getCommonName());
//        organism = DaOrganism.selectOneById(6);
//        System.out.println("Select one organism:");
//        System.out.println(organism.getCommonName());
    }
}
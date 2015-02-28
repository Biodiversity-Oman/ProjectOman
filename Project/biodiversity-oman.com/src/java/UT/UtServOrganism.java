/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT;

import Service.ServOrganism;

/**
 *
 * @author bert
 */
public class UtServOrganism {
    
    public static void main(String[] args)
    {
        int[] habitatid = { 2, 3 };
        int[] seasonid = { 2, 3 };
        int[] eatenbyorganismid = { 2, 3 };
        int[] eatingorganismid = { 2, 3 };
        int[] geolocationid = { 2, 3 };
        byte[] photo = new byte[10];
        
        String message = ServOrganism.insert("scientificnamenewserv", "commonnamenewserv", "localnamenewserv", "descriptionnewserv", 
                1, 1, 1, habitatid, "populationnewserv", seasonid, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                "benefitsnewserv", "dangerousnewserv", "threatsnewserv", "opportunitiesnewserv", photo, "linksnewserv",
                eatenbyorganismid, eatingorganismid, Boolean.TRUE, "foodnamenewserv", "fooddescriptionnewserv", geolocationid);
        
        System.out.println(message);
        ServOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());
        });
        
        message = ServOrganism.update(1, "scientificnameupdateserv", "commonnameupdateserv", "localnameupdateserv", "descriptionupdateserv", 
                2, 2, 2, habitatid, "populationupdateserv", seasonid, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                "benefitsupdateserv", "dangerousupdateserv", "threatsupdateserv", "opportunitiesupdateserv", photo, "linksupdateserv",
                eatenbyorganismid, eatingorganismid, Boolean.FALSE, "foodnameupdateserv", "fooddescriptionupdateserv", geolocationid);
        
        System.out.println(message);
        ServOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());
        });
        
        message = ServOrganism.delete(4);
        System.out.println(message);
        ServOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());
        });

    }
}

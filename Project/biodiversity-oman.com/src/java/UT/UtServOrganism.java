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
        int[] habitatid = { 1, 2 };
        int[] seasonid = { 1, 2 };
        int[] eatenbyorganismid = { 1, 2 };
        int[] eatingorganismid = { 1, 2 };
        int[] geolocationid = { 1, 2 };
        
        String message = ServOrganism.insert("scientificnamenewserv", "commonnamenewserv", "localnamenewserv", "descriptionnewserv", 
                1, 1, 1, habitatid, "populationnewserv", seasonid, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                "benefitsnewserv", "dangerousnewserv", "threatsnewserv", "opportunitiesnewserv", Byte.MIN_VALUE, "linksnewserv",
                eatenbyorganismid, eatingorganismid, Boolean.TRUE, "foodnamenewserv", "fooddescriptionnewserv", geolocationid);
        
        System.out.println(message);
        ServOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());
        });

    }
}

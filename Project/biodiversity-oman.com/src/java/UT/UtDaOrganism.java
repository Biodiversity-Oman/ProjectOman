/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT;
import BLL.*;
import DAL.*;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author bert
 */
public class UtDaOrganism {
    
    public static void main(String[] args) throws SQLException
    {
        // De objecten waarmee gewerkt gaat worden.
        // Als eerst de objecten waarmee het organisme in relatie zal staan.
        SubFamilyold subfamilyNew = new SubFamilyold();
        subfamilyNew.setSubfamilyId(1);
        
        Season seasonNew1 = new Season();
        seasonNew1.setSeasonId(1);
        Season seasonNew2 = new Season();
        seasonNew2.setSeasonId(2);
        List<Season> seasonsNew = new java.util.ArrayList<>();
        seasonsNew.add(seasonNew1);
        seasonsNew.add(seasonNew2);
        
        Habitat habitatNew1 = new Habitat();
        habitatNew1.setHabitatId(1);
        Habitat habitatNew2 = new Habitat();
        habitatNew2.setHabitatId(2);
        List<Habitat> habitatsNew = new java.util.ArrayList<>();
        habitatsNew.add(habitatNew1);
        habitatsNew.add(habitatNew2);
        
        Organism eatenByOrganismNew1 = new Organism();
        eatenByOrganismNew1.setOrganismId(2);
        Organism eatenByOrganismNew2 = new Organism();
        eatenByOrganismNew2.setOrganismId(3);
        List<Organism> eatenByOrganismsNew = new java.util.ArrayList<>();
        eatenByOrganismsNew.add(eatenByOrganismNew1);
        eatenByOrganismsNew.add(eatenByOrganismNew2);
        
        Organism eatingOrganismNew1 = new Organism();
        eatingOrganismNew1.setOrganismId(4);
        Organism eatingOrganismNew2 = new Organism();
        eatingOrganismNew2.setOrganismId(5);
        List<Organism> eatingOrganismsNew = new java.util.ArrayList<>();
        eatingOrganismsNew.add(eatenByOrganismNew1);
        eatingOrganismsNew.add(eatenByOrganismNew2);
        
        GeoLocationold geoLocationNew1 = new GeoLocationold();
        geoLocationNew1.setGeolocationId(1);
        GeoLocationold geoLocationNew2 = new GeoLocationold();
        geoLocationNew2.setGeolocationId(2);
        List<GeoLocationold> geoLocationsNew = new java.util.ArrayList();
        geoLocationsNew.add(geoLocationNew1);
        geoLocationsNew.add(geoLocationNew2);
        
        Organism organismNew = new Organism();
        //organismNew.setScientificName("ScientificNameInsert");
        organismNew.setCommonName("CommonNameInsert");
        organismNew.setLocalName("LocalNameInsert");
        organismNew.setSubfamily(subfamilyNew);
        organismNew.setDescription("DescriptionNew");
        organismNew.setPopulation("PopulationNew");
        organismNew.setIndigenous(Boolean.TRUE);
        organismNew.setCultivated(Boolean.TRUE);
        organismNew.setEndangered(Boolean.TRUE);
        organismNew.setMedicinal(Boolean.TRUE);
        organismNew.setBenefits("BenefitsNew");
        organismNew.setDangerous("DangerousNew");
        organismNew.setThreats("ThreatsNew");
        organismNew.setOpportunities("OpportunitiesNew");
        organismNew.setLinks("LinksNew");
        organismNew.setFoodName("FoodNameNew");
        organismNew.setFoodDescription("FoodDescriptionNew");
        organismNew.setValidated(Boolean.TRUE);
        organismNew.setSeason(seasonsNew);
        organismNew.setHabitat(habitatsNew);
        organismNew.setEatenByOrganism(eatenByOrganismsNew);
        organismNew.setEatingOrganisms(eatingOrganismsNew);
        organismNew.setGeolocations(geoLocationsNew);
        
        // Var om het id van de geïnserted organism in op te slaan.
        int organismIdNew = 0;
        
        // Methode om het organisme in de db op te slaan.
        organismIdNew = DaOrganism.insertOrganism(organismNew);

        // Methode welke een List retourneerd met alle organismes aanwezig in de databank.
        List<Organism> organisms = DaOrganism.sellectAll();
        
        // Resultaten van de selectAll() methode worden afgeprint in de console.
        System.out.println("-----Select All organisms-----");
        for (Organism o : organisms) {
            System.out.println(o.getCommonName());
        }
        
        // Details van het nieuwe organisme.
        if (organismIdNew > 0)
        {
            // selectOneById() methode welke een organisme retourneerd, in dit geval het organisme dat net werd aangemaakt.
            Organism organism = DaOrganism.selectOneById(organismIdNew);
            System.out.println("-----Select one organism-----");
            System.out.println("Id: " + Integer.toString(organism.getOrganismId()));
            System.out.println("ScientificName: " + organism.getScientificName());
            System.out.println("CommonName: " + organism.getCommonName());
            System.out.println("LocalName: " + organism.getLocalName());
            System.out.println("SubFamily: " + organism.getSubfamily().getSubfamilyName());
            System.out.println("Description: " + organism.getDescription());
            System.out.println("Population: " + organism.getPopulation());
            System.out.println("Indigenous: " + Boolean.toString(organism.getIndigenous()));
            System.out.println("Cultivated: " + Boolean.toString(organism.getCultivated()));
            System.out.println("Endangered: " + Boolean.toString(organism.getEndangered()));
            System.out.println("Medicinal: " + Boolean.toString(organism.getMedicinal()));
            System.out.println("Benefits: " + organism.getBenefits());
            System.out.println("Dangerous: " + organism.getDangerous());
            System.out.println("Threats: " + organism.getThreats());
            System.out.println("Opportunities: " + organism.getOpportunities());
            System.out.println("Links: " + organism.getLinks());
            System.out.println("FoodName: " + organism.getFoodName());
            System.out.println("FoodDescription: " + organism.getFoodDescription());
            System.out.println("IsValidated: " + organism.getValidated());
            System.out.println("InsertedOn: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(organism.getInsertedOn()));
            System.out.println("Seasons: ");
            for (Season s : organism.getSeason()) {System.out.println(s.getSeasonName() + ", ");}
            System.out.println("Habitats: ");
            for (Habitat h : organism.getHabitat()) {System.out.println(h.getHabitatName() + ", ");}
            System.out.println("EatenByOrganisms: ");
            for (Organism o : organism.getEatenByOrganism()) {System.out.println(o.getCommonName() + ", ");}
            System.out.println("EatingOrganisms: ");
            for (Organism o : organism.getEatingOrganisms()) {System.out.println(o.getCommonName() + ", ");}
            System.out.println("GeoLocations: ");
            for (GeoLocationold g : organism.getGeolocations()) {System.out.println(g.getAreaName() + ", ");}
        }
        else
        {
            System.out.println("ErrorCode: "+ organismIdNew);
        }
        
//        SubFamily sf2 = new SubFamily();
//        sf2.setSubfamilyId(2);
//        
//        Season season3 = new Season();
//        season3.setSeasonId(3);
//        Season season4 = new Season();
//        season4.setSeasonId(4);
//        List<Season> seasons2 = new java.util.ArrayList<>();
//        seasons2.add(season3);
//        seasons2.add(season4);
//        
//        Organism updatedOrganism = new Organism();
//        updatedOrganism.setOrganismId(newOrganismId);
//        updatedOrganism.setBenefits("updatedbenefit");
//        updatedOrganism.setCommonName("CommonNameUpdated");
//        updatedOrganism.setCultivated(false);
//        updatedOrganism.setValidated(false);
//        updatedOrganism.setSubfamily(sf2);
//        updatedOrganism.setSeason(seasons2);
//        DaOrganism.updateOrganism(updatedOrganism);
//        
//        if (newOrganismId > 0)
//        {
//            Organism organism = DaOrganism.selectOneById(newOrganismId);
//            System.out.println("-----updated organism-----");
//            System.out.println(organism.getCommonName());
//            System.out.println(organism.getSubfamily().getSubfamilyName());
//            int i=1;
//            for (Season s : organism.getSeason()) {
//                System.out.println("Season " + i + ": " + s.getSeasonName());
//                i++;
//            }
//        }
//        else
//        {
//            System.out.println("ErrorCode: "+ newOrganismId);
//        }
        
    }
}
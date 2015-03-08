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
        Organism organismNew = new Organism();
        Organism organismUpdate = new Organism();
        Organism organismSelectOne = new Organism();
        
        // De objecten waarmee een insert van een organisme op uitgevoerd worden.
        Subfamily subfamilyNew = new Subfamily();
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
        eatenByOrganismNew1.setOrganismId(1);
        Organism eatenByOrganismNew2 = new Organism();
        eatenByOrganismNew2.setOrganismId(2);
        List<Organism> eatenByOrganismsNew = new java.util.ArrayList<>();
        eatenByOrganismsNew.add(eatenByOrganismNew1);
        eatenByOrganismsNew.add(eatenByOrganismNew2);
        
        Organism eatingOrganismNew1 = new Organism();
        eatingOrganismNew1.setOrganismId(3);
        Organism eatingOrganismNew2 = new Organism();
        eatingOrganismNew2.setOrganismId(4);
        List<Organism> eatingOrganismsNew = new java.util.ArrayList<>();
        eatingOrganismsNew.add(eatingOrganismNew1);
        eatingOrganismsNew.add(eatingOrganismNew2);
        
        Geolocation geoLocationNew1 = new Geolocation();
        geoLocationNew1.setGeolocationId(1);
        Geolocation geoLocationNew2 = new Geolocation();
        geoLocationNew2.setGeolocationId(2);
        List<Geolocation> geoLocationsNew = new java.util.ArrayList();
        geoLocationsNew.add(geoLocationNew1);
        geoLocationsNew.add(geoLocationNew2);
        
        organismNew.setScientificName("ScientificNameInsert");
        organismNew.setCommonName("CommonNameInsert");
        organismNew.setLocalName("LocalNameInsert");
        organismNew.setSubfamily(subfamilyNew);
        organismNew.setDescription("DescriptionInsert");
        organismNew.setPopulation("PopulationInsert");
        organismNew.setIndigenous(Boolean.TRUE);
        organismNew.setCultivated(Boolean.FALSE);
        organismNew.setEndangered(Boolean.TRUE);
        organismNew.setMedicinal(Boolean.FALSE);
        organismNew.setBenefits("BenefitsInsert");
        organismNew.setDangerous("DangerousInsert");
        organismNew.setThreats("ThreatsNew");
        organismNew.setOpportunities("OpportunitiesInsert");
        organismNew.setLinks("LinksInsert");
        organismNew.setFoodName("FoodNameInsert");
        organismNew.setFoodDescription("FoodDescriptionInsert");
        organismNew.setValidated(Boolean.FALSE);
        
        organismNew.setSeason(seasonsNew);
        organismNew.setHabitat(habitatsNew);
        organismNew.setEatenByOrganism(eatenByOrganismsNew);
        organismNew.setEatingOrganisms(eatingOrganismsNew);
        organismNew.setGeolocations(geoLocationsNew);
        
        // Var om het id van de geïnserted organism in op te slaan.
        int organismIdNew = 0;
        
        // Methode om het organisme in de db op te slaan.
        
        // Resultaten van de selectAll() methode worden afgeprint in de console.
        System.out.println("-----Select All organisms-----");
        DaOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());
        });
        
        if (DaOrganism.checkOrganismExist(organismNew.getScientificName())) 
        {
            System.out.println("---- organismNew exists: true ----");
            System.out.println("---- insert aborted ----");
        }
        else    
        {
            System.out.println("---- organismNew exists: false ----");
            System.out.println("---- insert succeeded ----");
            organismIdNew = DaOrganism.insert(organismNew);
            
            // Resultaten van de selectAll() methode worden afgeprint in de console.
            System.out.println("-----Select All organisms-----");
            DaOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());
        });
        }
        

        
        // Details van het nieuwe organisme.
        if (organismIdNew > 0)
        {
            // selectOneById() methode welke een organisme retourneerd, in dit geval het organisme dat net werd aangemaakt.
            organismSelectOne = DaOrganism.selectOneById(organismIdNew);
            System.out.println("-----Select one organism (inserted)-----");
            System.out.println("Id: " + Integer.toString(organismSelectOne.getOrganismId()));
            System.out.println("ScientificName: " + organismSelectOne.getScientificName());
            System.out.println("CommonName: " + organismSelectOne.getCommonName());
            System.out.println("LocalName: " + organismSelectOne.getLocalName());
            System.out.println("Subfamily: " + organismSelectOne.getSubfamily().getSubfamilyName());
            System.out.println("Description: " + organismSelectOne.getDescription());
            System.out.println("Population: " + organismSelectOne.getPopulation());
            System.out.println("Indigenous: " + Boolean.toString(organismSelectOne.getIndigenous()));
            System.out.println("Cultivated: " + Boolean.toString(organismSelectOne.getCultivated()));
            System.out.println("Endangered: " + Boolean.toString(organismSelectOne.getEndangered()));
            System.out.println("Medicinal: " + Boolean.toString(organismSelectOne.getMedicinal()));
            System.out.println("Benefits: " + organismSelectOne.getBenefits());
            System.out.println("Dangerous: " + organismSelectOne.getDangerous());
            System.out.println("Threats: " + organismSelectOne.getThreats());
            System.out.println("Opportunities: " + organismSelectOne.getOpportunities());
            System.out.println("Links: " + organismSelectOne.getLinks());
            System.out.println("FoodName: " + organismSelectOne.getFoodName());
            System.out.println("FoodDescription: " + organismSelectOne.getFoodDescription());
            System.out.println("IsValidated: " + organismSelectOne.getValidated());
            System.out.println("InsertedOn: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(organismSelectOne.getInsertedOn()));
            System.out.println("Seasons: ");
            for (Season s : organismSelectOne.getSeason()) {System.out.println("- " + s.getSeasonName());}
            System.out.println("Habitats: ");
            for (Habitat h : organismSelectOne.getHabitat()) {System.out.println("- " + h.getHabitatName());}
            System.out.println("EatenByOrganisms: ");
            for (Organism o : organismSelectOne.getEatenByOrganism()) {System.out.println("- " + o.getCommonName());}
            System.out.println("EatingOrganisms: ");
            for (Organism o : organismSelectOne.getEatingOrganisms()) {System.out.println("- " + o.getCommonName());}
            System.out.println("Geolocations: ");
            for (Geolocation g : organismSelectOne.getGeolocations()) {System.out.println("- " + g.getAreaName());}

        
            // Objecten om een update mee uit te voeren op een organismen.
            Subfamily subfamilyUpdate = new Subfamily();
            subfamilyUpdate.setSubfamilyId(2);

            Season seasonUpdate1 = new Season();
            seasonUpdate1.setSeasonId(3);
            Season seasonUpdate2 = new Season();
            seasonUpdate2.setSeasonId(4);
            List<Season> seasonsUpdate = new java.util.ArrayList<>();
            seasonsUpdate.add(seasonUpdate1);
            seasonsUpdate.add(seasonUpdate2);

            Habitat habitatUpdate1 = new Habitat();
            habitatUpdate1.setHabitatId(3);
            Habitat habitatUpdate2 = new Habitat();
            habitatUpdate2.setHabitatId(4);
            List<Habitat> habitatsUpdate = new java.util.ArrayList<>();
            habitatsUpdate.add(habitatUpdate1);
            habitatsUpdate.add(habitatUpdate2);

            Organism eatenByOrganismUpdate1 = new Organism();
            eatenByOrganismUpdate1.setOrganismId(3);
            Organism eatenByOrganismUpdate2 = new Organism();
            eatenByOrganismUpdate2.setOrganismId(4);
            List<Organism> eatenByOrganismsUpdate = new java.util.ArrayList<>();
            eatenByOrganismsUpdate.add(eatenByOrganismUpdate1);
            eatenByOrganismsUpdate.add(eatenByOrganismUpdate2);

            Organism eatingOrganismUpdate1 = new Organism();
            eatingOrganismUpdate1.setOrganismId(1);
            Organism eatingOrganismUpdate2 = new Organism();
            eatingOrganismUpdate2.setOrganismId(2);
            List<Organism> eatingOrganismsUpdate = new java.util.ArrayList<>();
            eatingOrganismsUpdate.add(eatingOrganismUpdate1);
            eatingOrganismsUpdate.add(eatingOrganismUpdate2);

            Geolocation geoLocationUpdate1 = new Geolocation();
            geoLocationUpdate1.setGeolocationId(3);
            Geolocation geoLocationUpdate2 = new Geolocation();
            geoLocationUpdate2.setGeolocationId(4);
            List<Geolocation> geoLocationsUpdate = new java.util.ArrayList();
            geoLocationsUpdate.add(geoLocationUpdate1);
            geoLocationsUpdate.add(geoLocationUpdate2);

            
            // Het Id wordt hier meegegeven zodat de methode weet welk organisme eht moet updaten.
            organismUpdate.setOrganismId(organismIdNew);
            organismUpdate.setScientificName("Dhofari goat");
            organismUpdate.setCommonName("CommonNameUpdate");
            organismUpdate.setLocalName("LocalNameUpdate");
            organismUpdate.setSubfamily(subfamilyUpdate);
            organismUpdate.setDescription("DescriptionUpdate");
            organismUpdate.setPopulation("PopulationUpdate");
            organismUpdate.setIndigenous(Boolean.FALSE);
            organismUpdate.setCultivated(Boolean.TRUE);
            organismUpdate.setEndangered(Boolean.FALSE);
            organismUpdate.setMedicinal(Boolean.TRUE);
            organismUpdate.setBenefits("BenefitsUpdate");
            organismUpdate.setDangerous("DangerousUpdate");
            organismUpdate.setThreats("ThreatsUpdate");
            organismUpdate.setOpportunities("OpportunitiesUpdate");
            organismUpdate.setLinks("LinksUpdate");
            organismUpdate.setFoodName("FoodNameUpdate");
            organismUpdate.setFoodDescription("FoodDescriptionUpdate");
            organismUpdate.setValidated(Boolean.TRUE);


            organismUpdate.setSeason(seasonsUpdate);
            organismUpdate.setHabitat(habitatsUpdate);
            organismUpdate.setEatenByOrganism(eatenByOrganismsUpdate);
            organismUpdate.setEatingOrganisms(eatingOrganismsUpdate);
            organismUpdate.setGeolocations(geoLocationsUpdate);

            if (DaOrganism.checkOrganismExist(organismUpdate.getScientificName(), organismIdNew)) 
            {

                System.out.println("---- organismUpdate exists: true ----");
                System.out.println("---- update aborted ----");
            }
            else
            {
                DaOrganism.update(organismUpdate);
                System.out.println("---- organismUpdate exists: false ----");
                System.out.println("---- update succeeded ----");
                
                // selectOneById() methode welke een organisme retourneerd, in dit geval het organisme dat aangepast werd aangemaakt.
                organismSelectOne = DaOrganism.selectOneById(organismIdNew);
                System.out.println("-----Select one organism (updated)-----");
                System.out.println("Id: " + Integer.toString(organismSelectOne.getOrganismId()));
                System.out.println("ScientificName: " + organismSelectOne.getScientificName());
                System.out.println("CommonName: " + organismSelectOne.getCommonName());
                System.out.println("LocalName: " + organismSelectOne.getLocalName());
                System.out.println("Subfamily: " + organismSelectOne.getSubfamily().getSubfamilyName());
                System.out.println("Description: " + organismSelectOne.getDescription());
                System.out.println("Population: " + organismSelectOne.getPopulation());
                System.out.println("Indigenous: " + Boolean.toString(organismSelectOne.getIndigenous()));
                System.out.println("Cultivated: " + Boolean.toString(organismSelectOne.getCultivated()));
                System.out.println("Endangered: " + Boolean.toString(organismSelectOne.getEndangered()));
                System.out.println("Medicinal: " + Boolean.toString(organismSelectOne.getMedicinal()));
                System.out.println("Benefits: " + organismSelectOne.getBenefits());
                System.out.println("Dangerous: " + organismSelectOne.getDangerous());
                System.out.println("Threats: " + organismSelectOne.getThreats());
                System.out.println("Opportunities: " + organismSelectOne.getOpportunities());
                System.out.println("Links: " + organismSelectOne.getLinks());
                System.out.println("FoodName: " + organismSelectOne.getFoodName());
                System.out.println("FoodDescription: " + organismSelectOne.getFoodDescription());
                System.out.println("IsValidated: " + organismSelectOne.getValidated());
                System.out.println("UpdatedOn: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(organismSelectOne.getUpdatedOn()));
                System.out.println("Seasons: ");
                for (Season s : organismSelectOne.getSeason()) {System.out.println("- " + s.getSeasonName());}
                System.out.println("Habitats: ");
                for (Habitat h : organismSelectOne.getHabitat()) {System.out.println("- " + h.getHabitatName());}
                System.out.println("EatenByOrganisms: ");
                for (Organism o : organismSelectOne.getEatenByOrganism()) {System.out.println("- " + o.getCommonName());}
                System.out.println("EatingOrganisms: ");
                for (Organism o : organismSelectOne.getEatingOrganisms()) {System.out.println("- " + o.getCommonName());}
                System.out.println("Geolocations: ");
                for (Geolocation g : organismSelectOne.getGeolocations()) {System.out.println("- " + g.getAreaName());}

                System.out.println("-----Delete organismUpdate-----");
                DaOrganism.deleteOrganism(organismIdNew);
            }
            
            // Resultaten van de selectAll() methode worden afgeprint in de console.
            System.out.println("-----Select All organisms -----");
            DaOrganism.selectAll().stream().forEach((o) -> {
            System.out.println(o.getCommonName());});
        }
        else
        {
            System.out.println("ErrorCode: "+ organismIdNew);
        }
    }
}
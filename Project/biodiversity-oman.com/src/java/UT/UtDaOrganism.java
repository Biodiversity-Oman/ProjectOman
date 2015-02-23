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
        // De objecten waarmee een insert van een organisme op uitgevoerd worden.
        SubFamily subfamilyNew = new SubFamily();
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
        eatingOrganismsNew.add(eatingOrganismNew1);
        eatingOrganismsNew.add(eatingOrganismNew2);
        
        GeoLocation geoLocationNew1 = new GeoLocation();
        geoLocationNew1.setGeolocationId(1);
        GeoLocation geoLocationNew2 = new GeoLocation();
        geoLocationNew2.setGeolocationId(2);
        List<GeoLocation> geoLocationsNew = new java.util.ArrayList();
        geoLocationsNew.add(geoLocationNew1);
        geoLocationsNew.add(geoLocationNew2);
        
        Organism organismNew = new Organism();
        organismNew.setScientificName("ScientificNameInsert10000");
        organismNew.setCommonName("CommonNameInsert10000");
        organismNew.setLocalName("LocalNameInsert");
        organismNew.setSubfamily(subfamilyNew);
        organismNew.setDescription("DescriptionInsert");
        organismNew.setPopulation("PopulationInsert");
        organismNew.setIndigenous(Boolean.TRUE);
        organismNew.setCultivated(Boolean.TRUE);
        organismNew.setEndangered(Boolean.TRUE);
        organismNew.setMedicinal(Boolean.TRUE);
        organismNew.setBenefits("BenefitsInsert");
        organismNew.setDangerous("DangerousInsert");
        organismNew.setThreats("ThreatsNew");
        organismNew.setOpportunities("OpportunitiesInsert");
        organismNew.setLinks("LinksInsert");
        organismNew.setFoodName("FoodNameInsert");
        organismNew.setFoodDescription("FoodDescriptionInsert");
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
            System.out.println("-----Select one organism (inserted)-----");
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
            for (Season s : organism.getSeason()) {System.out.println("- " + s.getSeasonName());}
            System.out.println("Habitats: ");
            for (Habitat h : organism.getHabitat()) {System.out.println("- " + h.getHabitatName());}
            System.out.println("EatenByOrganisms: ");
            for (Organism o : organism.getEatenByOrganism()) {System.out.println("- " + o.getCommonName());}
            System.out.println("EatingOrganisms: ");
            for (Organism o : organism.getEatingOrganisms()) {System.out.println("- " + o.getCommonName());}
            System.out.println("GeoLocations: ");
            for (GeoLocation g : organism.getGeolocations()) {System.out.println("- " + g.getAreaName());}
        }
        else
        {
            System.out.println("ErrorCode: "+ organismIdNew);
        }
        
        // Objecten om een update mee uit te voeren op een organismen.
        SubFamily subfamilyUpdate = new SubFamily();
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
        eatenByOrganismUpdate1.setOrganismId(4);
        Organism eatenByOrganismUpdate2 = new Organism();
        eatenByOrganismUpdate2.setOrganismId(5);
        List<Organism> eatenByOrganismsUpdate = new java.util.ArrayList<>();
        eatenByOrganismsUpdate.add(eatenByOrganismUpdate1);
        eatenByOrganismsUpdate.add(eatenByOrganismUpdate2);
        
        Organism eatingOrganismUpdate1 = new Organism();
        eatingOrganismUpdate1.setOrganismId(2);
        Organism eatingOrganismUpdate2 = new Organism();
        eatingOrganismUpdate2.setOrganismId(3);
        List<Organism> eatingOrganismsUpdate = new java.util.ArrayList<>();
        eatingOrganismsUpdate.add(eatingOrganismUpdate1);
        eatingOrganismsUpdate.add(eatingOrganismUpdate2);
        
        GeoLocation geoLocationUpdate1 = new GeoLocation();
        geoLocationUpdate1.setGeolocationId(3);
        GeoLocation geoLocationUpdate2 = new GeoLocation();
        geoLocationUpdate2.setGeolocationId(4);
        List<GeoLocation> geoLocationsUpdate = new java.util.ArrayList();
        geoLocationsUpdate.add(geoLocationUpdate1);
        geoLocationsUpdate.add(geoLocationUpdate2);
        
        Organism organismUpdate = new Organism();
        // Het Id wordt hier meegegeven zodat de methode weet welk organisme eht moet updaten.
        organismUpdate.setOrganismId(organismIdNew);
        organismUpdate.setScientificName("ScientificNameUpdate10001");
        organismUpdate.setCommonName("CommonNameUpdate10001");
        organismUpdate.setLocalName("LocalNameUpdate");
        organismUpdate.setSubfamily(subfamilyUpdate);
        organismUpdate.setDescription("DescriptionUpdate");
        organismUpdate.setPopulation("PopulationUpdate");
        organismUpdate.setIndigenous(Boolean.TRUE);
        organismUpdate.setCultivated(Boolean.TRUE);
        organismUpdate.setEndangered(Boolean.TRUE);
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
        
        DaOrganism.updateOrganism(organismUpdate);
        // Details van de upgedated organism weergeven.
        if (organismIdNew > 0)
        {
            // selectOneById() methode welke een organisme retourneerd, in dit geval het organisme dat aangepast werd aangemaakt.
            Organism organism = DaOrganism.selectOneById(organismIdNew);
            System.out.println("-----Select one organism (updated)-----");
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
            System.out.println("UpdatedOn: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(organism.getUpdatedOn()));
            System.out.println("Seasons: ");
            for (Season s : organism.getSeason()) {System.out.println("- " + s.getSeasonName());}
            System.out.println("Habitats: ");
            for (Habitat h : organism.getHabitat()) {System.out.println("- " + h.getHabitatName());}
            System.out.println("EatenByOrganisms: ");
            for (Organism o : organism.getEatenByOrganism()) {System.out.println("- " + o.getCommonName());}
            System.out.println("EatingOrganisms: ");
            for (Organism o : organism.getEatingOrganisms()) {System.out.println("- " + o.getCommonName());}
            System.out.println("GeoLocations: ");
            for (GeoLocation g : organism.getGeolocations()) {System.out.println("- " + g.getAreaName());}
        }
        else
        {
            System.out.println("ErrorCode: "+ organismIdNew);
        }
        
    }
}
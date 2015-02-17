/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Family;
import BLL.Habitat;
import BLL.Organism;
import BLL.Post;
import BLL.Season;
import BLL.SubFamily;
import BLL.World;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bert
 * 
 * 
 */

public class DaOrganism {
    
    private static PreparedStatement stmt;
    private static Connection conn;
    
    /*  Deze methode selecteert de volgende properties van alle organisme:
        organism_id, common_name, subfamily_id, family_id en world_id.
        Deze methode is bedoelt om een snel overzicht te bieden van alle organisme in de databank.
        De reden waarom er ook foreign keys en names worden opgevraagd is zodat we de lijst in secties kunnen weergeven.
        je kan ook voor elk van deze entiteiten een aparte methode oproepen in de view maar dan moet je 3x een querie verzenden
        om hetzelfde resultaat te bekomen. Met deze select heb je alle informatie om alle organismen weer 
        te geven onderverdeeld in wereld, family en subfamily.*/
    public static List<Organism> sellectAll ()
    {
        List<Organism> organisms = new ArrayList<>();
        try {
            
            conn = DataSource.getConnection();
            
            // SQL werkt
            stmt = conn.prepareStatement("SELECT organism.organism_id, organism.common_name, organism.subfamily_id, subfamily.subfamily_name," +
                    "subfamily.family_id, family.family_name," +
                    "family.world_id, world.world_name \n" +
                    "FROM organism \n" +
                    "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id \n"+
                    "LEFT JOIN family ON subfamily.family_id = family.family_id \n" +
                    "LEFT JOIN world ON family.world_id = world.world_id \n");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Organism o = new Organism();
                SubFamily sf = new SubFamily();
                Family f = new Family();
                World w = new World();
                
                o.setOrganismId(rs.getInt("organism_id"));
                o.setCommonName(rs.getString("common_name"));
                
                sf.setSubfamilyId(rs.getInt("subfamily_id"));
                sf.setSubfamilyName(rs.getString("subfamily_name"));
                o.setSubfamily(sf);
                
                f.setFamilyId(rs.getInt("family_id"));
                f.setFamilyName(rs.getString("family_name"));
                o.setFamily(f);
                
                w.setWorldId(rs.getInt("world_id"));
                w.setWorldName(rs.getString("world_name"));
                o.setWorld(w);
                
                organisms.add(o);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return organisms;
    }
    
    public static Organism selectOneById(int id)
    {
        
        // Dit object zal geretourneerd worden.
        Organism organism = new Organism();
        try {
            // Deze lists vangen de objecten op die in een many to many relatie staan met het organisme object.
            // Eens gevuld worden ze toegekend aan de list attributen van Organism.
            List<Organism> eatingOrganisms = new ArrayList();
            List<Organism> eatenByOrganisms = new ArrayList();
            List<Habitat> habitats = new ArrayList();
            List<Season> seasons = new ArrayList();
            List<Post> posts = new ArrayList();
            
            conn = DataSource.getConnection();
            
            
            // Statement welke een organische object opvraagd met al zijn columns en one to many relaties.
            
            // SQL werkt
//            stmt = conn.prepareStatement("SELECT organism.*, subfamily.subfamily_name, family.family_name, family.family_id, worlds.name\n" +
//                                        "FROM organism\n" +
//                                        "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id\n" +
//                                        "LEFT JOIN family ON subfamily.family_id = family.family_id\n" +
//                                        "LEFT JOIN worlds ON organism.world_id = worlds.world_id\n" +
//                                        "WHERE organism.organism_id="+Integer.toString(id));
            
            stmt = conn.prepareStatement("SELECT organism.*, subfamily.subfamily_name, " +
                                        "subfamily.family_id, family.family_name, " +
                                        "family.world_id, world.world_name \n" +
                                        "FROM organism \n" +
                                        "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id \n"+
                                        "LEFT JOIN family ON subfamily.family_id = family.family_id \n" +
                                        "LEFT JOIN world ON family.world_id = world.world_id \n" +
                                        "WHERE organism.organism_id="+Integer.toString(id));
            
            ResultSet rsOrganism = stmt.executeQuery();
            
            
            // De volgende statements worden gebruikt om de many to many relaties van organism uit te lezen 
            //en de relationele objecten uit de databank te halen.
            
            // SQL Werkt
            stmt = conn.prepareStatement("SELECT food.eaten_by_organism_id, organism.common_name\n" +
                                        "FROM food\n" +
                                        "INNER JOIN organism ON food.eaten_by_organism_id = organism.organism_id\n" +
                                        "WHERE food.eating_organism_id ="+Integer.toString(id));
            ResultSet rsEatingOrganism = stmt.executeQuery();
            // SQL Werkt
            stmt = conn.prepareStatement("SELECT food.eating_organism_id, organism.common_name\n" +
                                        "FROM food\n" +
                                        "INNER JOIN organism ON food.eating_organism_id = organism.organism_id\n" +
                                        "WHERE food.eaten_by_organism_id ="+Integer.toString(id));
            ResultSet rsEatenByOrganism = stmt.executeQuery();
            // SQL Werkt
            stmt = conn.prepareStatement("SELECT habitat_organism.habitat_id, habitat.habitat_name\n" +
                                        "FROM habitat_organism\n" +
                                        "INNER JOIN habitat ON habitat_organism.habitat_id = habitat.habitat_id\n" +
                                        "WHERE habitat_organism.organism_id ="+Integer.toString(id));
            ResultSet rsHabitat = stmt.executeQuery();
            // SQL Werkt
            stmt = conn.prepareStatement("SELECT organism_season.season_id, season.name\n" +
                                        "FROM organism_season\n" +
                                        "INNER JOIN season ON organism_season.season_id = season.season_id\n" +
                                        "WHERE organism_season.organism_id ="+Integer.toString(id));
            ResultSet rsSeason = stmt.executeQuery();
            
            while(rsOrganism.next()){
                
                // De objecten voor de One to many relaties.
                SubFamily sf = new SubFamily();
                Family f = new Family();
                World w = new World();
                
                // algemene properties
                organism.setOrganismId(rsOrganism.getInt("organism_id"));
                organism.setScientificName(rsOrganism.getString("scientific_name"));
                organism.setCommonName(rsOrganism.getString("common_name"));
                organism.setLocalName(rsOrganism.getString("local_name"));
                organism.setDescription(rsOrganism.getString("organism_description"));
                organism.setPopulation(rsOrganism.getString("population"));
                organism.setIndigenous(rsOrganism.getBoolean("indigenous"));
                organism.setCultivated(rsOrganism.getBoolean("cultivated"));
                organism.setEndangered(rsOrganism.getBoolean("endangered"));
                organism.setMedicinal(rsOrganism.getBoolean("medicinal"));
                organism.setBenefits(rsOrganism.getString("benefits"));
                organism.setDangerous(rsOrganism.getString("dangerous"));
                organism.setThreats(rsOrganism.getString("threats"));
                organism.setOpportunities(rsOrganism.getString("opportunities"));
                organism.setPhoto(rsOrganism.getByte("photo"));
                organism.setLinks(rsOrganism.getString("links"));
                organism.setValidated(rsOrganism.getBoolean("isvalidated"));
                organism.setFoodName(rsOrganism.getString("food_name"));
                organism.setFoodDescription(rsOrganism.getString("food_description"));
                
                // One to many objecten
                // Er moet nog een One To many bijkomen namelijk voor alle posts te selecteren die behoren tot dit bepaald organisme.
                // Hiervoor gaat er gebruik gemaakt worden van een functie binnen DAPost welke alle posts gaat terug geven voor een bepaald organisme.
                // Deze methode moet nog geschreven worden.
                sf.setSubfamilyId(rsOrganism.getInt("subfamily_id"));
                sf.setSubfamilyName(rsOrganism.getString("subfamily_name"));
                organism.setSubfamily(sf);
                
                f.setFamilyId(rsOrganism.getInt("family_id"));
                f.setFamilyName(rsOrganism.getString("family_name"));
                organism.setFamily(f);
                
                w.setWorldId(rsOrganism.getInt("world_id"));
                w.setWorldName(rsOrganism.getString("world_name"));
                organism.setWorld(w);
            }
            
            // Many to Many objecten
            while (rsEatingOrganism.next()){
                Organism o = new Organism();
                o.setOrganismId(rsEatingOrganism.getInt("eaten_by_organism_id"));
                o.setCommonName(rsEatingOrganism.getString("common_name"));
                eatingOrganisms.add(o);
            }
            while (rsEatenByOrganism.next()){
                Organism o = new Organism();
                o.setOrganismId(rsEatenByOrganism.getInt("eating_organism_id"));
                o.setCommonName(rsEatenByOrganism.getString("common_name"));
                eatenByOrganisms.add(o);
            }
            while (rsHabitat.next()){
                Habitat h = new Habitat();
                h.setHabitatId(rsHabitat.getInt("habitat_id"));
                h.setHabitatName(rsHabitat.getString("habitat_name"));
                habitats.add(h);
            }
            while (rsSeason.next()){
                Season s = new Season();
                s.setSeasonId(rsSeason.getInt("season_id"));
                s.setSeasonName(rsSeason.getString("name"));
                seasons.add(s);
            }
            
            // De List toevoegen aan de juiste properties.
            // Deze bevatten de objecten die in een Many to Many relatie staan met het organisme.
            organism.setEatingOrganisms(eatingOrganisms);
            organism.setEatenByOrganism(eatenByOrganisms);
            organism.setHabitat(habitats);
            organism.setSeason(seasons);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return organism;
    }
    
    public static List<Organism> selectAllByNameLike(String name)
    {
        /*
        Deze methode moet het mogelijk maken om dmv een zoekopdracht organisms op te vragen
        die deelse gelijkenissen hebben met de ingevoerde waarde.
        */
        return new ArrayList<>();
    }
    
    public static List<Organism> selectAllBySubfamily(int id)
    {
        /*
        Deze methode zoekt door de databank naar organismes die behoren tot een bepaalde subfamily.
        */
        return new ArrayList<>();
    }
    
    public static List<Organism> selectAllByFamily(int id)
    {
        /*
        Deze methode zoekt door de databank naar organismes die behoren tot een bepaalde family.
        */
        return new ArrayList<>();
    }
    
    public static List<Organism> selectAllByWorld(int id)
    {
        /*
        Deze methode zoekt door de databank naar organismes die behoren tot een bepaalde family.
        */
        return new ArrayList<>();
    }
    
    public static List<Organism> selectAllByHabitat(int id)
    {
        /*
        Deze methode zoekt door de databank naar organismes die behoren tot een bepaald habitat.
        */
        return new ArrayList<>();
    }
    
    public static List<Organism> selectAllBySeason(int id)
    {
        /*
        Deze methode zoekt door de databank naar organismes die behoren tot een bepaald seizoen.
        */
        return new ArrayList<>();
    }
    
    public static void insertOrganism(Organism organism)
    {
        //String query = "INSERT INTO animals (name) VALUES ('zebra')";
        //Integer insertedId = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
    }
    
    public static void deleteOrganism(int id)
    {
        
    }
    
    public static void updateOrganism(Organism organism)
    {
        
    }
}
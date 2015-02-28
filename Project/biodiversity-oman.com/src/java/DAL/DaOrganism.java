/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.Format;
import java.text.SimpleDateFormat;
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

    // Nagaan voor doubles op alle records buiten 1. (update)
    public static boolean checkOrganismExist(String scientificname, Integer id)
    {
        try {conn = DataSource.getConnection();}
        catch (SQLException e)  {System.out.println(e.getMessage());}
        
        try 
        {
            stmt = conn.prepareStatement("SELECT 1 FROM organism\n" +
                        "WHERE organism.scientific_name = ?\n" +
                        "AND organism.organism_id not in (?)");
            stmt.setString(1, scientificname);
            stmt.setInt(2, id);

            ResultSet rsExists = stmt.executeQuery();
            if(rsExists.next())
            {
                return true;
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    // Nagaan voor doubles op alle records. (insert)
    public static boolean checkOrganismExist(String scientificname)
    {
                try {conn = DataSource.getConnection();}
        catch (SQLException e)  {System.out.println(e.getMessage());}
        
        try 
        {
            stmt = conn.prepareStatement("SELECT 1 FROM organism\n" +
                        "WHERE organism.scientific_name = ?");
            stmt.setString(1, scientificname);

            ResultSet rsExists = stmt.executeQuery();
            if(rsExists.next())
            {
                return true;
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static List<Organism> sellectAll ()
    {
            /*  Deze methode selecteert de volgende properties van alle organisme:
        organism_id, common_name, subfamily_id, family_id en world_id.
        Deze methode is bedoelt om een snel overzicht te bieden van alle organisme in de databank.
        De reden waarom er ook foreign keys en names worden opgevraagd is zodat we de lijst in secties kunnen weergeven.
        je kan ook voor elk van deze entiteiten een aparte methode oproepen in de view maar dan moet je 3x een querie verzenden
        om hetzelfde resultaat te bekomen. Met deze select heb je alle informatie om alle organismen weer 
        te geven onderverdeeld in wereld, family en subfamily.*/
        
        List<Organism> organisms = new ArrayList<>();
        
        try {
            conn = DataSource.getConnection();
            
            
            // SQL werkt
            stmt = conn.prepareStatement("SELECT organism.organism_id, organism.common_name, organism.inserted_on, organism.updated_on," + 
                    "organism.subfamily_id, subfamily.subfamily_name," +
                    "subfamily.family_id, family.family_name," +
                    "family.world_id, world.world_name \n" +
                    "FROM organism \n" +
                    "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id \n"+
                    "LEFT JOIN family ON subfamily.family_id = family.family_id \n" +
                    "LEFT JOIN world ON family.world_id = world.world_id \n");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Organism o = new Organism();
                Subfamily sf = new Subfamily();
                Family f = new Family();
                World w = new World();
                
                o.setOrganismId(rs.getInt("organism_id"));
                o.setCommonName(rs.getString("common_name"));
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                o.setInsertedOn(df.format(rs.getDate("inserted_on")));
                o.setUpdatedOn(df.format(rs.getDate("updated_on")));
                
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
            List<Geolocation> geolocations = new ArrayList<>();
            List<Post> posts = new ArrayList();
            conn = DataSource.getConnection();
            
            
            
            // Statement welke een organische object opvraagd met al zijn columns en one to many relaties.
            
            // SQL werkt
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
            stmt = conn.prepareStatement("SELECT organism_season.season_id, season.season_name\n" +
                                        "FROM organism_season\n" +
                                        "INNER JOIN season ON organism_season.season_id = season.season_id\n" +
                                        "WHERE organism_season.organism_id ="+Integer.toString(id));
            ResultSet rsSeason = stmt.executeQuery();
            // SQL Werkt
            stmt = conn.prepareStatement("SELECT geolocation_organism.geolocation_id, geolocation.area_name\n" +
                                        "FROM geolocation_organism\n" +
                                        "INNER JOIN geolocation ON geolocation_organism.geolocation_id = geolocation.geolocation_id\n" +
                                        "WHERE geolocation_organism.organism_id ="+Integer.toString(id));
            ResultSet rsGeolocation = stmt.executeQuery();
            
            while(rsOrganism.next()){
                
                // De objecten voor de One to many relaties.
                Subfamily sf = new Subfamily();
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
                organism.setPhoto(rsOrganism.getBytes("photo"));
                organism.setLinks(rsOrganism.getString("links"));
                organism.setValidated(rsOrganism.getBoolean("isvalidated"));
                organism.setFoodName(rsOrganism.getString("food_name"));
                organism.setFoodDescription(rsOrganism.getString("food_description"));
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                organism.setInsertedOn(df.format(rsOrganism.getDate("inserted_on")));
                organism.setUpdatedOn(df.format(rsOrganism.getDate("updated_on")));
                
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
                s.setSeasonName(rsSeason.getString("season_name"));
                seasons.add(s);
            }
            while (rsGeolocation.next()){
                Geolocation g = new Geolocation();
                g.setGeolocationId(rsGeolocation.getInt("geolocation_id"));
                g.setAreaName(rsGeolocation.getString("area_name"));
                geolocations.add(g);
            }
            
            // De List toevoegen aan de juiste properties.
            // Deze bevatten de objecten die in een Many to Many relatie staan met het organisme.
            organism.setEatingOrganisms(eatingOrganisms);
            organism.setEatenByOrganism(eatenByOrganisms);
            organism.setHabitat(habitats);
            organism.setSeason(seasons);
            organism.setGeolocations(geolocations);
            
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
    
    public static int insertOrganism(Organism organism)
    {
        // Return variabel. Hier wordt het id van de geïnserted organism in opgeslaan.
        int result = 0;
        
        // DAL code
        try 
        {
            // Setup variabelen
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            
            // Eerste statement: Inserten van een organisme met One To Many relaties
            stmt = conn.prepareStatement("INSERT INTO organism (scientific_name, common_name, local_name, subfamily_id, organism_description," +
                    "population, indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats, opportunities, photo, links," +
                    "food_name, food_description, isvalidated, inserted_on)\n" + 
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
                    
            stmt.setString(1, organism.getScientificName());
            stmt.setString(2, organism.getCommonName());
            stmt.setString(3, organism.getLocalName());
            stmt.setInt(4, organism.getSubfamily().getSubfamilyId());
            stmt.setString(5, organism.getDescription());
            stmt.setString(6, organism.getPopulation());
            if (organism.getIndigenous() == (null))  {stmt.setNull(7, Types.BIT);}
                else {stmt.setBoolean(7, organism.getIndigenous());}
            if (organism.getCultivated() == (null))  {stmt.setNull(8, Types.BIT);}
                else {stmt.setBoolean(8, organism.getCultivated());}
            if (organism.getEndangered() == (null))  {stmt.setNull(9, Types.BIT);}
                else {stmt.setBoolean(9, organism.getEndangered());}
            if (organism.getMedicinal() == (null))  {stmt.setNull(10, Types.BIT);}
                else {stmt.setBoolean(10, organism.getMedicinal());}
            stmt.setString(11, organism.getBenefits());
            stmt.setString(12, organism.getDangerous());
            stmt.setString(13, organism.getThreats());
            stmt.setString(14, organism.getOpportunities());
            if (organism.getPhoto() == null) {stmt.setNull(15, Types.BLOB);}
            else {stmt.setBlob(15, new javax.sql.rowset.serial.SerialBlob(organism.getPhoto()));}
            stmt.setString(16, organism.getLinks());
            stmt.setString(17, organism.getFoodName());
            stmt.setString(18, organism.getFoodDescription());
            if (organism.getValidated() == (null))  {stmt.setNull(19, Types.BIT);}
                else {stmt.setBoolean(19, organism.getValidated());}
            java.util.Calendar cal = java.util.Calendar.getInstance();
            // !Date methode retourneerd een datum zonder tijd!
            stmt.setDate(20, new java.sql.Date(cal.getTimeInMillis()));
            
            // Resultaat in de database opvragen en controleren.
            if ((result = stmt.executeUpdate()) == 0)  {throw new SQLException("Creating organism failed, no rows affected.");}
            
            // Het id dat gegenereerd werd voor het nieuwe organisme wordt opgehaald
            try(ResultSet generatedKeys = stmt.getGeneratedKeys();)
            {
            if (generatedKeys.next())   {result = (int) generatedKeys.getLong(1);}
            else {throw new SQLException("Creating organism failed, no ID obtained.");}
            }
                    
            // volgende statements zijn voor de Many To Many relaties vast te leggen.
            // season
            if(organism.getSeason() != null){
                stmt = conn.prepareStatement("INSERT INTO organism_season (organism_id, season_id) VALUES(?,?)");
                for (Season s : organism.getSeason())
                {
                    stmt.setInt(1, result);
                    stmt.setInt(2, s.getSeasonId());
                    stmt.executeUpdate();
                }}
            // habitat
            if(organism.getHabitat() != null){
                stmt = conn.prepareStatement("INSERT INTO habitat_organism (habitat_id, organism_id) VALUES(?,?)");
                for (Habitat h : organism.getHabitat()) 
                {
                    stmt.setInt(1, h.getHabitatId());
                    stmt.setInt(2, result);
                    stmt.executeUpdate();
                }}
            // EatenBy
            if(organism.getEatenByOrganism() != null){
                stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
                for (Organism o : organism.getEatenByOrganism()) 
                {
                    stmt.setInt(1, result);
                    stmt.setInt(2, o.getOrganismId());
                    stmt.executeUpdate();
                }}
            // Eating
            if(organism.getEatingOrganisms() != null){
                for (Organism o : organism.getEatingOrganisms()) 
                {
                    stmt.setInt(1, o.getOrganismId());
                    stmt.setInt(2, result);
                    stmt.executeUpdate();
                }}
            // Geolocation
            if(organism.getGeolocations() != null){
                stmt = conn.prepareStatement("INSERT INTO geolocation_organism (organism_id, geolocation_id) VALUES(?,?)");
                for (Geolocation g : organism.getGeolocations()) 
                {
                    stmt.setInt(1, result);
                    stmt.setInt(2, g.getGeolocationId());
                    stmt.executeUpdate();
                }}

            conn.commit();
        }
        
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            result = -1;
            try{conn.rollback();}
            catch (SQLException ex2){ System.out.println(ex.getMessage()); }
            
        }
        finally
        {
            try{conn.setAutoCommit(true);}
            catch (SQLException ex){ System.out.println(ex.getMessage()); }
        }
        return result;
    }
    
    public static int deleteOrganism(int id)
    {
        int result;
        try
        {
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement("DELETE FROM organism_season WHERE organism_season.organism_id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM habitat_organism WHERE habitat_organism.organism_id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM food WHERE food.eaten_by_organism_id=? OR food.eating_organism_id=?");
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM geolocation_organism WHERE geolocation_organism.organism_id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM organism WHERE organism.organism_id=?");
            stmt.setInt(1, id);
            if ((result = stmt.executeUpdate()) == 0) { throw new SQLException("Failed to delete organism with id=" + Integer.toString(id));}
        }
        catch (SQLException ex)
        {
            System.out.println("---Delete failed on organism id="+Integer.toString(id)+"---");
            result = -1;
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                conn.setAutoCommit(true);
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    
    public static int updateOrganism(Organism organism)
    {
        int result;
        try 
        {
            // Setup variabelen
            conn = DataSource.getConnection();
            conn.setAutoCommit(false);
            
            // Eerste statement: Updaten van een organisme met One To Many relaties
            stmt = conn.prepareStatement(
                    "UPDATE organism SET scientific_name = ?, common_name = ?, local_name = ?, subfamily_id = ?, " +
                    "organism_description = ?, population = ?, indigenous = ?, cultivated = ?, endangered = ?, medicinal = ?, benefits = ?, dangerous = ?, " +
                    "threats = ?, opportunities = ?, photo = ?, links = ?, food_name = ?, food_description = ?, isvalidated = ?, updated_on = ?\n" +
                    "WHERE organism.organism_id="+Integer.toString(organism.getOrganismId()));
                    
            stmt.setString(1, organism.getScientificName());
            stmt.setString(2, organism.getCommonName());
            stmt.setString(3, organism.getLocalName());
            stmt.setInt(4, organism.getSubfamily().getSubfamilyId());
            stmt.setString(5, organism.getDescription());
            stmt.setString(6, organism.getPopulation());
            if (organism.getIndigenous() == (null))  {stmt.setNull(7, Types.BIT);}
                else {stmt.setBoolean(7, organism.getIndigenous());}
            if (organism.getCultivated() == (null))  {stmt.setNull(8, Types.BIT);}
                else {stmt.setBoolean(8, organism.getCultivated());}
            if (organism.getEndangered() == (null))  {stmt.setNull(9, Types.BIT);}
                else {stmt.setBoolean(9, organism.getEndangered());}
            if (organism.getMedicinal() == (null))  {stmt.setNull(10, Types.BIT);}
                else {stmt.setBoolean(10, organism.getMedicinal());}
            stmt.setString(11, organism.getBenefits());
            stmt.setString(12, organism.getDangerous());
            stmt.setString(13, organism.getThreats());
            stmt.setString(14, organism.getOpportunities());
            //stmt.setBlob(15, new javax.sql.rowset.serial.SerialBlob(organism.getPhoto()));
            if (organism.getPhoto() == null) {stmt.setNull(15, Types.BLOB);}
            else {stmt.setBlob(15, new javax.sql.rowset.serial.SerialBlob(organism.getPhoto()));}
            stmt.setString(16, organism.getLinks());
            stmt.setString(17, organism.getFoodName());
            stmt.setString(18, organism.getFoodDescription());
            if (organism.getValidated() == (null))  {stmt.setNull(19, Types.BIT);}
                else {stmt.setBoolean(19, organism.getValidated());}
            java.util.Calendar cal = java.util.Calendar.getInstance();
            // !Date methode retourneerd een datum zonder tijd!
            stmt.setDate(20, new java.sql.Date(cal.getTimeInMillis()));
            
            // Resultaat in de database opvragen en controleren.
            if ((result = stmt.executeUpdate()) == 0)  {throw new SQLException("Update failed on organism id=" +  Integer.toString(organism.getOrganismId()));}
                    
            // volgende statements zijn voor de Many To Many relaties up te daten.
            // season
            if(organism.getSeason() != null){
                stmt = conn.prepareStatement("DELETE FROM organism_season WHERE organism_season.organism_id="+Integer.toString(organism.getOrganismId()));
                stmt.executeUpdate();
                stmt = conn.prepareStatement("INSERT INTO organism_season (organism_id, season_id) VALUES(?,?)");
                for (Season s : organism.getSeason())
                {
                    stmt.setInt(1, organism.getOrganismId());
                    stmt.setInt(2, s.getSeasonId());
                    stmt.executeUpdate();
                }}
            // habitat
            if(organism.getHabitat() != null){
                stmt = conn.prepareStatement("DELETE FROM habitat_organism WHERE habitat_organism.organism_id="+Integer.toString(organism.getOrganismId()));
                stmt.executeUpdate();
                stmt = conn.prepareStatement("INSERT INTO habitat_organism (habitat_id, organism_id) VALUES(?,?)");
                for (Habitat h : organism.getHabitat()) 
                {
                    stmt.setInt(1, h.getHabitatId());
                    stmt.setInt(2, organism.getOrganismId());
                    stmt.executeUpdate();
                }}
            // EatenBy
            if(organism.getEatenByOrganism() != null){
                stmt = conn.prepareStatement("DELETE FROM food WHERE food.eaten_by_organism_id="+Integer.toString(organism.getOrganismId()));
                stmt.executeUpdate();
                stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
                for (Organism o : organism.getEatenByOrganism()) 
                {
                    stmt.setInt(1, organism.getOrganismId());
                    stmt.setInt(2, o.getOrganismId());
                    stmt.executeUpdate();
                }}
            // Eating
            if(organism.getEatingOrganisms() != null){                
                stmt = conn.prepareStatement("DELETE FROM food WHERE food.eating_organism_id="+Integer.toString(organism.getOrganismId()));
                stmt.executeUpdate();
                stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
                for (Organism o : organism.getEatingOrganisms()) 
                {
                    stmt.setInt(1, o.getOrganismId());
                    stmt.setInt(2, organism.getOrganismId());
                    stmt.executeUpdate();
                }}
            // Geolocation
            if(organism.getGeolocations() != null){
                stmt = conn.prepareStatement("DELETE FROM geolocation_organism WHERE geolocation_organism.organism_id="+Integer.toString(organism.getOrganismId()));
                stmt.executeUpdate();
                stmt = conn.prepareStatement("INSERT INTO geolocation_organism (organism_id, geolocation_id) VALUES(?,?)");
                for (Geolocation g : organism.getGeolocations()) 
                {
                    stmt.setInt(1, organism.getOrganismId());
                    stmt.setInt(2, g.getGeolocationId());
                    stmt.executeUpdate();
                }}

            conn.commit();
        }
        
        catch(SQLException ex)
        {
            System.out.println("---Update failed on organism id="+Integer.toString(organism.getOrganismId())+"---");
            System.out.println(ex.getMessage());
            result = -1;
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                System.out.println(ex2.getMessage());
            }
        }
        finally
        {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public static List<Organism> selectAllForValidation() throws SQLException {
		List<Organism> org = new ArrayList();

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("SELECT common_name, organism_id, scientific_name, inserted_on FROM organism WHERE isvalidated = 0 ORDER BY inserted_on");
                        
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Organism o = new Organism();
                                o.setCommonName(rs.getString("common_name"));
                                o.setOrganismId(rs.getInt("organism_id"));
<<<<<<< HEAD
                                o.setScientificName(rs.getString("scientific_name"));                         
                                o.setInsertedOn(rs.getDate("inserted_on"));                                
=======
                                o.setScientificName(rs.getString("scientific_name"));
                                // Date to short date
                                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                o.setInsertedOn(df.format(rs.getDate("inserted_on")));  
                                
>>>>>>> origin/master
                                org.add(o);
			}

			conn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}

		return org;
	}
    
    public static List<Organism> selectAllPublished() throws SQLException {
		List<Organism> org = new ArrayList();

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("SELECT common_name, scientific_name, updated_on, organism_id FROM organism WHERE isvalidated = 1 ORDER BY updated_on");
                        
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Organism o = new Organism();
                                o.setCommonName(rs.getString("common_name"));
                                o.setScientificName(rs.getString("scientific_name"));
<<<<<<< HEAD
                                
                                o.setUpdatedOn(rs.getDate("updated_on"));
=======
                                // Date to short date
                                                
                                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                o.setUpdatedOn(df.format(rs.getDate("updated_on")));
>>>>>>> origin/master
                                o.setOrganismId(rs.getInt("organism_id"));
                                org.add(o);
			}

			conn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}

		return org;
	}
    
    
}
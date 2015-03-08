/*
 * DAL class for ins and outs with organism table in the database.
 * This DAL Class can be used for the basic CRUD operations of the Organism class.
 * Aside for the CRUD there are functions to select organism based on various fields inside and outside the organism table.
 */
package DAL;

import BLL.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

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
	public static boolean checkOrganismExist(String scientificname, Integer id) throws SQLException {

		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT 1 FROM organism\n"
				+ "WHERE organism.scientific_name = ?\n"
				+ "AND organism.organism_id not in (?)");
		stmt.setString(1, scientificname);
		stmt.setInt(2, id);
		ResultSet rsExists = stmt.executeQuery();
		boolean exist = rsExists.next();
		conn.close();
		return exist;
		
	}

	// Nagaan voor doubles op alle records. (insert)
	public static boolean checkOrganismExist(String scientificname) throws SQLException {

		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT 1 FROM organism\n"
				+ "WHERE organism.scientific_name = ?");
		stmt.setString(1, scientificname);
		ResultSet rsExists = stmt.executeQuery();
		boolean exist = rsExists.next();
		conn.close();
		return exist;
		
	}

	public static List<Organism> selectAll() throws SQLException {
		/*  Deze methode selecteert de volgende properties van alle organisme:
		 organism_id, common_name, subfamily_id, family_id en world_id.
		 Deze methode is bedoelt om een snel overzicht te bieden van alle organisme in de databank.
		 De reden waarom er ook foreign keys en names worden opgevraagd is zodat we de lijst in secties kunnen weergeven.
		 je kan ook voor elk van deze entiteiten een aparte methode oproepen in de view maar dan moet je 3x een querie verzenden
		 om hetzelfde resultaat te bekomen. Met deze select heb je alle informatie om alle organismen weer 
		 te geven onderverdeeld in wereld, family en subfamily.*/

		List<Organism> organisms = new ArrayList<>();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT organism.organism_id, organism.common_name, organism.inserted_on, organism.updated_on,"
				+ "organism.subfamily_id, subfamily.subfamily_name,"
				+ "subfamily.family_id, family.family_name,"
				+ "family.world_id, world.world_name \n"
				+ "FROM organism \n"
				+ "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id \n"
				+ "LEFT JOIN family ON subfamily.family_id = family.family_id \n"
				+ "LEFT JOIN world ON family.world_id = world.world_id \n"
				+ "WHERE isvalidated = 1 LIMIT 100");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			Subfamily sf = new Subfamily();
			Family f = new Family();
			World w = new World();

			o.setOrganismId(rs.getInt("organism_id"));
			o.setCommonName(rs.getString("common_name"));
			o.setInsertedOn(rs.getDate("inserted_on"));
			o.setUpdatedOn(rs.getDate("updated_on"));

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
		conn.close();
		return organisms;
	}

	public static byte[] selectPhotoById(int id) throws SQLException {

		byte[] photo = null;
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT organism.photo\n"
				+ "FROM organism\n"
				+ "WHERE organism.organism_id=" + id);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		photo = rs.getBytes("photo");
		conn.close();
		return photo;
	}

	public static Organism selectOneById(int id) throws SQLException {

		// Dit object zal geretourneerd worden.
		Organism organism = new Organism();

		// Deze lists vangen de objecten op die in een many to many relatie staan met het organisme object.
		List<Organism> eatingOrganisms = new ArrayList();
		List<Organism> eatenByOrganisms = new ArrayList();
		List<Habitat> habitats = new ArrayList();
		List<Season> seasons = new ArrayList();
		List<Geolocation> geolocations = new ArrayList<>();
		List<Post> posts = new ArrayList();
		conn = DataSource.getConnection();
		// Statement welke een organische object opvraagd met al zijn columns en one to many relaties.
		stmt = conn.prepareStatement("SELECT organism.*, subfamily.subfamily_name, "
				+ "subfamily.family_id, family.family_name, "
				+ "family.world_id, world.world_name \n"
				+ "FROM organism \n"
				+ "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id \n"
				+ "LEFT JOIN family ON subfamily.family_id = family.family_id \n"
				+ "LEFT JOIN world ON family.world_id = world.world_id \n"
				+ "WHERE organism.organism_id=" + id);
		ResultSet rsOrganism = stmt.executeQuery();

		// De volgende statements worden gebruikt om de many to many relaties van organism uit te lezen 
		stmt = conn.prepareStatement("SELECT food.eaten_by_organism_id, organism.common_name\n"
				+ "FROM food\n"
				+ "INNER JOIN organism ON food.eaten_by_organism_id = organism.organism_id\n"
				+ "WHERE food.eating_organism_id =" + id);
		ResultSet rsEatingOrganism = stmt.executeQuery();
		stmt = conn.prepareStatement("SELECT food.eating_organism_id, organism.common_name\n"
				+ "FROM food\n"
				+ "INNER JOIN organism ON food.eating_organism_id = organism.organism_id\n"
				+ "WHERE food.eaten_by_organism_id =" + id);
		ResultSet rsEatenByOrganism = stmt.executeQuery();
		stmt = conn.prepareStatement("SELECT habitat_organism.habitat_id, habitat.habitat_name\n"
				+ "FROM habitat_organism\n"
				+ "INNER JOIN habitat ON habitat_organism.habitat_id = habitat.habitat_id\n"
				+ "WHERE habitat_organism.organism_id =" + id);
		ResultSet rsHabitat = stmt.executeQuery();
		stmt = conn.prepareStatement("SELECT organism_season.season_id, season.season_name\n"
				+ "FROM organism_season\n"
				+ "INNER JOIN season ON organism_season.season_id = season.season_id\n"
				+ "WHERE organism_season.organism_id =" + id);
		ResultSet rsSeason = stmt.executeQuery();
		stmt = conn.prepareStatement("SELECT geolocation_organism.geolocation_id, geolocation.area_name\n"
				+ "FROM geolocation_organism\n"
				+ "INNER JOIN geolocation ON geolocation_organism.geolocation_id = geolocation.geolocation_id\n"
				+ "WHERE geolocation_organism.organism_id =" + id);
		ResultSet rsGeolocation = stmt.executeQuery();
		while (rsOrganism.next()) {

			// De objecten voor de One to many relaties.
			Subfamily sf = new Subfamily();
			Family f = new Family();
			World w = new World();

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
			organism.setInsertedOn(rsOrganism.getDate("inserted_on"));
			organism.setUpdatedOn(rsOrganism.getDate("updated_on"));

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
		while (rsEatingOrganism.next()) {
			Organism o = new Organism();
			o.setOrganismId(rsEatingOrganism.getInt("eaten_by_organism_id"));
			o.setCommonName(rsEatingOrganism.getString("common_name"));
			eatingOrganisms.add(o);
		}
		while (rsEatenByOrganism.next()) {
			Organism o = new Organism();
			o.setOrganismId(rsEatenByOrganism.getInt("eating_organism_id"));
			o.setCommonName(rsEatenByOrganism.getString("common_name"));
			eatenByOrganisms.add(o);
		}
		while (rsHabitat.next()) {
			Habitat h = new Habitat();
			h.setHabitatId(rsHabitat.getInt("habitat_id"));
			h.setHabitatName(rsHabitat.getString("habitat_name"));
			habitats.add(h);
		}
		while (rsSeason.next()) {
			Season s = new Season();
			s.setSeasonId(rsSeason.getInt("season_id"));
			s.setSeasonName(rsSeason.getString("season_name"));
			seasons.add(s);
		}
		while (rsGeolocation.next()) {
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
		conn.close();
		return organism;
	}

	public static List<Organism> selectAllByNameLike(String name) throws SQLException {

		List<Organism> organisms = new ArrayList<>();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT organism.organism_id, organism.common_name, organism.inserted_on, organism.updated_on,"
				+ "organism.subfamily_id, subfamily.subfamily_name,"
				+ "subfamily.family_id, family.family_name,"
				+ "family.world_id, world.world_name \n"
				+ "FROM organism \n"
				+ "LEFT JOIN subfamily ON organism.subfamily_id = subfamily.subfamily_id \n"
				+ "LEFT JOIN family ON subfamily.family_id = family.family_id \n"
				+ "LEFT JOIN world ON family.world_id = world.world_id \n"
				+ "WHERE organism.common_name like '%' + ? + '%' \n"
				+ "OR \n"
				+ "WHERE organism.scientific_name like '%' + ? + '%' \n"
				+ "OR \n"
				+ "WHERE organism.local_name like '%' + ? + '%'");
		stmt.setString(1, name);
		stmt.setString(2, name);
		stmt.setString(3, name);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			Subfamily sf = new Subfamily();
			Family f = new Family();
			World w = new World();

			o.setOrganismId(rs.getInt("organism_id"));
			o.setCommonName(rs.getString("common_name"));
			o.setInsertedOn(rs.getDate("inserted_on"));
			o.setUpdatedOn(rs.getDate("updated_on"));

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
		conn.close();
		return organisms;
	}

	public static List<Organism> selectAllBySubfamily(int id) {
		/*
		 Deze methode zoekt door de databank naar organismes die behoren tot een bepaalde subfamily.
		 */
		return new ArrayList<>();
	}

	public static List<Organism> selectAllByFamily(int id) {
		/*
		 Deze methode zoekt door de databank naar organismes die behoren tot een bepaalde family.
		 */
		return new ArrayList<>();
	}

	public static List<Organism> selectAllByWorld(int id) {
		/*
		 Deze methode zoekt door de databank naar organismes die behoren tot een bepaalde family.
		 */
		return new ArrayList<>();
	}

	public static List<Organism> selectAllByHabitat(int id) {
		/*
		 Deze methode zoekt door de databank naar organismes die behoren tot een bepaald habitat.
		 */
		return new ArrayList<>();
	}

	public static List<Organism> selectAllBySeason(int id) {
		/*
		 Deze methode zoekt door de databank naar organismes die behoren tot een bepaald seizoen.
		 */
		return new ArrayList<>();
	}

	public static void insert(Organism organism) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO organism (scientific_name, common_name, local_name, subfamily_id, organism_description,"
					+ "population, indigenous, cultivated, endangered, medicinal, benefits, dangerous, threats, opportunities, photo, links,"
					+ "food_name, food_description, inserted_on)\n"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, organism.getScientificName());
			stmt.setString(2, organism.getCommonName());
			stmt.setString(3, organism.getLocalName());
			stmt.setInt(4, organism.getSubfamily().getSubfamilyId());
			stmt.setString(5, organism.getDescription());
			stmt.setString(6, organism.getPopulation());
			stmt.setBoolean(7, organism.getIndigenous());
			stmt.setBoolean(8, organism.getCultivated());
			stmt.setBoolean(9, organism.getEndangered());
			stmt.setBoolean(10, organism.getMedicinal());
			stmt.setString(11, organism.getBenefits());
			stmt.setString(12, organism.getDangerous());
			stmt.setString(13, organism.getThreats());
			stmt.setString(14, organism.getOpportunities());
			stmt.setBlob(15, new SerialBlob(organism.getPhoto()));
			stmt.setString(16, organism.getLinks());
			stmt.setString(17, organism.getFoodName());
			stmt.setString(18, organism.getFoodDescription());
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			stmt.setDate(19, date);
			stmt.executeUpdate();

			// id van net geinserte organism om tussentabbelen te vullen
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int orgId = (int) rs.getLong(1);

			// volgende statements zijn voor de Many To Many relaties vast te leggen.
			// season
			stmt = conn.prepareStatement("INSERT INTO organism_season (organism_id, season_id) VALUES(?,?)");
			for (Season s : organism.getSeason()) {
				stmt.setInt(1, orgId);
				stmt.setInt(2, s.getSeasonId());
				stmt.executeUpdate();
			}
			// habitat
			stmt = conn.prepareStatement("INSERT INTO habitat_organism (habitat_id, organism_id) VALUES(?,?)");
			for (Habitat h : organism.getHabitat()) {
				stmt.setInt(1, h.getHabitatId());
				stmt.setInt(2, orgId);
				stmt.executeUpdate();
			}
			// EatenBy
			stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
			for (Organism o : organism.getEatenByOrganism()) {
				stmt.setInt(1, orgId);
				stmt.setInt(2, o.getOrganismId());
				stmt.executeUpdate();
			}
			// Eating
			for (Organism o : organism.getEatingOrganisms()) {
				stmt.setInt(1, o.getOrganismId());
				stmt.setInt(2, orgId);
				stmt.executeUpdate();
			}
			// Geolocation
			stmt = conn.prepareStatement("INSERT INTO geolocation_organism (organism_id, geolocation_id) VALUES(?,?)");
			for (Geolocation g : organism.getGeolocations()) {
				stmt.setInt(1, orgId);
				stmt.setInt(2, g.getGeolocationId());
				stmt.executeUpdate();
			}
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static void deleteOrganism(int id) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("DELETE FROM post WHERE post.organism_id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
                        stmt = conn.prepareStatement("UPDATE food SET eaten_by_organism_id= null WHERE eaten_by_organism_id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
                        stmt = conn.prepareStatement("UPDATE food SET eating_organism_id = null WHERE eating_organism_id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt = conn.prepareStatement("DELETE FROM organism WHERE organism.organism_id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static void update(Organism organism) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(
					"UPDATE organism SET scientific_name = ?, common_name = ?, local_name = ?, subfamily_id = ?, "
					+ "organism_description = ?, population = ?, indigenous = ?, cultivated = ?, endangered = ?, medicinal = ?, benefits = ?, dangerous = ?, "
					+ "threats = ?, opportunities = ?, photo = ?, links = ?, food_name = ?, food_description = ?, updated_on = ?, isvalidated=?\n"
					+ "WHERE organism.organism_id=" + organism.getOrganismId());
			stmt.setString(1, organism.getScientificName());
			stmt.setString(2, organism.getCommonName());
			stmt.setString(3, organism.getLocalName());
			stmt.setInt(4, organism.getSubfamily().getSubfamilyId());
			stmt.setString(5, organism.getDescription());
			stmt.setString(6, organism.getPopulation());
			stmt.setBoolean(7, organism.getIndigenous());
			stmt.setNull(8, Types.BIT);
			stmt.setBoolean(8, organism.getCultivated());
			stmt.setNull(9, Types.BIT);
			stmt.setBoolean(9, organism.getEndangered());
			stmt.setNull(10, Types.BIT);
			stmt.setBoolean(10, organism.getMedicinal());
			stmt.setString(11, organism.getBenefits());
			stmt.setString(12, organism.getDangerous());
			stmt.setString(13, organism.getThreats());
			stmt.setString(14, organism.getOpportunities());
			stmt.setBlob(15, new SerialBlob(organism.getPhoto()));
			stmt.setString(16, organism.getLinks());
			stmt.setString(17, organism.getFoodName());
			stmt.setString(18, organism.getFoodDescription());
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			stmt.setDate(19, date);
			stmt.setBoolean(20, true);
			stmt.executeUpdate();

			// volgende statements zijn voor de Many To Many relaties up te daten.
			// season
			stmt = conn.prepareStatement("DELETE FROM organism_season WHERE organism_season.organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO organism_season (organism_id, season_id) VALUES(?,?)");
			for (Season s : organism.getSeason()) {
				stmt.setInt(1, organism.getOrganismId());
				stmt.setInt(2, s.getSeasonId());
				stmt.executeUpdate();
			}
			// habitat
			stmt = conn.prepareStatement("DELETE FROM habitat_organism WHERE habitat_organism.organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO habitat_organism (habitat_id, organism_id) VALUES(?,?)");
			for (Habitat h : organism.getHabitat()) {
				stmt.setInt(1, h.getHabitatId());
				stmt.setInt(2, organism.getOrganismId());
				stmt.executeUpdate();
			}
			// EatenBy
			stmt = conn.prepareStatement("DELETE FROM food WHERE food.eaten_by_organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
			for (Organism o : organism.getEatenByOrganism()) {
				stmt.setInt(1, organism.getOrganismId());
				stmt.setInt(2, o.getOrganismId());
				stmt.executeUpdate();
			}
			// Eating
			stmt = conn.prepareStatement("DELETE FROM food WHERE food.eating_organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
			for (Organism o : organism.getEatingOrganisms()) {
				stmt.setInt(1, o.getOrganismId());
				stmt.setInt(2, organism.getOrganismId());
				stmt.executeUpdate();
			}
			// Geolocation
			stmt = conn.prepareStatement("DELETE FROM geolocation_organism WHERE geolocation_organism.organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO geolocation_organism (organism_id, geolocation_id) VALUES(?,?)");
			for (Geolocation g : organism.getGeolocations()) {
				stmt.setInt(1, organism.getOrganismId());
				stmt.setInt(2, g.getGeolocationId());
				stmt.executeUpdate();
			}
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static void updatePending(Organism organism) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(
					"UPDATE organism SET scientific_name = ?, common_name = ?, local_name = ?, subfamily_id = ?, "
					+ "organism_description = ?, population = ?, indigenous = ?, cultivated = ?, endangered = ?, medicinal = ?, benefits = ?, dangerous = ?, "
					+ "threats = ?, opportunities = ?, photo = ?, links = ?, food_name = ?, food_description = ?, updated_on = ?, isvalidated=?\n"
					+ "WHERE organism.organism_id=" + organism.getOrganismId());
			stmt.setString(1, organism.getScientificName());
			stmt.setString(2, organism.getCommonName());
			stmt.setString(3, organism.getLocalName());
			stmt.setInt(4, organism.getSubfamily().getSubfamilyId());
			stmt.setString(5, organism.getDescription());
			stmt.setString(6, organism.getPopulation());
			stmt.setBoolean(7, organism.getIndigenous());
			stmt.setBoolean(8, organism.getCultivated());
			stmt.setBoolean(9, organism.getEndangered());
			stmt.setBoolean(10, organism.getMedicinal());
			stmt.setString(11, organism.getBenefits());
			stmt.setString(12, organism.getDangerous());
			stmt.setString(13, organism.getThreats());
			stmt.setString(14, organism.getOpportunities());
			stmt.setBlob(15, new SerialBlob(organism.getPhoto()));
			stmt.setString(16, organism.getLinks());
			stmt.setString(17, organism.getFoodName());
			stmt.setString(18, organism.getFoodDescription());
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			stmt.setDate(19, date);
			stmt.setBoolean(20, false);
			stmt.executeUpdate();

			// volgende statements zijn voor de Many To Many relaties up te daten.
			// season
			stmt = conn.prepareStatement("DELETE FROM organism_season WHERE organism_season.organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO organism_season (organism_id, season_id) VALUES(?,?)");
			for (Season s : organism.getSeason()) {
				stmt.setInt(1, organism.getOrganismId());
				stmt.setInt(2, s.getSeasonId());
				stmt.executeUpdate();
			}
			// habitat
			stmt = conn.prepareStatement("DELETE FROM habitat_organism WHERE habitat_organism.organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO habitat_organism (habitat_id, organism_id) VALUES(?,?)");
			for (Habitat h : organism.getHabitat()) {
				stmt.setInt(1, h.getHabitatId());
				stmt.setInt(2, organism.getOrganismId());
				stmt.executeUpdate();
			}
			// EatenBy
			stmt = conn.prepareStatement("DELETE FROM food WHERE food.eaten_by_organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
			for (Organism o : organism.getEatenByOrganism()) {
				stmt.setInt(1, organism.getOrganismId());
				stmt.setInt(2, o.getOrganismId());
				stmt.executeUpdate();
			}
			// Eating
			stmt = conn.prepareStatement("DELETE FROM food WHERE food.eating_organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO food (eaten_by_organism_id, eating_organism_id) VALUES(?,?)");
			for (Organism o : organism.getEatingOrganisms()) {
				stmt.setInt(1, o.getOrganismId());
				stmt.setInt(2, organism.getOrganismId());
				stmt.executeUpdate();
			}
			// Geolocation
			stmt = conn.prepareStatement("DELETE FROM geolocation_organism WHERE geolocation_organism.organism_id=" + organism.getOrganismId());
			stmt.executeUpdate();
			stmt = conn.prepareStatement("INSERT INTO geolocation_organism (organism_id, geolocation_id) VALUES(?,?)");
			for (Geolocation g : organism.getGeolocations()) {
				stmt.setInt(1, organism.getOrganismId());
				stmt.setInt(2, g.getGeolocationId());
				stmt.executeUpdate();
			}
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static List<Organism> selectAllForValidation() throws SQLException {

		List<Organism> orga = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT common_name, organism_id, scientific_name, inserted_on, updated_on FROM organism WHERE isvalidated = 0 ORDER BY inserted_on");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			o.setCommonName(rs.getString("common_name"));
			o.setOrganismId(rs.getInt("organism_id"));
			o.setScientificName(rs.getString("scientific_name"));
			o.setInsertedOn(rs.getDate("inserted_on"));
			o.setUpdatedOn(rs.getDate("updated_on"));
			orga.add(o);
		}
		conn.close();
		return orga;
	}

	public static List<Organism> selectAllPublished() throws SQLException {

		List<Organism> orgb = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT common_name, scientific_name, organism_id, updated_on, inserted_on FROM organism WHERE isvalidated = 1 ORDER BY updated_on LIMIT 100");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			o.setCommonName(rs.getString("common_name"));
			o.setScientificName(rs.getString("scientific_name"));
			o.setUpdatedOn(rs.getDate("updated_on"));
			o.setInsertedOn(rs.getDate(("inserted_on")));
			o.setOrganismId(rs.getInt("organism_id"));
			orgb.add(o);
		}
		conn.close();
		return orgb;
	}

	public static void publishFromQueue(int organismId) throws SQLException {

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("UPDATE organism set isvalidated= '1' WHERE organism_id=" + organismId);
			stmt.executeUpdate();
			conn.commit();
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}

	public static List searchOrganismTable(String keyword) throws SQLException {

		List<Organism> result = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT organism_id, common_name, scientific_name, inserted_on, updated_on\n"
				+ "FROM organism \n"
				+ "WHERE (CONCAT(common_name, scientific_name) LIKE '%" + keyword + "%') AND isvalidated = '1'");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			o.setOrganismId(rs.getInt("organism_id"));
			o.setCommonName(rs.getString("common_name"));
			o.setScientificName(rs.getString("scientific_name"));
			o.setInsertedOn(rs.getDate("inserted_on"));
			o.setUpdatedOn(rs.getDate("updated_on"));
			result.add(o);
		}
		conn.close();
		return result;
	}

	public static List searchOrganismPendingTable(String keyword) throws SQLException {

		List<Organism> result = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT organism_id, common_name, scientific_name, inserted_on, updated_on\n"
				+ "FROM organism \n"
				+ "WHERE (CONCAT(common_name, scientific_name) LIKE '%" + keyword + "%') AND isvalidated = '0'");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			o.setOrganismId(rs.getInt("organism_id"));
			o.setCommonName(rs.getString("common_name"));
			o.setScientificName(rs.getString("scientific_name"));
			o.setInsertedOn(rs.getDate("inserted_on"));
			o.setUpdatedOn(rs.getDate("updated_on"));
			result.add(o);
		}
		conn.close();
		return result;
	}

	public static List<Organism> selectEaten() throws SQLException {

		List<Organism> eats = new ArrayList();
		conn = DataSource.getConnection();
		stmt = conn.prepareStatement("SELECT organism_id, common_name FROM organism ORDER BY common_name ");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Organism o = new Organism();
			o.setOrganismId(rs.getInt("organism_id"));
			o.setCommonName(rs.getString("common_name"));
			eats.add(o);
		}
		conn.close();
		return eats;
	}
}

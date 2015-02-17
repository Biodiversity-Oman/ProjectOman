/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.List;

/**
 *
 * @author lennyasus
 */
public class Organism {

	private int organismId;
	private String scientificName;
	private String commonName;
	private String localName;
	private String description;
	private Subfamily subFamily;
	private Family family;
	private World world;
	private List<Habitat> habitat;
	private String population;
	private List<Season> season;
	private Boolean indigenous;
	private Boolean cultivated;
	private Boolean endangered;
	private Boolean medicinal;
	private String benefits;
	private String dangerous;
	private String threats;
	private String opportunities;
	private Byte photo;
	private String links;
	private List<Organism> eatenByOrganism;
	private List<Organism> eatingOrganisms;
	private List<Post> post;
	private Boolean validated;
	private String foodName;
	private String foodDescription;
        private java.util.Date insertedOn;
        private java.util.Date updatedOn;

	/**
	 * @return the organismId
	 */
	public int getOrganismId() {
		return organismId;
	}

	/**
	 * @param organismId the organismId to set
	 */
	public void setOrganismId(int organismId) {
		this.organismId = organismId;
	}

	/**
	 * @return the scientificName
	 */
	public String getScientificName() {
		return scientificName;
	}

	/**
	 * @param scientificName the scientificName to set
	 */
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	/**
	 * @return the commonName
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * @param commonName the commonName to set
	 */
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	/**
	 * @return the localName
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * @param localName the localName to set
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the subFamily
	 */
	public Subfamily getSubfamily() {
		return subFamily;
	}

	/**
	 * @param subFamily the subFamily to set
	 */
	public void setSubfamily(Subfamily subFamily) {
		this.subFamily = subFamily;
	}

	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @return the habitat
	 */
	public List<Habitat> getHabitat() {
		return habitat;
	}

	/**
	 * @param habitat the habitat to set
	 */
	public void setHabitat(List<Habitat> habitat) {
		this.habitat = habitat;
	}

	/**
	 * @return the population
	 */
	public String getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(String population) {
		this.population = population;
	}

	/**
	 * @return the season
	 */
	public List<Season> getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(List<Season> season) {
		this.season = season;
	}

	/**
	 * @return the indigenous
	 */
	public Boolean getIndigenous() {
		return indigenous;
	}

	/**
	 * @param indigenous the indigenous to set
	 */
	public void setIndigenous(Boolean indigenous) {
		this.indigenous = indigenous;
	}

	/**
	 * @return the cultivated
	 */
	public Boolean getCultivated() {
		return cultivated;
	}

	/**
	 * @param cultivated the cultivated to set
	 */
	public void setCultivated(Boolean cultivated) {
		this.cultivated = cultivated;
	}

	/**
	 * @return the endangered
	 */
	public Boolean getEndangered() {
		return endangered;
	}

	/**
	 * @param endangered the endangered to set
	 */
	public void setEndangered(Boolean endangered) {
		this.endangered = endangered;
	}

	/**
	 * @return the medicinal
	 */
	public Boolean getMedicinal() {
		return medicinal;
	}

	/**
	 * @param medicinal the medicinal to set
	 */
	public void setMedicinal(Boolean medicinal) {
		this.medicinal = medicinal;
	}

	/**
	 * @return the benefits
	 */
	public String getBenefits() {
		return benefits;
	}

	/**
	 * @param benefits the benefits to set
	 */
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	/**
	 * @return the dangerous
	 */
	public String getDangerous() {
		return dangerous;
	}

	/**
	 * @param dangerous the dangerous to set
	 */
	public void setDangerous(String dangerous) {
		this.dangerous = dangerous;
	}

	/**
	 * @return the threats
	 */
	public String getThreats() {
		return threats;
	}

	/**
	 * @param threats the threats to set
	 */
	public void setThreats(String threats) {
		this.threats = threats;
	}

	/**
	 * @return the opportunities
	 */
	public String getOpportunities() {
		return opportunities;
	}

	/**
	 * @param opportunities the opportunities to set
	 */
	public void setOpportunities(String opportunities) {
		this.opportunities = opportunities;
	}

	/**
	 * @return the photo
	 */
	public Byte getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Byte photo) {
		this.photo = photo;
	}

	/**
	 * @return the links
	 */
	public String getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(String links) {
		this.links = links;
	}

	/**
	 * @return the eatenByOrganism
	 */
	public List<Organism> getEatenByOrganism() {
		return eatenByOrganism;
	}

	/**
	 * @param eatenByOrganism the eatenByOrganism to set
	 */
	public void setEatenByOrganism(List<Organism> eatenByOrganism) {
		this.eatenByOrganism = eatenByOrganism;
	}

	/**
	 * @return the eatingOrganisms
	 */
	public List<Organism> getEatingOrganisms() {
		return eatingOrganisms;
	}

	/**
	 * @param eatingOrganisms the eatingOrganisms to set
	 */
	public void setEatingOrganisms(List<Organism> eatingOrganisms) {
		this.eatingOrganisms = eatingOrganisms;
	}

	/**
	 * @return the post
	 */
	public List<Post> getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(List<Post> post) {
		this.post = post;
	}

	/**
	 * @return the validated
	 */
	public Boolean getValidated() {
		return validated;
	}

	/**
	 * @param validated the validated to set
	 */
	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	/**
	 * @return the foodName
	 */
	public String getFoodName() {
		return foodName;
	}

	/**
	 * @param foodName the foodName to set
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	/**
	 * @return the foodDescription
	 */
	public String getFoodDescription() {
		return foodDescription;
	}

	/**
	 * @param foodDescription the foodDescription to set
	 */
	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

    /**
     * @return the insertedOn
     */
    public java.util.Date getInsertedOn() {
        return insertedOn;
    }

    /**
     * @param insertedOn the insertedOn to set
     */
    public void setInsertedOn(java.util.Date insertedOn) {
        this.insertedOn = insertedOn;
    }

    /**
     * @return the updatedOn
     */
    public java.util.Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn the updatedOn to set
     */
    public void setUpdatedOn(java.util.Date updatedOn) {
        this.updatedOn = updatedOn;
    }

	
	
	
	
	
	
}

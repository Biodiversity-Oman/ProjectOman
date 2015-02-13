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
	private int organism_id;
	private String scientifi_name;
	private String common_name;
	private String local_name;
	private String description;
	private SubFamily sub_family;
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
	private List<Organism> eaten_by_organism;
	private List<Organism> eating_organisms;
	private List<Post> post;
	private Boolean validated;

	/**
	 * @return the organism_id
	 */
	public int getOrganism_id() {
		return organism_id;
	}

	/**
	 * @param organism_id the organism_id to set
	 */
	public void setOrganism_id(int organism_id) {
		this.organism_id = organism_id;
	}

	/**
	 * @return the scientifi_name
	 */
	public String getScientifi_name() {
		return scientifi_name;
	}

	/**
	 * @param scientifi_name the scientifi_name to set
	 */
	public void setScientifi_name(String scientifi_name) {
		this.scientifi_name = scientifi_name;
	}

	/**
	 * @return the common_name
	 */
	public String getCommon_name() {
		return common_name;
	}

	/**
	 * @param common_name the common_name to set
	 */
	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}

	/**
	 * @return the local_name
	 */
	public String getLocal_name() {
		return local_name;
	}

	/**
	 * @param local_name the local_name to set
	 */
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
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
	 * @return the sub_family
	 */
	public SubFamily getSub_family() {
		return sub_family;
	}

	/**
	 * @param sub_family the sub_family to set
	 */
	public void setSub_family(SubFamily sub_family) {
		this.sub_family = sub_family;
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
	 * @return the eaten_by_organism
	 */
	public List<Organism> getEaten_by_organism() {
		return eaten_by_organism;
	}

	/**
	 * @param eaten_by_organism the eaten_by_organism to set
	 */
	public void setEaten_by_organism(List<Organism> eaten_by_organism) {
		this.eaten_by_organism = eaten_by_organism;
	}

	/**
	 * @return the eating_organisms
	 */
	public List<Organism> getEating_organisms() {
		return eating_organisms;
	}

	/**
	 * @param eating_organisms the eating_organisms to set
	 */
	public void setEating_organisms(List<Organism> eating_organisms) {
		this.eating_organisms = eating_organisms;
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
	
	
	
	
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author lennyasus
 */
public class Season {
	
	private int seasonId;
	private String seasonName;
	private String description;
        private java.util.List<Organism> organisms;

	/**
	 * @return the seasonId
	 */
	public int getSeasonId() {
		return seasonId;
	}

	/**
	 * @param seasonId the seasonId to set
	 */
	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	/**
	 * @return the name
	 */
	public String getSeasonName() {
		return seasonName;
	}

	/**
	 * @param seasonName the name to set
	 */
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
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
     * @return the organisms
     */
    public java.util.List<Organism> getOrganisms() {
        return organisms;
    }

    /**
     * @param organisms the organisms to set
     */
    public void setOrganisms(java.util.List<Organism> organisms) {
        this.organisms = organisms;
    }
}

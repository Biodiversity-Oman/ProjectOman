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
class Season {
	
	private int seasonId;
	private String name;
	private String description;

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
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
}

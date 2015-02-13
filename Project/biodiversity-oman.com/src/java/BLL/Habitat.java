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
class Habitat {
	private int habitat_id;
	private String name;
	private String description;

	/**
	 * @return the habitat_id
	 */
	public int getHabitat_id() {
		return habitat_id;
	}

	/**
	 * @param habitat_id the habitat_id to set
	 */
	public void setHabitat_id(int habitat_id) {
		this.habitat_id = habitat_id;
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

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
public class Habitat {
	
	private int worldId;
	private String habitatName;
	private String description;

	/**
	 * @return the worldId
	 */
	public int getWorldId() {
		return worldId;
	}

	/**
	 * @param worldId the worldId to set
	 */
	public void setWorldId(int worldId) {
		this.worldId = worldId;
	}

	/**
	 * @return the name
	 */
	public String getHabitatName() {
		return habitatName;
	}

	/**
	 * @param habitatName the name to set
	 */
	public void setHabitatName(String habitatName) {
		this.habitatName = habitatName;
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

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
	
        private int habitatId;
	private String habitatName;
	private String description;

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

    /**
     * @return the habitatId
     */
    public int getHabitatId() {
        return habitatId;
    }

    /**
     * @param habitatId the habitatId to set
     */
    public void setHabitatId(int habitatId) {
        this.habitatId = habitatId;
    }
}

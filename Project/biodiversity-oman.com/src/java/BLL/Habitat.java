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
        private java.util.List<Organism> organisms;

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

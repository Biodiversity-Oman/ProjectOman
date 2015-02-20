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
	private String seasonDescription;
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
     * @return the seasonName
     */
    public String getSeasonName() {
        return seasonName;
    }

    /**
     * @param seasonName the seasonName to set
     */
    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    /**
     * @return the seasonDescription
     */
    public String getSeasonDescription() {
        return seasonDescription;
    }

    /**
     * @param seasonDescription the seasonDescription to set
     */
    public void setSeasonDescription(String seasonDescription) {
        this.seasonDescription = seasonDescription;
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

    public String getSeasonDescription(String string) {
        return seasonDescription;
    }

   
	
}

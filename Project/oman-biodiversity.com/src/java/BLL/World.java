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
public class World {
	
    private int worldId;
    private String worldName;
    private String description;
    private java.util.List<Download> downloads;

    // Algemene constructor    
    public World() {
    }

    // Relatie Constructor
    public World(int worldId) {
        this.worldId = worldId;
    }

    @Override
    public String toString() {
            return  worldId +  worldName + description  + downloads;
    }


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
    public String getWorldName() {
            return worldName;
    }

    /**
     * @param worldName the name to set
     */
    public void setWorldName(String worldName) {
            this.worldName = worldName;
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
     * @return the downloads
     */
    public java.util.List<Download> getDownloads() {
        return downloads;
    }

    /**
     * @param downloads the downloads to set
     */
    public void setDownloads(java.util.List<Download> downloads) {
        this.downloads = downloads;
    }
}

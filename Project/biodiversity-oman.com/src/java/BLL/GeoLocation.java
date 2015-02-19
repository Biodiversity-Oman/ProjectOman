/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Tom
 */
public class GeoLocation {

    private Integer geolocationId;
    private String areaName;
    private String areaDescription;
    private String coordinates;
    private java.util.List<Organism> organisms;

    public Integer getGeolocationId() {
        return geolocationId;
    }

    public void setGeolocationId(Integer geolocationId) {
        this.geolocationId = geolocationId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public String getCoordinates(){
        return coordinates;
    }
    
    public void setCoordinates(String coordinates){
        this.coordinates = coordinates;
    }

    public java.util.List<Organism> getOrganisms() {
        return organisms;
    }

    public void setOrganisms(java.util.List<Organism> organisms) {
        this.organisms = organisms;
    }

}

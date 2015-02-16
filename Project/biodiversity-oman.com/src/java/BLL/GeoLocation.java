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
     private String latitudeHeight1;
     private String longitudeHeight1;
     private String latitudeWidth1;
     private String longitudeWidth1;
     private String latitudeHeight2;
     private String longitudeHeight2;
     private String latitudeWidth2;
     private String longitudeWidth2;
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

    public String getLatitudeHeight1() {
        return latitudeHeight1;
    }

    public void setLatitudeHeight1(String latitudeHeight1) {
        this.latitudeHeight1 = latitudeHeight1;
    }

    public String getLongitudeHeight1() {
        return longitudeHeight1;
    }

    public void setLongitudeHeight1(String longitudeHeight1) {
        this.longitudeHeight1 = longitudeHeight1;
    }

    public String getLatitudeWidth1() {
        return latitudeWidth1;
    }

    public void setLatitudeWidth1(String latitudeWidth1) {
        this.latitudeWidth1 = latitudeWidth1;
    }

    public String getLongitudeWidth1() {
        return longitudeWidth1;
    }

    public void setLongitudeWidth1(String longitudeWidth1) {
        this.longitudeWidth1 = longitudeWidth1;
    }

    public String getLatitudeHeight2() {
        return latitudeHeight2;
    }

    public void setLatitudeHeight2(String latitudeHeight2) {
        this.latitudeHeight2 = latitudeHeight2;
    }

    public String getLongitudeHeight2() {
        return longitudeHeight2;
    }

    public void setLongitudeHeight2(String longitudeHeight2) {
        this.longitudeHeight2 = longitudeHeight2;
    }

    public String getLatitudeWidth2() {
        return latitudeWidth2;
    }

    public void setLatitudeWidth2(String latitudeWidth2) {
        this.latitudeWidth2 = latitudeWidth2;
    }

    public String getLongitudeWidth2() {
        return longitudeWidth2;
    }

    public void setLongitudeWidth2(String longitudeWidth2) {
        this.longitudeWidth2 = longitudeWidth2;
    }

    public java.util.List<Organism> getOrganisms() {
        return organisms;
    }

    public void setOrganisms(java.util.List<Organism> organisms) {
        this.organisms = organisms;
    }

	
}

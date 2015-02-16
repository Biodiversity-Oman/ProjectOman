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
public class GeoLocation {
	
	private int geoLocationId;
	private String latitudeHeight;
	private String latitudeHeight2;
	private String longitudeHeight;
	private String longitudeHeight2;
	private String longitudeWidth;
	private String longitudeWidth2;
	private String latitudeWidth;
	private String latitudeWidth2;
        private java.util.List<Organism> organisms;

	/**
	 * @return the geoLocationId
	 */
	public int getGeoLocationId() {
		return geoLocationId;
	}

	/**
	 * @param geoLocationId the geoLocationId to set
	 */
	public void setGeoLocationId(int geoLocationId) {
		this.geoLocationId = geoLocationId;
	}

	/**
	 * @return the latitudeHeight
	 */
	public String getLatitudeHeight() {
		return latitudeHeight;
	}

	/**
	 * @param latitudeHeight the latitudeHeight to set
	 */
	public void setLatitudeHeight(String latitudeHeight) {
		this.latitudeHeight = latitudeHeight;
	}

	/**
	 * @return the latitudeHeight2
	 */
	public String getLatitudeHeight2() {
		return latitudeHeight2;
	}

	/**
	 * @param latitudeHeight2 the latitudeHeight2 to set
	 */
	public void setLatitudeHeight2(String latitudeHeight2) {
		this.latitudeHeight2 = latitudeHeight2;
	}

	/**
	 * @return the longitudeHeight
	 */
	public String getLongitudeHeight() {
		return longitudeHeight;
	}

	/**
	 * @param longitudeHeight the longitudeHeight to set
	 */
	public void setLongitudeHeight(String longitudeHeight) {
		this.longitudeHeight = longitudeHeight;
	}

	/**
	 * @return the longitudeHeight2
	 */
	public String getLongitudeHeight2() {
		return longitudeHeight2;
	}

	/**
	 * @param longitudeHeight2 the longitudeHeight2 to set
	 */
	public void setLongitudeHeight2(String longitudeHeight2) {
		this.longitudeHeight2 = longitudeHeight2;
	}

	/**
	 * @return the longitudeWidth
	 */
	public String getLongitudeWidth() {
		return longitudeWidth;
	}

	/**
	 * @param longitudeWidth the longitudeWidth to set
	 */
	public void setLongitudeWidth(String longitudeWidth) {
		this.longitudeWidth = longitudeWidth;
	}

	/**
	 * @return the longitudeWidth2
	 */
	public String getLongitudeWidth2() {
		return longitudeWidth2;
	}

	/**
	 * @param longitudeWidth2 the longitudeWidth2 to set
	 */
	public void setLongitudeWidth2(String longitudeWidth2) {
		this.longitudeWidth2 = longitudeWidth2;
	}

	/**
	 * @return the latitudeWidth
	 */
	public String getLatitudeWidth() {
		return latitudeWidth;
	}

	/**
	 * @param latitudeWidth the latitudeWidth to set
	 */
	public void setLatitudeWidth(String latitudeWidth) {
		this.latitudeWidth = latitudeWidth;
	}

	/**
	 * @return the latitudeWidth2
	 */
	public String getLatitudeWidth2() {
		return latitudeWidth2;
	}

	/**
	 * @param latitudeWidth2 the latitudeWidth2 to set
	 */
	public void setLatitudeWidth2(String latitudeWidth2) {
		this.latitudeWidth2 = latitudeWidth2;
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

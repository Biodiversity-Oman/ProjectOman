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
class SubFamily {
	
	private int subFamilyId;
	private Family family;
	private String subFamilyName;
	private String description;

	/**
	 * @return the subFamilyId
	 */
	public int getSubFamilyId() {
		return subFamilyId;
	}

	/**
	 * @param subFamilyId the subFamilyId to set
	 */
	public void setSubFamilyId(int subFamilyId) {
		this.subFamilyId = subFamilyId;
	}

	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}

	/**
	 * @return the subFamilyName
	 */
	public String getSubFamilyName() {
		return subFamilyName;
	}

	/**
	 * @param subFamilyName the subFamilyName to set
	 */
	public void setSubFamilyName(String subFamilyName) {
		this.subFamilyName = subFamilyName;
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

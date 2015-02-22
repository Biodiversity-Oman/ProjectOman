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
public class SubFamily {
	
	private int subFamilyId;
	private int familyId;
	private String subFamilyName;
	private String subFamilyDescription;

	/**
	 * @return the subFamilyId
	 */
	public int getSubfamilyId() {
		return subFamilyId;
	}

	/**
	 * @param subFamilyId the subFamilyId to set
	 */
	public void setSubfamilyId(int subFamilyId) {
		this.subFamilyId = subFamilyId;
	}

	/**
	 * @return the familyId
	 */
	public int getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId the familyId to set
	 */
	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	/**
	 * @return the subFamilyName
	 */
	public String getSubfamilyName() {
		return subFamilyName;
	}

	/**
	 * @param subFamilyName the subFamilyName to set
	 */
	public void setSubfamilyName(String subFamilyName) {
		this.subFamilyName = subFamilyName;
	}

	/**
	 * @return the description
	 */
	public String getSubFamilyDescription() {
		return subFamilyDescription;
	}

	/**
	 * @param description the description to set
	 */
	public void setSubFamilyDescription(String description) {
		this.subFamilyDescription = description;
	}
}

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
class Family {
	private int family_id;
	private String family_name;
	private String description;

	/**
	 * @return the family_id
	 */
	public int getFamily_id() {
		return family_id;
	}

	/**
	 * @param family_id the family_id to set
	 */
	public void setFamily_id(int family_id) {
		this.family_id = family_id;
	}

	/**
	 * @return the family_name
	 */
	public String getFamily_name() {
		return family_name;
	}

	/**
	 * @param family_name the family_name to set
	 */
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
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

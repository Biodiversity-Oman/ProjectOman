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
public class Family {
	
	private int familyId;
	private String familyName;
	private String familyDescription;
        private int worldId;

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
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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
     * @return the familyDescription
     */
    public String getFamilyDescription() {
        return familyDescription;
    }

    /**
     * @param familyDescription the familyDescription to set
     */
    public void setFamilyDescription(String familyDescription) {
        this.familyDescription = familyDescription;
    }
}

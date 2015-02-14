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
public class Post {

	private int postId;
	private int OrganismId;
	private String FirstName;
	private String LastName;
	private String email;
	private String description;
	private Byte photoPost;
	private int longitude;
	private int latitude;

	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * @return the OrganismId
	 */
	public int getOrganismId() {
		return OrganismId;
	}

	/**
	 * @param OrganismId the OrganismId to set
	 */
	public void setOrganismId(int OrganismId) {
		this.OrganismId = OrganismId;
	}

	/**
	 * @return the FirstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param FirstName the FirstName to set
	 */
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	/**
	 * @return the LastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param LastName the LastName to set
	 */
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the photoPost
	 */
	public Byte getPhotoPost() {
		return photoPost;
	}

	/**
	 * @param photoPost the photoPost to set
	 */
	public void setPhotoPost(Byte photoPost) {
		this.photoPost = photoPost;
	}

	/**
	 * @return the longitude
	 */
	public int getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public int getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
}

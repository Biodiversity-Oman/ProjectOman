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
public class Post {

    private Integer postId;
    private Integer organismId;
    private String postFirstName;
    private String postLastName;
    private String postEmail;
    private String postDescription;
    private byte[] postPhoto;
    private String postLongitude;
    private String postLatitude;
    private String organismName;

    /**
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * @return the organismId
     */
    public Integer getOrganismId() {
        return organismId;
    }

    /**
     * @param organismId the organismId to set
     */
    public void setOrganismId(Integer organismId) {
        this.organismId = organismId;
    }

    /**
     * @return the postFirstName
     */
    public String getPostFirstName() {
        return postFirstName;
    }

    /**
     * @param postFirstName the postFirstName to set
     */
    public void setPostFirstName(String postFirstName) {
        this.postFirstName = postFirstName;
    }

    /**
     * @return the postLastName
     */
    public String getPostLastName() {
        return postLastName;
    }

    /**
     * @param postLastName the postLastName to set
     */
    public void setPostLastName(String postLastName) {
        this.postLastName = postLastName;
    }

    /**
     * @return the postEmail
     */
    public String getPostEmail() {
        return postEmail;
    }

    /**
     * @param postEmail the postEmail to set
     */
    public void setPostEmail(String postEmail) {
        this.postEmail = postEmail;
    }

    /**
     * @return the postDescription
     */
    public String getPostDescription() {
        return postDescription;
    }

    /**
     * @param postDescription the postDescription to set
     */
    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    /**
     * @return the postPhoto
     */
    public byte[] getPostPhoto() {
        return postPhoto;
    }

    /**
     * @param postPhoto the postPhoto to set
     */
    public void setPostPhoto(byte[] postPhoto) {
        this.postPhoto = postPhoto;
    }

    /**
     * @return the postLongitude
     */
    public String getPostLongitude() {
        return postLongitude;
    }

    /**
     * @param postLongitude the postLongitude to set
     */
    public void setPostLongitude(String postLongitude) {
        this.postLongitude = postLongitude;
    }

    /**
     * @return the postLatitude
     */
    public String getPostLatitude() {
        return postLatitude;
    }

    /**
     * @param postLatitude the postLatitude to set
     */
    public void setPostLatitude(String postLatitude) {
        this.postLatitude = postLatitude;
    }

    /**
     * @return the organismName
     */
    public String getOrganismName() {
        return organismName;
    }

    /**
     * @param organismName the organismName to set
     */
    public void setOrganismName(String organismName) {
        this.organismName = organismName;
    }

}

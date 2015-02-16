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
     private Organism organism;
     private String postFirstName;
     private String postLastName;
     private String postEmail;
     private String postDescription;
     private byte[] photoPost;
     private String postLongitude;
     private String postLatitude;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public String getPostFirstName() {
        return postFirstName;
    }

    public void setPostFirstName(String postFirstName) {
        this.postFirstName = postFirstName;
    }

    public String getPostLastName() {
        return postLastName;
    }

    public void setPostLastName(String postLastName) {
        this.postLastName = postLastName;
    }

    public String getPostEmail() {
        return postEmail;
    }

    public void setPostEmail(String postEmail) {
        this.postEmail = postEmail;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public byte[] getPhotoPost() {
        return photoPost;
    }

    public void setPhotoPost(byte[] photoPost) {
        this.photoPost = photoPost;
    }

    public String getPostLongitude() {
        return postLongitude;
    }

    public void setPostLongitude(String postLongitude) {
        this.postLongitude = postLongitude;
    }

    public String getPostLatitude() {
        return postLatitude;
    }

    public void setPostLatitude(String postLatitude) {
        this.postLatitude = postLatitude;
    }

	
	
}

package dal;
// Generated 13-feb-2015 0:06:47 by Hibernate Tools 4.3.1



/**
 * Post generated by hbm2java
 */
public class Post  implements java.io.Serializable {


     private Integer postId;
     private Organism organism;
     private String firstName;
     private String lastName;
     private String email;
     private String description;
     private byte[] photoPost;
     private String longitude;
     private String latitude;
     private boolean newsLetter;

    public Post() {
    }

	
    public Post(String lastName, String email, boolean newsLetter) {
        this.lastName = lastName;
        this.email = email;
        this.newsLetter = newsLetter;
    }
    public Post(Organism organism, String firstName, String lastName, String email, String description, byte[] photoPost, String longitude, String latitude, boolean newsLetter) {
       this.organism = organism;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.description = description;
       this.photoPost = photoPost;
       this.longitude = longitude;
       this.latitude = latitude;
       this.newsLetter = newsLetter;
    }
   
    public Integer getPostId() {
        return this.postId;
    }
    
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    public Organism getOrganism() {
        return this.organism;
    }
    
    public void setOrganism(Organism organism) {
        this.organism = organism;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public byte[] getPhotoPost() {
        return this.photoPost;
    }
    
    public void setPhotoPost(byte[] photoPost) {
        this.photoPost = photoPost;
    }
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public boolean isNewsLetter() {
        return this.newsLetter;
    }
    
    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }




}


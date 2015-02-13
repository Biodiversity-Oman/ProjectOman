package dal;
// Generated 13-feb-2015 0:06:47 by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin  implements java.io.Serializable {


     private Integer adminId;
     private String firstName;
     private String lastName;
     private String email;
     private String city;
     private String country;
     private String address;
     private String passWord;
     private String userName;

    public Admin() {
    }

	
    public Admin(String lastName, String email, String address, String passWord, String userName) {
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.passWord = passWord;
        this.userName = userName;
    }
    public Admin(String firstName, String lastName, String email, String city, String country, String address, String passWord, String userName) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.city = city;
       this.country = country;
       this.address = address;
       this.passWord = passWord;
       this.userName = userName;
    }
   
    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassWord() {
        return this.passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }




}


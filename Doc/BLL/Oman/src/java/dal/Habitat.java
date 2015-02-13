package dal;
// Generated 13-feb-2015 0:06:47 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Habitat generated by hbm2java
 */
public class Habitat  implements java.io.Serializable {


     private Integer habitatId;
     private String name;
     private String description;
     private Set habitatOrganismes = new HashSet(0);

    public Habitat() {
    }

    public Habitat(String name, String description, Set habitatOrganismes) {
       this.name = name;
       this.description = description;
       this.habitatOrganismes = habitatOrganismes;
    }
   
    public Integer getHabitatId() {
        return this.habitatId;
    }
    
    public void setHabitatId(Integer habitatId) {
        this.habitatId = habitatId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getHabitatOrganismes() {
        return this.habitatOrganismes;
    }
    
    public void setHabitatOrganismes(Set habitatOrganismes) {
        this.habitatOrganismes = habitatOrganismes;
    }




}



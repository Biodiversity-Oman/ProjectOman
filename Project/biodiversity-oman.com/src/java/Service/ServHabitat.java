/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Habitat;
import DAL.DaHabitat;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lennyasus
 */
public class ServHabitat {

    public static boolean checkHbitatExist(String habitatName) throws SQLException {

        return DaHabitat.checkIfExists(habitatName);
    }

    public static List selectAllHabitats() throws SQLException {

        return DaHabitat.selectAll();
    }

    public static void insertHabitat(String name, String description) throws SQLException {

        Habitat habitat = new Habitat();
        habitat.setHabitatName(name);
        habitat.setHabitatDescription(description);
        DaHabitat.insert(habitat);
    }

    public static void deleteHabitat(int id) throws SQLException {

        DaHabitat.delete(id);
    }

    public static void updateHabitat(String habitatName, String habitatdescription, int habitatId) throws SQLException {

        Habitat h = new Habitat();
        h.setHabitatName(habitatName);
        h.setHabitatDescription(habitatdescription);
        h.setHabitatId(habitatId);
        DaHabitat.update(h);

    }

    public static BLL.Habitat selectOneById(int id) throws SQLException {

        return DaHabitat.selectOneByID(id);
    }
}

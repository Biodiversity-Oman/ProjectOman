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

    public static List selectAllHabitats() throws SQLException {

        return DaHabitat.selectAll();
    }

    public static String insertHabitat(String name, String description) {

        try {
            if (!name.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!description.matches("^[^<>\\\\/{}\\[\\]]*(\\\r\\\n)?$")){
                return "required";
            } else if (DaHabitat.checkIfExists(name) == false) {
                Habitat habitat = new Habitat();
                habitat.setHabitatName(name);
                habitat.setHabitatDescription(description);
                DaHabitat.insert(habitat);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static void deleteHabitat(int id) throws SQLException {

        DaHabitat.delete(id);
    }

    public static String updateHabitat(String name, String description, int id) {

        try {
            if (!name.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!description.matches("^[^<>\\\\/{}\\[\\]]*(\\\r\\\n)?$")){
                return "required";
            } else if (DaHabitat.selectOneByID(id).getHabitatName().equalsIgnoreCase(name)) {
                Habitat h = new Habitat();
                h.setHabitatName(name);
                h.setHabitatDescription(description);
                h.setHabitatId(id);
                DaHabitat.update(h);
                return "succes";
            } else if (DaHabitat.checkIfExists(name) == false) {
                Habitat h = new Habitat();
                h.setHabitatName(name);
                h.setHabitatDescription(description);
                h.setHabitatId(id);
                DaHabitat.update(h);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static BLL.Habitat selectOneById(int id) throws SQLException {

        return DaHabitat.selectOneByID(id);
    }
}

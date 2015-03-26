/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Family;
import DAL.DaFamily;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class ServFamily {

    public static List selectAllFamily() throws SQLException {

        return DaFamily.selectAll();
    }

    public static String insertFamily(String name, String description, int worldId) {

        try {
            if (name.length() < 1 || !name.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!description.matches("^[^<>\\\\/{}\\[\\]]*(\\\r\\\n)?$")){
                return "required";
            } else if (worldId == 0) {
                return "required";
            } else if (DaFamily.checkIfExists(name) == false) {
                Family fam = new Family();
                fam.setFamilyDescription(description);
                fam.setFamilyName(name);
                fam.setWorldId(worldId);
                DaFamily.insert(fam);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static void deleteFamily(int id) throws SQLException {

        DaFamily.delete(id);
    }

    public static String updateFamily(String name, String description, int worldId, int id) {

        try {
            if (name.length() < 1 || !name.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!description.matches("^[^<>\\\\/{}\\[\\]]*(\\\r\\\n)?$")){
                return "required";
            } else if (worldId == 0) {
                return "required";
            } else if (DaFamily.selectOneByID(id).getFamilyName().equalsIgnoreCase(name)) {
                Family f = new Family();
                f.setFamilyName(name);
                f.setFamilyDescription(description);
                f.setFamilyWorldName(name);
                f.setWorldId(worldId);
                f.setFamilyId(id);
                DaFamily.update(f);
                return "succes";
            } else if (DaFamily.checkIfExists(name) == false) {
                Family f = new Family();
                f.setFamilyName(name);
                f.setFamilyDescription(description);
                f.setFamilyWorldName(name);
                f.setWorldId(worldId);
                f.setFamilyId(id);
                DaFamily.update(f);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static BLL.Family selectOneById(int id) throws SQLException {

        return DaFamily.selectOneByID(id);
    }
}

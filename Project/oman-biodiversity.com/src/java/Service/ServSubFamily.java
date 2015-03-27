/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.*;
import DAL.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Eric
 */
public class ServSubFamily {

    public static List selectAllSubFamily() throws SQLException {

        return DaSubfamily.selectAll();
    }

    public static BLL.Subfamily selectOneById(int id) throws SQLException {

        return DaSubfamily.selectOneByID(id);
    }

    public static String insertSubFamily(String name, String description, int familyId) {

        try {
            if (name.length() < 1 || !name.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!description.matches("^[^<>\\\\/{}\\[\\]]*(\\\r\\\n)?$")){
                return "required";
            } else if (familyId == 0) {
                return "required";
            } else if (DaSubfamily.checkIfExists(name) == false) {
                Subfamily subfam = new Subfamily();
                subfam.setSubFamilyDescription(description);
                subfam.setSubfamilyName(name);
                subfam.setFamilyId(familyId);
                DaSubfamily.insert(subfam);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static String updateSubFamily(String name, String description, int familyId, int id) {

        try {
            if (name.length() < 1 || !name.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!description.matches("^[^<>\\\\/{}\\[\\]]*(\\\r\\\n)?$")){
                return "required";
            } else if (familyId == 0) {
                return "required";
            } else if (DaSubfamily.selectOneByID(id).getSubfamilyName().equalsIgnoreCase(name)) {
                Subfamily subfam = new Subfamily();
                subfam.setSubFamilyDescription(description);
                subfam.setSubfamilyName(name);
                subfam.setFamilyId(familyId);
                subfam.setSubfamilyId(id);
                DaSubfamily.update(subfam);
                return "succes";
            } else if (DaSubfamily.checkIfExists(name) == false) {
                Subfamily subfam = new Subfamily();
                subfam.setSubFamilyDescription(description);
                subfam.setSubfamilyName(name);
                subfam.setFamilyId(familyId);
                subfam.setSubfamilyId(id);
                DaSubfamily.update(subfam);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static void deleteSubFamily(int id) throws SQLException {

        DaSubfamily.delete(id);
    }

    public static List SearchSubFamily(String keyword) throws SQLException {

        return DaSubfamily.searchSubfamily(keyword);
    }
}

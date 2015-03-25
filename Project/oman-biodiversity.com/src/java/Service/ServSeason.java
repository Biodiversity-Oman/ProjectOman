/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Season;
import DAL.DaSeason;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lennyasus
 */
public class ServSeason {

    public static List selectAllSeasons() throws SQLException {

        return DaSeason.selectAll();
    }

    public static String insertSeason(String name, String description) {

        try {
            if (name.length() < 1) {
                return "required";
            } else if (DaSeason.checkIfExists(name) == false) {
                Season season = new Season();
                season.setSeasonName(name);
                season.setSeasonDescription(description);
                DaSeason.insert(season);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static void deleteSeason(int id) throws SQLException {

        DaSeason.delete(id);
    }

    public static String updateSeason(String name, String description, int id) {

        try {
            if (name.length() < 1) {
                return "required";
            } else if (DaSeason.selectOneByID(id).getSeasonName().equalsIgnoreCase(name)) {
                Season s = new Season();
                s.setSeasonName(name);
                s.setSeasonDescription(description);
                s.setSeasonId(id);
                DaSeason.update(s);
                return "succes";
            } else if (DaSeason.checkIfExists(name) == false){
                Season s = new Season();
                s.setSeasonName(name);
                s.setSeasonDescription(description);
                s.setSeasonId(id);
                DaSeason.update(s);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static BLL.Season selectOneById(int id) throws SQLException {
        return DaSeason.selectOneByID(id);
    }
}

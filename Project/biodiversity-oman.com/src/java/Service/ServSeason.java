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

	public static void insertSeason(String name, String description) throws SQLException {

		Season season = new Season();
		season.setSeasonName(name);
		season.setSeasonDescription(description);
		DaSeason.insertSeason(season);
	}

	public static void deleteSeason(int id) throws SQLException {

		DaSeason.deleteSeason(id);
	}
        
          public static void updateSeason(String seasonName, String seasonDescription, int seasonId) throws SQLException {

		Season s =new Season();
                s.setSeasonName(seasonName);
                s.setSeasonDescription(seasonDescription);
                s.setSeasonId(seasonId);
                DaSeason.updateSeason(s);
	}
                 
          public static BLL.Season selectOneById(int id){
             return DaSeason.selectOneByIdSeason(id);
          }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Geolocation;
import DAL.DaGeolocation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Oualid
 */
public class ServGeolocation {

	public static Geolocation selectOneByID(int id) throws SQLException {

		return DaGeolocation.selectOneByID(id);
	}

	public static List selectAll() throws SQLException {

		return DaGeolocation.selectAll();
	}

	public static String insert(String name, String description, String coordinates) {

		try {
                                                if(coordinates.length() < 15){
                                                    return "map";
                                                } else if (DaGeolocation.checkIfExists(name) == false) {
				Geolocation geolocation = new Geolocation();
				geolocation.setAreaName(name);
				geolocation.setAreaDescription(description);
				geolocation.setCoordinates(coordinates);
				DaGeolocation.insert(geolocation);
				return "succes";
			} else {
				return "exists";
			}
		} catch (SQLException ex) {
			return "sql";
		}
	}

	public static void delete(int id) throws SQLException {

		DaGeolocation.delete(id);
	}

	public static String update(String name, String description, String coordinates, int id) {

		try {
                                            if(coordinates.length() < 5){
                                                return "map";
                                            } else if (DaGeolocation.checkIfExists(name) == false){
                                                Geolocation geolocation = new Geolocation();
			geolocation.setAreaName(name);
			geolocation.setAreaDescription(description);
			geolocation.setCoordinates(coordinates);
			geolocation.setGeolocationId(id);
			DaGeolocation.update(geolocation);
			return "succes";
                                            } else {
                                                return "exists";
                                            }
			
		} catch (SQLException ex) {
			return "sql";
		}
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.Geolocation;
import BLL.Habitat;
import DAL.DaGeolocation;
import DAL.DaHabitat;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Oualid
 */
public class ServGeolocation {

    public static List selectAllGeolocations() throws SQLException {

        return DaGeolocation.selectAll();
    }

    public static void insertGeolocation(String name, String description, String coordinates) throws SQLException {

        Geolocation geolocation = new Geolocation();
        geolocation.setAreaName(name);
        geolocation.setAreaDescription(description);
        geolocation.setCoordinates(coordinates);
        DaGeolocation.insert(geolocation);
    }

    public static void deleteGeolocation(int id) throws SQLException {

        DaGeolocation.delete(id);
    }
}

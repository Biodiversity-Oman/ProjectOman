/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.*;
import DAL.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Tom
 */
public class ServWorld {

    public static boolean checkWorld(String worldName) throws SQLException {

        return DaWorld.checkIfExists(worldName);
    }

    public static String insertWorld(String name, String description) {

        try {
            if (name.length() < 1) {
                return "required";
            } else if (DaWorld.checkIfExists(name) == false) {
                World world = new World();
                world.setWorldName(name);
                world.setDescription(description);
                DaWorld.insert(world);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static List selectAll() throws SQLException {

        return DaWorld.selectAll();
    }

    public static void deleteWorld(int id) throws SQLException {

        DaWorld.delete(id);
    }

    public static String updateWorld(String name, String description, int id) {

        try {
            if (name.length() < 1) {
                return "required";
            } else if (DaWorld.selectOneByID(id).getWorldName().equalsIgnoreCase(name)) {
                World w = new World();
                w.setWorldId(id);
                w.setWorldName(name);
                w.setDescription(description);
                DaWorld.update(w);
                return "succes";
            } else if (DaWorld.checkIfExists(name) == false) {
                World w = new World();
                w.setWorldId(id);
                w.setWorldName(name);
                w.setDescription(description);
                DaWorld.update(w);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static BLL.World selectOneById(int id) throws SQLException {

        return DaWorld.selectOneByID(id);
    }
}

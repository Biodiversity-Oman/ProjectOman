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

		return DaWorld.checkWorldExist(worldName);
	}

	public static void insertWorld(String worldName, String worldDescription) throws SQLException {
		
		World world = new World();
		world.setWorldName(worldName);
		world.setDescription(worldDescription);
		DaWorld.insertWorld(world);
	}
	
	public static List selectAll() {
		
		return DaWorld.selectAll();
	}
	
	public static void deleteWorld(int id) throws SQLException {
		
		DaWorld.deleteWorld(id);
	}
        
        public static void updateWorld(String worldName, String description) throws SQLException {

		World w = new World();
                w.setWorldName(worldName);
		w.setDescription(description);
		DaWorld.updateWorld(w);

	}

}

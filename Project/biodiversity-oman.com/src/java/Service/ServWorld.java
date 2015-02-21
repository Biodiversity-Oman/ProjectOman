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
		World world =new World();
                
                if(!world.getWorldName().equals(worldName)){
                world.setWorldName(worldName);
                world.setDescription(worldDescription);
		
		DaWorld.insertWorld(world);
                }
	}
   
}

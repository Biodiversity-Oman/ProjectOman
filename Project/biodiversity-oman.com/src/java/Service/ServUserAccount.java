/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAL.DaUserAccount;
import java.sql.SQLException;

/**
 *
 * @author lennyasus
 */
public class ServUserAccount {

	public static boolean checkPassword(String username, String password) throws SQLException {

		boolean exist;
		exist = DaUserAccount.checkPassword(username, password) == true;
		return exist;
	}
}

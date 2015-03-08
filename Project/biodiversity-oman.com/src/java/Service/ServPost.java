/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAL.DaPost;
import java.sql.SQLException;

/**
 *
 * @author bert
 */
public class ServPost {
    
    public static java.util.List<BLL.Post> selectAll()
    {
        return DAL.DaPost.selectAll();
    }
    
    public static void deletePost(int id) throws SQLException {

		DaPost.delete(id);
	}
}

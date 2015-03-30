/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import BLL.UserAccount;
import DAL.DaUserAccount;
import java.sql.SQLException;
import java.util.List;

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

    public static boolean isAdmin(String username) throws SQLException {

        boolean exist;
        exist = DaUserAccount.isAdmin(username) == true;
        return exist;
    }

    public static UserAccount selectUserAccountByUsername(String username) throws SQLException {

        UserAccount user = DaUserAccount.selectByUsername(username);
        return user;
    }

    public static String update(String username, String firstname, String lastname, String city, String country, String phone, String email) {

        try {
            UserAccount user = new UserAccount();
            user.setUserName(username);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setCity(city);
            user.setCountry(country);
            user.setPhone(phone);
            user.setEmail(email);
            DaUserAccount.update(user);
            return "succes";
        } catch (SQLException ex) {
            return "sql";
        }

    }

    public static String updatePassword(String password, String username) {

        try {
            if (password.length() < 6 || password.length() > 15) {
                return "required";
            } else {
                DaUserAccount.updatePassword(password, username);
                return "succes";
            }
        } catch (SQLException ex) {
            return "sql";
        }

    }

    public static void deleteUserAccount(String username) throws SQLException {

        DaUserAccount.delete(username);
    }

    public static List<UserAccount> selectAll() throws SQLException {

        return DaUserAccount.selectAll();
    }

    public static void setSuperUser(String username) throws SQLException {

        DaUserAccount.setSuperUser(username);
    }

    public static String insert(String username, String firstname, String lastname, String city, String country, String phone, String email, boolean isadmin, String password) {

        try {
            if (username.length() < 5  || !username.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (password.length() < 6) {
                return "required";
            } else if (!firstname.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!lastname.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!country.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!city.matches("[^()[\\\\]{}*&^%$<>#0-9@!]+$")) {
                return "required";
            } else if (!phone.matches("^[0-9./()-]*$")) {
                return "required";
            } else if (!email.matches("\\w+@\\w+.[a-z]{2,3}")) {
                return "required";
            } else if (DaUserAccount.checkUsername(username) == false) {
                UserAccount user = new UserAccount();
                user.setUserName(username);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setCity(city);
                user.setCountry(country);
                user.setPhone(phone);
                user.setEmail(email);
                user.setPassword(password);
                user.setIsAdmin(isadmin);
                DaUserAccount.insert(user);
                return "succes";
            } else {
                return "exists";
            }
        } catch (SQLException ex) {
            return "sql";
        }
    }

    public static boolean checkUsername(String username) throws SQLException {

        return DaUserAccount.checkUsername(username);
    }

    public static void setNormalUser(String username) throws SQLException {

        DaUserAccount.setNormalUser(username);
    }

    public static List<UserAccount> searchUserAccount(String keyword) throws SQLException {

        return DaUserAccount.search(keyword);
    }

    public static boolean isLastUser() throws SQLException {

        return DaUserAccount.isLastUser();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BLL.UserAccount;
import Service.ServUserAccount;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lennyasus
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		try {
			if (ServUserAccount.checkPassword(username, request.getParameter("password")) == true) {
				UserAccount user = new UserAccount();
				user.setUserName(username);
				if (ServUserAccount.isAdmin(username)==true) {
					user.setIsAdmin(true);
				} else {
					user.setIsAdmin(false);
				}
				session.setAttribute("user", user);
				response.sendRedirect("dashboard.jsp");
			} else {
				session.setAttribute("error", "Username or password not valid");
				response.sendRedirect("adminlogin.jsp");
			}
		} catch (SQLException ex) {
			if(ex.getMessage().contains("Communications")) {
				session.setAttribute("error", "Service unavailable");
				response.sendRedirect("adminlogin.jsp");
			} else if(ex.getMessage().contains("Illegal")) {
				session.setAttribute("error", "Username or password is not valid");
				response.sendRedirect("adminlogin.jsp");
			}
		} catch (NullPointerException e) {
			session.setAttribute("error", "Fill in al fields");
			response.sendRedirect("adminlogin.jsp");
		} 
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}

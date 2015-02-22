/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Service.ServUserAccount;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lennyasus
 */
@WebServlet(name = "InsertUserAccount", urlPatterns = {"/InsertUserAccount"})
public class InsertUserAccount extends HttpServlet {

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

		String password = request.getParameter("password");
		String check = request.getParameter("check");
		String username = request.getParameter("username");

		if (password.equals(check)) {
			try {
				if (ServUserAccount.checkUsername(username) == false) {
					
					ServUserAccount.insertUserAccount(request.getParameter("username"),
									  request.getParameter("firstname"),
									  request.getParameter("lastname"),
									  request.getParameter("city"),
									  request.getParameter("country"),
									  request.getParameter("phone"),
									  request.getParameter("email"),
									  request.getParameter("isadmin"),
									  request.getParameter("password"));
					response.getWriter().write("succes");
				} else {
					response.getWriter().write("error1");
				}
			} catch (Exception ex) {
				response.getWriter().write("error2");
			}
		} else {
			response.getWriter().write("error3");
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
	@Override
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}

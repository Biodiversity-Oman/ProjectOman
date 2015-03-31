/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import BLL.Organism;
import Service.ServOrganism;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric
 */
@WebServlet(name = "ViewOrganism", urlPatterns = {"/organism"})
public class ViewOrganism extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String color=""; 
        String bgcolor="";
        Organism o;
        try {
            o = ServOrganism.selectOneById(id);
            ArrayList<Organism> org = new ArrayList<>();
            org.add(o);
            
            String world = o.getWorld().getWorldName();
            if (world.toLowerCase().contains("animal")) {color = "#f44336"; bgcolor = "#EF5350";}
            else if (world.toLowerCase().contains("plant")) {color = "#4caf50"; bgcolor = "#9CCC65";}
            else if (world.toLowerCase().contains("micro")) {color = "#ffc107"; bgcolor = "#FFF176";}
            else if (world.toLowerCase().contains("marine")) {color = "#03a9f4"; bgcolor = "#29B6F6";}          
            
            request.getSession().setAttribute("view", org);
            request.getSession().setAttribute("colorscheme", color);
            request.getSession().setAttribute("bgcolorscheme", bgcolor);
            RequestDispatcher dispatcher = request.getRequestDispatcher("organismdetail.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException ex) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "");
        }
        
        
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

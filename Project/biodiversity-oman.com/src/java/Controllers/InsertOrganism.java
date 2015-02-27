/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bert
 */
@WebServlet(name = "InsertOrganism", urlPatterns = {"/InsertOrganism"})
public class InsertOrganism extends HttpServlet {

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
            
        int[] habitatIds = new int[request.getParameterValues("habitat-id").length];
        for (int i=0; i < request.getParameterValues("habitat-id").length; i++) {
        habitatIds[i] = Integer.parseInt(request.getParameterValues("habitat-id")[i]);}

        int[] seasonIds = new int[request.getParameterValues("season-id").length];
        for (int i=0; i < request.getParameterValues("season-id").length; i++) {
        seasonIds[i] = Integer.parseInt(request.getParameterValues("season-id")[i]);}

        int[] eatenByOrganismIds = new int[request.getParameterValues("eaten-by-organism-id").length];
        for (int i=0; i < request.getParameterValues("eaten-by-organism-id").length; i++) {
        eatenByOrganismIds[i] = Integer.parseInt(request.getParameterValues("eaten-by-organism-id")[i]);}

        int[] eatingOrganismIds = new int[request.getParameterValues("eating-organism-id").length];
        for (int i=0; i < request.getParameterValues("eating-organism-id").length; i++) {
        eatingOrganismIds[i] = Integer.parseInt(request.getParameterValues("eating-organism-id")[i]);}

        int[] geolocationIds = new int[request.getParameterValues("geolocation-id").length];
        for (int i=0; i < request.getParameterValues("geolocation-id").length; i++) {
        geolocationIds[i] = Integer.parseInt(request.getParameterValues("geolocation-id")[i]);}


        response.getWriter().write(Service.ServOrganism.insert(request.getParameter("scientific-name"), 
                                                                request.getParameter("common-name"), 
                                                                request.getParameter("local-name"), 
                                                                request.getParameter("description"), 
                                                                Integer.parseInt(request.getParameter("subfamily-id")), 
                                                                Integer.parseInt(request.getParameter("family-id")), 
                                                                Integer.parseInt(request.getParameter("world-id")), 
                                                                habitatIds, 
                                                                request.getParameter("population"), 
                                                                seasonIds, 
                                                                Boolean.parseBoolean(request.getParameter("indigenous")), 
                                                                Boolean.parseBoolean(request.getParameter("cultivated")), 
                                                                Boolean.parseBoolean(request.getParameter("endangered")), 
                                                                Boolean.parseBoolean(request.getParameter("medicinal")), 
                                                                request.getParameter("benefits"), 
                                                                request.getParameter("dangerous"),
                                                                request.getParameter("threats"), 
                                                                request.getParameter("opportunities"), 
                                                                Byte.parseByte(request.getParameter("photo")), 
                                                                request.getParameter("links"), 
                                                                eatenByOrganismIds, 
                                                                eatingOrganismIds, 
                                                                Boolean.parseBoolean(("validated")), 
                                                                request.getParameter("food-name"), 
                                                                request.getParameter("food-description"), 
                                                                geolocationIds));
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

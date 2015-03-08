/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author bert
 */
@WebServlet(name = "InsertOrganism", urlPatterns = {"/InsertOrganism"})
@MultipartConfig
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
        
		int[] habitatIds = null;
		int[] seasonIds = null;
		int[] eatenByOrganismIds = null;
		int[] eatingOrganismIds = null;
		int[] geolocationIds = null;

		if (request.getParameterValues("organism-habitat-id") != null) {
			habitatIds = new int[request.getParameterValues("organism-habitat-id").length];
			for (int i = 0; i < request.getParameterValues("organsm-habitat-id").length; i++) {
				habitatIds[i] = Integer.parseInt(request.getParameterValues("organism-habitat-id")[i]);
			}
		}
		if (request.getParameterValues("organism-season-id") != null) {
			seasonIds = new int[request.getParameterValues("organism-season-id").length];
			for (int i = 0; i < request.getParameterValues("organism-season-id").length; i++) {
				seasonIds[i] = Integer.parseInt(request.getParameterValues("organism-season-id")[i]);
			}
		}
		if (request.getParameterValues("eaten-by-organism-id") != null) {
			eatenByOrganismIds = new int[request.getParameterValues("eaten-by-organism-id").length];
			for (int i = 0; i < request.getParameterValues("eaten-by-organism-id").length; i++) {
				eatenByOrganismIds[i] = Integer.parseInt(request.getParameterValues("eaten-by-organism-id")[i]);
			}
		}
		if (request.getParameterValues("eating-organism-id") != null) {
			eatingOrganismIds = new int[request.getParameterValues("eating-organism-id").length];
			for (int i = 0; i < request.getParameterValues("eating-organism-id").length; i++) {
				eatingOrganismIds[i] = Integer.parseInt(request.getParameterValues("eating-organism-id")[i]);
			}
		}
		if (request.getParameterValues("organism-geolocation-id") != null) {
			geolocationIds = new int[request.getParameterValues("organism-geolocation-id").length];
			for (int i = 0; i < request.getParameterValues("organism-geolocation-id").length; i++) {
				geolocationIds[i] = Integer.parseInt(request.getParameterValues("organism-geolocation-id")[i]);
			}
		}
        Part filePart = request.getPart("upfileOrganism"); 
        InputStream fileContent = filePart.getInputStream();
        byte[] bytes = IOUtils.toByteArray(fileContent);
        if (bytes.length == 0) {
            bytes = new byte[2];
        }
	    response.getWriter().write(Service.ServOrganism.insert(request.getParameter("organism-scientific-name"),
															   request.getParameter("organism-common-name"),
															   request.getParameter("organism-local-name"),
															   request.getParameter("organism-description"),
															   Integer.parseInt(request.getParameter("organism-subfamily-id")),
															   habitatIds,
															   request.getParameter("organism-population"),
															   seasonIds,
															   Boolean.parseBoolean(request.getParameter("organism-indigenous")),
															   Boolean.parseBoolean(request.getParameter("organism-cultivated")),
															   Boolean.parseBoolean(request.getParameter("organism-endangered")),
															   Boolean.parseBoolean(request.getParameter("organism-medicinal")),
															   request.getParameter("organism-benefits"),
															   request.getParameter("organism-dangerous"),
															   request.getParameter("organism-threats"),
															   request.getParameter("organism-opportunities"),
															   bytes,
															   request.getParameter("organism-links"),
															   eatenByOrganismIds,
															   eatingOrganismIds,
															   request.getParameter("organism-food-name"),
															   request.getParameter("organism-food-description"),
															   geolocationIds));
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

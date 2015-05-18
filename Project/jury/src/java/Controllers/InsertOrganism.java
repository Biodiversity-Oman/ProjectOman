/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.imageio.ImageIO;
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
        response.setContentType("text/html;charset=UTF-8");

        int[] habitatIds = null;
        int[] seasonIds = null;
        int[] eatenByOrganismIds = null;
        int[] eatingOrganismIds = null;
        int[] geolocationIds = null;
        int subfamilyId = 0;

        if (request.getParameterValues("organism-habitat-id") != null) {
            habitatIds = new int[request.getParameterValues("organism-habitat-id").length];
            for (int i = 0; i < request.getParameterValues("organism-habitat-id").length; i++) {
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
        
        if (request.getParameter("organism-subfamily-id") != null){
            subfamilyId = Integer.parseInt(request.getParameter("organism-subfamily-id"));
        }
        
        Part filePart = request.getPart("upfileOrganism");
        InputStream fileContent = filePart.getInputStream();
        byte[] bytes = IOUtils.toByteArray(fileContent);
        
        if (bytes.length == 0) {
            BufferedImage image = ImageIO.read(URI.create("http://fuengirolapoolleague.com/bar_images//no-image-available-icon-303.jpg").toURL());
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", b);
            bytes = b.toByteArray();
        }

        response.getWriter().write(Service.ServOrganism.insert(new String(request.getParameter("organism-scientific-name").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-common-name").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-local-name").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-description").getBytes("iso-8859-1"), "UTF-8"),
                subfamilyId,
                habitatIds,
                new String(request.getParameter("organism-population").getBytes("iso-8859-1"), "UTF-8"),
                seasonIds,
                Boolean.parseBoolean(request.getParameter("organism-indigenous")),
                Boolean.parseBoolean(request.getParameter("organism-cultivated")),
                Boolean.parseBoolean(request.getParameter("organism-endangered")),
                Boolean.parseBoolean(request.getParameter("organism-medicinal")),
                new String(request.getParameter("organism-benefits").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-dangerous").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-threats").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-opportunities").getBytes("iso-8859-1"), "UTF-8"),
                bytes,
                new String(request.getParameter("organism-links").getBytes("iso-8859-1"), "UTF-8"),
                eatenByOrganismIds,
                eatingOrganismIds,
                new String(request.getParameter("organism-food-name").getBytes("iso-8859-1"), "UTF-8"),
                new String(request.getParameter("organism-food-description").getBytes("iso-8859-1"), "UTF-8"),
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
        response.setContentType("text/html;charset=UTF-8");

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

<%-- 
    Document   : organismdetail
    Created on : 18-mrt-2015, 1:53:04
    Author     : Eric
--%>
<%@page import="BLL.Geolocation"%>
<%@page import="BLL.Season"%>
<%@page import="BLL.Habitat"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BLL.Organism"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Organism> organism = (ArrayList<Organism>) session.getAttribute("view");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="StyleSheet" type="text/css" href="css/main.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%for (Organism o : organism) {
        %>
        <div class="wrapper">
            <div class="col-lg-12" >               
                <div class="col-lg-2 col-md-offset-2 text-left">
                    <div>
                        <label>Scientific name:</label>                                                
                        <label><%= o.getScientificName()%></label>
                    </div>
                    <div>
                        <label>Local name:</label>                                                
                        <label><%= o.getLocalName()%></label>
                    </div>                                                        
                    <div>
                        <label>Population:</label>
                        <label><%= o.getPopulation()%></label>
                    </div>
                    <div>
                        <label>Geolocation(s):</label>
                        <%
                            for (Geolocation g : o.getGeolocations()) {%>
                        <label>
                            <%= g.getAreaName()%>
                        </label>
                        <%}
                        %>
                    </div>
                    <div>
                        <label>World:</label>
                        <label><%= o.getWorld().getWorldName()%></label>
                    </div>
                    <div>
                        <label>Family:</label>
                        <label><%= o.getFamily().getFamilyName()%></label>
                    </div>                                                                               
                    <div>
                        <label>Breed:</label>                                                
                        <label><%= o.getSubfamily().getSubfamilyName()%></label>
                    </div>
                    <div>
                        <label>Habitat:</label>                                                
                        <%
                            for (Habitat h : o.getHabitat()) {%>
                        <label>
                            <%= h.getHabitatName()%>
                        </label>                                
                        <%}
                        %>
                    </div>
                    <div>
                        <label>Season:</label>                                                
                        <%
                            for (Season s : o.getSeason()) {%>
                        <label>
                            <%= s.getSeasonName()%>
                        </label>                                
                        <%}
                        %>
                    </div> 
                </div>                    
                <div class="col-lg-2">
                    <div>
                        <label>Indigenous:</label>
                        <label><%
                            Boolean bI = o.getIndigenous();
                            if (bI) {
                            %>Yes<%
                            } else {%> No <%}

                            %></label>
                    </div>
                    <div>
                        <label>Cultivated:</label>                                                
                        <label>
                            <%                                Boolean bC = o.getCultivated();
                                if (bC) {
                            %>Yes<%
                            } else {%> No <%}

                            %>
                        </label>
                    </div>
                    <div>
                        <label>Endangered:</label>                                                
                        <label>
                            <%                                Boolean bE = o.getEndangered();
                                if (bE) {
                            %>Yes<%
                            } else {%> No <%}

                            %>
                        </label>
                    </div>
                    <div>
                        <label>Medicinal:</label>                                                
                        <label>
                            <%                                Boolean bM = o.getMedicinal();
                                if (bM) {
                            %>Yes<%
                            } else {%> No <%}

                            %>
                        </label>
                    </div>
                    <div>
                        <label>Eats:</label>                                                
                        <%                                for (Organism or : o.getEatingOrganisms()) {%>
                        <label>
                            <%= or.getCommonName()%>
                        </label>                                
                        <%}
                        %>
                    </div>
                    <div>
                        <label>Gets eaten by:</label>                                                
                        <%
                        for (Organism or : o.getEatingOrganisms()) {%>
                        <label>
                            <%= or.getCommonName()%>
                        </label>                                
                        <%}
                        %>
                    </div>
                </div>
                <div class="col-lg-3 col-md-offset-1 text-right">
                    <img height="80%" width="80%" src="${pageContext.request.contextPath}/SelectPhotoById?id=<%=o.getOrganismId()%>">
                </div> 
                
                <div class="col-lg-8 text-left col-md-offset-2">
                    <br>
                    <br>
                    <div>
                        <label>Description:</label>                                                
                        <p><%= o.getDescription()%></p>
                    </div>
                    <div>
                        <label>Threats:</label>                                                
                        <p><%= o.getThreats()%></p>
                    </div>
                    <div>
                        <label>Opportunities:</label>                                                
                        <p><%= o.getOpportunities()%></p>
                    </div>
                    <div>
                        <label>Benefits:</label>                                                
                        <p><%= o.getBenefits()%></p>
                    </div>
                    <div>
                        <label>Links:</label>
                        <a href="<%=  o.getLinks()%>"> Click to learn more</a>
                    </div>
                </div>
            </div>  
        </div>
        <%}%>
    </body>
</html>



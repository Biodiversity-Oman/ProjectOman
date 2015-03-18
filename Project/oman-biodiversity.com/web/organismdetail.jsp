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
    String bgcolor = session.getAttribute("colorscheme").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="StyleSheet" type="text/css" href="css/main.css">
        <link rel="StyleSheet" type="text/css" href="css/fonts/fonts.min.css">
        <script src='js/jquery.min.js'></script>
        <script src='js/view.js'></script>
        <title>Detailed view</title>
    </head>
    <body>
        <script>

            $(document).ready(function () {

                $("#slide-info").click(function () {
                    $("#info-panel").slideToggle("slow");
                });
            });
        </script>
        <%for (Organism o : organism) {
        %>
        <div class="wrapper">
            <div class="col-lg-8 col-md-offset-2" id="detail-header" style="background-color: <%= bgcolor %>">               
                    <h2 class="text-center"> <%= o.getCommonName()%></h2>
            </div>
            <div class="col-lg-12"> 
                <br>
                <br>
                <div class="col-lg-3 col-md-offset-2 text-left">
                    <img id="img" src="${pageContext.request.contextPath}/SelectPhotoById?id=<%=o.getOrganismId()%>">
                </div> 
                <div class="col-lg-2 col-md-offset-1 text-left">
                    <br>
                    <fieldset>
                        <legend>Taxonomy</legend>
                        <div class="detail-container">
                        <div>
                            <label>Scientific name:</label>                                                
                            <label class="detail-text"><%= o.getScientificName()%></label>
                        </div>
                        <div>
                            <label>Local name:</label>                                                
                            <label class="detail-text"><%= o.getLocalName()%></label>
                        </div>                                                        
                        <div>
                            <label>Population:</label>
                            <label class="detail-text"><%= o.getPopulation()%></label>
                        </div>
                        <div>
                            <label>Geolocation(s):</label>
                            <%
                            for (Geolocation g : o.getGeolocations()) {%>
                            <label class="detail-text">
                                <%= g.getAreaName()+", "%>
                            </label>
                            <%}
                            %>
                        </div>
                        <div>
                            <label>World:</label>
                            <label class="detail-text"><%= o.getWorld().getWorldName()%></label>
                        </div>
                        <div>
                            <label>Family:</label>
                            <label class="detail-text"><%= o.getFamily().getFamilyName()%></label>
                        </div>                                                                               
                        <div>
                            <label>Breed:</label>                                                
                            <label class="detail-text"><%= o.getSubfamily().getSubfamilyName()%></label>
                        </div>
                        <div>
                            <label>Habitat:</label>                                                
                            <%
                            for (Habitat h : o.getHabitat()) {%>
                            <label class="detail-text">
                                <%= h.getHabitatName() + ", "%>
                            </label>                                
                            <%}
                            %>
                        </div>
                        <div>
                            <label>Season:</label>                                                
                            <%
                            for (Season s : o.getSeason()) {%>
                            <label class="detail-text">
                                <%= s.getSeasonName() + ", "%>
                            </label>                                
                            <%}
                            %>
                        </div> 
                </div>
                    </fieldset>
                </div>                    
                <div class="col-lg-2">
                    <br>
                    <fieldset>                        
                        <legend>Interesting Facts</legend>
                        <div class="detail-container">
                        <div>
                            <label>Indigenous:</label>
                            <label class="detail-text"><%
                                Boolean bI = o.getIndigenous();
                                if (bI) {
                                %>Yes<%
                            } else {%> No <%}

                                %></label>
                        </div>
                        <div>
                            <label>Cultivated:</label>                                                
                            <label class="detail-text">
                                <%                                Boolean bC = o.getCultivated();
                                    if (bC) {
                                %>Yes<%
                            } else {%> No <%}

                                %>
                            </label>
                        </div>
                        <div>
                            <label>Endangered:</label>                                                
                            <label class="detail-text">
                                <%                                Boolean bE = o.getEndangered();
                                    if (bE) {
                                %>Yes<%
                            } else {%> No <%}

                                %>
                            </label>
                        </div>
                        <div>
                            <label>Medicinal:</label>                                                
                            <label class="detail-text">
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
                            <label class="detail-text">
                                <%= or.getCommonName() + ", "%>
                            </label>                                
                            <%}
                            %>
                        </div>
                        <div>
                            <label>Gets eaten by:</label>                                                
                            <%
                            for (Organism or : o.getEatingOrganisms()) {%>
                            <label class="detail-text">
                                <%= or.getCommonName() + ", "%>
                            </label>                                
                            <%}
                            %>
                        </div>
                        </div>
                    </fieldset>
                </div>  
            </div>
                <div class="col-lg-8 text-left col-md-offset-2">
                    <br>
                    <br>
                    <fieldset>
                        <div id="slide-info">
                            <legend>Click or tap here for more info</legend>
                        </div>
                        <div class="slide-panel detail-container" id="info-panel">
                            <div>
                                <label class="detail-container">Description:</label>                                                
                                <p class="detail-text"><%= o.getDescription()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Threats:</label>                                                
                                <p class="detail-text"><%= o.getThreats()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Opportunities:</label>                                                
                                <p class="detail-text"><%= o.getOpportunities()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Benefits:</label>                                                
                                <p class="detail-text"><%= o.getBenefits()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Links:</label>
                                <p><a href="<%=  o.getLinks()%>"> <%= o.getLinks()%></a></p>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>  
        <%}%>
    </body>
</html>



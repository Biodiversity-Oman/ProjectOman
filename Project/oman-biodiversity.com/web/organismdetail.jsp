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
    String headcolor = session.getAttribute("colorscheme").toString();
    String bgcolor = session.getAttribute("bgcolorscheme").toString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="StyleSheet" type="text/css" href="css/main.min.css">
        <link rel="StyleSheet" type="text/css" href="css/fonts/fonts.min.css" media="none" onload="if(media!='all')media='all'">
        <title>Detailed view</title>
    </head>
    <body>
        <%for (Organism o : organism) {
        %>
        <div class="col-lg-12 detail-back">
            <div class="col-lg-8 col-md-offset-2 detail-header" style="background-color: <%= headcolor%>">               
                <h2 class="text-center"> <%= o.getCommonName()%></h2>
            </div>
            <div class="col-lg-8 col-md-offset-2 detail-container rsp" style="background-color: <%= bgcolor%>"> 
                <br>
                <br>
                <div class="col-lg-3 col-md-offset-1 text-left">                    
                    <a href="index.jsp#worlds"><button class="button btn-material-orange">Click here and learn about their world and others</button></a>
                    <br>
                    <br>
                    <img class="img-responsive" src="SelectPhotoById?id=<%=o.getOrganismId()%>"> 
                    <br>
                </div> 
                <div class="col-lg-3 col-md-offset-1 text-left">
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
                                    <%= g.getAreaName() + ", "%>
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
                            <br>
                </div>                    
                <div class="col-lg-3 col-md-offset-1 text-left">
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
                <div class="col-lg-11 text-left col-md-offset-1">
                    <br>
                    <br>
                    <fieldset>
                        <div id="slide-info">
                            <legend><span class="glyphicon glyphicon-collapse-down"></span>Learn more</legend>
                            <br>
                        </div>
                        <div class="slide-panel detail-container" style="background-color: <%= bgcolor%>" id="info-panel">
                            <div>
                                <label class="detail-container">Description:</label>                                                
                                <p class="detail-text minimize"><%= o.getDescription()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Threats:</label>                                                
                                <p class="detail-text minimize"><%= o.getThreats()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Opportunities:</label>                                                
                                <p class="detail-text minimize"><%= o.getOpportunities()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Benefits:</label>                                                
                                <p class="detail-text minimize"><%= o.getBenefits()%></p>
                            </div>
                            <div>
                                <label class="detail-container">Links:</label>
                                <p><a href="<%=  o.getLinks()%>"> <%= o.getLinks()%></a></p>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <%}%>                
            </div>
            <div class="col-lg-8 col-md-offset-2 footer-detail">
                <div class="col-lg-8 col-md-offset-1">
                    <br>
                    <h1><u>About us</u></h1>
                </div>                
                <div class="col-lg-3 col-md-offset-1">                    
                    <h2>Developers</h2>
                    <p>Tom Adriaens</p>
                    <p>Lenny Donnez</p>
                    <p>Eric Michiels</p>
                    <p>Bert Cortois</p>
                    <p>Oualid Yousfi</p>
                </div>
                <div class="col-lg-3 col-md-offset-1">
                    <h2>Project Leader</h2>
                    <p>Filip Keunen</p>
                </div>
                <div class="col-lg-3 col-md-offset-1" >
                    <p><img src="img/logo-aopgrc.png" width="120" height="110"></p>
                </div>
            </div>
        </div>
        <script type="text/javascript" src='js/jquery.min.js'></script>
        <script type="text/javascript" src='js/view.min.js'></script>
        <script type="text/javascript" async src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript">
	    $(document).ready(function(){$("#slide-info").click(function(){$("#info-panel").slideToggle("slow")})}),$(function(){var e=$("p.minimize");e.each(function(){var e=$(this).text();e.length<200||$(this).html(e.slice(0,200)+'<span>... </span><a href="#" class="more">more</a><span style="display:none;">'+e.slice(200,e.length)+' <a href="#" class="less">less</a></span>')}),$("a.more",e).click(function(e){e.preventDefault(),$(this).hide().prev().hide(),$(this).next().show()}),$("a.less",e).click(function(e){e.preventDefault(),$(this).parent().hide().prev().show().prev().show()})});
        </script>
    </body>
</html>



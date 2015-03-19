<%-- 
    Document   : header
    Created on : Dec 22, 2014, 7:29:35 PM
    Author     : lenny
--%>


<%@page import="BLL.UserAccount"%>
<%
    String username = null;
    UserAccount us = (UserAccount) session.getAttribute("user");
    if (us != null) {
        username = us.getUserName();
    } else {
        String message = "You are not logged in";
        session.setAttribute("error", message);
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
                <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
                <script src="js/jquery.min.js"></script>
                <script src="js/loaders.js"></script>
                <script src="js/ajax.js"></script>
                <script src="js/maps.js"></script>
                <script src="js/validator.js"></script>
                <script src="js/chosen.jquery.min.js"></script>
                <script src="js/bootbox.min.js"></script>
                <link rel="StyleSheet" type="text/css" href="css/admin.min.css">
                <link rel="StyleSheet" type="text/css" href="css/icons.min.css">
                <link rel="StyleSheet" type="text/css" href="css/chosen.min.css">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js" async></script>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        </head>
        <title>Welcome, <%= username%>  </title>
        <script>
            function adminCheck() {
                <%if (us.getIsAdmin() == false){%> 
                    $(".no-button").each(function () {
                    $(this).hide();
                });
                <%} else {%>
                <%}%>
            };
        </script>
<nav>
        <ul>
                <li><a href="dashboard.jsp" ><span class="icon-home"></span><Strong>Dashboard</strong></a></li>
                <li><a href="mailto:developersteam.belgium@gmail.com?Subject=Incident Report" target="_top"><strong class="error-message">Version 0.1 - For any problems click here to mail</strong></a></li>               
                <li class="right"><a href="Logout"><span class="icon-exit"></span><strong>Log out</strong></a></li>
                <li class="right"><a href="userinfo.jsp"><span class="icon-user"></span><strong><%=username%></strong></a></li>
                <li class="right" id="adminuser"></li>
                <li class="right" id="adminpublish"></li>
        </ul>
</nav>
<script>
        var adminuser = document.getElementById('adminuser');
        var adminpublish = document.getElementById('adminpublish');
        <%if (us.getIsAdmin() == true) {%>
            adminuser.innerHTML += '<a href="usermanagement.jsp"><span class="icon-users"></span><strong>User Management</strong></a>';
            adminpublish.innerHTML += '<a href="publish.jsp"><span class="icon-book"></span><strong>Publish</strong></a>';
        <%} else {%>
            adminuser.innerHTML += '';
            adminpublish.innerHTML += '';
        <%}%>
</script>
</html>

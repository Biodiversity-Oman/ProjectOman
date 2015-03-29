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
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name=viewport />
<link rel=StyleSheet type="text/css" href="css/admin.min.css">
<link rel=StyleSheet type="text/css" href="css/icons.min.css">
<link rel=StyleSheet type="text/css" href="css/chosen.min.css">
<link rel=stylesheet href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<title>Welcome, admin </title>
</head>
<nav>
<ul>
<li><a href=dashboard.jsp><span class=icon-home></span><strong>Dashboard</strong></a></li>
<li><a href="mailto:developersteam.belgium@gmail.com?Subject=Incident Report" target=_top><strong class=error-message>Version 0.2 - For any problems click here to mail</strong></a></li>
<li class=right><a href=Logout><span class=icon-exit></span><strong>Log out</strong></a></li>
<li class=right><a href=userinfo.jsp><span class=icon-user></span><strong>admin</strong></a></li>
<li class=right id=adminuser></li>
<li class=right id=adminpublish></li>
</ul>
</nav>
</html>

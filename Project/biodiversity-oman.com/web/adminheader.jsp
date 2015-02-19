<%-- 
    Document   : header
    Created on : Dec 22, 2014, 7:29:35 PM
    Author     : lenny
--%>


<%@page import="BLL.UserAccount"%>
<%
	// username variable wordt enkel gevuld als er een username object is. deze wordt enkel aangemaakt als een gebruiker succesvol is ingelogt (Login controller)
	String username = null;
	UserAccount us = (UserAccount) session.getAttribute("user");
	if (us != null) {
		username = us.getUserName();

	} else {
	// wanneer er geen us.Object is aangemaakt redirect de server terug naar adminlogin.jsp. dit is om te voorkomen dat de gebruiker in de browser wwww.domain.com/welcome.jsp kan gebruike om	  // login te omzeilen.
		String message = "You are not logged in";
		session.setAttribute("error", message);
		response.sendRedirect("adminlogin.jsp");
		return;
	}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
		<script src="js/jquery.js"></script>
		<link rel="StyleSheet" type="text/css" href="css/admin.css">
		<link rel="StyleSheet" type="text/css" href="css/icons.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
        </head>
	<!--[if lte IE 10]>
	 <style type="text/css">#ie6_banner{background:#333;width:100%;position:relative;padding:15px 0;margin:0;border-bottom:1px solid #111;z-index:999;}#ie6_wrap{width:1000px;margin:0 auto;}#ie6_wrap h1{font-size:18px;text-transform:none;color:#fff;background:none;margin:0 0 10px;padding:0;font-weight:bold;}#ie6_wrap p{text-align:left;font-size:12px;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-weight:normal;color:#fff;background:none;line-height:16px;margin:0;}#ie6_wrap p a{color:#fff;background:none;text-decoration:underline;font-size:12px;}#ie6_wrap p a:hover{color:#fff;background:none;text-decoration:none;}#ie6_links{float:right;width:272px;}#ie6_links a{float:left;background:#5a5a5a;width:85px;height:27px;padding:12px 0 0 50px;margin:0 1px 1px 0;color:#fff;}#ie6_links a:hover{text-decoration:underline;}#ie6_links img{position:absolute;margin:-5px 0 0 -35px;border:none;}</style><div id="ie6_banner"><div id="ie6_wrap"><div id="ie6_links"><a href="http://www.mozilla.com/nl"><img src="http://www.wijstoppenook.nl/site/gfx/firefox_small.png" alt="" />Firefox</a><a href="http://www.google.com/chrome"><img src="http://www.wijstoppenook.nl/site/gfx/chrome_small.png" alt="" />Chrome</a><a href="http://www.apple.com/safari"><img src="http://www.wijstoppenook.nl/site/gfx/safari_small.png" alt="" />Safari</a><a href="http://www.opera.com"><img src="http://www.wijstoppenook.nl/site/gfx/opera_small.png" alt="" />Opera</a> </div><h1>U gebruikt een verouderde versie van Internet Explorer</h1><p>Helaas wordt Internet Explorer 9 of ouder niet meer volledig ondersteund op deze website. Wij raden u aan over te schakelen naar een moderne internetbrowser. U kunt natuurlijk kiezen voor <a href="http://www.microsoft.com/ie">Internet Explorer 11</a>. Beter nog kiest u een browser uit het overzicht hiernaast.<br /> Deze browsers zijn veelal sneller, veiliger en voldoen beter aan de webstandaarden.</p></div></div>
	 <![endif]-->
        <title>Welkom, </title>
</head>
<nav>
	<ul>
		<!-- hamburger menu icoon voor responsive design. wordt enkel getoont op mobile resoluties-->
		<li class="current"><a href="#" onclick=""><span class="icon-menu"></span></a></li>
		<!-- ------------------------------------------------------------------------------------>
		<!-- alle menu items aan de linkerkant -->
		<li><a href="dashboard.jsp" ><span class="icon-home"></span><Strong>Dashboard</strong></a></li>
		
		<!--------------------------------------------------------------------------------------->
		<!-- alle menu items aan de rechterkant -->
		<li class="right"><a href="Logout"><span class="icon-exit"></span><strong>Log out</strong></a></li>
		<li class="right"><a href="userinfo.jsp"><span class="icon-user"></span><strong><%=username%></strong></a></li>
		<li class="right" id="adminuser"></li>
		<li class="right" id="adminpublish"></li>
		<!--------------------------------------------------------------------------------------->
	</ul>
</nav>
<!-- dit stukje javascript zorgt ervoor dat een gewone user de admin paginas niet kan zien. --->	    
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

<%-- 
    Document   : header
    Created on : Mar 12, 2015, 1:56:16 PM
    Author     : lenny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="StyleSheet" type="text/css" href="css/main.min.css">
	<link rel="StyleSheet" type="text/css" href="css/fonts/fonts.min.css">
	<link rel="StyleSheet" type="text/css" href="css/icons.min.css">
	<link rel='stylesheet' href='css/fullcalendar.min.css' />
	<link rel="stylesheet" href="css/slicknav.min.css" />
	<title>Oman-Biodiversity</title>
    </head>
    <nav>
	<body>
	    <ul id="menu">
		<li><img src="img/logo-roadshow.png" height="58" width="103"></li>
		<li><a href="#event">Event</a></li>
		<li ><a href="#event-calendar">Calendar</a></li>
		<li><a href="#worlds">Worlds</a></li>
		<li><a href="#fun-stuff">Fun stuff</a></li>
		<li><a href="#about-us">About us</a></li>
	    </ul>
	    <script type="text/javascript" src = 'js/jquery.min.js' ></script>
	    <script type="text/javascript" src="js/jquery.slicknav.min.js"></script>
	    <script>
		$(function () {
		    $("#menu").slicknav({label: ""});
		});
	    </script>
	</body>
    </nav>
</html>

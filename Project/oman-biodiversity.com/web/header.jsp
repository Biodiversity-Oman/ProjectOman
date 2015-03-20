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
        <link rel="StyleSheet" type="text/css" href="css/main.css">
        <link rel="StyleSheet" type="text/css" href="css/fonts/fonts.min.css">
        <link rel="StyleSheet" type="text/css" href="css/icons.min.css">
        <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
        <link rel='stylesheet' href='css/fullcalendar.min.css' />
        <link rel="stylesheet" href="css/slicknav.min.css" />
        <script src='js/jquery.min.js'></script>
        <script src='js/moment.min.js'></script>
        <script src='js/fullcalendar.min.js'></script>
        <script src='js/gcal.min.js'></script>
        <script src="js/jquery.slicknav.min.js"></script>
        <script type="text/javascript" src="js/instafeed.min.js"></script>
        <script src='js/view.js'></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <title>Oman-Biodiversity</title>
    </head>
    <script>
        $(function () {
            $("#menu").slicknav({label: ""});
        });
        $(function () {
            var minimized_elements = $('p.minimize');
            minimized_elements.each(function () {
                var t = $(this).text();
                if (t.length < 200)
                    return;
                $(this).html(
                        t.slice(0, 200) + '<span>... </span><a href="#" class="more">more</a>' +
                        '<span style="display:none;">' + t.slice(200, t.length) + ' <a href="#" class="less">less</a></span>'
                        );
            });
            $('a.more', minimized_elements).click(function (event) {
                event.preventDefault();
                $(this).hide().prev().hide();
                $(this).next().show();
            });
            $('a.less', minimized_elements).click(function (event) {
                event.preventDefault();
                $(this).parent().hide().prev().show().prev().show();
            });
        });
    </script>
    <nav>
        <ul id="menu">
            <li><img src="img/logo-roadshow.png" height="58" width="103"></li>
            <li><a href="#event">Event</a></li>
            <li ><a href="#event-calendar">Calendar</a></li>
            <li><a href="#worlds">Worlds</a></li>
            <li><a href="#fun-stuff">Fun stuff</a></li>
            <li><a href="#about-us">About us</a></li>
        </ul>
    </nav>
</html>

<%-- 
    Document   : redirect
    Created on : Dec 23, 2014, 9:37:44 PM
    Author     : lenny
--%>
<%
    response.setHeader("Refresh", "5; URL=adminlogin.jsp");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <label>You will be redirected in 5 seconds.</label>
    </body>
</html>

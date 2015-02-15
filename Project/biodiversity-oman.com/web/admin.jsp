<%-- 
    Document   : admin
    Created on : Feb 14, 2015, 1:48:11 PM
    Author     : Oualid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="StyleSheet" type="text/css" href="css/style.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    </head>
    <body>
        <h1>Admin</h1>
        <div class="input-group">
            <label for="first_name">First name</label>
            <input id="first_name" type="text" >
            <label for="last_name">Last name</label>
            <input id="last_name" type="text" >
        </div>
        <div class="input-group">
            <label for="city">City</label>
            <input id="city" type="text" >
        </div>
        <div class="input-group">
            <label for="country">Country</label>
            <input id="country" type="text" >
        </div>
        <div class="input-group">
            <label for="email">E-mail</label>
            <input id="email" type="text" >
        </div>
        <div class="input-group">
            <label for="phone">Phone number</label>
            <input id="phone" type="text" >
        </div>
        <button class="button">Change password</button>
    </body>
</html>

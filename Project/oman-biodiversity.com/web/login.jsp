<%-- 
    Document   : adminlogin
    Created on : Feb 16, 2015, 11:47:48 PM
    Author     : lennyasus
--%>
<%
    String error = (String) session.getAttribute("error");
    String message = " ";
    if (error == null) {
        session.removeAttribute("error");
    } else {
        message = error;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color: #ffffff">
    <head>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <link rel="StyleSheet" type="text/css" href="css/admin.css">
        <script src="js/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <title>Admin</title>
        <!--[if lte IE 10]>
        <style type="text/css">#ie6_banner{background:#333;width:100%;position:relative;padding:15px 0;margin:0;border-bottom:1px solid #111;z-index:999;}#ie6_wrap{width:1000px;margin:0 auto;}#ie6_wrap h1{font-size:18px;text-transform:none;color:#fff;background:none;margin:0 0 10px;padding:0;font-weight:bold;}#ie6_wrap p{text-align:left;font-size:12px;font-family:'Helvetica Neue', Helvetica, Arial, sans-serif;font-weight:normal;color:#fff;background:none;line-height:16px;margin:0;}#ie6_wrap p a{color:#fff;background:none;text-decoration:underline;font-size:12px;}#ie6_wrap p a:hover{color:#fff;background:none;text-decoration:none;}#ie6_links{float:right;width:272px;}#ie6_links a{float:left;background:#5a5a5a;width:85px;height:27px;padding:12px 0 0 50px;margin:0 1px 1px 0;color:#fff;}#ie6_links a:hover{text-decoration:underline;}#ie6_links img{position:absolute;margin:-5px 0 0 -35px;border:none;}</style><div id="ie6_banner"><div id="ie6_wrap"><div id="ie6_links"><a href="http://www.mozilla.com/nl"><img src="http://www.wijstoppenook.nl/site/gfx/firefox_small.png" alt="" />Firefox</a><a href="http://www.google.com/chrome"><img src="http://www.wijstoppenook.nl/site/gfx/chrome_small.png" alt="" />Chrome</a><a href="http://www.apple.com/safari"><img src="http://www.wijstoppenook.nl/site/gfx/safari_small.png" alt="" />Safari</a><a href="http://www.opera.com"><img src="http://www.wijstoppenook.nl/site/gfx/opera_small.png" alt="" />Opera</a> </div><h1>U gebruikt een verouderde versie van Internet Explorer</h1><p>Helaas wordt Internet Explorer 9 of ouder niet meer volledig ondersteund op deze website. Wij raden u aan over te schakelen naar een moderne internetbrowser. U kunt natuurlijk kiezen voor <a href="http://www.microsoft.com/ie">Internet Explorer 11</a>. Beter nog kiest u een browser uit het overzicht hiernaast.<br /> Deze browsers zijn veelal sneller, veiliger en voldoen beter aan de webstandaarden.</p></div></div>
        <![endif]-->
    </head>
    <body style="background-color: #ffffff;">
        <div class="login col-md-6 col-md-offset-3">
            <form class="form form-horizontal" method="POST" action="Login">
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="username">Username</label>
                    <div class="col-sm-7">
                        <input class="form-control" type="text" name="username" required />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label" for="username">Password</label>
                    <div class="col-sm-7">
                        <input class="form-control" type="password" name="password" required />
                    </div>
                </div>
                <div class="form-group " >
                    <label class="col-sm-3 control-label">Language</label>
                    <div class="col-sm-7" >
                        <label class="radio-inline">
                            <input type="radio" name="language" checked="true" id="language" value="0" />English
                        </label>
                        <label class="radio-inline" >
                            <input type="radio" name="language" id="language" value="1" />Arabic
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> </label>
                    <div class="col-sm-3">
                        <button class="btn btn-default" type="submit">Login</button>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"></label>
                    <label class="error-message"><%=message%></label>
                </div>
            </form>
        </div>
    </body>
</html>

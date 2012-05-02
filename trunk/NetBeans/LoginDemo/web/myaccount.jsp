<%-- 
    Document   : myaccount
    Created on : 18 Apr, 2012, 4:12:57 PM
    Author     : behera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account Page</title>
    </head>
    <body>
        Hallo ${pageContext.request.userPrincipal.name} <a href="logout">Logout</a>
        
    </body>
</html>

<%-- 
    Document   : login
    Created on : 18 Apr, 2012, 4:07:48 PM
    Author     : behera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Mock Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            <div>
                <fieldset>
                    <legend>Login Here</legend>
                    <label for="uid">Username</label>
                    <input id="uid" name="uid" type="text" /><br />
                    <label for="pwd">Password</label>
                    <input id="pwd" name="pwd" type="password" />
                    <input type="submit" value="login" />
                </fieldset>
            </div>
            <div>
                ${requestScope.msg}
            </div>   
                
        </form>
    </body>
</html>

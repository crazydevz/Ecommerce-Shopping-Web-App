<%-- 
    Document   : AdminSignInTest
    Created on : Jul 29, 2018, 1:08:28 AM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        <h1>Admin Login</h1>
        <form name = "adminSignInForm" action="AdminLoginServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name OR Email: </td>
                        <td><input type="text" name="adminNameOrEmail" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="adminPassword" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
        <span  class = "loginStatus">${loginStatus}</span>
    </body>
</html>

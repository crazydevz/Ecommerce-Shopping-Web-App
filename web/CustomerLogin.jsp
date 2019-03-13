<%-- 
    Document   : CustomerLogin
    Created on : Feb 18, 2019, 7:57:42 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Login</title>
    </head>
    <body>
        <h1>Customer Login</h1>
        <form name = "CustomerLoginForm" action="CustomerLoginServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name OR Email: </td>
                        <td><input type="text" name="customerNameOrEmail" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="customerPassword" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />
        </form>
    </body>
</html>

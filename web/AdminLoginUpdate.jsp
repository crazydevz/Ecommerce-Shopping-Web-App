<%-- 
    Document   : AdminLoginCredentials
    Created on : Feb 4, 2019, 12:47:05 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Credentials</title>
    </head>
    <body>
        <h1>Enter New Login Credentials</h1>
        <form name="currentLoginCredentials" action="AdminLoginUpdateServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="adminName" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="adminEmail" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="adminPassword" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Reset" name="reset" />
            <input type="submit" value="Save Changes" name="saveChanges" />
        </form>
        <span class="updateCredentials">${updateCredentials}</span>
    </body>
</html>

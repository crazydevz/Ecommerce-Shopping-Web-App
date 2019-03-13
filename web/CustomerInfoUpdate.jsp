<%-- 
    Document   : CustomerInfoUpdate
    Created on : Feb 24, 2019, 7:14:31 AM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer Info</title>
    </head>
    <body>
        <h1>Customer Info</h1>
        <form name="currentLoginCredentials" action="CustomerInfoUpdateServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="customerName" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="customerEmail" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="customerPassword" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Reset" name="reset" />
            <input type="submit" value="Save Changes" name="saveChanges" />
        </form>
    </body>
</html>

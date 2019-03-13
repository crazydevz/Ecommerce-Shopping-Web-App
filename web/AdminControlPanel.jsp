<%-- 
    Document   : Admin Control Panel
    Created on : Jan 28, 2019, 9:59:06 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Control Panel</title>
    </head>
    <body>
        <h1>Admin Control Panel</h1>
        <form name="adminControlPanel" action="AdminControlPanelServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td><input type="submit" value="Update Login Credentials" name="buttonClicked" /></td>
                        <td><input type="submit" value="Add Product" name="buttonClicked" /></td>
                        <td><input type="submit" value="Search Product" name="buttonClicked" /></td>
                        <td><input type="submit" value="View Products" name="buttonClicked" /></td>
                        <td><input type="submit" value="Log out" name="buttonClicked" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

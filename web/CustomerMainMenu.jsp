<%-- 
    Document   : CustomerMainMenu
    Created on : Feb 24, 2019, 7:20:16 AM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <form name="customerMainMenu" action="CustomerMainMenuServlet" method="POST">
            <input type="submit" value="Browse Catalog" name="buttonClicked" />
            <input type="submit" value="Search Product" name="buttonClicked"/>
            <input type="submit" value="Update Account Info" name="buttonClicked" />
            <input type="submit" value="Logout" name="buttonClicked" />
        </form>
    </body>
</html>

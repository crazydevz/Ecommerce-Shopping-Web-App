<%-- 
    Document   : index
    Created on : Jul 20, 2018, 9:16:44 PM
    Author     : Talha Iqbal
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping System</title>
    </head>
    
    <body>
        <h1>Online Shopping System</h1>
        <form name="main" action="MainServlet" method="POST">
            <input type="submit" value="Admin Login" name="buttonClicked" />
            <input type="submit" value="Customer Login" name="buttonClicked" />
            <input type="submit" value="Customer Signup" name="buttonClicked" />
        </form>
    </body>
</html>

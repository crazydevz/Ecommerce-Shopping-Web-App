<%-- 
    Document   : SearchProductForAdmin.jsp
    Created on : Jan 31, 2019, 2:25:57 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Product</title>
    </head>
    <body>
        <h1>Search Product</h1>
        <form name="searchProduct" action="SearchProductForAdminServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Search Product" name="searchProduct" />
        </form>
        <span class="productStatus">${productStatus}</span>
    </body>
</html>

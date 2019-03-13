<%-- 
    Document   : SearchProductForCustomer
    Created on : Feb 24, 2019, 7:04:51 AM
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
        <form name="searchProduct" action="SearchProductForCustomerServlet" method="POST">
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
    </body>
</html>

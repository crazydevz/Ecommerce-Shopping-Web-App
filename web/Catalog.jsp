<%-- 
    Document   : Catalog
    Created on : Feb 12, 2019, 5:46:55 PM
    Author     : Talha Iqbal
--%>

<%@page import="java.util.Iterator"%>
<%@page import="ProductModule.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="DAOs.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Catalog</title>
    </head>
    <body>
        <h1>Available Products</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<ProductDetails> productList = new ProductDAO().getProducts(10);
                    if(productList == (null)){
                        out.print("No Product found!");
                        return;
                    }
                    Iterator<ProductDetails> iterator = productList.iterator();

                    ProductDetails p;
                    while(iterator.hasNext()){
                        p = (ProductDetails) iterator.next();
                %>
                <tr>
                <form name="catalog" action="SearchProductForAdminServlet" method = "POST">
                    <td><input type="text" name="productName" value="<%= p.getName() %>" size="50" readonly/></td>
                    <td><%= p.getPrice() %></td>
                    <td><input type="submit" name="buttonClicked" value="Manage Product" ></td>
                </form>
                </tr>
                <%      
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

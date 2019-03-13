<%-- 
    Document   : BrowseCatalog
    Created on : Feb 19, 2019, 9:38:40 PM
    Author     : Talha Iqbal
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ProductModule.ProductDetails"%>
<%@page import="DAOs.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalog</title>
    </head>
    <body>
        <h1>Catalog</h1>
        <form name="extra" action="ManageCartServlet" method="POST">
            <input type="submit" value="Edit Cart" name="buttonClicked" />
            <input type="submit" value="Checkout" name="buttonClicked" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Price</th>
                    <!--<th>In Cart</th>-->
                </tr>
            </thead>
            <tbody>
                <%
                    List<ProductDetails> productList = new ProductDAO().getProducts(10);
                    Iterator<ProductDetails> iterator = productList.iterator();

                    ProductDetails p;
                    while(iterator.hasNext()){
                        p = (ProductDetails) iterator.next();
                %>
                <tr>
                    <form name="catalog" action="ManageCartServlet" method = "POST">
                        <input type="hidden" name="productId" value="<%=p.getId()%>">
                        <td><input type="text" name="productName" value="<%= p.getName() %>" size="50" readonly/></td>
                        <td><%= p.getPrice() %></td>
                        <td><input type="submit" name="buttonClicked" value="View Product" ></td>
                        <td><input type="submit" name="buttonClicked" value="Add to Cart" ></td>
                        <td><input type="submit" name="buttonClicked" value="Remove from Cart" ></td>
                    </form>
                </tr>
                <%      
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

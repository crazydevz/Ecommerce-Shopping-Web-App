<%-- 
    Document   : ProductDetails
    Created on : Feb 19, 2019, 9:47:05 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details</title>
    </head>
    <body>
        <h1>Product Details</h1>
        <form name="manageProductForm" action="ManageCartServlet" method="POST">
            <input type="hidden" name="productId" value="${productId}" size="50" >
                <table border="1">
                <tbody>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="${productName}" size="50" readonly/></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="productPrice" value="${productPrice}" size="50" readonly/></td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td><input type="text" name="categoryList" value="${categoryList}" size="50" readonly/></td>
<!--                        <td><select name="categoryList" value="${categoryList}">
                                <option>Electronics</option>
                                <option>Food</option>
                                <option>Clothing</option>
                            </select></td>-->
                    </tr>
                    <tr>
                        <td>Amount in Stock</td>
                        <td><input type="text" name="amountInStock" value="${amountInStock}" size="50" readonly/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add to Cart" name="buttonClicked" />
            <input type="submit" value="Edit Cart" name="buttonClicked" />
        </form>
    </body>
</html>

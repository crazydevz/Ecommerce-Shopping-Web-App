<%-- 
    Document   : UpdateProduct
    Created on : Jan 25, 2019, 7:03:43 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Product</title>
    </head>
    <body>
        <h1>Manage Product</h1>
        <form name="manageProductForm" action="ManageProductServlet" method="POST">
            <input type="hidden" name="productId" value="${productId}" size="50" >
                <table border="1">
                <tbody>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="${productName}" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="productPrice" value="${productPrice}" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td><select name="categoryList" value="${categoryList}">
                                <option>Electronics</option>
                                <option>Food</option>
                                <option>Clothing</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Amount in Stock</td>
                        <td><input type="text" name="amountInStock" value="${amountInStock}" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Save Changes" name="buttonClicked" />
            <input type="submit" value="Delete Product" name="buttonClicked" />
        </form>
        <span class="productStatus">${productStatus}</span>
    </body>
</html>

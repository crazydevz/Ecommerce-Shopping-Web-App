<%-- 
    Document   : AddProductForm
    Created on : Jan 24, 2019, 2:18:02 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Form</title>
    </head>
    <body>
        <h1>Add Product</h1>
        <form name="addProductForm" action="AddProductServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Product Name</td>
                        <td><input type="text" name="productName" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="productPrice" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td><select name="categoryList">
                                <option>Electronics</option>
                                <option>Food</option>
                                <option>Clothing</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Amount In Stock</td>
                        <td><input type="text" name="inStockQuantity" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add Product" name="addProduct" />
        </form>
    </body>
</html>

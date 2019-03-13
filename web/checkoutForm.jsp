<%-- 
    Document   : checkoutForm
    Created on : Feb 20, 2019, 8:10:03 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <h1>Checkout</h1>
        <form name="checkoutForm" action="CheckoutServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Credit Card Number</td>
                        <td><input type="text" name="creditCardNo" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Shipping Address</td>
                        <td><input type="text" name="shippingAddress" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Checkout" />
        </form>
    </body>
</html>

<%-- 
    Document   : CustomerSignUp
    Created on : Jan 24, 2019, 1:38:02 PM
    Author     : Talha Iqbal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Signup</title>
    </head>
    <body>
        <h1>Customer Signup</h1>
        <form name="customerSignupForm" action="CustomerSignupServlet" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="customerName" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="customerEmail" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="text" name="customerPhoneNo" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Credit Card Number</td>
                        <td><input type="text" name="customerCreditCardNo" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="customerPassword" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Reset" name="reset" />
            <input type="submit" value="Signup" name="signup" />
        </form>
    </body>
</html>

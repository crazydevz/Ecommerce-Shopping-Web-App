<%-- 
    Document   : EditCart
    Created on : Feb 20, 2019, 9:42:40 PM
    Author     : Talha Iqbal
--%>

<%@page import="CustomerModule.Customer"%>
<%@page import="java.util.Iterator"%>
<%@page import="DAOs.CartDAO"%>
<%@page import="java.util.List"%>
<%@page import="CartModule.CartItemDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Cart</title>
    </head>
    <body>
        <h1>Edit Cart</h1>
        <%
          Customer customer = (Customer) request.getSession().getAttribute("customer");
        %>
        <input type="text" name="subTotal" value="Subtotal: <%= new CartDAO().calculateSubtotal(customer.getId()) %>" readonly/>
        <table border="1">
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Items in Cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Iterator<CartItemDetails> iterator = null;
                    try{
                        List<CartItemDetails> itemDetailsList = new CartDAO().getCartItems(customer.getId());
                        iterator = itemDetailsList.iterator();
                    }
                    catch(NullPointerException ex){
                        response.getWriter().print("Cart is empty");
                    }
                    
                    CartItemDetails itemDetails;
                    while(iterator.hasNext()){
                        itemDetails = (CartItemDetails) iterator.next();
                %>
                <tr>
                    <form name="updateCartForm" action="ManageCartServlet" method="POST">
                        <input type="hidden" name="productId" value="<%= itemDetails.getItemId() %>" size="50" />
                        <td><%= itemDetails.getItemName() %></td>
                        <td><%= itemDetails.getItemPrice() %></td>
                        <td><input type="text" name="quantityInCart" value="<%= itemDetails.getItemsInCart() %>" size="50" /></td>
                        <td><input type="submit"  name="buttonClicked" value="Update Cart" /></td>
                        <td><input type="submit"  name="buttonClicked" value="Remove from Cart" /></td>
                    </form>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <form name="checkoutForm" action="checkoutForm.jsp" method="POST">
            <input type="submit" value="Checkout" name="buttonClicked" />
        </form>
    </body>
</html>

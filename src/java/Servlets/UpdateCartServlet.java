/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import CustomerModule.Customer;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class UpdateCartServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        
        try{
            if(customer.isLoggedIn()){
                if(customer.updateItemQuantity(Integer.parseInt(req.getParameter("productId")), Integer.parseInt(req.getParameter("quantityInCart")))){
                    res.getWriter().print("Cart updated!");
                }
                else{
                    res.getWriter().print("An error occurred while updating the cart");
                }
            }
            else{
                res.sendRedirect("CustomerLogin.jsp");
            }
        }
        catch(NullPointerException ex){
            res.sendRedirect("CustomerLogin.jsp");
        }
    }
}

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
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        
        if(customer.removeItemFromCart(Integer.parseInt(req.getParameter("productId")))){
            res.getWriter().print("Product Removed from Cart");
        }
        else{
            res.getWriter().print("This Product is not present in Cart");
        }
    }
}

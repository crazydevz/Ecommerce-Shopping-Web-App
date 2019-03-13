/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import CustomerModule.Customer;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = res.getWriter();
        
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        
        if(customer.updateQuantity(Integer.parseInt(req.getParameter("productId")), Integer.parseInt(req.getParameter("quantityInCart")))){
            out.print("Cart updated!");
        }
        else{
            out.print("An error occurred while updating the cart");
        }
    }
}

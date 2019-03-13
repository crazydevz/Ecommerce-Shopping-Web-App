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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Talha Iqbal
 */
public class AddToCartServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        
        int itemId = Integer.parseInt(req.getParameter("productId"));
            
        if(customer.addItemToCart(itemId, 1)){
            res.getWriter().print("Product Added to Cart!");
        }
        else{
            res.getWriter().print("Product has already been added to Cart!");
        }
    }
}

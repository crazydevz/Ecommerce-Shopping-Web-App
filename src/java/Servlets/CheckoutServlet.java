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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Talha Iqbal
 */
public class CheckoutServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        
        if(customer.checkout(req.getParameter("creditCardNo"), req.getParameter("shippingAddress")))
            out.print("Checkout successfull!");
        else
            out.print("An error occured while checkingout");
    }
}

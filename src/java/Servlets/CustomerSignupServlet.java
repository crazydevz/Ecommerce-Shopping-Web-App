/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import CustomerModule.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class CustomerSignupServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String forLater;
        Customer customer = new Customer.Builder()
        .setCustomerInfo(req.getParameter("customerName"), req.getParameter("customerEmail"), req.getParameter("customerPassword"), req.getParameter("customerPhoneNo"))
        .setCreditCardNo(req.getParameter("customerCreditCardNo"))
        .build();

        if(customer.signUp())
            forLater = "Signup Successfull!";
        else
            forLater = "Signup UNsuccessful";
        
        out.print(forLater);
    }
    
}

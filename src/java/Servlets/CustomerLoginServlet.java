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
public class CustomerLoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        Customer customer = new Customer.Builder().setLoginDetails(req.getParameter("customerNameOrEmail"),
                req.getParameter("customerPassword")).build();
        if(customer.login()){
            req.getSession().setAttribute("customer", customer);
            
            res.sendRedirect("CustomerMainMenu.jsp");
        }
        else{
            out.print("Invalid Username and/or Password");
        }
    }
}

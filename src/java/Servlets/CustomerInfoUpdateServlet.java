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
public class CustomerInfoUpdateServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        
        Customer customer = (Customer) req.getSession().getAttribute("customer");
//        customer.setNewUserInfo(req.getParameter("customerName"), req.getParameter("customerEmail"), req.getParameter("customerPassword"));

        if(customer.updateLoginDetails(req.getParameter("customerName"), req.getParameter("customerEmail"), req.getParameter("customerPassword"))){
            res.getWriter().print("Customer Info Updated Successfully!");
        }
        else{
            res.getWriter().print("An error occcured while updating Customer Info");
        }
    }
}

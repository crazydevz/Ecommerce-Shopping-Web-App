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
public class EditCartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        
        Customer customer = (Customer) req.getSession().getAttribute("customer");
                  
        try{
            if(customer.isLoggedIn()){
                res.sendRedirect("EditCart.jsp");
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

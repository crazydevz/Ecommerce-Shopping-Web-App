/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Utilities;

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
public class MainServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String buttonClicked = req.getParameter("buttonClicked");
        
        if("Admin Login".equals(buttonClicked)){
            res.sendRedirect("AdminLogin.jsp");
        }
        else if("Customer Login".equals(buttonClicked)){
            res.sendRedirect("CustomerLogin.jsp");
        }
        else if("Customer Signup".equals(buttonClicked)){
            res.sendRedirect("CustomerSignup.jsp");
        }
    }
}

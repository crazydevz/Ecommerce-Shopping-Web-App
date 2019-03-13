package Servlets.AdminServlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class AdminControlPanelServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        
        String buttonClicked = req.getParameter("buttonClicked");
        
        if("Add Product".equals(buttonClicked)){
            res.sendRedirect("AddProduct.jsp");
        }
        else if("Search Product".equals(buttonClicked)){
            res.sendRedirect("SearchProductForAdmin.jsp");
        }
        else if("Update Login Credentials".equals(buttonClicked)){
            res.sendRedirect("AdminLoginUpdate.jsp");
        }
        else if("Log out".equals(buttonClicked)){
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
        else if("View Products".equals(buttonClicked)){
            res.sendRedirect("Catalog.jsp");
        }
    }
}

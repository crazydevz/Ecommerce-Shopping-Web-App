/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class CustomerMainMenuServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String buttonClicked = req.getParameter("buttonClicked");
        
        if("Browse Catalog".equals(buttonClicked)){
            res.sendRedirect("BrowseCatalog.jsp");
        }
        else if("Search Product".equals(buttonClicked)){
            res.sendRedirect("SearchProductForCustomer.jsp");
        }
        else if("Update Account Info".equals(buttonClicked)){
            res.sendRedirect("CustomerInfoUpdate.jsp");
        }
        else if("Logout".equals(buttonClicked)){
            res.sendRedirect("index.jsp");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.AdminServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class ManageProductServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        
        String buttonClicked = req.getParameter("buttonClicked");
        if("Save Changes".equals(buttonClicked)){
            req.getRequestDispatcher("UpdateProductServlet").forward(req, res);
        }
        else if("Delete Product".equals(buttonClicked)){
            req.getRequestDispatcher("DeleteProductServlet").forward(req, res);
        }
    }
}

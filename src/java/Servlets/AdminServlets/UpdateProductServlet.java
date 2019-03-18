/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.AdminServlets;

import AdminModule.Admin;
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
public class UpdateProductServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        
        int id = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        Float price = Float.parseFloat(req.getParameter("productPrice"));
        String category = req.getParameter("categoryList");
        int amountInStock = Integer.parseInt(req.getParameter("amountInStock"));
        
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        
        if(admin.updateProductDetails(productName, price, category, amountInStock, id)){
            res.getWriter().print("Product updated successfully!");
        }
        else{
            res.getWriter().print("An error occured while updating the product");
        }
    }

}

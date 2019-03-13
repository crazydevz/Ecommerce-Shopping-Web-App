/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.AdminServlets;

import AdminModule.Admin;
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
public class AddProductServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String forLater;
        if(admin.createProduct(req.getParameter("productName"), Float.parseFloat(req.getParameter("productPrice")), req.getParameter("categoryList"), Integer.parseInt(req.getParameter("inStockQuantity"))))
            forLater = "Product Added Successfully!";
        else
            forLater = "Product Entry Failed";
        
        out.print(forLater);
    }

}

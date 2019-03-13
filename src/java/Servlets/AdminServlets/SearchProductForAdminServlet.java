/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.AdminServlets;

import DAOs.ProductDAO;
import ProductModule.ProductDetails;
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
public class SearchProductForAdminServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        
//        req.getRequestDispatcher("ProductSearchServlet").include(req, res);

        PrintWriter out = res.getWriter();
        
        try{
            ProductDetails product = new ProductDAO().searchProductByName(req.getParameter("productName"));

            req.setAttribute("productId", product.getId());
            req.setAttribute("productName", product.getName());
            req.setAttribute("productPrice", product.getPrice());
            req.setAttribute("categoryList", product.getCategory());
            req.setAttribute("amountInStock", product.getAmountInStock());
            
            req.getRequestDispatcher("ManageProduct.jsp").forward(req, res);
        }
        catch(NullPointerException ex){
            out.print("Product not found!");
        }
//        req.getRequestDispatcher("ManageProduct.jsp").forward(req, res);
    }
}

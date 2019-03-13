/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class ManageCartServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        
        String buttonClicked = req.getParameter("buttonClicked");
//        String cartItemAddOrRemove = req.getParameter("BtnCartAddOrRemove");
        
        if("Add to Cart".equals(buttonClicked)){
//            req.setAttribute("BtnCartAddOrRemove", "Remove from Cart");
            req.getRequestDispatcher("AddToCartServlet").include(req, res);
        }
        else if("Remove from Cart".equals(buttonClicked)){
//            req.setAttribute("BtnCartAddOrRemove", "Add to Cart");
            req.getRequestDispatcher("RemoveFromCartServlet").include(req, res);
        }
        else if("View Product".equals(buttonClicked)){
            req.getRequestDispatcher("SearchProductForCustomerServlet").forward(req, res);
        }
        else if("Update Cart".equals(buttonClicked)){
            req.getRequestDispatcher("UpdateCartServlet").forward(req, res);
        }
        else if("Edit Cart".equals(buttonClicked)){
            res.sendRedirect("EditCart.jsp");
        }
        else if("Checkout".equals(buttonClicked)){
            res.sendRedirect("checkoutForm.jsp");
        }
        else
            res.getWriter().print("Oh no");
    }
}

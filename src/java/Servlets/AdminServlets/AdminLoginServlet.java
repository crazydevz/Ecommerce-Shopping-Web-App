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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Talha Iqbal
 */
public class AdminLoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        Admin admin = new Admin(req.getParameter("adminNameOrEmail"), req.getParameter("adminPassword"));
        
        if(admin.login()){
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
            
            res.sendRedirect("AdminControlPanel.jsp");
        }
        else{
            out.print("Invalid Username and/or Password");
        }
    }
}

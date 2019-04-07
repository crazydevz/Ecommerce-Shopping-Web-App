/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.AdminServlets;

import AdminModule.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Talha Iqbal
 */
public class AdminLoginUpdateServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");

        Admin admin = (Admin) req.getSession().getAttribute("admin");
//        admin.setNewUserInfo(req.getParameter("adminName"), req.getParameter("adminEmail"), req.getParameter("adminPassword"));

        if(admin.updateLoginDetails(req.getParameter("adminName"), req.getParameter("adminEmail"), req.getParameter("adminPassword"))){
            res.getWriter().print("Admin Credentials updated successfully!");
        }
        else{
            res.getWriter().print("An error occured while updating Admin Credentials");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automation;

/**
 *
 * @author Talha Iqbal
 */

// Note: Run this class for deleting all contents of database (except for admin's info)

public class AutomationRunner {
    public static void main(String[] args){
        AutomationDAO dao = new AutomationDAO();
        System.out.println(dao.resetDatabase());
    }
}

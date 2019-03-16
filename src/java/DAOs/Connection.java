/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.sql.*;

/**
 *
 * @author Talha Iqbal
 */
public class Connection {
    
    public java.sql.Connection con;
    public ResultSet rs;
    public Statement stmt;
    
    public void makeConnection(){
        try{  
                Class.forName("com.mysql.jdbc.Driver");  

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_online_shopping?autoReconnect=true&useSSL=false","root","database_connection_password");
                
                stmt = con.createStatement();
        }
        catch(ClassNotFoundException | SQLException ex){ 
            System.out.println(ex);
        }
    }
    
    public void close(){
        try{
            if(rs != null)
                this.rs.close();
            this.stmt.close();
            this.con.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}

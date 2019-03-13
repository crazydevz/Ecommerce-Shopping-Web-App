/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automation;

import DAOs.Connection;
import java.sql.SQLException;

/**
 *
 * @author Talha Iqbal
 */
public class AutomationDAO {
    
    // objects
    Connection conn;

    public AutomationDAO() {
        conn = new Connection();
    }
    
    public boolean resetDatabase(){
        conn.makeConnection();
        try{
            conn.stmt.addBatch("delete from db_online_shopping.orders;");
            conn.stmt.addBatch("delete from db_online_shopping.order_details;");
            conn.stmt.addBatch("alter table db_online_shopping.order_details auto_increment = 1;");
            conn.stmt.addBatch("delete from db_online_shopping.products;");
            conn.stmt.addBatch("alter table db_online_shopping.products auto_increment = 1;");
            conn.stmt.addBatch("delete from db_online_shopping.cutomers_accounts;");
            conn.stmt.addBatch("delete from db_online_shopping.accounts;");
            conn.stmt.addBatch("alter table db_online_shopping.accounts auto_increment = 1;");
            conn.stmt.addBatch("delete from db_online_shopping.customers;");
            conn.stmt.addBatch("alter table db_online_shopping.customers auto_increment = 1;");
            conn.stmt.addBatch("delete from db_online_shopping.users where db_online_shopping.users.id > 0;");
            conn.stmt.addBatch("alter table db_online_shopping.users auto_increment = 1;");
            
            conn.stmt.executeBatch();
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                conn.stmt.close();
                conn.con.close();
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}

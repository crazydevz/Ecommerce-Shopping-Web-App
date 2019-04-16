/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import OrderModule.OrderDetailsAccessor;
import java.sql.SQLException;

/**
 *
 * @author Talha Iqbal
 */
public class OrderDAO implements OrderDAOIntfc{
    
    // Objects
    private final Connection conn;

    public OrderDAO() {
        conn = new Connection();
    }
    
    @Override
    public boolean createOrder(OrderDetailsAccessor orderDetails){
        conn.makeConnection();
        try{
            // storing the order details in the database
            conn.stmt.executeUpdate(
                        "INSERT INTO `db_online_shopping`.`order_details` (`shipping_address`, `billing_amount`)\n" +
                        "VALUES ('" + orderDetails.getShippingAddress() + "', '" + orderDetails.getBillingAmount() + "');"
            );
            conn.rs = conn.stmt.executeQuery(
                    "SELECT `AUTO_INCREMENT`\n" +
                    "FROM  INFORMATION_SCHEMA.TABLES\n" +
                    "WHERE TABLE_SCHEMA = 'db_online_shopping'\n" +
                    "AND   TABLE_NAME   = 'order_details';"
            );
            int orderDetailsId = 0;
            if(conn.rs.isBeforeFirst() && conn.rs.next()){
                orderDetailsId = conn.rs.getInt(1) - 1;
            }
            
            // retreiving list of cart items from database
            conn.rs = conn.stmt.executeQuery(
                    "SELECT * FROM db_online_shopping.cart;"
            );
            
            if(conn.rs.isBeforeFirst()){
                // populating the Order table in the database
                while(conn.rs.next()){
                    conn.stmt.addBatch("INSERT INTO `db_online_shopping`.`orders` (`Customers_Users_id`, `Products_id`, `order_details_id`, `quantity`)\n" +
                        "VALUES ('" + conn.rs.getInt("Customers_Users_id") + "', '" + conn.rs.getInt("Products_id") + "', '" + orderDetailsId + "', '" + conn.rs.getInt("quantity") + "');");
                }
                conn.stmt.executeBatch();
                return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
}

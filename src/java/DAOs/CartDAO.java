/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import CartModule.CartDetailsAccessor;
import CartModule.CartItemDetails;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Talha Iqbal
 */
public class CartDAO implements CartDAOIntfc{
    
    // objects
    Connection conn;

    public CartDAO() {
        conn = new Connection();
    }
    
    @Override
    public List<CartItemDetails> getCartItems(int customerId){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                "select crt.Products_id, p.name, crt.quantity, p.price\n" +
                "from db_online_shopping.cart as crt\n" +
                "join db_online_shopping.products as p\n" +
                "on(crt.Products_id = p.id)\n" +
                "where (crt.Customers_Users_id = " + customerId + ");"
            );
            if(conn.rs.isBeforeFirst()){
                List<CartItemDetails> itemDetailsList = new LinkedList();
                CartItemDetails itemDetails;
                while(conn.rs.next()){
                    itemDetails = new CartItemDetails();
                    itemDetails.setItemId(conn.rs.getInt("Products_id"));
                    itemDetails.setItemName(conn.rs.getString("name"));
                    itemDetails.setItemPrice(conn.rs.getFloat("price"));
                    itemDetails.setItemsInCart(conn.rs.getInt("quantity"));
                    
                    itemDetailsList.add(itemDetails);
                }
                return itemDetailsList;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    @Override
    public boolean createCart(CartDetailsAccessor item){
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                "INSERT INTO `db_online_shopping`.`cart` (`Customers_Users_id`, `Products_id`, `quantity`)\n" +
                "VALUES ('" + item.getCustomerId() + "', '" + item.getProductId() + "', '" + item.getQuantity() + "');"
            );
            return(result > 0);
        }
        catch(SQLException  ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    @Override
    public boolean deleteAllCartItems(){
        conn.makeConnection();
        try{
            conn.stmt.executeUpdate(
                "DELETE FROM db_online_shopping.cart;"
            );
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    @Override
    public boolean deleteCartItem(int userId, int productId){
        conn.makeConnection();
            try{
                int result = conn.stmt.executeUpdate(
                    "DELETE FROM db_online_shopping.cart\n" +
                    "WHERE Customers_Users_id = " + userId + "\n" +
                    "AND\n" +
                    "Products_id = " + productId + ";"
                );
                if(result > 0)
                    return true;
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            finally{
                conn.close();
            }
    return false;
    }
    
    @Override
    public boolean updateItemQuantity(CartDetailsAccessor cartDetails){
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                "UPDATE `db_online_shopping`.`cart`\n" +
                "SET `quantity`='" + cartDetails.getQuantity() + "'\n" +
                "WHERE `Customers_Users_id`='" + cartDetails.getCustomerId() + "'\n" +
                "and `Products_id`= " + cartDetails.getProductId() + ";"
            );
            return (result > 0);
        }
        catch(SQLException ex){
            System.out.println("Problem: " + ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    @Override
    public float calculateSubtotal(int customerId){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                "SELECT sum(p.price * crt.quantity) as amount_to_pay\n" +
                "FROM db_online_shopping.cart as crt\n" +
                "join db_online_shopping.products  as p on(crt.Products_id = p.id)\n" +
                "WHERE crt.Customers_Users_id = " + customerId + ";"
            );
            if(conn.rs.isBeforeFirst() && conn.rs.next())
                return conn.rs.getInt("amount_to_pay");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return 0;
    } 
}

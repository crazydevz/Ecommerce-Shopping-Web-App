/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import CustomerModule.CustomerDetailsAccessor;
import Utilities.UserDetailsAccessor;
import java.sql.SQLException;

/**
 *
 * @author Talha Iqbal
 */
public class CustomerDAO implements CustomerDAOIntfc{
    
    // objects
    Connection conn;

    public CustomerDAO() {
        conn = new Connection();
    }
    
    private boolean checkIfExists(String customerName){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT name FROM `db_online_shopping`.`users`\n" +
                    "WHERE name LIKE '" + customerName + "';"
            );
            if(conn.rs.isBeforeFirst()){
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
    
    @Override
    public boolean checkIfExistsInt(int customerId){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT id FROM `db_online_shopping`.`users`\n" +
                    "WHERE id LIKE '" + customerId + "';"
            );
            if(conn.rs.isBeforeFirst()){
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
    
    @Override
     public boolean createCustomer(String phoneNumber, UserDetailsAccessor userDetails){
        if(!checkIfExists(userDetails.getName())){
            conn.makeConnection();
            try{
                int result1 = conn.stmt.executeUpdate(
                        "INSERT INTO `db_online_shopping`.`users` (`name`, `email`, `password`)\n" +
                        "VALUES ('" + userDetails.getName() + "', '" + userDetails.getEmail() + "', '" + userDetails.getPassword() +"');"
                );
                conn.rs = conn.stmt.executeQuery(
                    "SELECT `AUTO_INCREMENT`\n" +
                    "FROM  INFORMATION_SCHEMA.TABLES\n" +
                    "WHERE TABLE_SCHEMA = 'db_online_shopping'\n" +
                    "AND   TABLE_NAME   = 'users';"
                );
                int customersUsersID = 0;
                if(conn.rs.isBeforeFirst() && conn.rs.next()){
                    customersUsersID = conn.rs.getInt(1) - 1;
                }
                int result2 = conn.stmt.executeUpdate(
                    "INSERT INTO `db_online_shopping`.`customers` (`Users_id`, `phone_number`)"
                    + "VALUES ('" + customersUsersID + "', '" + phoneNumber + "');"
                );
                if(result1 > 0 && result2 > 0){
                    return true;
                }
            }
            catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            finally{
                conn.close();
            }
        }
        return false;
    }
    
    @Override
    public int readCustomer(String[] nameOrEmail, String password){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT *\n" +
                    "FROM db_online_shopping.users\n" +
                    "WHERE (name LIKE '" + nameOrEmail[0] + "' OR\n" +
                    "email LIKE '" + nameOrEmail[1] + "') AND\n" +
                    "password LIKE '" + password + "';"
            );
            if(conn.rs.isBeforeFirst() && conn.rs.next()){
                if(conn.rs.getString("password").equals(password))
                    return conn.rs.getInt("id");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return 0;
    }
    
    @Override
    public boolean updateLoginDetails(UserDetailsAccessor userDetails){
        conn.makeConnection();
        try{
            String id = String.valueOf(userDetails.getId());
            int result = conn.stmt.executeUpdate(
                    "UPDATE `db_online_shopping`.`users`\n" +
                    "SET `name`='" + userDetails.getName() + "', `email`='" + userDetails.getEmail() + "', `password`='" + userDetails.getPassword() + "'\n" +
                    "WHERE `id`='" + id + "';"
            );
            return (result > 0);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    @Override
    public boolean updateCustomerDetails(CustomerDetailsAccessor customerDetails, int userId){
        conn.makeConnection();
        try{
            int result1 = 0;
            int result2 = 0;
            if(customerDetails.getCreditCardNumber() != null){
                result1 = conn.stmt.executeUpdate(
                    "UPDATE `db_online_shopping`.`customers`\n" +
                    "SET `credit_card_number`='" + customerDetails.getCreditCardNumber() + "', `phone_number`='" + customerDetails.getPhoneNumber() + "'\n" +
                    "WHERE `User_id`='" + userId + "';"
                );
            }
            else if(customerDetails.getPhoneNumber()!= null){
                    result2 = conn.stmt.executeUpdate(
                        "UPDATE `db_online_shopping`.`customers`\n" +
                        "SET `phone_number`='" + customerDetails.getPhoneNumber() + "'\n" +
                        "WHERE `User_id`='" + userId + "';"
                    );
            }
            return (result1 > 0 || result2 > 0);
        }
        catch(SQLException ex){
            System.out.println("");
        }
        finally{
            conn.close();
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import java.sql.SQLException;

/**
 *
 * @author Talha Iqbal
 */
public class AccountDAO{
    
    // objects
    Connection conn;

    public AccountDAO() {
        conn = new Connection();
    }
    
    public boolean populateCreditCardNo(String creditCardNo){
        boolean terminateConn = false;
        try{
//            if(conn.con.isClosed()){
                conn.makeConnection();
//                terminateConn = true;
//            }
            conn.rs = conn.stmt.executeQuery(
                        "SELECT `AUTO_INCREMENT`\n" +
                        "FROM  INFORMATION_SCHEMA.TABLES\n" +
                        "WHERE TABLE_SCHEMA = 'db_online_shopping'\n" +
                        "AND   TABLE_NAME = 'users';"
                );
            int tempUserId = 0;
            if(conn.rs.isBeforeFirst() && conn.rs.next()){
                tempUserId = conn.rs.getInt(1) - 1;
            }
            if(creditCardNo != null){
                    int result = conn.stmt.executeUpdate(
                        "INSERT INTO `db_online_shopping`.`accounts` (`credit_card_no`, `balance`)\n" +
                        "VALUES ('" + creditCardNo + "', '45000');"  // 45000 is the default amount assigned
                    );
                    if(result > 0){
                        conn.stmt.executeUpdate(
                                "INSERT INTO `db_online_shopping`.`cutomers_accounts` (`Customers_Users_id`, `Accounts_credit_card_no`)\n" +
                                "VALUES ('" + tempUserId + "', '" + creditCardNo + "');"
                        );
                        return true;
                    }
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if(terminateConn){
                conn.close();
            }
        }
        return false;
    }
   
    public float getCustomersBalance(int customerId, String bankAccountNum){
        float tempCustomerBalance = 0;
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT Accounts_credit_card_no AS account_no\n" +
                    "FROM db_online_shopping.cutomers_accounts\n" +
                    "WHERE Customers_Users_id = " + customerId + ";"
            );
            if(conn.rs.isBeforeFirst()){
                while(conn.rs.next()){
                    if(conn.rs.getString(1).equals(bankAccountNum)){
                        conn.rs = conn.stmt.executeQuery(
                        "SELECT balance FROM db_online_shopping.accounts\n" +
                        "WHERE credit_card_no = '" + bankAccountNum + "';"
                        );
                        if(conn.rs.isBeforeFirst() && conn.rs.next()){
                            tempCustomerBalance = conn.rs.getFloat(1);
                        }
                        break;
                    }
                }
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return tempCustomerBalance;
    }
    
    public boolean updateCustomerAccountBalance(float updatedAmount, String accountNumber){
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                    "UPDATE `db_online_shopping`.`accounts`\n" +
                    "SET `balance`='" + updatedAmount + "'\n" +
                    "WHERE `credit_card_no`='" + accountNumber + "';"
            );
            return (result > 0);
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

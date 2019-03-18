/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Utilities.UserDetails;
import Utilities.UserDetailsAccessor;
import java.sql.SQLException;

/**
 *
 * @author Talha Iqbal
 */
public class AdminDAO implements AdminDAOIntfc{
    
    // objects
    Connection conn;

    public AdminDAO() {
        conn = new Connection();
    }
    
    @Override
    public UserDetails readAdmin(String[] nameOrEmail, String password){
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
                UserDetails ad = new UserDetails();
                ad.setName(conn.rs.getString("name"));
                ad.setEmail(conn.rs.getString("email"));
                ad.setPassword(conn.rs.getString("password"));
                
                return ad;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return null;
    }
    
    @Override
    public int searchAdmin(String[] nameOrEmail, String password){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT id\n" +
                    "FROM db_online_shopping.users\n" +
                    "WHERE (name LIKE '" + nameOrEmail[0] + "' OR\n" +
                    "email LIKE '" + nameOrEmail[1] + "') AND\n" +
                    "password LIKE '" + password + "';"
            );
            if(conn.rs.isBeforeFirst() && conn.rs.next()){
                return conn.rs.getInt("id");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        /* return 1 and not 0 because returning 0 will indicate the
        signIn() in the Admin class that the admin has signed in*/
        return 1;
    }
    
    @Override
    public boolean updateLoginDetails(UserDetailsAccessor admin){
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                    "UPDATE `db_online_shopping`.`users`\n" +
                    "SET `name`='" + admin.getName() + "', `email`='" + admin.getEmail()+ "', `password`='" + admin.getPassword() + "'\n" +
                    "WHERE `id`='" + admin.getId() + "';"
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
}

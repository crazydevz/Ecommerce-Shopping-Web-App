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
public class AdminDAO {
    
    // objects
    Connection conn;

    public AdminDAO() {
        conn = new Connection();
    }
    
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
    
//    public boolean createAdmin(Admin admin){
//        conn.makeconn();
//        try{
//            // Checking if there exists an admin in the database already
//            conn.rs = conn.stmt.executeQuery(
//                    "SELECT id FROM db_online_shopping.users\n" +
//                    "WHERE id = 0;"
//            );
//            if(conn.rs.isBeforeFirst()){
//                return false;
//            }
//            
//            // if their is no admin currently in the database, register the new admin  in the database
//            int done = conn.stmt.executeUpdate(
//                    "INSERT INTO `db_online_shopping`.`users` (`id`, `name`, `email`, `password`)\n" +
//                    " VALUES ('" + admin.getId() + "','" + admin.getName() + "', '" + admin.getEmail() + "', '" + admin.getPassword() + "');"
//            );
//            if(done <= 0)
//                return false;
//        }
//        catch(SQLException ex){
//            System.out.println(ex.getMessage());
//        }
//        finally{
//            try{
//                conn.con.close();
//                conn.rs.close();
//                conn.stmt.close();
//            }
//            catch(SQLException ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//        return true;
//    }
}

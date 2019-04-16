/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Talha Iqbal
 */
public abstract class User {
    
    // Objects
    protected UserDetails userDetails;
    
    public User(int id, String name, String email, String password){
        userDetails = new UserDetails();
        userDetails.setId(id);
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPassword(password);
    }
    
    public abstract boolean login();
    protected void setNewUserInfo(String name, String email, String password){
            this.userDetails.setName(name);
            this.userDetails.setEmail(email);
            this.userDetails.setPassword(password);
    }
    public abstract boolean updateLoginDetails(String name, String email, String password);
    public void logout() {
        if(this.userDetails.isLoggedIn())
            this.userDetails.setLoginStatus(false);
    }
}

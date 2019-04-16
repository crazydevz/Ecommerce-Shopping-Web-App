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
public class UserDetails implements UserDetailsAccessor{
    
    // Local variables
    private int id;
    private String name;
    private String email;
    private String password;

    // State variables
    private boolean loginStatus;
    
    // ACCESSOR METHODS
    public boolean isLoggedIn(){
        return loginStatus;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // MUTATOR METHODS
    public void setLoginStatus(boolean loginStatus){
        this.loginStatus = loginStatus;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

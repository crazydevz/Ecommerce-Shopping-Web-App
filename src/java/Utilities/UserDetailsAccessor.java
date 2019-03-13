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
public interface UserDetailsAccessor {
    
    public int getId();
    
    public String getName();

    public String getEmail();

    public String getPassword();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Utilities.UserDetails;
import Utilities.UserDetailsAccessor;

/**
 *
 * @author Talha Iqbal
 */
public interface AdminDAOIntfc {
    
    public UserDetails readAdmin(String[] nameOrEmail, String password);
    
    public int searchAdmin(String[] nameOrEmail, String password);
    
    public boolean updateLoginDetails(UserDetailsAccessor admin);
}

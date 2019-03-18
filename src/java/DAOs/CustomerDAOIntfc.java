/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import CustomerModule.CustomerDetailsAccessor;
import Utilities.UserDetailsAccessor;

/**
 *
 * @author Talha Iqbal
 */
public interface CustomerDAOIntfc {
    
    public boolean checkIfExistsInt(int customerId);
    
    public boolean createCustomer(String phoneNumber, UserDetailsAccessor userDetails);
    
    public int readCustomer(String[] nameOrEmail, String password);
    
    public boolean updateLoginDetails(UserDetailsAccessor userDetails);
    
    public boolean updateCustomerDetails(CustomerDetailsAccessor customerDetails, int userId);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

/**
 *
 * @author Talha Iqbal
 */
public interface AccountDAOIntfc {
    public boolean populateCreditCardNo(String creditCardNo);
    
    public float getCustomersBalance(int customerId, String bankAccountNum);
    
    public boolean updateCustomerAccountBalance(float updatedAmount, String accountNumber);
}

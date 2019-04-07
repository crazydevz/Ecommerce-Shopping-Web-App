/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountingModule;

import DAOs.AccountDAO;

/**
 *
 * @author Talha Iqbal
 */
public class Accounting implements TransactionIntfc{

    // local variables
    private final String accountNumber;
    private float customersBalance;
    
    public Accounting(String accountNumber){
        this.accountNumber = accountNumber;
    }
    
    @Override
    public boolean chargeCustomer(float amountToTransact) {
        float updatedCustomerBalance = this.customersBalance - amountToTransact;
        return new AccountDAO().updateCustomerAccountBalance(updatedCustomerBalance, accountNumber);
    }

    @Override
    public float getCustomersBalance(int customerId) {
        this.customersBalance = new AccountDAO().getCustomersBalance(customerId, accountNumber);
        return this.customersBalance;
    }
}

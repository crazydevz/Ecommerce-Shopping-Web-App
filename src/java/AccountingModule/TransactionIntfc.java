/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountingModule;

/**
 *
 * @author Talha Iqbal
 */
public interface TransactionIntfc {
    public boolean chargeCustomer(float amountToTransact);
    public float getCustomersBalance(int customerId);
}

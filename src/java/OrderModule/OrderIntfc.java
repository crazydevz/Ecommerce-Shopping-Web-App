/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderModule;

/**
 *
 * @author Talha Iqbal
 */
public interface OrderIntfc {
    public boolean processOrder(int customerId, String bankAccountNo);
}

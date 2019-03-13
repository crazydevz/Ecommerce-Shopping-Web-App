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
public class OrderDetails implements OrderDetailsAccessor{
    // local variables
    private float billingAmount;
    private String shippingAddress;

    // Mutator Methods
    public void setBillingAmount(float billingAmount) {
        this.billingAmount = billingAmount;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    // Accessor Methods
    @Override
    public float getBillingAmount() {
        return billingAmount;
    }
    
    @Override
    public String getShippingAddress() {
        return shippingAddress;
    }
    
}

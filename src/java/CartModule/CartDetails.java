/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartModule;

/**
 *
 * @author Talha Iqbal
 */
public class CartDetails implements CartDetailsAccessor{
    // Local variables
    private int customerId;
    private int productId;
    private int quantity;

    // MUTATORS
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ACCESSORS
    @Override
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public int getProductId() {
        return productId;
    }
    
    @Override
    public int getQuantity() {
        return quantity;
    }
}

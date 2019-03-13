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
public class CartItem {
    private int customerId;
    private int productId;
    private int quantity;
    
    private CartItem(Builder builder){
        this.customerId = builder.customerId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
    }
    
    public static class Builder{
        private int customerId;
        private int productId;
        private int quantity;
        
        public Builder setCustomerIdProductIdItemQuantity(int customerId, int productId, int quantity){
            this.customerId = customerId;
            this.productId = productId;
            this.quantity = quantity;
            return this;
        }
        
        public Builder setCustomerIdProductId(int customerId, int productId){
            this.customerId = customerId;
            this.productId = productId;
            return this;
        }
        
        public Builder setCustomerId(int customerId){
            this.customerId = customerId;
            return this;
        }
        
        public CartItem build(){
            return new CartItem(this);
        }
    }
    
    // Accessor Methods
    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

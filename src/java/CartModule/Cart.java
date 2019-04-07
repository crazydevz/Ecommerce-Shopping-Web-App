/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartModule;

import DAOs.CartDAO;

/**
 *
 * @author Talha Iqbal
 */
public class Cart implements CartModule.CustomerAccessible{

    // objects
//    private CartItem item;
    
    private final CartDetails cartDetails;
    
    private Cart(Builder builder){
        this.cartDetails = new CartDetails();
        this.cartDetails.setCustomerId(builder.cartDetails.getCustomerId());
        this.cartDetails.setProductId(builder.cartDetails.getProductId());
        this.cartDetails.setQuantity(builder.cartDetails.getQuantity());
    }
    
    public static class Builder{
        private CartDetails cartDetails = new CartDetails();
        
        public Builder setCustomerIdProductIdItemQuantity(int customerId, int productId, int quantity){
            this.cartDetails.setCustomerId(customerId);
            this.cartDetails.setProductId(productId);
            this.cartDetails.setQuantity(quantity);
            return this;
        }
        
        public Builder setCustomerIdProductId(int customerId, int productId){
            this.cartDetails.setCustomerId(customerId);
            this.cartDetails.setProductId(productId);
            return this;
        }
        
        public Builder setCustomerId(int customerId){
            this.cartDetails.setCustomerId(customerId);
            return this;
        }
        
        public Cart build(){
            return new Cart(this);
        }
    }
    
    @Override
    public boolean addItem() {
        return new CartDAO().createCart(this.cartDetails);
    }

    @Override
    public boolean removeItem() {
        return new CartDAO().deleteCartItem(this.cartDetails.getCustomerId(), this.cartDetails.getProductId());
    }

    @Override
    public boolean updateItemQuantity() {
        return new CartDAO().updateItemQuantity(this.cartDetails);
    }

    @Override
    public float calculateSubtotal() {
        return new CartDAO().calculateSubtotal(this.cartDetails.getCustomerId());
    }
    
    @Override
    public boolean deleteAllItems(){
        return new CartDAO().deleteAllCartItems();
    }
}

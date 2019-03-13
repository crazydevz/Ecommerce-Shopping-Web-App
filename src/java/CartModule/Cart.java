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
public class Cart implements CustomerModule.CustomerAccessible{

    // objects
    private CartItem item;
    
    public Cart(CartItem item){
        this.item = item;
    }
    
    public Cart(){
        // empty constructor
    }
    
    @Override
    public boolean addItem() {
        return new CartDAO().createCart(this.item);
    }

    @Override
    public boolean removeItem() {
        return new CartDAO().deleteCartItem(this.item.getCustomerId(), this.item.getProductId());
    }

    @Override
    public boolean updateItemQuantity() {
        return new CartDAO().updateItemQuantity(this.item.getCustomerId(), this.item.getProductId(), this.item.getQuantity());
    }

    @Override
    public float calculateSubtotal() {
        return new CartDAO().calculateSubtotal(this.item.getCustomerId());
    }

//    @Override
//    public List<CartItem> getCartItems() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
    
    @Override
    public boolean deleteAllItems(){
        return new CartDAO().deleteAllCartItems();
    }
}

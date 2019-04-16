/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import CartModule.CartDetailsAccessor;
import CartModule.CartItemDetails;
import java.util.List;

/**
 *
 * @author Talha Iqbal
 */
public interface CartDAOIntfc {
    
    public List<CartItemDetails> getCartItems(int customerId);
    
    public boolean createCart(CartDetailsAccessor item);
    
    public boolean deleteAllCartItems();
    
    public boolean deleteCartItem(int userId, int productId);
    
    public boolean updateItemQuantity(CartDetailsAccessor cartDetails);
    
    public float calculateSubtotal(int customerId);
}

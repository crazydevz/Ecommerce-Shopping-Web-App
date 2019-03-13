/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartModule;

import java.util.List;

/**
 *
 * @author Talha Iqbal
 */
public interface CartHandler {
    public List<CartItem> getCartItems();
    public boolean deleteAllCartItems();
}

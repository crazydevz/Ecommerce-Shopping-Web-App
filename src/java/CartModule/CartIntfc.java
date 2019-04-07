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

// Note: This interface is not currently in use.

public interface CartIntfc {
    public boolean addItem(int productId, int itemQuantity);
    public boolean removeItem(int productId);
    public boolean updateItemQuantity(int productId, int itemQuantity);
    public boolean deleteAllItems();
}

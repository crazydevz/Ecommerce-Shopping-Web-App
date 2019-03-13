/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

/**
 *
 * @author Talha Iqbal
 */
public interface CustomerAccessible {
    public boolean addItem();
    public boolean removeItem();
    public boolean updateItemQuantity();
    public float calculateSubtotal();
    public boolean deleteAllItems();
}

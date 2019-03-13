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
public class CartItemDetails {
    // local variables
    int itemId;
    private String itemName;
    private float itemPrice;
    private int itemsInCart;

    // Mutator Methods
    public void setItemId(int itemId){
        this.itemId = itemId;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemsInCart(int itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    // Accessor Methods
    public int getItemId(){
        return itemId;
    }
    
    public String getItemName() {
        return itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public int getItemsInCart() {
        return itemsInCart;
    }
}

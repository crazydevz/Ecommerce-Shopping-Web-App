/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductModule;

/**
 *
 * @author Talha Iqbal
 */
public interface ProductDetailsAccessor {
    
    public int getId();
    
    public String getName();
    
    public float getPrice();
    
    public String getCategory();
    
    public int getAmountInStock();
}

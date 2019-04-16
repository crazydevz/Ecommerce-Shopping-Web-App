/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminModule;

/**
 *
 * @author Talha Iqbal
 */
public interface AdminIntfc {
    public boolean createProduct(String productName, float productPrice, String productCategory, int productAmountInStock);
    
    public boolean deleteProduct(int productId);
    
    public boolean updateProductDetails();
}

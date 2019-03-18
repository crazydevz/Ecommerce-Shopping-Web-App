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
    public boolean createProduct(String productName, float price, String category, int amountInStock);
    
    public boolean deleteProduct(int id);
    
    public boolean updateProductDetails();
    
    // Must use this interface before using the updateLoginDetails method of the User class.
    public void setNewAdminInfo(String name, String email, String password);
}

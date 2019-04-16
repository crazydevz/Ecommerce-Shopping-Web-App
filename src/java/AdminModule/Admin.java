/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminModule;

import ProductModule.AdminAccessible;
import DAOs.AdminDAO;
import ProductModule.Product;
import Utilities.User;

/**
 *
 * @author Talha Iqbal
 */
public class Admin extends User{
    
    public Admin(String nameOrEmail, String password) {
        super(0, nameOrEmail, nameOrEmail, password);
    }
    
    // PRODUCT HANDLING METHODS
    public boolean createProduct(String name, float price, String category, int amountInStock){
        if(super.userDetails.isLoggedIn()){
            AdminAccessible product = new Product.Builder().setProductDetails(name, price, category, amountInStock).build();
            return product.addProductToCatalog();
        }
        return false;
    }
    
    public boolean deleteProduct(int productId){
        if(super.userDetails.isLoggedIn()){
            AdminAccessible product = new Product.Builder().setId(productId).build();
            return product.removeProductsFromCatalog();
        }
        return false;
    }
    
    public boolean updateProductDetails(int id, String name, float price, String category, int amountInStock){
        if(super.userDetails.isLoggedIn()){
            AdminAccessible product = new Product.Builder().setId(id).setProductDetails(name, price, category, amountInStock).build();
            return product.updateProductDetails();
        }
        return false;
    }
    
    // ADMIN HANDLING METHODS
    @Override
    public boolean login() {
        if(super.userDetails.isLoggedIn())
            return true;
        
        String[] nameAndEmail = {super.userDetails.getName(), super.userDetails.getEmail()};
        super.userDetails.setId(new AdminDAO().searchAdmin(nameAndEmail, super.userDetails.getPassword()));
        if(super.userDetails.getId() == 0){
            super.userDetails.setLoginStatus(true);
        }
        return super.userDetails.isLoggedIn();    
    }

    @Override
    public boolean updateLoginDetails(String name, String email, String password) {
        if(super.userDetails.isLoggedIn()){
                super.setNewUserInfo(name, email, password);
                return new AdminDAO().updateLoginDetails(super.userDetails);
        }
        return false;
    }
}

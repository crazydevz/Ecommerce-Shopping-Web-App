/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminModule;

import DAOs.AdminDAO;
import ProductModule.Product;
import Utilities.User;

/**
 *
 * @author Talha Iqbal
 */
public class Admin extends User<Admin>{
    
    // interfaces
    private AdminAccessible product;
    
    
    // constructor for sign up
    private Admin(Builder builder){
        super(0 ,builder.name, builder.email, builder.password);
    }
    
    public static class Builder{
        private String name;
        private String email;
        private String password;
        
        public Builder setNewLoginDetails(String name, String email, String password){
            this.name = name;
            this.email = email;
            this.password = password;
            return this;
        }
        
        public Builder setLoginDetails(String nameOrEmail, String password){
            this.name = nameOrEmail;
            this.email = nameOrEmail;
            this.password = password;
            return this;
        }
        
        public Admin build(){
            return new Admin(this);
        }
    }   
    
    // Product Handling Methods
    public boolean createProduct(String productName, float price, String category, int amountInStock){
        if(super.userDetails.isLoggedIn()){
            product = new Product.Builder().setProductNamePriceCategoryAmountInStock(productName, price, category, amountInStock).build();
            return product.addProductToCatalog();
        }
        else
            return false;
    }
    
    public boolean deleteProduct(int id){
        if(super.userDetails.isLoggedIn()){
            product = new Product.Builder().setId(id).build();
            return product.removeProductsFromCatalog();
        }
        else
            return false;
    }
    
    public boolean updateProductDetails(String productName, float price, String category, int amountInStock, int productId){
        if(super.userDetails.isLoggedIn()){
            product = new Product.Builder().setId(productId).setProductNamePriceCategoryAmountInStock(productName, price, category, amountInStock).build();
            return product.updateProductDetails();
        }
        else
            return false;
    } 
    
    // Admin Handling Methods
    @Override
    public boolean login() {
        if(super.userDetails.isLoggedIn())
            return true;
        // validate admin's sign in credentials
//        if(super.validateForSignIn()){
            // verify admin's sign in credentials
        String[] nameAndEmail = {super.userDetails.getName(), super.userDetails.getEmail()};
        super.userDetails.setId(new AdminDAO().searchAdmin(nameAndEmail, super.userDetails.getPassword()));
        if(super.userDetails.getId() == 0){
            super.userDetails.setLoginStatus(true);
        }
//        }
        return super.userDetails.isLoggedIn();    
    }
    
    @Override
    public void logout() {
        if(super.userDetails.isLoggedIn())
            super.userDetails.setLoginStatus(false);
    }
   
    public void setNewAdminInfo(String name, String email, String password){
            super.userDetails.setName(name);
            super.userDetails.setEmail(email);
            super.userDetails.setPassword(password);
    }
    
    @Override
    public boolean updateLoginDetails() {
        if(super.userDetails.isLoggedIn()){
            // validate new sign in credentials
//            if(super.validateForSignUp()){
                return new AdminDAO().updateLoginDetails(super.userDetails);
//            }
        }
        return false;
    }
}

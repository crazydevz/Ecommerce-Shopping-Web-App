/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import CartModule.CustomerAccessible;
import CartModule.Cart;
import DAOs.AccountDAO;
import DAOs.CustomerDAO;
import OrderModule.Order;
import Utilities.User;

/**
 *
 * @author Talha Iqbal
 */
public class Customer extends User{
    
    // Objects
    private final CustomerDetails customerDetails;
    
    private Customer(Builder builder){
        super(builder.id, builder.name, builder.email, builder.password);
        customerDetails = new CustomerDetails();
        customerDetails.setCreditCardNumber(builder.creditCardNumber);
        customerDetails.setPhoneNumber(builder.phoneNumber);
    }
    
    public static class Builder{
        private int id;
        private String name, email, password, creditCardNumber, phoneNumber;
        
        public Builder setCustomerInfo(String name, String email, String password, String phoneNumber){
            this.name = name;
            this.email = email;
            this.password = password;
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        public Builder setLoginDetails(String nameOrEmail, String password){
            this.name = nameOrEmail;
            this.email = nameOrEmail;
            this.password = password;
            return this;
        }
        
        public Builder setId(int id){
            this.id = id;
            return this;
        }
        
        public Builder setCreditCardNo(String crdNum){
            this.creditCardNumber = crdNum;
            return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
    }
    
    // Customer Handling Methods
    public boolean signUp(){
            return (new CustomerDAO().createCustomer(this.customerDetails.getPhoneNumber(), super.userDetails) && new AccountDAO().populateCreditCardNo(this.customerDetails.getCreditCardNumber()));
    }
    
    @Override
    public boolean login() {
        String[] nameOrEmail = {super.userDetails.getName(), super.userDetails.getEmail()};
        
        // verify customer's sign in credentials
        super.userDetails.setId(new CustomerDAO().readCustomer(nameOrEmail, super.userDetails.getPassword()));
        if(super.userDetails.getId() != 0){
            super.userDetails.setLoginStatus(true);
        }
        return super.userDetails.isLoggedIn();
    }
    
    @Override
    public boolean updateLoginDetails(String name, String email, String password) {
        if(super.userDetails.isLoggedIn()){
                super.setNewUserInfo(name, email, password);
                return new CustomerDAO().updateLoginDetails(super.userDetails);
        }
        return false;
    }
    
    // CART HANDLING METHODS
    public boolean addItemToCart(int productId, int itemQuantity){
        if(super.userDetails.isLoggedIn()){
            CustomerAccessible cart = new Cart.Builder().setCartDetails(super.userDetails.getId(), productId, itemQuantity).build();
            return cart.addItem();
        }
        return false;
    }
    
    public boolean removeItemFromCart(int productId){
        if(super.userDetails.isLoggedIn()){
            CustomerAccessible cart = new Cart.Builder().setCustomerIdProductId(super.userDetails.getId(), productId).build();
            return cart.removeItem();
        }
        return false;
    }
    
    public boolean updateItemQuantity(int productId, int itemQuantity){
        if(super.userDetails.isLoggedIn()){
            CustomerAccessible cart = new Cart.Builder().setCartDetails(super.userDetails.getId() ,productId, itemQuantity).build();
            return cart.updateItemQuantity();
        }
        return false;
    }
    
    public boolean checkout(String customersCreditCardNo, String shippingAddress){
        if(super.userDetails.isLoggedIn()){
            CustomerAccessible cart = new Cart.Builder().setCustomerId(super.userDetails.getId()).build();
            return new Order(cart.calculateSubtotal(), shippingAddress).processOrder(super.userDetails.getId(), customersCreditCardNo);
        }
        return false;
    }
    
    // ACCESSOR METHODS
    public int getId(){
        return super.userDetails.getId();
    }
    
    public boolean isLoggedIn(){
        return super.userDetails.isLoggedIn();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;

import CartModule.Cart;
import CartModule.CartItem;
import DAOs.AccountDAO;
import DAOs.CustomerDAO;
import OrderModule.Order;
import Utilities.User;

/**
 *
 * @author Talha Iqbal
 */
public class Customer extends User{
    
    // interfaces
    private CustomerAccessible cart;
    
    // objects
    private CustomerDetails customerDetails;
    
    
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
        // validate customer's sign up credentials
//        if(super.validateForSignUp()){
            return (new CustomerDAO().createCustomer(this.customerDetails.getPhoneNumber(), super.userDetails) && new AccountDAO().populateCreditCardNo(this.customerDetails.getCreditCardNumber()));
//        }
//        return false;
    }
    
    @Override
    public boolean login() {
        // validate customer's sign in credentials
//        if(super.validateForSignIn()){
            String[] nameOrEmail = {super.userDetails.getName(), super.userDetails.getEmail()};
            // verify customer's sign in credentials
            super.userDetails.setId(new CustomerDAO().readCustomer(nameOrEmail, super.userDetails.getPassword()));
            if(super.userDetails.getId() != 0){
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

    public void setNewCustomerInfo(String name, String email, String password){
            super.userDetails.setName(name);
            super.userDetails.setEmail(email);
            super.userDetails.setPassword(password);
    }
    
    @Override
    public boolean updateLoginDetails() {
        if(super.userDetails.isLoggedIn()){
            // validate new sign in credentials
//            if(super.validateForSignUp()){
                return new CustomerDAO().updateLoginDetails(super.userDetails);
//            }
        }
        return false;
    }
    
    // Product Handling Methods
    public boolean addItemToCart(int productId, int itemQuantity){
        if(super.userDetails.isLoggedIn()){
            cart = new Cart(new CartItem.Builder().setCustomerIdProductIdItemQuantity(super.userDetails.getId(), productId, itemQuantity).build());
            return cart.addItem();
        }
        return false;
    }
    
    public boolean removeItemFromCart(int productId){
        if(super.userDetails.isLoggedIn()){
            cart = new Cart(new CartItem.Builder().setCustomerIdProductId(super.userDetails.getId(), productId).build());
            return cart.removeItem();
        }
        return false;
    }
    
    public boolean updateQuantity(int productId, int quantity){
        if(super.userDetails.isLoggedIn()){
            cart = new Cart(new CartItem.Builder().setCustomerIdProductIdItemQuantity(super.userDetails.getId(), productId, quantity).build());
            return cart.updateItemQuantity();
        }
        return false;
    }
    
    public boolean checkout(String customersAccountNo, String shippingAddress){
        if(super.userDetails.isLoggedIn()){
            cart = new Cart(new CartItem.Builder().setCustomerId(super.userDetails.getId()).build());
            return new Order(cart.calculateSubtotal(), shippingAddress).processOrder(super.userDetails.getId(), customersAccountNo);
        }
        return false;
    }
    
    // testing method
    @Override
    public String toString(){
        return super.userDetails.getName() + "\n" + super.userDetails.getEmail() + "\n" + super.userDetails.getPassword() + "\n" + this.customerDetails.getPhoneNumber() + "\n" + this.customerDetails.getCreditCardNumber();
    }
    
    public int getId(){
        return super.userDetails.getId();
    }
}

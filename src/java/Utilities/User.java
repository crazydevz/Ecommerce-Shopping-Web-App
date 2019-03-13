/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Validation.Validator;

/**
 *
 * @author Talha Iqbal
 * @param <T>
 */
public abstract class User<T> {
    
    // objects
    protected UserDetails userDetails;
    
    public User(int id, String name, String email, String password){
        userDetails = new UserDetails();
        userDetails.setId(id);
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPassword(password);
    }
    
    public abstract boolean login();
    public abstract void logout();
    public abstract boolean updateLoginDetails();
//    public abstract boolean updateProfie();
    
//    protected boolean validateForSignIn(){
//        return new Validator.Builder().setName(userDetails.getName()).setEmail(userDetails.getEmail()).setPassword(userDetails.getPassword())
//                .build()
//                .validateForSignIn();
//    }
//    
//    protected boolean validateForSignUp(){
//        return new Validator.Builder().setName(userDetails.getName()).setEmail(userDetails.getEmail()).setPassword(userDetails.getPassword())
//                .build()
//                .validateForSignUp();
//    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Talha Iqbal
 */
public class Validator {
    private String name;
    private String email;
    private String password;
    
    private Validator(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
    }
    
    public static class Builder{
        private String name;
        private String email;
        private String password;
        
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        
        public Validator build(){
            return new Validator(this);
        }
    }
    
    public boolean validateForSignUp(){
        return ((this.validateName() && this.validateEmail()) && this.validatePassword());
    }
    
    public boolean validateForSignIn(){
        return ((this.validateName() || this.validateEmail()) && this.validatePassword());
    }
    
    private boolean validateName(){
        return !this.name.isEmpty();
    }
    
    private boolean validateEmail(){
        if(email.isEmpty()){
            return false;          
        }
        else{
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher((CharSequence) email);

            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }
    
    private boolean validatePassword(){
        return !(this.password.isEmpty() || this.password.length() < 8);
    }
}

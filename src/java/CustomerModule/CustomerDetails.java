/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerModule;


/**
 *
 * @author Talha Iqbal
 */
public class CustomerDetails implements CustomerDetailsAccessor{
    
    // local variables
    private String creditCardNumber;
    private String phoneNumber;
    
    // Accessor Methods
    @Override
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Mutator Methods
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

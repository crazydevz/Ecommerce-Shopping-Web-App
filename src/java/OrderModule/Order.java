/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderModule;

import DAOs.OrderDAO;
import AccountingModule.Accounting;
import AccountingModule.TransactionIntfc;
import DAOs.CartDAO;
import DAOs.ProductDAO;

/**
 *
 * @author Talha Iqbal
 */
public class Order implements OrderIntfc{
    
    // Objects
    private final OrderDetails orderDetails;
    
    public Order(float billingAmount, String shippingAddress){
        orderDetails = new OrderDetails();
        this.orderDetails.setBillingAmount(billingAmount);
        this.orderDetails.setShippingAddress(shippingAddress);
    }
    
    @Override
    public boolean processOrder(int customerId, String customersCreditCardNo){
        if(orderDetails.getBillingAmount() != 0){
            TransactionIntfc transaction = new Accounting(customersCreditCardNo);
            float customerBalance = transaction.getCustomersBalance(customerId);
            if(customerBalance != 0 && customerBalance >= this.orderDetails.getBillingAmount()){
                if(new OrderDAO().createOrder(this.orderDetails)){
                    return (
                        (transaction.chargeCustomer(this.orderDetails.getBillingAmount()))
                        && (new ProductDAO().updateProductQuantity())
                        && (new CartDAO().deleteAllCartItems())
                    );
                }
            }
        }
        return false;
    }
}

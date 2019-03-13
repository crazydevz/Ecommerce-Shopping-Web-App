/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductModule;

/**
 *
 * @author Talha Iqbal
 */
public class ProductDetails implements ProductDetailsAccessor {
    private int id;
    private String name;
    private float price;
    private String category;
    private int amountInStock;

    // Accessor Methods
    @Override
    public int getId(){
        return this.id;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public float getPrice(){
        return this.price;
    }
    
    @Override
    public String getCategory(){
        return this.category;
    }
    
    @Override
    public int getAmountInStock(){
        return this.amountInStock;
    }
    
    // Mutator Methods
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setAmountInStock(int amountInStock){
        this.amountInStock = amountInStock;
    }
}

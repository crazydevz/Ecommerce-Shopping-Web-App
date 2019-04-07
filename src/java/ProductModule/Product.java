/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductModule;

import DAOs.ProductDAO;

/**
 *
 * @author Talha Iqbal
 */
public class Product implements ProductModule.AdminAccessible{
    
    // objects
    private final ProductDetails productDetails;
    
    private Product(Builder builder){
        this.productDetails = new ProductDetails();
        this.productDetails.setName(builder.name);
        this.productDetails.setId(builder.id);
        this.productDetails.setPrice(builder.price);
        this.productDetails.setCategory(builder.category);
        this.productDetails.setAmountInStock(builder.amountInStock);
    }
    
    public static class Builder{
        private int id;
        private String name;
        private float price;
        private String category;
        private int amountInStock;
        
        public Builder setProductNamePriceCategoryAmountInStock(String productName, float price, String category, int amountInStock){
            this.name = productName;
            this.price = price;
            this.category = category;
            this.amountInStock = amountInStock;
            return this;
        }
        
        public Builder setAmountInStock(int amount){
            this.amountInStock = amount;
            return this;
        }
        
        public Builder setId(int id){
            this.id = id;
            return this;
        }
        
        public Product build(){
            return new Product(this);
        }
    }
    
    // Product Handling Methods
    @Override
    public boolean addProductToCatalog() {
        return new ProductDAO().createProduct(this.productDetails);
    }

    @Override
    public boolean removeProductsFromCatalog() {
        return new ProductDAO().deleteProduct(this.productDetails.getId());
    }

    @Override
    public boolean updateProductDetails() {
        return new ProductDAO().updateProduct(this.productDetails);
    }
}

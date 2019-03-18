/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import ProductModule.ProductDetails;
import ProductModule.ProductDetailsAccessor;
import java.util.List;

/**
 *
 * @author Talha Iqbal
 */
public interface ProductDAOIntfc {
    
    public List<ProductDetails> getProducts(int numberOfProducts);
    
    public ProductDetails searchProductByName(String productName);
    
    public boolean createProduct(ProductDetailsAccessor product);
    
    public boolean deleteProduct(int productId);
    
    public boolean searchProductByID(int productId);
    
    public boolean updateProduct(ProductDetailsAccessor updatedProduct);
    
    public boolean updateProductQuantity();
}

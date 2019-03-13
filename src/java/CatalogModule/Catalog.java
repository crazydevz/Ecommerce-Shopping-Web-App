/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogModule;

import ProductModule.Product;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Talha Iqbal
 */
public class Catalog{
    private Set<Product> products;

    public Catalog(){
        products = new HashSet<>();
    }
    
    public List<Product> getProductList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import ProductModule.Product;
import ProductModule.ProductDetails;
import ProductModule.ProductDetailsAccessor;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Talha Iqbal
 */
public class ProductDAO{

    // objects
    private Connection conn;
    
    public ProductDAO() {
        conn = new Connection();
    }
    
    public List<ProductDetails> getProducts(int numberOfProducts){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                "select * from db_online_shopping.products\n" +
                "limit"  + numberOfProducts + ";"
            );
            if(conn.rs.isBeforeFirst()){
                List<ProductDetails> productList = new LinkedList<>();
                ProductDetails pd;
                while(conn.rs.next()){
                    pd = new ProductDetails();
                    pd.setId(conn.rs.getInt("id"));
                    pd.setName(conn.rs.getString("name"));
                    pd.setPrice(conn.rs.getFloat("price"));
                    productList.add(pd);
                }
                return productList;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return null;
    }
    
    public ProductDetails searchProductByName(String productName){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT * FROM `db_online_shopping`.`products`\n" +
                    "WHERE name LIKE '" + productName + "';"
            );
            if(conn.rs.isBeforeFirst() && conn.rs.next()){
                ProductDetails pd = new ProductDetails();
                pd.setId(conn.rs.getInt("id"));
                pd.setName(conn.rs.getString("name"));
                pd.setCategory(conn.rs.getString("category"));
                pd.setPrice(conn.rs.getFloat("price"));
                pd.setAmountInStock(conn.rs.getInt("quantity_available"));
                
                return pd;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return null;
    }
    
    public boolean createProduct(ProductDetailsAccessor product){
        if(productExists(product.getName()))
            return false;
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                    "INSERT INTO `db_online_shopping`.`products` (`name`, `price`, `category`, `quantity_available`)\n" +
                    "VALUES ('" + product.getName()+ "', '" + product.getPrice() + "', '" + product.getCategory() + "', '" + product.getAmountInStock() + "');"
            );
            if(result > 0){
                return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    public boolean deleteProduct(int productId){
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                    "DELETE FROM `db_online_shopping`.`products`\n" +
                    "WHERE `id`='" + productId + "';"
            );
            if(result > 0){
                return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    private boolean productExists(String productName){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT name FROM `db_online_shopping`.`products`\n" +
                    "WHERE name LIKE '" + productName + "';"
            );
            if(conn.rs.isBeforeFirst()){
                    return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    public boolean searchProductByID(int productId){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "SELECT id FROM `db_online_shopping`.`products`\n" +
                    "WHERE id LIKE '" + productId + "';"
            );
            if(conn.rs.isBeforeFirst()){
                    return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    public boolean updateProduct(ProductDetailsAccessor updatedProduct){
        conn.makeConnection();
        try{
            int result = conn.stmt.executeUpdate(
                    "UPDATE `db_online_shopping`.`products`\n" +
                    "SET `name`='" + updatedProduct.getName()+ "', `price`='" + updatedProduct.getPrice() + "', `category`='" + updatedProduct.getCategory() + "', `quantity_available`='" + updatedProduct.getAmountInStock() + "' \n" +
                    "WHERE `id`='" + updatedProduct.getId() + "';"
            );
            
            if(result > 0){
                return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
    
    public boolean updateProductQuantity(){
        conn.makeConnection();
        try{
            conn.rs = conn.stmt.executeQuery(
                    "select p.id as product_id, (p.quantity_available - crt.quantity) as new_quantity\n" +
                    "from db_online_shopping.products as p join\n" +
                    "db_online_shopping.cart as crt\n" +
                    "on (crt.Products_id=p.id);"
            );
            if(conn.rs.isBeforeFirst()){
                // update the product quantity attribute of all the products in the product table
                while(conn.rs.next()){
                    conn.stmt.addBatch(
                            "UPDATE `db_online_shopping`.`products`\n" +
                            "SET `quantity_available`= " + conn.rs.getInt("new_quantity") + "\n" +
                            "WHERE id = " + conn.rs.getInt("product_id") + ";");
                }
                conn.stmt.executeBatch();
                return true;
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            conn.close();
        }
        return false;
    }
}

package com.database.repositories;

import com.database.ConnectionManager;
import com.database.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    // This class belongs to products table.
    // Here we instantiate our connection and call a simple query
    // from the table, map their columns, store the object in a
    // list, and then return all the mapped objects.

    public List<Product> findAllProducts() throws SQLException {

        // Initialize a list
        List<Product> products = new ArrayList<>();
        // Call our connection class
        ConnectionManager.getInstance().getConnection();
        // Initialize ResultSet
        ResultSet rs = null;
        try{
            // We call our query
            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM products");
            // We use a dummy object
            Product p = null;
            while(rs.next()){
                // We map the attributes for every object in the result set.
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setProviderId(rs.getInt("provider_id"));
                p.setUserId(rs.getInt("user_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setAmount(rs.getInt("amount"));
                // Then we add it to the list
                products.add(p);
                // And clean the dummy object
                p = null;
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        } finally {
            // At the end of the query, we need to close the ResultSet
            rs.close();
        }

        // And at the end of the operations, we need to close the connection
        ConnectionManager.getInstance().close();

        // At the end of the method we just return the filled list.
        return products;
    }

}

package com.database.repositories;

import com.database.ConnectionManager;
import com.database.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public List<Product> findAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        ConnectionManager.getInstance().getConnection();
        ResultSet rs = null;
        try{
            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM products");
            Product p = null;
            while(rs.next()){
                p = new Product();
                p.setId(rs.getInt("id"));
                p.setProviderId(rs.getInt("provider_id"));
                p.setUserId(rs.getInt("user_id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setAmount(rs.getInt("amount"));
                products.add(p);
                p = null;
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        } finally {
            rs.close();
        }
        ConnectionManager.getInstance().close();
        return products;
    }

}

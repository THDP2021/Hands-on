package com.database.examples;

import com.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example7 {

    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        System.out.println("Welcome to Java Database Hands-On Example Four - ADVANCED SELECT QUERY");
        try  {
            List<Object> params = new ArrayList<>();
            params.add(2); // ID
            params.add(10); // AMOUNT
            ConnectionManager.getInstance().getConnection();
            rs = ConnectionManager.getInstance()
                    .executeQuery("SELECT name, amount  FROM products WHERE provider_id = ? AND amount > ? ORDER BY name" ,
                            params);
            while (rs.next()) {
                System.out.println("> " + rs.getString("name") +
                                    "-" + rs.getInt("amount"));
            }
        } catch (Exception e) {
            System.err.println(e);
            ConnectionManager.getInstance().close();
        } finally {
            rs.close();
            ConnectionManager.getInstance().close();
        }
    }
}

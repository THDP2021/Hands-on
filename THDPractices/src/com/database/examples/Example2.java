package com.database.examples;

import com.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;

        System.out.println("Welcome to Java Database Hands-On Example Two.");
        try  {
            ConnectionManager.getInstance().getConnection();
            List<Object> params = new ArrayList<>();
            // TODO: Map a parameter to filter the query and then print the retrieved data on the console
            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM products WHERE user_id = ? AND UPPER(name) like ?", params);
            while (rs.next()) {
                // Print section
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
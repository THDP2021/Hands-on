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
            // TODO: Retrieve the name and amount of the products with provider id 2 and with amount higher than 10, then print them.
            ConnectionManager.getInstance().getConnection();
            rs = ConnectionManager.getInstance().executeQuery("", params);
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

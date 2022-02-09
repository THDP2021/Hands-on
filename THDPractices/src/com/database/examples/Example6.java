package com.database.examples;

import com.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Example6 {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        System.out.println("Welcome to Java Database Hands-On Example Six - JOINS");
        try  {
            ConnectionManager.getInstance().getConnection();
            // TODO: Build a query and retrieve the user and the provider name, these tables are linked with the id column.
            // Please use left join on the query.
            rs = ConnectionManager.getInstance().executeQuery("");
            while (rs.next()) {
                System.out.println("> " + rs.getString("name") +
                        "-" + rs.getString("provider_name"));
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

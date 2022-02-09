package com.database.examples;

import com.database.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example1 {

    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;

        System.out.println("Welcome to Java Database Hands-On Example One");
        try  {
            ConnectionManager.getInstance().getConnection();
            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM users");
            while (rs.next()) {
                // TODO: Map here the "id" and the "name" columns from users table and print them in the console.
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

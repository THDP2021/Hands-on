package com.database.examples;

import com.database.ConnectionManager;

import java.util.ArrayList;
import java.util.List;

public class Example3 {

    public static void main(String[] args) {

        System.out.println("Welcome to Java Database Hands-On Example Three.");
        try  {
            ConnectionManager.getInstance().getConnection();
            List<Object> params = new ArrayList<>();
            // TODO: Map some names to be inserted on users table, and then complete the SQL statement with the number of elements you want to insert.
            int rows = ConnectionManager.getInstance().executeUpdate("INSERT INTO users (name)", params);
            System.out.println("Added: " + rows + " rows.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            ConnectionManager.getInstance().close();
        } finally {
            ConnectionManager.getInstance().close();
        }
    }

}
package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public static void main(String[] args) throws SQLException {
        // Welcome to THD Hands-on practices, here we have a pre-configured class with all the logic to call the DB
        Connection conn = ConnectionManager.getInstance().getConnection();
        // In order to retrieve the info from the database, we need to use this ResultSet object
        ResultSet rs = null;

        System.out.println("Welcome to Java Database Hands-On");
        try  {
            // Then we try to execute a SQL query, very simple
            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM providers");
            while (rs.next()) {
                // If the query has one or more rows, this code will be executed, and it will print some data,
                // we use the get method, but we need to call the type of data we will retrieve, in this case
                // we need to retrieve an integer "id" and a string "name".
                System.out.println("> " + rs.getInt("id") + "-" + rs.getString("name"));
            }
        } catch (Exception e) {
            // If there is any error, this line of code will print it, so we can debug our code.
            System.err.println(e);
        }
        finally {
            // Finally, no matter what happens in the previous code, this line of code will close the ResultSet
            // object, in order to save memory and resources from the JVM.
            rs.close();
        }

        // When we finish our operations with the connection, we need to call its close method, like the
        // previous ResultSet object.
        ConnectionManager.getInstance().close();
    }
}

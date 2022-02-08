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
            rs = ConnectionManager.getInstance()
                    .executeQuery("SELECT users.name, providers.name AS provider_name FROM users " +
                                    "LEFT JOIN providers ON users.id = providers.id ORDER BY users.name");
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

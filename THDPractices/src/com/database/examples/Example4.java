package com.database.examples;

import com.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example4 {

        public static void main(String[] args) throws SQLException {
            ResultSet rs = null;
            System.out.println("Welcome to Java Database Hands-On Example Four.");
            try  {
                ConnectionManager.getInstance().getConnection();
                List<Object> params = new ArrayList<>();
                int id=1;
                params.add("New name");
                params.add(id);
                int rows = ConnectionManager.getInstance().executeUpdate(
                        "UPDATE users SET name = ?  WHERE id = ?", params);
                System.out.println("Added: " + rows + " rows.");
            } catch (Exception e) {
                System.err.println(e);
                ConnectionManager.getInstance().close();
            } finally {
                ConnectionManager.getInstance().close();
            }
        }
}

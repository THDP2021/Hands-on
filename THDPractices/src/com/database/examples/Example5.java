package com.database.examples;

import com.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example5 {

    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to Java Database Hands-On Example Four - CONSTRAINS");
        try  {
            ConnectionManager.getInstance().getConnection();
            List<Object> params = new ArrayList<>();
            // TODO: Delete a row from providers table with the name "Saul", remember to only map the parameters and build the query.
            int rows = ConnectionManager.getInstance().executeUpdate("DELETE FROM ", params);
            if(rows > 0){
                System.out.println("QUERY EXECUTED");
            }else{
                throw new SQLException("QUERY NOT EXECUTED");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            ConnectionManager.getInstance().close();
        }
    }
}

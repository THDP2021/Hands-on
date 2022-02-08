package com.database.examples;

import com.database.ConnectionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abraham Tenorio
 */

public class FunctionsExample {

    public static void main(String[] args){

        System.out.println("Welcome to Java Database Hands-On Functions Example.");
        try  {
            // Get connection
            ConnectionManager.getInstance().getConnection();

            // Set query
            String query = "{? = call name_product(?)}";

            // Set out params
            Map<Integer, String> outParam = new HashMap<>();
            outParam.put(1, "VARCHAR");

            // Set in params
            Map<Integer, Object> params = new HashMap<>();
            params.put(2, 1);

            // Execute and store result
            Object rOut = ConnectionManager.getInstance().callFunction(outParam, params, query);

            // Print result
            System.out.print(rOut);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            ConnectionManager.getInstance().close();
        } finally {
            ConnectionManager.getInstance().close();
        }

    }
}
package com.database.examples;

import com.database.ConnectionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abraham Tenorio
 */

public class ProceduresExample {

    public static void main(String[] args){
        System.out.println("Welcome to Java Database Hands-On Procedures Example.");
        try  {
            ConnectionManager.getInstance().getConnection();

            // Get initial price
            String query = "{? = call price_product(?)}";
            Map<Integer, String> outParam = new HashMap<>();
            outParam.put(1, "FLOAT");
            Map<Integer, Object> params = new HashMap<>();
            params.put(2, "%TV%");
            Object rOut = ConnectionManager.getInstance().callFunction(outParam, params, query);
            System.out.println(rOut);

            // Apply discount
            String query2 = "{ call apply_discount(?, ?) }";
            Map<Integer, Object> params2 = new HashMap<>();
            params2.put(1, 20.0f);
            params2.put(2, 32); // The id of TV product is 32s
            ConnectionManager.getInstance().callProcedure(params2, query2);

            // Get final price with discount
            String query3= "{? = call price_product(?)}";
            Map<Integer, String> outParam3 = new HashMap<>();
            outParam3.put(1, "FLOAT");
            Map<Integer, Object> params3 = new HashMap<>();
            params3.put(2, "%TV%");
            Object rOut3 = ConnectionManager.getInstance().callFunction(outParam3, params3, query3);
            System.out.println(rOut3);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            ConnectionManager.getInstance().close();
        } finally {
            ConnectionManager.getInstance().close();
        }
    }

}

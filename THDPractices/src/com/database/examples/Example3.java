<<<<<<< HEAD:THDPractices/src/com/database/examples/ExampleThree.java
//package com.database.examples;
//
//import com.database.ConnectionManager;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExampleThree {
//
//    public static void main(String[] args) throws SQLException {
//
//        System.out.println("Welcome to Java Database Hands-On Example Three.");
//        try  {
//            ConnectionManager.getInstance().getConnection();
//            List<Object> params = new ArrayList<>();
//            params.add("Hearts");
//            params.add("Solstice");
//            int rows = ConnectionManager.getInstance().executeUpdate("INSERT INTO users (name) VALUES (?), (?)", params);
//            System.out.println("Added: " + rows + " rows.");
//        } catch (Exception e) {
//            System.err.println(e);
//            ConnectionManager.getInstance().close();
//        } finally {
//            ConnectionManager.getInstance().close();
//        }
//    }
//
//}
=======
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
            params.add("Hearts");
            params.add("Solstice");
            int rows = ConnectionManager.getInstance().executeUpdate("INSERT INTO users (name) VALUES (?), (?)", params);
            System.out.println("Added: " + rows + " rows.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            ConnectionManager.getInstance().close();
        } finally {
            ConnectionManager.getInstance().close();
        }
    }

}
>>>>>>> 934aa81c2dcdbf0d4b918fb59839b7bd267589f9:THDPractices/src/com/database/examples/Example3.java

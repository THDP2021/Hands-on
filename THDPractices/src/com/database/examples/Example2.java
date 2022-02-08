<<<<<<< HEAD:THDPractices/src/com/database/examples/ExampleTwo.java
//package com.database.examples;
//
//import com.database.ConnectionManager;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExampleTwo {
//    public static void main(String[] args) throws SQLException {
//        ResultSet rs = null;
//
//        System.out.println("Welcome to Java Database Hands-On Example Two.");
//        try  {
//            ConnectionManager.getInstance().getConnection();
//            List<Object> params = new ArrayList<>();
//            params.add(1);
//            params.add("%FR%");
//            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM products WHERE user_id = ? AND UPPER(name) like ?", params);
//            while (rs.next()) {
//                System.out.println("> " + rs.getInt("id") + "-" + rs.getString("name"));
//            }
//        } catch (Exception e) {
//            System.err.println(e);
//            ConnectionManager.getInstance().close();
//        } finally {
//            rs.close();
//            ConnectionManager.getInstance().close();
//        }
//    }
//}
=======
package com.database.examples;

import com.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;

        System.out.println("Welcome to Java Database Hands-On Example Two.");
        try  {
            ConnectionManager.getInstance().getConnection();
            List<Object> params = new ArrayList<>();
            params.add(1);
            params.add("%F%");
            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM products WHERE user_id = ? AND UPPER(name) like ?", params);
            while (rs.next()) {
                System.out.println("> " + rs.getInt("id") + "-" + rs.getString("name"));
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
>>>>>>> 934aa81c2dcdbf0d4b918fb59839b7bd267589f9:THDPractices/src/com/database/examples/Example2.java

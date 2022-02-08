<<<<<<< HEAD:THDPractices/src/com/database/examples/ExampleOne.java
//package com.database.examples;
//
//import com.database.ConnectionManager;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ExampleOne {
//
//    public static void main(String[] args) throws SQLException {
//        ResultSet rs = null;
//
//        System.out.println("Welcome to Java Database Hands-On Example One");
//        try  {
//            ConnectionManager.getInstance().getConnection();
//            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM users");
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
>>>>>>> 934aa81c2dcdbf0d4b918fb59839b7bd267589f9:THDPractices/src/com/database/examples/Example1.java

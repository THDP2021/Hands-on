//package com.database;
//
//import javax.xml.transform.Result;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Database {
//
//    public static void main(String[] args) throws SQLException {
//        Connection conn = ConnectionManager.getInstance().getConnection();
//        ResultSet rs = null;
//
//        System.out.println("Welcome to Java Database Hands-On");
//        try  {
//            rs = ConnectionManager.getInstance().executeQuery("SELECT * FROM providers");
//            while (rs.next()) {
//                System.out.println("> " + rs.getInt("id") + "-" + rs.getString("name"));
//            }
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        finally {
//            rs.close();
//        }
//
//        ConnectionManager.getInstance().close();
//    }
//}

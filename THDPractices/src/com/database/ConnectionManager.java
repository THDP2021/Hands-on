<<<<<<< HEAD
//package com.database;
//
//import sun.rmi.registry.RegistryImpl_Stub;
//
//import java.sql.*;
//import java.util.List;
//import java.util.function.Function;
//
//public class ConnectionManager {
//
//    private static ConnectionManager instance = null;
//
//    private final String USERNAME = "sql5455114";
//    private final String PASSWORD = "tlp2rWRT7r";
//    private final String CONN_STRING = "jdbc:mysql://sql5.freemysqlhosting.net/sql5455114";
//
//    private Connection conn = null;
//    private Statement statement = null;
//    private PreparedStatement st = null;
//
//    private ConnectionManager() {
//
//    }
//
//    public static ConnectionManager getInstance() {
//        if (instance == null) {
//            instance = new ConnectionManager();
//        }
//        return instance;
//    }
//
//    private boolean openConnection()
//    {
//        try {
//            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
//            return true;
//        }
//        catch (SQLException e) {
//            System.err.println(e);
//            return false;
//        }
//
//    }
//
//    public Connection getConnection()
//    {
//        if (conn == null) {
//            if (openConnection()) {
//                //Connection opened
//                return conn;
//            } else {
//                return null;
//            }
//        }
//        return conn;
//    }
//
//    public ResultSet executeQuery(String query) throws SQLException {
//        statement = conn.createStatement();
//        return statement.executeQuery(query);
//    }
//
//    public ResultSet executeQuery(String query, List<Object> params) throws Exception {
//        st = conn.prepareStatement(query);
//        long paramCount = query.codePoints().filter(ch -> ch == '?').count();
//        if(paramCount != params.size()){
//            throw new Exception("The number of parameters included on the query String is not equals to the number of parameters on the List.");
//        }
//        int index = 1;
//        for(Object o : params){
//            String type = o.getClass().getSimpleName();
//            switch(type.toUpperCase()){
//                case "INTEGER":
//                    st.setInt(index, (int) o);
//                    break;
//                case "STRING":
//                    st.setString(index, (String) o);
//                    break;
//            }
//            index++;
//        }
//        return  st.executeQuery();
//    }
//
//    public int executeUpdate(String query, List<Object> params) throws Exception {
//        st = conn.prepareStatement(query);
//        long paramCount = query.codePoints().filter(ch -> ch == '?').count();
//        if(paramCount != params.size()){
//            throw new Exception("The number of parameters included on the query String is not equals to the number of parameters on the List.");
//        }
//        int index = 1;
//        for(Object o : params){
//            String type = o.getClass().getSimpleName();
//            switch(type.toUpperCase()){
//                case "INTEGER":
//                    st.setInt(index, (int) o);
//                    break;
//                case "STRING":
//                    st.setString(index, (String) o);
//                    break;
//            }
//            index++;
//        }
//        return st.executeUpdate();
//    }
//
//    public void close() {
//        //Closing connection
//        try {
//            try{
//                statement.close();
//            } catch(Exception e){
//                // Print error
//            }
//            try{
//                st.close();
//            } catch(Exception e){
//                // Print error
//            }
//            conn.close();
//            conn = null;
//        } catch (Exception e) {
//        }
//    }
//
//    public static void processException(SQLException e) {
//        System.err.println("Error message: " + e.getMessage());
//        System.err.println("Error code: " + e.getErrorCode());
//        System.err.println("SQL state: " + e.getSQLState());
//    }
//
//}
=======
package com.database;

import sun.rmi.registry.RegistryImpl_Stub;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ConnectionManager {

    private static ConnectionManager instance = null;

    private final String USERNAME = "thd_ho_test";
    private final String PASSWORD = "h4nd50n3";
    private final String CONN_STRING = "jdbc:mysql://db4free.net/thd_ho_test";

    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement st = null;

    private ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    private boolean openConnection()
    {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            return true;
        }
        catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    public Connection getConnection()
    {
        if (conn == null) {
            if (openConnection()) {
                //Connection opened
                return conn;
            } else {
                return null;
            }
        }
        return conn;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    public ResultSet executeQuery(String query, List<Object> params) throws SQLException {
        st = conn.prepareStatement(query);
        long paramCount = query.codePoints().filter(ch -> ch == '?').count();
        if(paramCount != params.size()){
            throw new SQLException("The number of parameters included on the query String is not equals to the number of parameters on the List.");
        }
        int index = 1;
        for(Object o : params){
            String type = o.getClass().getSimpleName();
            switch(type.toUpperCase()){
                case "INTEGER":
                    st.setInt(index, (int) o);
                    break;
                case "STRING":
                    st.setString(index, (String) o);
                    break;
            }
            index++;
        }
        return  st.executeQuery();
    }

    public int executeUpdate(String query, List<Object> params) throws SQLException {
        st = conn.prepareStatement(query);
        long paramCount = query.codePoints().filter(ch -> ch == '?').count();
        if(paramCount != params.size()){
            throw new SQLException("The number of parameters included on the query String is not equals to the number of parameters on the List.");
        }
        int index = 1;
        for(Object o : params){
            String type = o.getClass().getSimpleName();
            switch(type.toUpperCase()){
                case "INTEGER":
                    st.setInt(index, (int) o);
                    break;
                case "STRING":
                    st.setString(index, (String) o);
                    break;
            }
            index++;
        }
        return st.executeUpdate();
    }

    public Object callFunction(Map<Integer, String> outParam, Map<Integer, Object> params, String query) throws SQLException {
        // Validations
        long paramCount = query.codePoints().filter(ch -> ch == '?').count();
        Object rOut = null;
        if(outParam.size() > 1){
            throw new SQLException("The query needs to have only 1 out parameter.");
        }
        if(params.size() != (paramCount - 1)){
            throw new SQLException("The number of parameters included on the query String is not equals to the number of parameters on the List.");
        }

        // Create stmt
        CallableStatement cstmt = conn.prepareCall(query);

        // Map out parameters
        for (Map.Entry<Integer, String> entry : outParam.entrySet()){
            switch(entry.getValue()){
                case "DATE":
                    cstmt.registerOutParameter(entry.getKey(), Types.DATE);
                    break;
                case "INTEGER":
                    cstmt.registerOutParameter(entry.getKey(), Types.INTEGER);
                    break;
                case "VARCHAR":
                    cstmt.registerOutParameter(entry.getKey(), Types.VARCHAR);
                    break;
                case "FLOAT":
                    cstmt.registerOutParameter(entry.getKey(), Types.FLOAT);
                    break;
            }
        }

        // Map in parameters
        for(Map.Entry<Integer, Object> entry : params.entrySet()){
            String type = entry.getValue().getClass().getSimpleName();
            switch(type.toUpperCase()){
                case "INTEGER":
                    cstmt.setInt(entry.getKey(), (int)  entry.getValue());
                    break;
                case "STRING":
                    cstmt.setString(entry.getKey(), (String) entry.getValue());
                    break;
                case "FLOAT":
                    cstmt.setFloat(entry.getKey(), (Float) entry.getValue());
                    break;
                case "DOUBLE":
                    cstmt.setDouble(entry.getKey(), (Double) entry.getValue());
                    break;
                case "DATE":
                    cstmt.setDate(entry.getKey(), (Date) entry.getValue());
                    break;
            }
        }

        //Execute query
        cstmt.execute();

        // Map output
        for (Map.Entry<Integer, String> entry : outParam.entrySet()){
            switch(entry.getValue()){
                case "DATE":
                    rOut = cstmt.getDate(entry.getKey());
                    break;
                case "INTEGER":
                    rOut = cstmt.getInt(entry.getKey());
                    break;
                case "VARCHAR":
                    rOut = cstmt.getString(entry.getKey());
                    break;
                case "FLOAT":
                    rOut = cstmt.getFloat(entry.getKey());
                    break;
            }
        }

        return rOut;
    }

    public void callProcedure(Map<Integer, Object> params, String query) throws SQLException {
        // Validations
        long paramCount = query.codePoints().filter(ch -> ch == '?').count();
        if(params.size() != paramCount){
            throw new SQLException("The number of parameters included on the query String is not equals to the number of parameters on the List.");
        }

        // Create stmt
        CallableStatement cstmt = conn.prepareCall(query);

        // Map in parameters
        for(Map.Entry<Integer, Object> entry : params.entrySet()){
            String type = entry.getValue().getClass().getSimpleName();
            switch(type.toUpperCase()){
                case "INTEGER":
                    cstmt.setInt(entry.getKey(), (int)  entry.getValue());
                    break;
                case "STRING":
                    cstmt.setString(entry.getKey(), (String) entry.getValue());
                    break;
                case "FLOAT":
                    cstmt.setFloat(entry.getKey(), (Float) entry.getValue());
                    break;
                case "DOUBLE":
                    cstmt.setDouble(entry.getKey(), (Double) entry.getValue());
                    break;
                case "DATE":
                    cstmt.setDate(entry.getKey(), (Date) entry.getValue());
                    break;
            }
        }

        //Execute query
        cstmt.execute();
        System.out.println("Query executed");
    }

    public void close() {
        //Closing connection
        try {
            try{
                statement.close();
            } catch(Exception e){
                // Print error
            }
            try{
                st.close();
            } catch(Exception e){
                // Print error
            }
            conn.close();
            conn = null;
        } catch (Exception e) {
        }
    }

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }

}
>>>>>>> 934aa81c2dcdbf0d4b918fb59839b7bd267589f9

package com.database;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class ConnectionManager {

    //This is our main connection class, here we declare our principal instance like a singleton implementation,
    // this will be helpful, so we can always have the same instance and have efficiency.
    private static ConnectionManager instance = null;

    // Here we store our database credentials, also our url for the connection, in this case, it needs to have
    // the prefix "jdbc:mysql://" and then the ip/domain and the username after a slash.
    private final String USERNAME = "thd_ho_test";
    private final String PASSWORD = "h4nd50n3";
    private final String CONN_STRING = "jdbc:mysql://db4free.net/thd_ho_test";

    // Next, once we have our singleton and our connection information stores, we initialize some helpful
    // objects, they will build our querys or transactions.
    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement st = null;

    // There is an empty constructor, so we can instantiate this class
    private ConnectionManager() {

    }

    // This method will return the same instance of the singleton, if there is any created,
    // otherwise, it will create a new instance and it will be our singleton.
    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    // This method will try to open the connection to the database, with the stored
    // credentials, if there is any error we will see the output on the terminal.
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

    // This method needs to be called when we instantiate our class, it will open the connection and return it.
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

    // This method will execute a simple query and return the data in the ResultSet object.
    public ResultSet executeQuery(String query) throws SQLException {
        statement = conn.createStatement();
        return statement.executeQuery(query);
    }

    // This method will execute a simple query too, but it receives a list of
    // parameters and the method will automatically map the parameters. By now
    // it only maps integers and strings, but it is scalable
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

    // This method will execute a transaction, no matter if it is insert, update or delete, also
    // it receives a list of parameters and auto map them too, as mentioned before, it is scalable.
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

    // This method will call a stored function from the database, and auto map the output result and the input parameters.
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

    // As the previous method, this one will map the input params, but the difference here
    // is that this method will call a stored procedure, o we don't have any output params.
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

    // This final method will close the connection and the statement if its opened, this method needs
    // to be called every time we call a query or transaction.
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

}

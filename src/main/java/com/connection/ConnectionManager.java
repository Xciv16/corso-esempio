package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager implements ConnectionParameters {

    // apertura di una connessione e restituzione della stessa
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(dbDriver);

        return DriverManager.getConnection(dbUrl, dbUser, dbPass);

    }

    // inizializzazione di un oggetto PreparedStatement e restituzione dello stesso
    public static PreparedStatement getPreparedStatement(String sql, Connection con)
            throws ClassNotFoundException, SQLException {

        return con.prepareStatement(sql);

    }
    
    public static ResultSet getResultSet(String sql, Connection con) throws SQLException {
    	
    	return con.createStatement().executeQuery(sql);
    }
    
    public static void closeConnection (Connection con) throws SQLException {
    	
    	con.close();
    }
    
}
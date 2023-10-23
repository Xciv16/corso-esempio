package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

public class DAOSingleton {
	
	private static StudentDAO studentDAO = null;
	private static Connection connection = null;
	
	public static StudentDAO getStudentDAOInstanceDao() {
		
		if (studentDAO == null) {
			studentDAO = new StudentDAOImpl();
		}
		
		return studentDAO;
	}
	
	public static Connection getConnectionInstance() throws ClassNotFoundException, SQLException {
		
		if (connection == null) {
			connection = ConnectionManager.getConnection();
		}
		return connection;
	}

}

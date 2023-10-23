package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentToUpdateEJBLocal {
	
	public String findStudentById(String id, HttpServletRequest request) throws ClassNotFoundException, SQLException;

}

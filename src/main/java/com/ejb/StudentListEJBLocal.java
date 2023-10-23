package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentListEJBLocal {
	
	public String findAllStudents(HttpServletRequest request) throws ClassNotFoundException, SQLException;

}

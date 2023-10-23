package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentsListUpdateEJBLocal {
	
	public String studentsListUpdate(HttpServletRequest request) throws ClassNotFoundException, SQLException;

}

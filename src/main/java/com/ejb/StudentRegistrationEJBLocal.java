package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

import com.dto.StudentDTO;

@Local
public interface StudentRegistrationEJBLocal {
	
	public String addStudent(StudentDTO studentDTO, HttpServletRequest request)
			throws ClassNotFoundException, SQLException;

}

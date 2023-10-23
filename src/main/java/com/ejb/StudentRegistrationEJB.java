package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SQLScript;

@Stateless
public class StudentRegistrationEJB implements StudentRegistrationEJBLocal {

	@Override
	public String addStudent(StudentDTO studentDTO, HttpServletRequest request)
			throws ClassNotFoundException, SQLException {

		String page = Page.error;
		int nRowsInserted = 0;

		Connection connection = DAOSingleton.getConnectionInstance();

		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();

		nRowsInserted = studentDAO.addStudent(SQLScript.sqlInsert, connection, studentDTO);

		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(connection);
		}
		
		if (nRowsInserted > 0) {

			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentDTOKey, studentDTO);
			page = Page.success;
			
		} 
		
		return page;

	}

}

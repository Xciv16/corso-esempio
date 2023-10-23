package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SQLScript;
import com.vo.StudentVO;

@Stateless
public class StudentDeleteEJB implements StudentDeleteEJBLocal {


	public String deleteStudent(String id, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String page = Page.error;
		ArrayList<StudentVO> studentsUpdate = new ArrayList<>();
		int nRowsDeleted = 0;
		
		Connection connection = DAOSingleton.getConnectionInstance();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();
		
		nRowsDeleted = studentDAO.deleteStudent(SQLScript.sqlDelete, connection, Integer.parseInt(id));
		
		
		if (nRowsDeleted > 0) {
			studentsUpdate = studentDAO.findAllStudent(SQLScript.sqlRead, connection);
		}
		
		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(connection);
		}
		
		if (!studentsUpdate.isEmpty()) {
			
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsListKey, studentsUpdate);
			page = Page.studentsList;
		}
		
		
		return page;
	}

}

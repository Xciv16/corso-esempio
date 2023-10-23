package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.page.Page;
import com.singleton.DAOSingleton;
import com.sql.SQLScript;
import com.vo.StudentVO;

@Stateless
public class StudentListEJB implements StudentListEJBLocal {

	@Override
	public String findAllStudents(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String page = Page.error;
		ArrayList<StudentVO> students = new ArrayList<>();
		
		Connection connection = DAOSingleton.getConnectionInstance();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();
		
		students = studentDAO.findAllStudent(SQLScript.sqlRead, connection);
		
		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(connection);
		}
		
		if (!students.isEmpty()) {

			HttpSession session = request.getSession();
			session.setAttribute("students", students);
			page = Page.studentsList;
			
		} 
		
		return page;
	}

	

}

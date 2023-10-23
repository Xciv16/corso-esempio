package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
import com.vo.StudentVO;

@Stateless
public class StudentsListUpdateEJB implements StudentsListUpdateEJBLocal {

	public String studentsListUpdate(HttpServletRequest request) throws ClassNotFoundException, SQLException {

		String page = Page.error;

		ArrayList<StudentVO> studentsListUpdate = new ArrayList<>();
		int nRowsUpdated = 0;

		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");

		Connection connection = DAOSingleton.getConnectionInstance();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));

		nRowsUpdated = studentDAO.updateStudent(SQLScript.sqlUpdate, connection, studentDTO, Integer.parseInt(id));


		if (nRowsUpdated > 0) {
			studentsListUpdate = studentDAO.findAllStudent(SQLScript.sqlRead, connection);
		}

		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(connection);
		}

		if (!studentsListUpdate.isEmpty()) {

			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsListKey, studentsListUpdate);
			page = Page.studentsList;
		}

		return page;

	}

}

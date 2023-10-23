package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;

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
public class StudentToUpdateEJB implements StudentToUpdateEJBLocal {

	public String findStudentById(String id, HttpServletRequest request) throws ClassNotFoundException, SQLException {

		String page = Page.error;
		StudentVO studentVO = null;

		Connection connection = DAOSingleton.getConnectionInstance();
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();

		studentVO = studentDAO.findStudentById(SQLScript.sqlReadById, connection, Integer.parseInt(id));

		if (!(request.getRequestedSessionId() == null) && !request.isRequestedSessionIdValid()) {

			ConnectionManager.closeConnection(connection);
		}
		
		if (studentVO != null) {

			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentVOKey, studentVO);
			page = Page.studentUpdate;
		}


		return page;

	}

}

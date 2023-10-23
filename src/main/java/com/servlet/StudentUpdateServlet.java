package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.StudentsListUpdateEJBLocal;

@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private StudentsListUpdateEJBLocal studentListEJB;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			response.sendRedirect(studentListEJB.studentsListUpdate(request));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}

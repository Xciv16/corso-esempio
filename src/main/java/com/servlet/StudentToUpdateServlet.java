package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.StudentToUpdateEJBLocal;

@WebServlet("/toUpdate")
public class StudentToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private StudentToUpdateEJBLocal studentToUpdateEJB;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		try {
			response.sendRedirect(studentToUpdateEJB.findStudentById(id, request));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}

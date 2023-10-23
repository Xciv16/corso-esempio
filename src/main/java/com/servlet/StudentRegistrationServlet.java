package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentDTO;
import com.ejb.StudentRegistrationEJBLocal;

@WebServlet("/registration")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 * Questa è una Dependency Injection fornita da Jave EE 
	 * per implementare il pattern IoC
	 * 
	 * Dietro le quinte l'EJB Container eseguirà il seguente codice:
	 * private StudentRegistrationEJBLocal studentRegistration = new StudentRegistrationEJB();
	 * 
	 * La Dependency Injection Java EE va applicata nel seguente modo:
	 * dichiarare una variabile di istanza del tipo Interfaccia EJB rispetto alla classe EJB
	 * che si vuole istanziare, e tale variabile di istanza deve essere preceduta
	 * dall'annotation @EJB
	 */
	@EJB
	private StudentRegistrationEJBLocal studentRegistration;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));
		
		/*
		 *  invocazione di un metodo dell'EJB StudentRegistration EJB
		 */
		
		try {
			response.sendRedirect(studentRegistration.addStudent(studentDTO, request));
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}

package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.singleton.DAOSingleton;
import com.sql.SQLScript;
import com.vo.StudentVO;

class Test {

	@org.junit.jupiter.api.Test
	void testAddStudent() throws ClassNotFoundException, SQLException {
		
		int nRowsInserted = 0;
		
		Connection connection = DAOSingleton.getConnectionInstance();
		
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();
		
		StudentDTO studentDTO = new StudentDTO("prova", "prova2", 30);
		
		nRowsInserted = studentDAO.addStudent(SQLScript.sqlInsert, connection, studentDTO);
		
		assertEquals(nRowsInserted, 1);
		
		System.out.println(studentDTO);
		
	}
	
	@org.junit.jupiter.api.Test
	void testListStudents() throws ClassNotFoundException, SQLException {
		
		ArrayList<StudentVO> students = new ArrayList<>();
		
		Connection connection = DAOSingleton.getConnectionInstance();
		
		StudentDAO studentDAO = DAOSingleton.getStudentDAOInstanceDao();
		
		students = studentDAO.findAllStudent(SQLScript.sqlRead, connection);
		
		
		
	}

}

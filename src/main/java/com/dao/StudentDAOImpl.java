package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.StudentDTO;
import com.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public int addStudent(String sql, Connection con, StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
			PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(sql, con);
			preparedStatement.setString(1, studentDTO.getFirstName());
			preparedStatement.setString(2, studentDTO.getLastName());
			preparedStatement.setInt(3, studentDTO.getAge());
			
			return preparedStatement.executeUpdate();
	}

	@Override
	public int updateStudent(String sql, Connection con, StudentDTO studentDTO, int id)
			throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(sql, con);
		preparedStatement.setString(1, studentDTO.getFirstName());
		preparedStatement.setString(2, studentDTO.getLastName());
		preparedStatement.setInt(3, studentDTO.getAge());
		preparedStatement.setInt(4, id);
		
		return preparedStatement.executeUpdate();
		
	}

	@Override
	public int deleteStudent(String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(sql, con);
		preparedStatement.setInt(1, id);
		
		return preparedStatement.executeUpdate();
	}

	@Override
	public ArrayList<StudentVO> findAllStudent(String sql, Connection con) throws SQLException {
		
		ResultSet resultSet = ConnectionManager.getResultSet(sql, con);
		
		ArrayList<StudentVO> students = new ArrayList<>();
		
		StudentVO studentVO = null;
		
		while(resultSet.next()) {
			
			studentVO = new StudentVO(
					resultSet.getInt("id"), 
					resultSet.getString("first_name"),
					resultSet.getString("last_name"), 
					resultSet.getInt("age"));
			
			students.add(studentVO);
			
		}
		
		students.forEach(student -> System.out.println(student));
		
		return students;
	}

	@Override
	public StudentVO findStudentById(String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		
		StudentVO studentVO = null;
		
		PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(sql, con);
		preparedStatement.setInt(1, id);
		
		ResultSet rSet = preparedStatement.executeQuery();
		
		if(rSet.next()) {
			studentVO = new StudentVO(
					rSet.getInt("id"), 
					rSet.getString("first_name"), 
					rSet.getString("last_name"), 
					rSet.getInt("age"));
		}
		
		return studentVO;
	}
	
	

}

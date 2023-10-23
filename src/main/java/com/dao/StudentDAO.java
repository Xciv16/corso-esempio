package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.StudentDTO;
import com.vo.StudentVO;

public interface StudentDAO {
	
	public int addStudent(String sql, Connection con, StudentDTO studentDTO) throws ClassNotFoundException, SQLException;
	public int updateStudent(String sql, Connection con, StudentDTO studentDTO, int id) throws ClassNotFoundException, SQLException;
	public int deleteStudent(String sql, Connection con, int id) throws ClassNotFoundException, SQLException;
	public ArrayList<StudentVO> findAllStudent(String sql, Connection con) throws SQLException;
	public StudentVO findStudentById(String sql, Connection con, int id) throws ClassNotFoundException, SQLException;
	
}

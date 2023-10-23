package com.sql;

public interface SQLScript {
	
	public String sqlInsert = "INSERT INTO student (first_name, last_name, age) VALUES (?,?,?)";
	public String sqlUpdate = "UPDATE student set first_name=?, last_name=?, age=? WHERE id=?";
	public String sqlDelete = "DELETE from student WHERE id=?";
	public String sqlRead = "SELECT * FROM student";
	public String sqlReadById = "SELECT * FROM student WHERE id=?";

}

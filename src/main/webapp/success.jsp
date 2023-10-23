<%@page import="com.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione corretta</title>
</head>

	<%
		StudentDTO studentDTO = (StudentDTO)session.getAttribute("studentDTO");
		String lastName = studentDTO.getLastName();
		String message = "Registrazione studente " + lastName + " corretta";
	%>
<body style="background-color:chartreuse" align="center">
	
	<%= message %>
	
</body>
</html>
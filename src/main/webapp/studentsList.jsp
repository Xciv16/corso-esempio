<%@page import="com.dao.StudentDAOImpl"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vo.StudentVO"%>
<!-- questa libreria ci permette di iterare su una lista, 
ma rispetto ai for classici, e' piu' prestazionale
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	  <style>
        .center-table {
            margin: 0 auto; 
            width: 80%; 
        }
    </style>
</head>
<%
ArrayList<StudentVO> students = (ArrayList<StudentVO>) session.getAttribute("students");
%>
<body style="background-color: antiquewhite" >
	<div class="center-table">
		<table>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Age</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="student" items="${students}">
				<tr>
					<td style="text-align: center">${student.firstName}</td>
					<td style="text-align: center">${student.lastName}</td>
					<td style="text-align: center">${student.age}</td>
					
					<td style="text-align: center"><c:url value="toUpdate" var="updateUrl">
							<c:param name="id" value="${student.id}" />
						</c:url> <a href="${updateUrl}" class="btn btn-info">update</a></td>
						
					<td style="text-align: center"><c:url value="delete" var="deleteUrl">
							<c:param name="id" value="${student.id}" />
						</c:url> <a href="${deleteUrl}" class="btn btn-info">delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<a href="home.html" class="btn btn-danger">Home</a>
	</div>
</body>
</html>
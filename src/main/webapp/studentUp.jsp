<%@page import="com.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>

<%
StudentVO studentVO = (StudentVO) session.getAttribute("studentVO");
%>
<body>
	<form method="post" action="update">
		<br> 
		<input type="hidden" name="id" value="<%=studentVO.getId()%>">
		<br>
		<label for="firstName"><strong>First Name:</strong></label>
		<input type="text" name="firstName" value="${studentVO.firstName}">
		<br> 
		<label for="lastName"><strong>Last Name:</strong></label> 
		<input type="text" name="lastName" value="${studentVO.lastName}"> 
		<br>
		<label for="age"><strong>Age:</strong></label> 
		<input type="text" name="age" value="${studentVO.age}"> <br> <br>
		
		<button type="submit" class="btn btn-primary" value="Update">Update</button>
		<a href="home.html" class="btn btn-primary">Home</a>
		
	</form>
	
</body>
</html>
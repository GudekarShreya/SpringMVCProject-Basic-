<%@page import="com.jspiders.sms1.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>

<style type="text/css">
h1 {
	text-align: center;
	color: teal;
	margin-top: 50px;
}

#formDiv {
	margin-top: 30px;
}

table {
	font-size: 20px;
}

input {
	padding: 5px;
	width: 300px;
}

td {
	padding: 10px;
}

input[type=submit] {
	width: 100px;
	background-color: teal;
	color: white;
	padding: 10px 15px;
	margin-top: 10px;
}
#message{
margin-top: 30px;
color: red;
}
</style>

</head>
<body>

	<%
	Student student = (Student) request.getAttribute("student");
	if (student != null) {
	%>
	<h1>Update Student</h1>
	<div align="center" id="formDiv">

		<form action="updateStudent" method="post">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" value="<%=student.getId()%>"
						readonly="true"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"
						value="<%=student.getName()%>"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"
						value="<%=student.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age"
						value="<%=student.getAge()%>"></td>
				</tr>
			</table>
			<input type="submit" value="UPDATE">
		</form>
	</div>

	<%
	}else{
	%>
	<h1 align="center" id="message">Student not found</h1>
	<%} %>
</body>
</html>
<%@page import="com.jspiders.sms1.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student</title>

<style type="text/css">
#deleteDiv{
margin: 50px 0 20px;
}
tr{
text-align: center;
}
td{
padding: 10px;=
}
input{
padding: 10px;
}
input[type=submit]{
padding: 10px 30px;
background-color: teal;
color: white; 
font-weight: bold;
}
th{
padding: 5px 50px;
}
#table table{
width: 70%;
}
#table table tr:nth-child(even) {
	background-color: lightgrey;
}
#table table tr th{
background-color: teal;
color: white;
}
.message{
margin: 20px;
color: red;
}
</style>

</head>
<body>
	<div align="center" id="deleteDiv">
		<form action="deleteStudent" method="post">
			<table>
				<tr>
					<td><input type="text" placeholder="Enter student id"
						name="id"></td>
					<td><input type="submit" value="DELETE"></td>
				</tr>
			</table>
		</form>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h2 align="center" class="message"><%=message%></h2>
	<%
	}
	%>

	<%
	@SuppressWarnings("unchecked")
	List<Student> students = (List<Student>) request.getAttribute("students");
	if (students != null && students.size() > 0) {
	%>
	<div align="center" id="table">
		<table border="1px solid">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>AGE</th>
			</tr>
			<%
			for (Student student : students) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getAge()%></td>
			</tr>

			<%
			}
			%>
		</table>

		<%
		} else {
		%>
		<h2 class="message">No students</h2>
		<%
		}
		%>
	</div>
</body>
</html>
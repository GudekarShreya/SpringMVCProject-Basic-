<%@page import="com.jspiders.sms1.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student list</title>
<style type="text/css">
h1{
	text-align: center;
	color: teal;
	margin-top: 50px;
}
#editDiv{
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
margin-top: 30PX;
width: 70%;
}
#table table tr:nth-child(even) {
	background-color: lightgrey;
}
#table table tr th{
background-color: teal;
color: white;
}
#message{
margin-top: 30px;
color: red;
}
</style>

</head>
<body>
<h1 align="center" color="teal">STUDENT LIST</h1>
	<%
	@SuppressWarnings("unchecked")
	List<Student> students = (List<Student>) request.getAttribute("students");
	if (students != null && students.size() > 0) {
	%>
	<div align="center" id="table">
		<table border="1px solid">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Age</th>
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
	</div>
	<%
	} else {
	%>
	<div align="center" >
		<h2 id="message">Students not found.</h2>
	</div>
	<%
	}
	%>

</body>
</html>
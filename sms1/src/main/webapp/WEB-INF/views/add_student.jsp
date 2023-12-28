<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="home.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<style type="text/css">
h1{
	text-align: center;
	color: teal;
	margin-top: 50px;
}
#formDiv{
	margin-top: 30px;
}
table{
font-size: 20px;
}
input{
padding: 5px;
width: 300px;
font-size: 17px;
}
td{
padding: 10px;
}
input[type=submit]{
width: 100px;
background-color: teal;
color: white;
padding: 10px 15px;
margin-top: 10px;
font-weight: bold;
}
#message{
margin-top: 30px;
color: red;
}


</style>
</head>
<body>
	<h1>ADD STUDENT</h1>
	<div align="center" id="formDiv">
		<form action="addStudent" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age"></td>
				</tr>
			</table>
			<input type="submit" value="ADD">
		</form>
	</div>

	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h2 align="center" id="message"><%=message%></h2>
	<%
	}
	%>
</body>
</html>
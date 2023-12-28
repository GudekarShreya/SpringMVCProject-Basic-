<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
h1 {
	margin-top: 100px;
	color: teal;
	font-size: 40px;
}

form {
	margin-top:50px;
	padding: 50px 10px;
	border: 1px solid teal;
	width: 30%;
	border-radius: 20px;
}

td {
	padding: 10px;
	font-size: 20px;
}

input {
	border: 1px solid teal;
	padding: 10px;
	width: 300px;
	border-radius: 20px;
}
input[type=submit]{
	margin-top: 20px;
	margin-bottom: 20px;
	width: 150px;
	background-color: teal;
	color: white;
}
#message{
margin-top: 30px;
color: red;
}
a{
margin-top: 20px;
}
</style>
</head>
<body>
	<h1 align="center">Welcome admin</h1>
	<div align="center">
		<form action="logIn">
			<table>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="LOG IN"> <br> 
			<a href="sign_up">New user? Create account</a>
		</form>
	</div>
	
	<% String message = (String) request.getAttribute("message"); 
	
	if(message != null){%>
	
	<div align="center">
	<h2 id="message"><%= message %></h2>
	</div>
	
	<%} %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

#container {
	display: flex;
}

#nav {
	display: flex;
	justify-content: right;
	background-color: teal;
	padding: 15px 0;
}

a {
	display: inline-block;
	padding: 20px;
	text-decoration: none;
	font-size: 20px;
	color: white;
}

a:hover {
	box-shadow: 0 2px 0 white;
}

h2 {
	margin-top: 50px;
	font-size: 30px;
}

h1 {
	color: teal;
	font-size: 50px;
}
</style>
</head>
<body>

	<%
	String userName = (String) request.getAttribute("admin");
	%>
	<div align="center" id="nav">
		<a href="home" title="Back to home">Home</a> <a href="add_student"
			title="Add student">Add</a> <a href="edit_student"
			title="Update by id">Update</a> <a href="delete_student"
			title="Delete by id">Delete</a> <a href="search"
			title="Search by name">Search</a> <a
			href="delete_admin?userName=<%=userName%>" title="Back to home">Delete
			Admin</a>
	</div>
		<h2 align="center">Welcome to</h2>
		<h1 align="center">Student Management System</h1>
	
</body>
</html>
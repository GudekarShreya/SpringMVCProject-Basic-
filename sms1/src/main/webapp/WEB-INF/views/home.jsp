<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

#nav {
	display: flex;
	padding: 15px 0;
	justify-content: right;
	background-color: teal;
}

a {
	display: inline-block;
	padding: 20px 10px;
	text-decoration: none;
	font-size: 20px;
	margin-left: 10px;
	color: white;
}

a:hover {
	box-shadow: 0 2px 0 white;
}
</style>

</head>
<body>

	<%
	String userName = (String) request.getAttribute("admin");
	%>
	<div align="center" id="nav">
		<a href="home" title="Back to home">Home</a> 
		<a href="add_student" title="Add student">Add</a> 
		<a href="edit_student" title="Update by id">Update</a> 
		<a href="delete_student" title="Delete by id">Delete</a> 
		<a href="search" title="Search by name">Search</a> 
		<a href="get_students" title="Get student list">Student list</a> 
		<a href="log_out">Log out</a>
	</div>
</body>
</html>
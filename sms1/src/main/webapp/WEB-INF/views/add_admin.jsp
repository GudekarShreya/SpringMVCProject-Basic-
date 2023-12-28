<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>

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
}
</style>

</head>
<body>
	<h1 align="center">Sign-Up</h1>
	<div align="center" id="formDiv">
		<form action="signUp" method="post">
			<table>
				<tr>
					<td>UserName</td>
					<td> <input type="text" name= "userName"> </td>
				</tr>
				<tr>
					<td>Email</td>
					<td> <input type="text" name= "email"> </td>
				</tr>
				<tr>
					<td>Password</td>
					<td> <input type="text" name= "password"> </td>
				</tr>
			</table>
			<input type="submit" value="Sign Up">
		</form>
	</div>
</body>
</html>
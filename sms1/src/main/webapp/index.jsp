<html>
<body>

	<%
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("log_in");
	requestDispatcher.forward(request, response);
	%>

</body>
</html>

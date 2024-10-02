<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>내장객체 - request</title>
</head>
<body>
	<%
		String[] hobbies = request.getParameterValues("hobby");
		for(int i = 0 ; i < hobbies.length ; i++ ) {
			
	%>
			<h5><%= hobbies[i] %></h5>
	<%
		}
	%>
	
</body>
</html>





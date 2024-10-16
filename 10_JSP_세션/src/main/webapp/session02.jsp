<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 가져오기</title>
</head>
<body>
	<h1>세션 정보 가져오기</h1>
	<%
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		
		out.println("세션 정보 - username : " + username);
		out.println("세션 정보 - password : " + password);
	%>
	<div>
		<a href="<%= request.getContextPath() %>/session03.jsp">session03.jsp</a>
	</div>
</body>
</html>








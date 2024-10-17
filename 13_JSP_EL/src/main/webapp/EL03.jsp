<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - session</title>
</head>
<body>
	<h1>sessionScope EL 내장객체</h1>
	<%
		session.setAttribute("username", "joeun");
	%>
	<h1>로그인된 아이디 : ${ sessionScope.username }</h1>
	<a href="EL03-1.jsp">EL03-1.jsp</a>
	<a href="EL03-2.jsp">EL03-2.jsp</a>
</body>
</html>
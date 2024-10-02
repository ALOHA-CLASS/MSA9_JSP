<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5초마다 새로고침</title>
</head>
<body>
	<h3>5초마다 새로고침</h3>
	<%
		response.setIntHeader("Refresh", 5);		
	%>
	
	<h3><%= new Date() %></h3>
</body>
</html>










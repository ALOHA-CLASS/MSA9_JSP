<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>
	<!-- ★선언문 -->
	<%!
		int sum(int a, int b) {
			return a + b;	
		}
		int result = 10+20;
	%>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<%--
		System.out.print()
		out : JSP 에서 출력을 하는 내장 객체
	--%>
	<!-- ★스크립틀릿 -->
	<h1><% out.print("a + b = " + sum(10, 20)); %></h1>
	<h2>a + b = 30</h2>
	<!-- ★표현문 -->
	<h3>a + b = <%= 30 %></h1>
	<h3>a + b = <%= 10 + 20 %></h1>
	<h3>a + b = <%= result %></h1>
	<h3>a + b = <%= sum(10,20) %></h1>
	
</body>
</html>








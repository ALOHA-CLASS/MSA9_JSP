<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현문</title>
</head>
<body>
	<%--
		JSP 스크립트 태그
		- 선언문			: 변수 선언O, 메소드 정의O	( __jspService() 외부 선언 )
		- 스크립틀릿		: 변수 선언O, 메소드 정의X   ( __jspService() 내부 선언 )
		- 표현문			: 변수 사용, 메소드 호출
	--%>
	<%-- 선언문 --%>
	<%!
		int a = 100;
	%>
	<%-- 스크립틀릿 --%>
	<%
		int a = 10;
		int b = 20;
		int c = 30;
		int sum = a + b + c;
	%>
	<%-- 표현문 --%>
	<%= a + b + c %>
	<%= sum %>
	<h3>sum : <%= sum %></h3>
</body>
</html>









<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<h3>회원가입에 성공했습니다.</h3>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
	%>
	<p>아이디  : <%= id %> </p> 
	<p>비밀번호 : <%= pw %> </p> 
	<p>이름 : <%= name %> </p> 
	<p>나이 : <%= age %> </p> 
</body>
</html>
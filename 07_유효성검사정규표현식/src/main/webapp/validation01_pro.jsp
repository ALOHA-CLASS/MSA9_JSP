<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유효성 검사</title>
</head>
<body>
	<h3>로그인에 성공했습니다.</h3>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
	%>
	<p>아이디  : <%= id %> </p> 
	<p>비밀번호 : <%= pw %> </p> 
</body>
</html>







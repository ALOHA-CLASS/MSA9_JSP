<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인</title>
</head>
<body>
	<!-- 세션 등록하는 과정 -->
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if( username.equals("joeun") && password.equals("123456") ) {
			// 아이디, 비번 일치 -> 인증(로그인) 성공
			// -> 세션에 사용자 정보 등록
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			out.println("세션 설정 성공! (로그인 성공)");
			out.println(username + "님 환영합니다.");
		}
		else {
			out.println("세션 설정 실패! (로그인 실패)");
		}
	%>
	<a href="<%= request.getContextPath() %>/session02.jsp">session02.jsp</a>
</body>
</html>












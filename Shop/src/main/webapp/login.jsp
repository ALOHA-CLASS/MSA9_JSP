<%@page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	<%
		// 아이디 저장 쿠키 확인
		String rememberId = "";
		String username = "";
		Cookie[] cookies = request.getCookies();
		if( cookies != null ) {
			for( Cookie cookie : cookies ) {
				String cookieName = cookie.getName();
				String cookieValue = URLDecoder.decode( cookie.getValue(), "UTF-8" );
				switch(cookieName) {
					case "username" : username = cookieValue; break;
					case "rememberId" : rememberId = cookieValue; break;
				}
				
			}
		}
		pageContext.setAttribute("username", username);
		pageContext.setAttribute("rememberId", rememberId);
	%>
	<h1>로그인</h1>
	<form action="login_pro.jsp" method="post">
		<p>아이디 : <input type="text" name="username" id="username" value="${ username }"  /> </p>
		<p>비밀번호 : <input type="password" name="password" id="password" /> </p>
		<p>
			<!-- 아이디 저장 -->
			<input type="checkbox" name="remember-id" id="remember-id"
				<% if(rememberId.equals("on") )	{ %>
					checked 
				<% } %>
				/>
			<label for="remember-id">아이디 저장</label>
			
			<!-- 자동 로그인 -->
			<input type="checkbox" name="remember-me" id="remember-me" />
			<label for="remember-me">자동 로그인</label>
		</p>
		<p>
			<input type="submit" value="로그인" /> 
		</p>
	</form>
</body>
</html>












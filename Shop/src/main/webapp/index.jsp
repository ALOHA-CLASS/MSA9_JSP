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
	<title>메인 화면</title>
</head>
<body>
	<h1>메인 화면</h1>
	<c:if test="${ sessionScope.loginId != null }">
		<h3>${ sessionScope.loginId } 님 환영합니다.</h3>
		<a href="logout.jsp">로그아웃</a>
	</c:if>
	<ul>
		<li><a href="signup.jsp">회원가입</a></li>
		<li><a href="login.jsp">로그인</a></li>
	</ul>
</body>
</html>


















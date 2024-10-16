<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - core</title>
</head>
<body>
	<%-- 변수 선언 --%>
	<%
		int number = 100;
	%>
	<c:set var="number" value="100" />
	
	<%-- 단일 조건문 if --%>
	<%-- 스크립틀릿 에서 선언한 변수 가져오기 --%>
	<c:if test="<%= number % 2 == 0 %>">
		<h3>2는 짝수입니다 (스크립틀릿)</h3>
	</c:if>
	
	<%-- JSTL 에서 선언한 변수 가져오기 --%>
	<c:if test="${ number % 2 == 0 }">
		<h3>2는 짝수입니다 (JSTL, EL)</h3>
	</c:if>
	
	<%-- 다중 조건문 choose --%>
	<c:choose>
		<c:when test="${ number % 2 == 1 }">
			<c:out value="${number}"/>는 홀수 입니다.
		</c:when>
		<c:when test="${ number % 2 == 0 }">
			<c:out value="${number}"/>는 짝수 입니다.
		</c:when>
		<c:otherwise>
			숫자가 아닙니다.
		</c:otherwise>
	</c:choose>
</body>
</html>







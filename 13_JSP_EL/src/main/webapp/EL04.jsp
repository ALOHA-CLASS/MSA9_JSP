<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - applicationScope</title>
</head>
<body>
	<h1>EL applicationScope</h1>
	<%
		// 멀티스레드 환경에서 정수값을 동기화 해주는 객체
// 		AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount");
// 		if( visitorCount == null ) {
// 			visitorCount = new AtomicInteger(0);
// 			application.setAttribute("visitorCount", visitorCount);
// 		}
		
		// 접속자 수를 1 증가
		// int currentCount = visitorCount.incrementAndGet();
	%>
	<h1>사이트 접속자 수 : ${ applicationScope.visitorCount }</h1>
</body>
</html>









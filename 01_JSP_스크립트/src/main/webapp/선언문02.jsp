<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>
	<%-- 선언문에서는 변수와 메소드 정의 --%>
	<%!
		String makeUpperCase( String str ) {
			return str.toUpperCase();
		}
	%>
	<h1><% out.println( makeUpperCase("hello jsp~!") ); %></h1>
</body>
</html>







<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브 태그</title>
</head>
<body>
	<%
		String menu1 = "Home";
		String menu2 = "Board";
		String menu3 = "Gallery";
	%>
	<%@ include file="header.jsp" %>
	<main>
		<div class="container">
			<h1>메인 컨텐츠</h1>
		</div>
	</main>
	<%@ include file="footer.jsp" %>
</body>
</html>



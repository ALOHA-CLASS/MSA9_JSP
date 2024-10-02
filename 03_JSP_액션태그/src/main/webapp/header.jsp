<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String menu1 = request.getParameter("menu1");
		String menu2 = request.getParameter("menu2");
		String menu3 = request.getParameter("menu3");
	%>
	<header>
		<h1>헤더 영역</h1>
		<%-- 
			include 액션태그는 각각의 jsp 페이지를 독립적으로 컴파일한다.
			include.jsp 에서 선언한 변수를 header.jsp 에서 참조할 수 없다.
		 --%>
		<ul>
			<li><%= menu1 %></li>
			<li><%= menu2 %></li>
			<li><%= menu3 %></li>
		</ul>
	</header>
</body>
</html>



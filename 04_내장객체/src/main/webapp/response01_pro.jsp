<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 - response</title>
</head>
<body>
	<%
		String title = request.getParameter("title");		
		String writer = request.getParameter("writer");		
		String content = request.getParameter("content");
		
		out.println("게시글이 등록되었습니다.");
		
		response.sendRedirect("list.jsp");
	%>
</body>
</html>










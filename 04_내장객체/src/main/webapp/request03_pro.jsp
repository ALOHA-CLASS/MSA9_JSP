<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 파라미터 가져오기</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Enumeration<String> params = request.getParameterNames();
		while( params.hasMoreElements() ) {
			String paramName = params.nextElement();
			String paramValue = request.getParameter(paramName);
			
			out.println("<h3>" + paramName + " : " + paramValue + "</h3>");
		}
	%>
</body>
</html>







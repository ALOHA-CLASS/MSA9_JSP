<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션의 모든 속성값 확인</title>
</head>
<body>
	<h1>세션 모든 속성값 확인</h1>
	<%
		String name;
		String value;
		
		// session.getAttributeNames() : 모든 세션 속성 이름을 반환
		Enumeration<String> en = session.getAttributeNames();
		int i = 0;
	
		// hasMoreElements() : 다음 세션 속성 존재 여부 (true/false)
		while (en.hasMoreElements()) {
			i++;
			name = en.nextElement().toString();				// 세션 속성이름 가져오기
			value = session.getAttribute(name).toString();	// 세션 속성값 가져오기
			out.println("설정된 세션의 속성 이름 [ " + i + " ] : " + name + "<br>");
			out.println("설정된 세션의 속성 값 [ " + i + " ] : " + value + "<br>");
			out.println("----------------------------------------------<br>");
		}
	%>
	
	<div>
		<a href="<%= request.getContextPath() %>/session04.jsp">session04.jsp</a>
	</div>
	<div>
		<a href="<%= request.getContextPath() %>/session05.jsp">session05.jsp</a>
	</div>
</body>
</html>




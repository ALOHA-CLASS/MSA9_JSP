<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 에서 사용하는 내장 객체</title>
</head>
<body>
	<h1>EL 에서 사용하는 내장 객체</h1>
	<h2>request Scope 속성 : ${ requestScope.name }</h2>
	
	<%
		// pname 은 pageContext 등록해서, 현재 EL02 페이지에서만 사용가능
		pageContext.setAttribute("pname", "페이지");
	
		// name 은 requset 등록해서, EL02.jsp~EL02_pro.jsp 범위에서 사용가능
		request.setAttribute("name", "김조은");
		
		// 포워드 방식으로 페이지 이동
		request.getRequestDispatcher("EL02_pro.jsp").forward(request, response);
	%>
	
	<h2>request Scope 속성 : ${ requestScope.name }</h2>
</body>
</html>





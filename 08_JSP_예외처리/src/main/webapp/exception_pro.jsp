<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 에러 만들기</title>
</head>
<body>
	<%
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = a / b;
		out.print(num1 + " / " + num2 + " = " + c);
	%>
</body>
</html>








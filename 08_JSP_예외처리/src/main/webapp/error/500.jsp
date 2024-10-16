<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>500 에러 페이지</h1>
	<div>
		<p>시스템 일시적인 에러가 발생하였습니다.</p>
		<h5>관리자에게 문의해주세요</h5>
		<div>
			<a href="<%= request.getContextPath() %>">메인 화면</a>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>404 에러 페이지</h1>
	<div>
		<p>페이지를 찾을 수 없습니다.</p>
		<h5>요청 경로를 확인해주세요.</h5>
		<div>
			<a href="<%= request.getContextPath() %>">메인 화면</a>
		</div>
	</div>
</body>
</html>
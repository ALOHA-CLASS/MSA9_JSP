<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 상태 코드</title>
</head>
<body>
	<%
		// 200 OK						: 요청 성공
		// 201 CREATED					: 데이터 등록 성공
		// 404 NOT FOUND				: 페이지를 찾을 수 없음
		// 500 Internal Server Error	: 서버 내부 에러
		// response.sendError(404, "요청한 페이지를 찾을 수 없습니다.");
		response.sendError(500, "서버 내부에 오류가 발생하였습니다.");
		
	%>
</body>
</html>







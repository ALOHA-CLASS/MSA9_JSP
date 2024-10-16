<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 요청/생성/경과 시간</title>
</head>
<body>
	<%
		String session_id = session.getId();			// 세션의 고유한 ID
		
		long last_time = session.getLastAccessedTime();	// 마지막 요청 시간 (ms단위)
		
		long start_time = session.getCreationTime();	// 세션 생성 시간 (ms단위)
		
		long used_time = (last_time - start_time) / (60*1000);	// 요청 경고 시간 (분단위로 환산)
		
		out.println("세션 아이디 : " + session_id + "<br>");
		out.println("요청 시작 시간 : " + start_time + "<br>");
		out.println("요청 마지막 시간 : " + last_time + "<br>");
		out.println("웹 사이트 경과 시간 : " + used_time + "분 <br>");
	%>
</body>
</html>


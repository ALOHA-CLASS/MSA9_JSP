<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	request.setCharacterEncoding("UTF-8");	%>
	<!-- 데이터 소스 -->
	<sql:setDataSource 
		var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>
	
	<!-- 게시글 수정 JSTL 태그 -->
	<sql:update dataSource="${dataSource}" var="resultSet">
		UPDATE board
		   SET title = ?
		      ,writer = ?
		      ,content = ?
		      ,upd_date = now()
	    WHERE no = ?
		<sql:param value="${ param.title }" />
		<sql:param value="${ param.writer }" />
		<sql:param value="${ param.content }" />
		<sql:param value="${ param.no }" />
	</sql:update>
	
	<!-- JSTL 이용한 외부 페이지 포함하기 -->
	<c:import url="sql01.jsp" var="list" />
	${list}	
</body>
</html>











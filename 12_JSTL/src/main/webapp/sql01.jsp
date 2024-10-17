<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL - sql</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<!-- 데이터 소스 -->
	<sql:setDataSource 
		var="dataSource" 
		url="jdbc:mysql://localhost:3306/aloha?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false"
		driver="com.mysql.cj.jdbc.Driver"
		user="aloha"
		password="123456"
	/>
	
	<!-- sql:query 반환된 결과는 ResultSet 객체로 반환 -->
	<sql:query var="list" dataSource="${dataSource}">
		SELECT * FROM board
	</sql:query>
	
	<table border="1">
		<tr>
			<c:forEach var="col" items="${list.columnNames}">
				<th><c:out value="${col}" /></th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${list.rowsByIndex}">
			<tr>
				<c:forEach var="col" items="${row}" varStatus="i">
					<td>
						<c:out value="${col}"/>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>










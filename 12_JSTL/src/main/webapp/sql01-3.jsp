<%@page import="java.util.SortedMap"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.taglibs.standard.tag.common.sql.ResultImpl"%>
<%@page import="DTO.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
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
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM board
	</sql:query>
	
	
	<!-- ResultImpl -> Board 객체로 매핑 -->
	<jsp:useBean id="boardList" class="java.util.ArrayList" />
	<c:forEach var="row" items="${ resultSet.rows }">
		<%
			Board board = new Board();
			pageContext.setAttribute("board", board);
		%>	
		<!-- board.set변수( rs.getInt("컬럼명") ) -->
		<%-- <jsp:setProperty property="변수명" name="객체" value="${ row.컬럼명 }"/> --%>
		<jsp:setProperty property="no" name="board" value="${ row.no }"/>
		<jsp:setProperty property="title" name="board" value="${ row.title }"/>
		<jsp:setProperty property="writer" name="board" value="${ row.writer }"/>
		<jsp:setProperty property="content" name="board" value="${ row.content }"/>
		<jsp:setProperty property="regDate" name="board" value="${ row.reg_date }"/>
		<% boardList.add(board); %>
	</c:forEach>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td> <c:out value="${ board.no }" /> </td>
				<td> <c:out value="${ board.title }" /> </td>
				<td> <c:out value="${ board.writer }" /> </td>
				<td> <c:out value="${ board.regDate }" /> </td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>











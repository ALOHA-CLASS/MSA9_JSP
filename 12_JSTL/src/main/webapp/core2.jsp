<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Board"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<%
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board(1, "제목1", "작성자1", "내용1"));
		boardList.add(new Board(2, "제목2", "작성자2", "내용2"));
		boardList.add(new Board(3, "제목3", "작성자3", "내용3"));
		
	%>
	
	<h1>게시글 목록</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
		</tr>
		<%
			for(Board board : boardList) {
		%>
		<tr>
			<td><%= board.getNo() %></td>
			<td><%= board.getTitle() %></td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getRegDate() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>














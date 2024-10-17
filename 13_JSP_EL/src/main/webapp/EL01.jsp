<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DTO.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - 표현 언어</title>
</head>
<body>
	<%-- 자바(스크립틀릿) 변수 선언 --%>
	<%
// 		int num1 = 10;
// 		int num2 = 20;
// 		pageContext.setAttribute("num1", num1);
// 		pageContext.setAttribute("num2", num2);
	%>
	<%-- JSTL 변수 선언 --%>
	<c:set var="num1" value="10" />
	<c:set var="num2" value="20" />
	<%--  --%>
	<h1>첫 번째 숫자 : ${num1}</h1>
	<h1>두 번째 숫자 : ${num2}</h1>
	
	<%-- EL을 사용하여 변수 값 변경 --%>
	<h1>num1 + num2 = ${num1 + num2}</h1>
	<h1>num1 - num2 = ${num1 - num2}</h1>
	
	<%-- 문자열 연결 --%>
	<c:set var="name1" value="미니" />
	<c:set var="name2" value="프로젝트" />
	<h1>프로젝트 명 : ${name1} ${name2}</h1>
	
	<%-- 객체 접근 --%>
	<%
		Board board = new Board();
		pageContext.setAttribute("board", board);
	%>
	<h1>게시글 제목 : ${board.title}</h1>
	
	<%-- 객체 리스트 접근 --%>
	<%
		Board board1 = new Board("제목1","작성자1","내용1");
		Board board2 = new Board("제목2","작성자2","내용2");
		Board board3 = new Board("제목3","작성자3","내용3");
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(board1);
		boardList.add(board2);
		boardList.add(board3);
		pageContext.setAttribute("boardList", boardList);
	%>
	<h1>board 객체 리스트 접근</h1>
	<ul>
		<c:forEach var="board" items="${ boardList }">
			<li>${board.title}</li>
		</c:forEach>
	</ul>
</body>
</html>











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
	<h1>게시글 조회</h1>
	<form action="sql01-4_pro.jsp" method="post">
		<p>번호 : <input type="text" name="no" /></p>
		<p><input type="submit" value="조회" /></p>
	</form>
	
</body>
</html>











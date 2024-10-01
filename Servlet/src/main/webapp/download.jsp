<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download</title>
</head>
<body>
	<h1>파일 다운로드</h1>
	<form action="/Servlet/download" method="get">
		<label for="fileName">파일명 : </label>
		<input type="text" name="fileName" id="fileName" />
		<br>
		<input type="submit" value="다운로드" />
	</form>
</body>
</html>
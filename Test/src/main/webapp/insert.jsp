<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
</head>
<body>
	<form action="/board" method="post">
		<label for="title">제목:</label>
        <input type="text" id="title" name="title"><br>
        <label for="writer">작성자:</label>
        <input type="text" id="writer" name="writer"><br>
        <label for="content">내용:</label>
        <textarea id="content" name="content"></textarea><br>
        <input type="submit" value="제출">
	</form>
</body>
</html>
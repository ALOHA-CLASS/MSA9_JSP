<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - response</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="response01_pro.jsp" method="post">
		<p>
			<label for="id">제목</label>
			<input type="text" name="title" id="title"/>
		</p>
		<p>
			<label for="wrtier">작성자</label>
			<input type="text" name="writer" id="writer"/>
		</p>
		<p>
			<label for="content">내용</label>
			<input type="text" name="content" id="content"/>
		</p>
		<input type="submit" value="등록하기" />
	</form>
</body>
</html>




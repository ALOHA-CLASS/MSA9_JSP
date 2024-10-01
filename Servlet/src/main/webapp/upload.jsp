<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="/Servlet/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="text" name="title" />
		<input type="submit" value="파일 업로드" />
	</form>
</body>
</html>
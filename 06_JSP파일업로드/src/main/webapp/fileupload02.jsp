<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 - common-fileupload</title>
</head>
<body>
	<form action="fileupload02_pro.jsp" method="post" enctype="multipart/form-data">
		<p>파일 : <input type="file" name="file" multiple /></p>
		<p><input type="submit" value="업로드" /></p>
	</form>
</body>
</html>
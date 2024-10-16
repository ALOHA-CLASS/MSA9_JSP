<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 - common-fileupload</title>
</head>
<body>
	<!-- jsp 로 파일 업로드 처리 -->
<!-- 	<form action="fileupload03_pro.jsp" method="post" enctype="multipart/form-data"> -->
	<!-- Servlet 으로 파일 업로드 처리 -->
		<form action="<%= request.getContextPath() %>/fileupload/commons" method="post" enctype="multipart/form-data">
		<p>이름 : <input type="text" name="name" /></p>
		<p>제목 : <input type="text" name="title" /></p>
		<p>파일 : <input type="file" name="file" multiple /></p>
		<p><input type="submit" value="업로드" /></p>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<!-- 
		enctype : 폼 데이터가 서버로 전송될 때, 데이터를 인코딩하는 방법을 지정하는 속성
			* method="post" 일 때만 사용가능
		- application/x-www-form-urlencoded	: 서버로 보내기 전에 인코딩
		- multipart/form-data				: 모든 문자를 인코딩하지 않음
											  * 파일, 이미지 전송할 때 사용
		- text/plain						: 공백만 + 로 변환, 나머지는 인코딩하지 않음
	 -->
	<!-- jsp 로 파일 업로드 처리 -->
	<form action="<%= request.getContextPath() %>/fileupload/cos" method="post" enctype="multipart/form-data">
<!-- 	<form action="fileupload01_pro.jsp" method="post" enctype="multipart/form-data"> -->
	<!-- Servlet 으로 파일 업로드 처리 -->
<%-- 	<form action="<%= request.getContextPath() %>/fileupload/cos" method="post" enctype="multipart/form-data"> --%>
		<p>이 름 : <input type="text" name="name"> </p>	
		<p>제 목 : <input type="text" name="title"> </p>	
		<!-- multiple : 여러 파일을 선택하도록 지정 -->
		<p>파 일 : <input type="file" name="file1" > </p>
		<p>파 일 : <input type="file" name="file2" > </p>
		<p>
			<input type="submit" value="업로드" />
		</p>
	</form>
</body>
</html>





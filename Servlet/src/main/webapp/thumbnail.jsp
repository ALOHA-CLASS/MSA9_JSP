<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>썸네일 이미지</title>
</head>
<body>
	<h1>썸네일 이미지</h1>
	<form id="form">
		<label for="fileName">파일명 : </label>
		<input type="text" name="fileName" id="fileName" />
		<br>
		<button type="button" id="btn">이미지 보기</button>
	</form>
	<h1>이미지 미리보기</h1>
	<img src="" id="thumbnail" width="300px" />
	
	<script>
		document.getElementById("btn").addEventListener("click", function(event) {
			let fileName = document.getElementById("fileName").value
			if( fileName ) {
				fileName = encodeURIComponent(fileName)
				const imageUrl = "/Servlet/img?fileName=" + fileName  
				const thumbnail = document.getElementById("thumbnail")
				thumbnail.src = imageUrl
			}
		})	
		
	</script>
</body>
</html>






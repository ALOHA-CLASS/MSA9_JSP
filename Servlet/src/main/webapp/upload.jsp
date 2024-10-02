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
		<input type="file" name="file" onchange="fileCheck(event)" />
		<input type="text" name="title" />
		<input type="submit" value="파일 업로드" />
	</form>
	
	<script>
		// 파일 업로드 제한 용량
		const MAX_FILE_SIZE = 10 * 1024 * 1024 // 10MB
		// 첨부파일 선택 시, 이벤트
		function fileCheck(event) {
			const fileInput = event.target
			const file = fileInput.files[0]
			
			if( file && file.size > MAX_FILE_SIZE ) {
				alert("파일 업로드 용량은 10MB 를 넘을 수 없습니다.")
				fileInput.value = ""  // 첨부한 파일 데이터 초기화
			}
		}
	</script>
</body>
</html>







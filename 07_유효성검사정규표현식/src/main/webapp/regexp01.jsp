<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정규표현식</title>
</head>
<body>
	<h1>정규표현식</h1>
	<form name="form" onsubmit="return checkForm()">
		<p>제목 : <input type="text" name="title" /></p>
		<p><input type="submit" value="등록" /></p>
	</form>
	
	<script>
		function checkForm() {
			let regExp = /Java/i		// Java 라는 문자열을 대소문자 구분없이 검사
			let str = document.form.title.value
			let result = regExp.exec(str)
			
			// exec() 	: 정규 표현식에 부합한 문자열 반환
			// test()	: 정규 표현식에 부합한지 여부를 반환(true/false)
			if( regExp.test(str) ) {
				alert(result[0])
			}
			return false
		}
	</script>
</body>
</html>
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
		<p>제목 : <input type="text" name="title" /> </p>
		
		<p>아이디 : <input type="text" name="id" /> </p>
		<p>이름 : <input type="text" name="name" /> </p>
		
		<p>전화번호 : <select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
					</select> 
					- <input type="text" maxlength="4" size="4" name="phone2"> 
					- <input type="text" maxlength="4" size="4" name="phone3">
					
		<p>이메일 : <input type="text" name="email" /> </p>
		
		<p><input type="submit" value="등록" /> </p>
	</form>
	<script>
	
		// 회원가입 정규 표현식으로 유효성 검사
		function checkForm() {
			
			// 아이디 패턴 : 영문자, 한글 시작
			let regExpId = /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]+$/
			
			// 이름 패턴 : 한글
			let regExpName = /^[가-힣]{2,}$/
			
			// 전화번호 패턴 : [3자리 숫자]-[3~4자리 숫자]-[4자리 숫자]
			let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/
			
			// 이메일 패턴 [숫자,영문자]@[숫자,영문자].~~.[영문자2~3자리]
			// OOO@OOOO.com
			// OOO@OOOO.co.kr
			// OOO@OOOO.ac.kr
			// OOO@OOOO.org
			let regExpEmail = /^[0-9a-zA-Z](-_\.)?[0-9a-zA-Z]*@[0-9a-zA-Z](-_\.)?[0-9a-zA-Z]*\.[a-zA-Z]{2,3}$/i          
			
			// 분석 - /^[0-9a-zA-Z](-_\.)?[0-9a-zA-Z]*
			// /^[0-9a-zA-Z](-_\.)?[0-9a-zA-Z]*
			// ^[0-9a-zA-Z]		: 시작은 숫자 또는 영어
			// (-_\.)?			: 중간에 -, _, .  0 또는 1회 가능
			// [0-9a-zA-Z]*		: 그 후에는 숫자 또는 영어가 0 또는 1회이상
			
			// 전체 분석
			// (1) : /^[0-9a-zA-Z](-_\.)?[0-9a-zA-Z]*
			// (2) : @
			// (3) : [0-9a-zA-Z](-_\.)?[0-9a-zA-Z]*
			// (4) : .
			// (5) : [a-zA-Z]{2,3}$/i
					
			// 가능
			// joeun
			// joeun1004
			// joeun_1004
			// joeun-1004
			// 1004joeun
			// 1004-joeun
			// joeun.1004
			
			// 불가능
			// -joeun
			// _jouen
			
			let id = form.id.value
			let name = form.name.value
			let phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value
			let email = form.email.value
			
			// test() : 부합O-true, 부합X-false
			if( !regExpId.test(id) ) {
				alert('아이디를 형식에 맞게 입력해주세요')
				return false
			}
			
			if( !regExpName.test(name) ) {
				alert('이름 형식에 맞게 입력해주세요')
				return false
			}
			
			if( !regExpPhone.test(phone) ) {
				alert('전화번호 형식에 맞게 입력해주세요')
				return false
			}
			
			if( !regExpEmail.test(email) ) {
				alert('이메일 형식에 맞게 입력해주세요')
				return false
			}
			
		}
	</script>
</body>
</html>
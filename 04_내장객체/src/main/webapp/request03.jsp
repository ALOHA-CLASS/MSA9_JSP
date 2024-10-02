<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="request03_pro.jsp" method="post">
		<p>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" />
		</p>
		<p>
			<label for="pw">비밀번호</label>
			<input type="password" name="pw" id="pw" />
		</p>
		<p>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" />
		</p>
		<p>
			<label for="email">이메일</label>
			<input type="email" name="email" id="email" />
		</p>
		<p>
			<label for="birth">생년월일</label>
			<input type="date" name="birth" id="birth" />
		</p>
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>










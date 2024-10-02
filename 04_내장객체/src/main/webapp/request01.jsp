<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="request01_pro.jsp" method="post">
		<p>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id"/>
		</p>
		<p>
			<label for="pw">비밀번호</label>
			<input type="password" name="pw" id="pw"/>
		</p>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>




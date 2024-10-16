<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 저장</title>
</head>
<body>
	<%
		// 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		// 쿠키의 아이디와 저장여부
		String username = "";
		String rememberId = "";
		
		if( cookies != null ) 
			for(int i = 0 ; i < cookies.length ; i++) {
				if( cookies[i].getName().equals("username") ) 
					username = cookies[i].getValue(); 			// 저장된 로그인 아이디
				if( cookies[i].getName().equals("rememberId") ) 
					rememberId = cookies[i].getValue(); 		// 저장 여부 - 저장(on)
			}
	%>
	<h1>로그인</h1>
	
	<form action="cookie_pro.jsp" method="post">
		<p>아이디 : <input type="text" name="username" value="<%= username %>" /></p>
		<p>비밀번호 : <input type="password" name="password" /></p>
		<p>
			<%
				if(rememberId.equals("on")) {
			%>
			<input type="checkbox" name="remember-id" id="remember-id" checked />
			<%
				} else {
			%>
			<input type="checkbox" name="remember-id" id="remember-id" />
			<%
				}
			%>
			<label for="remember-id">아이디 저장</label>
		</p>
		<p><input type="submit" value="로그인"/></p>
	</form>
</body>
</html>







<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String passowrd = request.getParameter("password");
	String rememberId = request.getParameter("remember-id");
	
	// checkbox 체크 시, 기본값 on 으로 넘어온다.
	out.println("rememberId : " + rememberId + "<br>");
	
	// 아이디 저장 체크 시, 쿠키 생성
	if( rememberId != null && rememberId.equals("on") ) {
		// 쿠키 생성
		Cookie cookieId = new Cookie("username", username); 			// 아이디 쿠키
		Cookie cookieRememberId = new Cookie("rememberId", rememberId); // 아이디 저장 쿠키
		response.addCookie(cookieId);
		response.addCookie(cookieRememberId);
		out.println("아이디를 쿠키에 저장했습니다.<br>");
	}
	// 아이디 저장 미체크 시, 쿠키 삭제
	else {
		Cookie cookieId = new Cookie("username", username); 			// 아이디 쿠키
		Cookie cookieRememberId = new Cookie("rememberId", rememberId); // 아이디 저장 쿠키
		// 쿠키 만료
		cookieId.setMaxAge(0);
		cookieRememberId.setMaxAge(0);
		response.addCookie(cookieId);
		response.addCookie(cookieRememberId);
		out.println("아이디를 쿠키에서 삭제했습니다.<br>");
	}
%>
<a href="cookie.jsp">cookie.jsp</a>







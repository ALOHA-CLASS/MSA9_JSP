<%@page import="shop.Service.PersistenceLoginsServiceImpl"%>
<%@page import="shop.Service.PersistenceLoginsService"%>
<%@page import="shop.DTO.PersistenceLogins"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="shop.Service.UserServiceImpl"%>
<%@page import="shop.Service.UserService"%>
<%@page import="shop.DTO.Users"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 아이디 비밀번호 가져오기
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	// 로그인 요청
	Users user = Users.builder()
						.username(username)
						.password(password)
						.build();
	UserService userService = new UserServiceImpl();
	Users loginUser = userService.login(user);
	
	// 로그인 실패
	if( loginUser == null ) {
		// 리다이렉트 -> 로그인 화면으로 다시 이동
		response.sendRedirect("login.jsp?error=0");
		return;
	}
	
	// 아이디 저장
	String rememberId = request.getParameter("remember-id");
	Cookie cookieRememberId = new Cookie("rememberId", "");
	Cookie cookieUsername = new Cookie("username", "");
	
	// 아이디 저장 체크 시 - 값 : on
	if( rememberId != null && rememberId.equals("on") ) {
		// 쿠키 생성
		cookieRememberId.setValue( URLEncoder.encode(rememberId, "UTF-8") );
		cookieUsername.setValue( URLEncoder.encode(username, "UTF-8") );
	}
	// 아이디 저장 체크 해제 시
	else {
		// 쿠키 삭제 - 쿠키 유효시간을 0으로 하고 응답
		cookieRememberId.setMaxAge(0);
		cookieUsername.setMaxAge(0);
	}
	// 아이디 저장 끝
	
	// 자동 로그인
	String rememberMe = request.getParameter("remember-me");
	Cookie cookieRememberMe = new Cookie("rememberMe", "");
	Cookie cookieToken = new Cookie("token", "");
	
	// 쿠키 설정
	cookieRememberMe.setPath("/");
	cookieToken.setPath("/");
	// 쿠키 만료시간 설정 - 7일 (/초)
	cookieRememberMe.setMaxAge(60*60*24*7); 
	cookieToken.setMaxAge(60*60*24*7);		
	
	// 자동 로그인 체크 여부
	if( rememberMe != null && rememberMe.equals("on") ) {
		// 자동 로그인 체크 시
		// - 토큰 발행
		PersistenceLoginsService persistenceLoginsService = new PersistenceLoginsServiceImpl();
		PersistenceLogins persistenceLogins = persistenceLoginsService.refresh(username);
		String token = null;
		if( persistenceLogins != null ) {
			token = persistenceLogins.getToken();
		}
		// - 쿠키 생성
		cookieRememberMe.setValue( URLEncoder.encode(rememberMe, "UTF-8") );
		cookieToken.setValue( URLEncoder.encode(token, "UTF-8") );
	} 
	else {
		// 자동 로그인 미체크 시
		// 쿠키 삭제
		cookieRememberMe.setMaxAge(0);
		cookieToken.setMaxAge(0);
	}
	// 자동 로그인 끝
	
	// 응답에 쿠키 등록
	response.addCookie(cookieRememberId);
	response.addCookie(cookieUsername);
	response.addCookie(cookieRememberMe);
	response.addCookie(cookieToken);
	
	
	// 로그인 성공
	if( loginUser != null ) {
		// 세션에 사용자 정보 등록
		session.setAttribute("loginId", loginUser.getUsername());
		session.setAttribute("loginUser", loginUser);
		// 리다이렉트 -> 메인 화면
		response.sendRedirect("index.jsp");
	}
%>





